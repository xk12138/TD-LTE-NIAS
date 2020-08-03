package com.example.back.service.impl;

import com.example.back.model.KPI;
import com.example.back.repository.KPIRepository;
import com.example.back.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class KPIServiceImpl implements KPIService {

    @Autowired
    KPIRepository kpiRepository;

    @Override
    @Transactional
    public void importKPI(List<KPI> kpis) {
        int page = kpis.size() / 50;
        for (int i = 0; i < page; i++) {
            List<KPI> temp = kpis.subList(i * 50, i * 50 + 50);
            kpiRepository.saveAll(temp);
        }
    }

}
