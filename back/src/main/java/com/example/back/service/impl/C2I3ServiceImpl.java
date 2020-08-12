package com.example.back.service.impl;

import com.example.back.repository.C2I3Repository;
import com.example.back.service.C2I3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class C2I3ServiceImpl implements C2I3Service {
    @Autowired
    C2I3Repository c2I3Repository;
    @PersistenceContext
    private EntityManager e;

    @Override
    public void exportC2I3(String filePath) {
        try {
            c2I3Repository.exportC2I3(filePath);
        } catch (Exception e) {
        }
    }

    @Override
    public List generate(double x) {
        String sql = "Select distinct a.scell as CELL1, b.scell as CELL2, c.ncell as CELL3 " +
                "from tbc2inew as a " +
                "join tbc2inew as b on a.ncell=b.scell " +
                "join tbc2inew as c on (b.ncell=c.scell and c.ncell=a.scell)" +
                " or (b.ncell=c.ncell and c.scell=a.scell)" +
                " where a.PrbABS6>=" + x +" and b.PrbABS6>=" + x + " and c.PrbABS6>="+x;
        return  e.createNativeQuery(sql).getResultList();
    }
}
