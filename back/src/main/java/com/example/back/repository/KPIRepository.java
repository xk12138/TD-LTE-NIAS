package com.example.back.repository;

import com.example.back.model.KPI;
import com.example.back.model.KPIKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KPIRepository extends JpaRepository<KPI, KPIKey> {

    @Query(value = "select * from tbkpi into outfile :file_path", nativeQuery = true)
    void export(@Param(value = "file_path") String filePath);

//    @Query(value = "select * from tbKPI where 网元名称=:网元名称 and timestampdiff(day, :start_time, 起始时间)>=0 and timestampdiff(day, :end_time, 起始时间)<=0")
//    List<KPI> search(@Param(value = "网元名称") String 网元名称, @Param(value = "start_time") Date startTime, @Param(value = "end_time") Date endTime);

}
