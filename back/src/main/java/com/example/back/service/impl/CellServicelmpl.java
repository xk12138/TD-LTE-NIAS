package com.example.back.service.impl;

import com.example.back.model.Cell;
import com.example.back.repository.CellRepository;
import com.example.back.repository.KPIRepository;
import com.example.back.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CellServicelmpl implements CellService {

    private static final int batch = 50;

    @Autowired
    CellRepository cellRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional
    public void importCell(List<Cell> cells) {
        int page = cells.size() / batch;
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into tbCell ").append(Cell.toKeys()).append(" values ");
            List<Cell> temp = cells.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                Cell cell = temp.get(j);
                stringBuilder.append(cell.toMsg());
                if(j != temp.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(" on duplicate key update VENDOR='华为'");
            System.out.println(stringBuilder.toString());
            e.createNativeQuery(stringBuilder.toString()).executeUpdate();
        }
    }

    @Override
    public void exportCELL(String filePath) {
        //导出CELL表
        try {
            cellRepository.export(filePath);
        } catch (Exception e) {
        }
    }

}
