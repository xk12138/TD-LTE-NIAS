package com.example.back.service;

import com.example.back.model.KPI;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface KPIService {

    void importKPI(List<KPI> kpis);

    void exportKPI(String filePath);

    List<Map<String, Object>> search(String keyword, String name, Date startTime, Date endTime);

}
