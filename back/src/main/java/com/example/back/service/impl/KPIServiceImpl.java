package com.example.back.service.impl;

import com.example.back.model.KPI;
import com.example.back.repository.KPIRepository;
import com.example.back.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPIServiceImpl implements KPIService {

    @Autowired
    KPIRepository kpiRepository;

    @Override
    public void importKPI(List<KPI> kpis) {
        kpiRepository.importKPI(kpis);
    }

}
