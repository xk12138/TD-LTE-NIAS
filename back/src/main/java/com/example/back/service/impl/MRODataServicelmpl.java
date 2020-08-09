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
            stringBuilder.append(" on duplicate key update LteScRSRP=VALUES(LteScRSRP)," +
                    "LteNcRSRP=VALUES(LteNcRSRP),LteNcEarfcn=VALUES(LteNcEarfcn)," +
                    "LteNcPci=VALUES(LteNcPci),interfering_sector=VALUES(interfering_sector)," +
                    "serving_sector=VALUES(serving_sector),time_stamp=VALUES(time_stamp)," +
                    "lte_nc_earfcn=values(lte_nc_earfcn),lte_nc_pci=values(lte_nc_pci)," +
                    "lte_ncrsrp=VALUES(lte_ncrsrp),lte_scrsrp=VALUES(lte_scrsrp);");
            System.out.println(stringBuilder.toString());
            e.createNativeQuery(stringBuilder.toString()).executeUpdate();
        }
    }

    @Override
    public void exportMRO(String filePath) {
        //导出MRO表
        try {
            mrodataRepository.export(filePath);
        } catch (Exception e) {
        }
    }
}