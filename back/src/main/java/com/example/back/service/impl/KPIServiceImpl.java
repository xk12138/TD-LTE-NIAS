package com.example.back.service.impl;

import com.example.back.model.KPI;
import com.example.back.repository.KPIRepository;
import com.example.back.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class KPIServiceImpl implements KPIService {

    private static final int batch = 50;

    @Autowired
    KPIRepository kpiRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional
    public void importKPI(List<KPI> kpis) {
        int page = kpis.size() / batch;
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into tbkpi ").append(KPI.toKeys()).append(" values ");
            List<KPI> temp = kpis.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                KPI kpi = temp.get(j);
                stringBuilder.append(kpi.toMsg());
                if(j != temp.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(" on duplicate key update 周期=VALUES(周期),网元名称=VALUES(网元名称),小区=VALUES(小区)," +
                    "RRC连接建立完成次数=VALUES(RRC连接建立完成次数),RRC连接请求次数_包括重发=VALUES(RRC连接请求次数_包括重发)," +
                    "RRC建立成功率qf=VALUES(RRC建立成功率qf),E_RAB建立成功总次数=VALUES(E_RAB建立成功总次数)," +
                    "E_RAB建立尝试总次数=VALUES(E_RAB建立尝试总次数),E_RAB建立成功率=VALUES(E_RAB建立成功率)," +
                    "e_nodeB触发的E_RAB异常释放总次数=VALUES(e_nodeB触发的E_RAB异常释放总次数)," +
                    "小区切换出E_RAB异常释放总次数=VALUES(小区切换出E_RAB异常释放总次数)," +
                    "E_RAB掉线率_新=VALUES(E_RAB掉线率_新),无线接通率ay=VALUES(无线接通率ay)," +
                    "e_nodeB发起的S1_RESET导致的UE_Context释放次数=VALUES(e_nodeB发起的S1_RESET导致的UE_Context释放次数)," +
                    "UE_Context异常释放次数=VALUES(UE_Context异常释放次数),UE_Context建立成功总次数=VALUES(UE_Context建立成功总次数)," +
                    "无线掉线率=VALUES(无线掉线率)," +
                    "e_nodeB内异频切换出成功次数=VALUES(e_nodeB内异频切换出成功次数)," +
                    "e_nodeB内异频切换出尝试次数=VALUES(e_nodeB内异频切换出尝试次数)," +
                    "e_nodeB内同频切换出成功次数=VALUES(e_nodeB内同频切换出成功次数)," +
                    "e_nodeB内同频切换出尝试次数=VALUES(e_nodeB内同频切换出尝试次数)," +
                    "e_nodeB间异频切换出成功次数=VALUES(e_nodeB间异频切换出成功次数)," +
                    "e_nodeB间异频切换出尝试次数=VALUES(e_nodeB间异频切换出尝试次数)," +
                    "e_nodeB间同频切换出成功次数=VALUES(e_nodeB间同频切换出成功次数)," +
                    "e_nodeB间同频切换出尝试次数=VALUES(e_nodeB间同频切换出尝试次数)," +
                    "eNB内切换成功率=VALUES(eNB内切换成功率),eNB间切换成功率=VALUES(eNB间切换成功率)," +
                    "同频切换成功率zsp=VALUES(同频切换成功率zsp),异频切换成功率zsp=VALUES(异频切换成功率zsp)," +
                    "切换成功率=VALUES(切换成功率),小区PDCP层所接收到的上行数据的总吞吐量=VALUES(小区PDCP层所接收到的上行数据的总吞吐量)," +
                    "小区PDCP层所发送的下行数据的总吞吐量=VALUES(小区PDCP层所发送的下行数据的总吞吐量)," +
                    "RRC重建请求次数=VALUES(RRC重建请求次数),RRC连接重建比率=VALUES(RRC连接重建比率)," +
                    "通过重建回源小区的e_nodeB间同频切换出执行成功次数=VALUES(通过重建回源小区的e_nodeB间同频切换出执行成功次数)," +
                    "通过重建回源小区的e_nodeB间异频切换出执行成功次数=VALUES(通过重建回源小区的e_nodeB间异频切换出执行成功次数)," +
                    "通过重建回源小区的e_nodeB内同频切换出执行成功次数=VALUES(通过重建回源小区的e_nodeB内同频切换出执行成功次数)," +
                    "通过重建回源小区的e_nodeB内异频切换出执行成功次数=VALUES(通过重建回源小区的e_nodeB内异频切换出执行成功次数)," +
                    "eNB内切换出成功次数=VALUES(eNB内切换出成功次数),eNB内切换出请求次数=VALUES(eNB内切换出请求次数)");
            System.out.println(stringBuilder.toString());
            e.createNativeQuery(stringBuilder.toString()).executeUpdate();
        }
    }

    @Override
    public void exportKPI(String filePath) {
        //导出KPI表
        try {
            kpiRepository.export(filePath);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Map<String, Object>> search(String keyword, String name, Date startTime, Date endTime) {
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String sql = "select " + keyword + ",起始时间" + " from tbKPI where 网元名称=\'" + name + "\' and timestampdiff(day, \'" + dateFormat.format(startTime) + "\', 起始时间)>=0 and timestampdiff(day, \'" + dateFormat.format(endTime) + "\', 起始时间)<=0";
        return e.createNativeQuery(sql).getResultList();
    }

}
