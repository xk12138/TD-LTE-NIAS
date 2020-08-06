package com.example.back.service;

import com.example.back.model.Cell;

import java.util.List;

public interface CellService {

    void importCell(List<Cell> Cells);

    void exportCELL(String filePath);

}
