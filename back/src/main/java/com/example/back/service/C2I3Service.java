package com.example.back.service;

import java.util.List;
import java.util.Map;

public interface C2I3Service {
    void exportC2I3(String filePath);
    List<Map<String, Object>> generate(double x);
}
