package com.example.back.repository;

import com.example.back.model.PRBKey;
import com.example.back.model.PRBnew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PRBnewRepository extends JpaRepository<PRBnew, PRBKey> {

    @Query(value = "select * from tbprbnew into outfile :file_path", nativeQuery = true)
    void exportPRBnew(@Param(value = "file_path") String filePath);

}
