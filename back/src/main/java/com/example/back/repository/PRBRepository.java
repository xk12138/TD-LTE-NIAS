package com.example.back.repository;

import com.example.back.model.PRB;
import com.example.back.model.PRBKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PRBRepository extends JpaRepository<PRB, PRBKey> {

    @Query(value = "insert into tbprb values (:prbs)", nativeQuery = true)
    @Modifying
    void importPRB(@Param(value = "prbs") List<PRB> prbs);

    @Query(value = "insert into tbprb values (:prbs)", nativeQuery = true)
    @Modifying
    void test(@Param(value = "prbs") String prbs);
//    @Query(value = "create table if not exists tbPRBnew (select " +
//            " 起始时间, 60 as 周期， 网元名称")
//    void createIfNotExists();

}
