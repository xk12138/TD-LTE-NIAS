package com.example.back.repository;


import com.example.back.model.Cell;
import com.example.back.model.CellKey;
import com.example.back.model.KPI;
import com.example.back.model.KPIKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CellRepository extends JpaRepository<Cell, CellKey> {
    @Query(value = "select * from tbcell into outfile :file_path", nativeQuery = true)
    void export(@Param(value = "file_path") String filePath);

}
