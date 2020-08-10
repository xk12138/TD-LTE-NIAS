package com.example.back.service.impl;

import com.example.back.repository.C2I3Repository;
import com.example.back.service.C2I3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
