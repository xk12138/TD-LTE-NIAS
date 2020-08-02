package com.example.back.repository;

import com.example.back.model.PRB;
import com.example.back.model.PRBKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PRBRepository extends JpaRepository<PRB, PRBKey> {

//    @Query(value = "create table if not exists tbPRBnew (select " +
//            " 起始时间, 60 as 周期， 网元名称")
//    void createIfNotExists();

}
