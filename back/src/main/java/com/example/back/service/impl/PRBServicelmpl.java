package com.example.back.service.impl;

import com.example.back.model.PRB;
import com.example.back.repository.PRBRepository;
import com.example.back.service.KPIService;
import com.example.back.service.PRBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PRBServicelmpl implements PRBService {
    private static final int batch = 50;

    @Autowired
    PRBRepository prbRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional
    public void importPRB(List<PRB> prbs) {
        int page = prbs.size() / batch;
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into tbprb ").append(PRB.toKeys()).append(" values ");
            List<PRB> temp = prbs.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                PRB prb = temp.get(j);
                stringBuilder.append(prb.toMsg());
                if(j != temp.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(" on duplicate key update 周期=15");
            System.out.println(stringBuilder.toString());
            e.createNativeQuery(stringBuilder.toString()).executeUpdate();
        }
    }

    @Override
    public void exportPRB(String filePath) {
        //导出PRB表
        try {
            prbRepository.export(filePath);
        } catch (Exception e) {
        }
    }

}
