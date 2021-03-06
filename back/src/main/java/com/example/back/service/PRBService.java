package com.example.back.service;

import com.example.back.model.PRB;

import java.util.Date;
import java.util.List;

public interface PRBService {

    void importPRB(List<PRB> prbs);

    void exportPRB(String filePath);

    void generate();

    void exportPRBnew(String filePath);

    List search(String keyword, String name, Date startTime, Date endTime);
}
