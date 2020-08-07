package com.example.back.repository;

import com.example.back.model.MROData;
import com.example.back.model.MRODataKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MRODataRepository extends JpaRepository<MROData, MRODataKey> {
    @Query(value = "select * from tbmrodata into outfile :file_path", nativeQuery = true)
    void export(@Param(value = "file_path") String filePath);


}
