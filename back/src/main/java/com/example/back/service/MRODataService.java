package com.example.back.service;

import com.example.back.model.MROData;

import java.util.List;
import java.util.Map;

public interface MRODataService {

    void importMROData(List<MROData> mrods);

    void exportMRO(String filePath);

    List<Map<String, Object>> search();

    void generate();
    void exportC2Inew(String filePath);
}
