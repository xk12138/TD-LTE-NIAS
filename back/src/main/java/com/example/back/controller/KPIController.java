package com.example.back.controller;

import com.example.back.common.ErrorCode;
import com.example.back.common.WebTools;
import com.example.back.model.KPI;
import com.example.back.service.KPIService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "kpi")
public class KPIController {

    @Autowired
    KPIService kpiService;

    @RequestMapping(value = "import")
    @CrossOrigin
    public ResponseEntity<String> importKPI(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        Workbook workbook;
        try {
            workbook = new XSSFWorkbook(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code", ErrorCode.OPERATE_FAILED.getValue());
            return WebTools.buildJsonResponse(result);
        }

        Sheet sheet = workbook.getSheetAt(0);
        if(sheet == null) {
            result.put("code", ErrorCode.OPERATE_FAILED.getValue());
            return WebTools.buildJsonResponse(result);
        }
        List<KPI> kpis = new ArrayList<>();
        int rows = sheet.getLastRowNum();
        for(int i = 1; i < rows; i++) {
            //对于每一行都进行创建然后放入列表中
            Row row = sheet.getRow(i);
            KPI kpi = getKPI(row);
            if(kpi != null) {
                kpis.add(kpi);
            }
        }

        kpiService.importKPI(kpis);

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    private KPI getKPI(Row row) {
        if(row == null) {
            return null;
        }
        int columns = row.getPhysicalNumberOfCells();
        if(columns != 42) {         //总共42行
            return null;
        }
        KPI kpi = new KPI();
        for (int i = 0; i < columns; i++) {
            Cell cell = row.getCell(i);
            switch (i) {
                case 0: {
                    kpi.set起始时间(cell.getDateCellValue());
                    break;
                }
                case 1: {
                    kpi.set周期((int) cell.getNumericCellValue());
                    break;
                }
                case 2: {
                    kpi.set网元名称(cell.getStringCellValue());
                    break;
                }
                case 3: {
                    kpi.set小区(cell.getStringCellValue());
                    break;
                }
                case 4: {
                    kpi.set小区名(cell.getStringCellValue());
                    break;
                }
                case 5: {
                    kpi.setRRC连接建立完成次数((int) cell.getNumericCellValue());
                    break;
                }
                case 6: {
                    kpi.setRRC连接请求次数_包括重发((int) cell.getNumericCellValue());
                    break;
                }
                case 7: {
                    kpi.setRRC建立成功率qf((float) cell.getNumericCellValue());
                    break;
                }
                case 8: {
                    kpi.setE_RAB建立成功总次数((int) cell.getNumericCellValue());
                    break;
                }
                case 9: {
                    kpi.setE_RAB建立尝试总次数((int) cell.getNumericCellValue());
                    break;
                }
                case 10: {
                    kpi.setE_RAB建立成功率((float) cell.getNumericCellValue());
                    break;
                }
                case 11: {
                    kpi.seteNodeB触发的E_RAB异常释放总次数((int) cell.getNumericCellValue());
                    break;
                }
                case 12: {
                    kpi.set小区切换出E_RAB异常释放总次数((int) cell.getNumericCellValue());
                    break;
                }
                case 13: {
                    kpi.setE_RAB掉线率_新((float) cell.getNumericCellValue());
                    break;
                }
                case 14: {
                    kpi.set无线接通率ay((float) cell.getNumericCellValue());
                    break;
                }
                case 15: {
                    kpi.seteNodeB发起的S1_RESET导致的UE_Context释放次数((int) cell.getNumericCellValue());
                    break;
                }
                case 16: {
                    kpi.setUE_Context异常释放次数((int) cell.getNumericCellValue());
                    break;
                }
                case 17: {
                    kpi.setUE_Context建立成功总次数((int) cell.getNumericCellValue());
                    break;
                }
                case 18: {
                    kpi.set无线掉线率((float) cell.getNumericCellValue());
                    break;
                }
                case 19: {
                    kpi.seteNodeB内异频切换出成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 20: {
                    kpi.seteNodeB内异频切换出尝试次数((int) cell.getNumericCellValue());
                    break;
                }
                case 21: {
                    kpi.seteNodeB内同频切换出成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 22: {
                    kpi.seteNodeB内同频切换出尝试次数((int) cell.getNumericCellValue());
                    break;
                }
                case 23: {
                    kpi.seteNodeB间异频切换出成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 24: {
                    kpi.seteNodeB间异频切换出尝试次数((int) cell.getNumericCellValue());
                    break;
                }
                case 25: {
                    kpi.seteNodeB间同频切换出成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 26: {
                    kpi.seteNodeB间同频切换出尝试次数((int) cell.getNumericCellValue());
                    break;
                }
                case 27: {
                    kpi.seteNB内切换成功率((float) cell.getNumericCellValue());
                    break;
                }
                case 28: {
                    kpi.seteNB间切换成功率((float) cell.getNumericCellValue());
                    break;
                }
                case 29: {
                    kpi.set同频切换成功率zsp((float) cell.getNumericCellValue());
                    break;
                }
                case 30: {
                    kpi.set异频切换成功率zsp((float) cell.getNumericCellValue());
                    break;
                }
                case 31: {
                    kpi.set切换成功率((float) cell.getNumericCellValue());
                    break;
                }
                case 32: {
                    kpi.set小区PDCP层所接收到的上行数据的总吞吐量((int) cell.getNumericCellValue());
                    break;
                }
                case 33: {
                    kpi.set小区PDCP层所发送的下行数据的总吞吐量((int) cell.getNumericCellValue());
                    break;
                }
                case 34: {
                    kpi.setRRC重建请求次数((int) cell.getNumericCellValue());
                    break;
                }
                case 35: {
                    kpi.setRRC连接重建比率((float) cell.getNumericCellValue());
                    break;
                }
                case 36: {
                    kpi.set通过重建回源小区的eNodeB间同频切换出执行成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 37: {
                    kpi.set通过重建回源小区的eNodeB间异频切换出执行成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 38: {
                    kpi.set通过重建回源小区的eNodeB内同频切换出执行成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 39: {
                    kpi.set通过重建回源小区的eNodeB内异频切换出执行成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 40: {
                    kpi.seteNB内切换出成功次数((int) cell.getNumericCellValue());
                    break;
                }
                case 41: {
                    kpi.seteNB内切换出请求次数((int) cell.getNumericCellValue());
                    break;
                }
            }
        }
        return kpi;
    }

}
