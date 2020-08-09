package com.example.back.service;

import com.example.back.model.Cell;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CellService {

    void importCell(List<Cell> Cells);

    void exportCELL(String filePath);

    List<Map<String, Object>> search_by_sector(String keyword);

    List<Map<String, Object>> search_by_enodeB(String keyword);


}
