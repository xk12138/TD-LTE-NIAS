package com.example.back.repository;

import com.example.back.model.C2Inew;
import com.example.back.model.C2InewKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface C2InewRepository extends JpaRepository<C2Inew, C2InewKey> {

    @Query(value = "select * from tbC2Inew into outfile :file_path", nativeQuery = true)
    void exportC2Inew(@Param(value = "file_path") String filePath);

}
