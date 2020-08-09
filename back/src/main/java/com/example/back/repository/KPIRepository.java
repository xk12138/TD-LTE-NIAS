package com.example.back.repository;

import com.example.back.model.KPI;
import com.example.back.model.KPIKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface KPIRepository extends JpaRepository<KPI, KPIKey> {

    @Query(value = "select * from tbkpi into outfile :file_path", nativeQuery = true)
    void export(@Param(value = "file_path") String filePath);

}
