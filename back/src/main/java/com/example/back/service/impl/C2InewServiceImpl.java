package com.example.back.service.impl;
import com.example.back.model.C2Inew;
import com.example.back.repository.C2InewRepository;

import com.example.back.service.C2InewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Service
public class C2InewServiceImpl implements C2InewService {

    @Autowired
    C2InewRepository c2InewRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    public void exportC2Inew(String filePath) {
        try {
            c2InewRepository.exportC2Inew(filePath);
        } catch (Exception e) {
        }
    }

}
