package com.example.back.service.impl;

import com.example.back.model.PRB;
import com.example.back.repository.PRBRepository;
import com.example.back.repository.PRBnewRepository;
import com.example.back.service.KPIService;
import com.example.back.service.PRBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PRBServicelmpl implements PRBService {
    private static final int batch = 50;

    @Autowired
    PRBRepository prbRepository;
    @Autowired
    PRBnewRepository prBnewRepository;
    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional
    public void importPRB(List<PRB> prbs) {
        int page = prbs.size() / batch;
        for (int i = 0; i < page; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into tbprb ").append(PRB.toKeys()).append(" values ");
            List<PRB> temp = prbs.subList(i * batch, (i + 1) * batch);
            for (int j = 0; j < temp.size(); j++) {
                PRB prb = temp.get(j);
                stringBuilder.append(prb.toMsg());
                if(j != temp.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(" on duplicate key update 周期=15;");
            System.out.println(stringBuilder.toString());
            e.createNativeQuery(stringBuilder.toString()).executeUpdate();
        }
    }

    @Override
    public void exportPRB(String filePath) {
        //导出PRB表
        try {
            prbRepository.export(filePath);
        } catch (Exception e) {
        }
    }

    @Override
    @Transactional
    public void generate() {
        e.createNativeQuery("drop table if exists tbPRBnew").executeUpdate();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table if not exists tbPRBnew ( select ")
                .append(" DATE_FORMAT(起始时间, '%Y-%m-%d %H') as 起始时间, ")
                .append(" 周期, ")
                .append(" 网元名称, ")
                .append(" 小区, ")
                .append(" 小区名, ")
                .append(" avg(第0个PRB上检测到的干扰噪声的平均值) as 第0个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第1个PRB上检测到的干扰噪声的平均值) as 第1个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第2个PRB上检测到的干扰噪声的平均值) as 第2个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第3个PRB上检测到的干扰噪声的平均值) as 第3个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第4个PRB上检测到的干扰噪声的平均值) as 第4个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第5个PRB上检测到的干扰噪声的平均值) as 第5个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第6个PRB上检测到的干扰噪声的平均值) as 第6个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第7个PRB上检测到的干扰噪声的平均值) as 第7个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第8个PRB上检测到的干扰噪声的平均值) as 第8个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第9个PRB上检测到的干扰噪声的平均值) as 第9个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第10个PRB上检测到的干扰噪声的平均值) as 第10个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第11个PRB上检测到的干扰噪声的平均值) as 第11个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第12个PRB上检测到的干扰噪声的平均值) as 第12个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第13个PRB上检测到的干扰噪声的平均值) as 第13个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第14个PRB上检测到的干扰噪声的平均值) as 第14个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第15个PRB上检测到的干扰噪声的平均值) as 第15个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第16个PRB上检测到的干扰噪声的平均值) as 第16个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第17个PRB上检测到的干扰噪声的平均值) as 第17个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第18个PRB上检测到的干扰噪声的平均值) as 第18个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第19个PRB上检测到的干扰噪声的平均值) as 第19个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第20个PRB上检测到的干扰噪声的平均值) as 第20个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第21个PRB上检测到的干扰噪声的平均值) as 第21个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第22个PRB上检测到的干扰噪声的平均值) as 第22个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第23个PRB上检测到的干扰噪声的平均值) as 第23个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第24个PRB上检测到的干扰噪声的平均值) as 第24个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第25个PRB上检测到的干扰噪声的平均值) as 第25个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第26个PRB上检测到的干扰噪声的平均值) as 第26个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第27个PRB上检测到的干扰噪声的平均值) as 第27个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第28个PRB上检测到的干扰噪声的平均值) as 第28个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第29个PRB上检测到的干扰噪声的平均值) as 第29个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第30个PRB上检测到的干扰噪声的平均值) as 第30个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第31个PRB上检测到的干扰噪声的平均值) as 第31个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第32个PRB上检测到的干扰噪声的平均值) as 第32个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第33个PRB上检测到的干扰噪声的平均值) as 第33个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第34个PRB上检测到的干扰噪声的平均值) as 第34个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第35个PRB上检测到的干扰噪声的平均值) as 第35个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第36个PRB上检测到的干扰噪声的平均值) as 第36个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第37个PRB上检测到的干扰噪声的平均值) as 第37个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第38个PRB上检测到的干扰噪声的平均值) as 第38个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第39个PRB上检测到的干扰噪声的平均值) as 第39个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第40个PRB上检测到的干扰噪声的平均值) as 第40个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第41个PRB上检测到的干扰噪声的平均值) as 第41个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第42个PRB上检测到的干扰噪声的平均值) as 第42个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第43个PRB上检测到的干扰噪声的平均值) as 第43个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第44个PRB上检测到的干扰噪声的平均值) as 第44个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第45个PRB上检测到的干扰噪声的平均值) as 第45个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第46个PRB上检测到的干扰噪声的平均值) as 第46个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第47个PRB上检测到的干扰噪声的平均值) as 第47个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第48个PRB上检测到的干扰噪声的平均值) as 第48个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第49个PRB上检测到的干扰噪声的平均值) as 第49个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第50个PRB上检测到的干扰噪声的平均值) as 第50个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第51个PRB上检测到的干扰噪声的平均值) as 第51个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第52个PRB上检测到的干扰噪声的平均值) as 第52个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第53个PRB上检测到的干扰噪声的平均值) as 第53个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第54个PRB上检测到的干扰噪声的平均值) as 第54个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第55个PRB上检测到的干扰噪声的平均值) as 第55个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第56个PRB上检测到的干扰噪声的平均值) as 第56个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第57个PRB上检测到的干扰噪声的平均值) as 第57个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第58个PRB上检测到的干扰噪声的平均值) as 第58个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第59个PRB上检测到的干扰噪声的平均值) as 第59个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第60个PRB上检测到的干扰噪声的平均值) as 第60个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第61个PRB上检测到的干扰噪声的平均值) as 第61个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第62个PRB上检测到的干扰噪声的平均值) as 第62个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第63个PRB上检测到的干扰噪声的平均值) as 第63个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第64个PRB上检测到的干扰噪声的平均值) as 第64个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第65个PRB上检测到的干扰噪声的平均值) as 第65个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第66个PRB上检测到的干扰噪声的平均值) as 第66个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第67个PRB上检测到的干扰噪声的平均值) as 第67个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第68个PRB上检测到的干扰噪声的平均值) as 第68个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第69个PRB上检测到的干扰噪声的平均值) as 第69个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第70个PRB上检测到的干扰噪声的平均值) as 第70个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第71个PRB上检测到的干扰噪声的平均值) as 第71个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第72个PRB上检测到的干扰噪声的平均值) as 第72个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第73个PRB上检测到的干扰噪声的平均值) as 第73个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第74个PRB上检测到的干扰噪声的平均值) as 第74个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第75个PRB上检测到的干扰噪声的平均值) as 第75个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第76个PRB上检测到的干扰噪声的平均值) as 第76个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第77个PRB上检测到的干扰噪声的平均值) as 第77个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第78个PRB上检测到的干扰噪声的平均值) as 第78个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第79个PRB上检测到的干扰噪声的平均值) as 第79个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第80个PRB上检测到的干扰噪声的平均值) as 第80个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第81个PRB上检测到的干扰噪声的平均值) as 第81个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第82个PRB上检测到的干扰噪声的平均值) as 第82个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第83个PRB上检测到的干扰噪声的平均值) as 第83个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第84个PRB上检测到的干扰噪声的平均值) as 第84个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第85个PRB上检测到的干扰噪声的平均值) as 第85个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第86个PRB上检测到的干扰噪声的平均值) as 第86个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第87个PRB上检测到的干扰噪声的平均值) as 第87个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第88个PRB上检测到的干扰噪声的平均值) as 第88个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第89个PRB上检测到的干扰噪声的平均值) as 第89个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第90个PRB上检测到的干扰噪声的平均值) as 第90个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第91个PRB上检测到的干扰噪声的平均值) as 第91个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第92个PRB上检测到的干扰噪声的平均值) as 第92个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第93个PRB上检测到的干扰噪声的平均值) as 第93个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第94个PRB上检测到的干扰噪声的平均值) as 第94个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第95个PRB上检测到的干扰噪声的平均值) as 第95个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第96个PRB上检测到的干扰噪声的平均值) as 第96个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第97个PRB上检测到的干扰噪声的平均值) as 第97个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第98个PRB上检测到的干扰噪声的平均值) as 第98个PRB上检测到的干扰噪声的平均值, ")
                .append(" avg(第99个PRB上检测到的干扰噪声的平均值) as 第99个PRB上检测到的干扰噪声的平均值 ")
                .append(" from tbPRB group by DATE_FORMAT(起始时间, '%Y-%m-%d %H'), 周期, 网元名称, 小区, 小区名)");

        e.createNativeQuery(stringBuilder.toString()).executeUpdate();
    }

    @Override
    public void exportPRBnew(String filePath) {
        //导出PRBnew表
        try {
            prBnewRepository.exportPRBnew(filePath);
        } catch (Exception e) {
        }
    }

}
