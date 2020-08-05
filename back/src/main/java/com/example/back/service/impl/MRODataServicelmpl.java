package com.example.back.service.impl;

import com.example.back.model.MROData;
import com.example.back.repository.MRODataRepository;
import com.example.back.service.MRODataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MRODataServicelmpl implements MRODataService {

    private static final int batch = 50;

    @Autowired
    MRODataRepository mrodataRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional
    public void importMROData(List<MROData> mrods) {
        int page = mrods.size() / batch;
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into tbMROData ").append(MROData.toKeys()).append(" values ");
            List<MROData> temp = mrods.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                MROData mro = temp.get(j);
                stringBuilder.append(mro.toMsg());
                if(j != temp.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(" on duplicate key update 周期=15");
            System.out.println(stringBuilder.toString());
            e.createNativeQuery(stringBuilder.toString()).executeUpdate();
        }
    }
}
