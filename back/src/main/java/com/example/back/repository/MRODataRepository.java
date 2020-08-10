package com.example.back.repository;

import com.example.back.model.MROData;
import com.example.back.model.MRODataKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MRODataRepository extends JpaRepository<MROData, MRODataKey> {
    @Query(value = "select * from tbmrodata into outfile :file_path", nativeQuery = true)
    void export(@Param(value = "file_path") String filePath);

//    @Query(value = "select Ser, Int, count(..), AVG(), STDEV()  from tbmrodata group by ServingSecotr, InterferingSector")
//    List<Map<String, Object>> demo(String s, String n);

}
