package com.example.back.service.impl;

import com.example.back.model.KPI;
import com.example.back.repository.KPIRepository;
import com.example.back.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Service
public class KPIServiceImpl implements KPIService {

    private static final int batch = 50;

    @Autowired
    KPIRepository kpiRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional
    public void importKPI(List<KPI> kpis) {
        int page = kpis.size() / batch;
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into tbkpi ").append(KPI.toKeys()).append(" values ");
            List<KPI> temp = kpis.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                KPI kpi = temp.get(j);
                stringBuilder.append(kpi.toMsg());
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
    public void exportKPI(String filePath) {
        //导出KPI表
        try {
            kpiRepository.export(filePath);
        } catch (Exception e) {
        }
    }

}
