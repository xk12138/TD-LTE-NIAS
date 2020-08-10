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
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        System.out.println("啥bug啊"+cells);
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
//            StringBuilder stringBuilder_del = new StringBuilder();//删除语句
//            stringBuilder_del.append("delete from tbcell where SECTOR_ID=");
            stringBuilder.append("insert into tbCell ").append(Cell.toKeys()).append(" values ");
            List<Cell> temp = cells.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                Cell cell = temp.get(j);
                stringBuilder.append(cell.toMsg());
                if(j != temp.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(" on duplicate key update CITY=VALUES(CITY)," +
                    "SECTOR_NAME=VALUES(SECTOR_NAME),ENODEBID=VALUES(ENODEBID)," +
                    "ENODEB_NAME=VALUES(ENODEB_NAME),EARFCN=VALUES(EARFCN)," +
                    "PCI=VALUES(PCI),PSS=VALUES(PSS),SSS=VALUES(SSS),TAC=VALUES(TAC)," +
                    "VENDOR=VALUES(VENDOR),LONGITUDE=VALUES(LONGITUDE),LATITUDE=VALUES(LATITUDE)," +
                    "STYLE=VALUES(STYLE),AZIMUTH=VALUES(AZIMUTH),HEIGHT=VALUES(HEIGHT)," +
                    "ELECTTILT=VALUES(ELECTTILT),MECHTILT=VALUES(MECHTILT),TOTLETILT=VALUES(TOTLETILT);");
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

    @Override
    public List<Map<String, Object>> search_by_sector(String keyword) {
        System.out.println(keyword);
        String sql = "select * from tbcell where SECTOR_NAME='" + keyword+ "' or SECTOR_ID='" + keyword +"'";
        return e.createNativeQuery(sql).getResultList();
    }

    @Override
    public List<Map<String, Object>> search_by_enodeB(String keyword) {
        String sql = "select " + "*" + " from tbCell where eNodeBID=" + keyword + " or eNodeBNAME=" + keyword +"GROUP BY SECTOR_ID";
        return e.createNativeQuery(sql).getResultList();
    }



}
