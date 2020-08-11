package com.example.back.service.impl;

import com.example.back.model.C2Inew;
import com.example.back.model.MROData;
import com.example.back.repository.C2InewRepository;
import com.example.back.repository.MRODataRepository;
import com.example.back.service.MRODataService;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.math3.distribution.NormalDistribution;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Service
public class MRODataServicelmpl implements MRODataService {

    private static final int batch = 50;

    @Autowired
    MRODataRepository mrodataRepository;
    @Autowired
    C2InewRepository c2InewRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional
    public void importMROData(List<MROData> mrods) {
        int page = mrods.size() / batch;
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into tbMROData ").append(MROData.toKeys()).append(" values ");
            List<MROData> temp = mrods.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                MROData mro = temp.get(j);
                stringBuilder.append(mro.toMsg());
                if(j != temp.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(" on duplicate key update " +
                    "lte_nc_earfcn=values(lte_nc_earfcn),lte_nc_pci=values(lte_nc_pci)," +
                    "lte_ncrsrp=VALUES(lte_ncrsrp),lte_scrsrp=VALUES(lte_scrsrp);");
            System.out.println(stringBuilder.toString());
            e.createNativeQuery(stringBuilder.toString()).executeUpdate();
        }
    }

    @Override
    public void exportMRO(String filePath) {
        //导出MRO表
        try {
            mrodataRepository.export(filePath);
        } catch (Exception e) {
        }
    }

    @Override
    @Transactional
    public void generate() {

        e.createNativeQuery("drop table if exists tbC2Inew").executeUpdate();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table if not exists tbC2Inew ( select ")
                .append(" Serving_Sector as SECLL, ")
                .append(" Interfering_Sector as NECLL, ")
                .append(" count(Lte_NcRSRP) as count, ")
                .append(" avg(Lte_ScRSRP-Lte_NcRSRP) as C2I_Mean, ")
                .append(" stddev(Lte_ScRSRP-Lte_NcRSRP) as C2I_Std ")
                .append(" from tbmrodata group by serving_sector, interfering_sector")
                .append(" having count(lte_ncrsrp) > 6 order by count)");

        e.createNativeQuery(stringBuilder.toString()).executeUpdate();

        List<C2Inew> dataList = c2InewRepository.findAll();
        NormalDistribution d;
        Float amean, astd;
        for (C2Inew c2Inew : dataList) {
            amean = c2Inew.getC2I_Mean();
            astd =  c2Inew.getC2I_Std();
            d = new NormalDistribution(amean, astd);
            c2Inew.setPrC2I9((float)d.cumulativeProbability(9));
            c2Inew.setPrbABS6((float)(d.cumulativeProbability(6)+d.cumulativeProbability(-6)));
        }
        c2InewRepository.saveAll(dataList);
        e.createNativeQuery(stringBuilder.toString()).executeUpdate();
    }

    @Override
    public void exportC2Inew(String filePath) {
        try {
            c2InewRepository.exportC2Inew(filePath);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Map<String, Object>> search() {
        String sql = "select Serving_Sector,Interfering_Sector,count(Lte_NcRSRP) as count," +
                " avg(Lte_ScRSRP-Lte_NcRSRP) as mean, stddev(Lte_ScRSRP-Lte_NcRSRP) as std " +
                " from tbMROData" +
                " group by Serving_Sector, Interfering_Sector" +
                " having count(Lte_NcRSRP) > 1000 order by count";
        return e.createNativeQuery(sql).getResultList();
    }

}
