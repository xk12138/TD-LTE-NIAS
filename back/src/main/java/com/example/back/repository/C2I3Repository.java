package com.example.back.repository;

import com.example.back.model.C2I3;
import com.example.back.model.C2I3Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface C2I3Repository extends JpaRepository<C2I3, C2I3Key> {
    @Query(value = "select * from tbC2I3 into outfile :file_path", nativeQuery = true)
    void exportC2I3(@Param(value = "file_path") String filePath);
}
