package com.example.back.controller;


import com.example.back.common.ErrorCode;
import com.example.back.common.WebTools;
import com.example.back.config.ApplicationConfiguration;
import com.example.back.model.MROData;
import com.example.back.service.MRODataService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "mro")
public class MRODataController {

    @Autowired
    MRODataService mrodataService;

    @RequestMapping(value = "import", consumes = "multipart/form-data;charset=utf-8")
    @CrossOrigin
    public ResponseEntity<String> importMROData(HttpServletRequest request, MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        InputStream inputStream = file.getInputStream();

        Workbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
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
        List<MROData> mrods = new ArrayList<>();
        int rows = sheet.getLastRowNum();
        for(int i = 1; i < rows; i++) {
            //对于每一行都进行创建然后放入列表中
            Row row = sheet.getRow(i);
            MROData mro = getMROData(row);
            if(mro != null) {
                mrods.add(mro);
            }
        }

        mrodataService.importMROData(mrods);

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "export")
    public ResponseEntity<String> exportCELL(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        String filePath = ApplicationConfiguration.outfileDir + "tbmro.txt";
        File file = new File(filePath);
        if(!file.exists()) {
            mrodataService.exportMRO(filePath);
        }

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    private MROData getMROData(Row row) {
        if(row == null) {
            return null;
        }
        int columns = row.getPhysicalNumberOfCells();
        if(columns != 7) {
            return null;
        }
        MROData mro = new MROData();
        for (int i = 0; i < columns; i++) {
            Cell cell = row.getCell(i);
            switch (i) {
                case 0: {
                    mro.setTimeStamp(cell.getStringCellValue());
                    break;
                }
                case 1: {
                    mro.setServingSector(cell.getStringCellValue());
                    break;
                }
                case 2: {
                    mro.setInterferingSector(cell.getStringCellValue());
                    break;
                }
                case 3: {
                    mro.setLteNcRSRP((float) cell.getNumericCellValue());
                    break;
                }
                case 4: {
                    mro.setLteScRSRP((float) cell.getNumericCellValue());
                    break;
                }
                case 5: {
                    mro.setLteNcEarfcn((int) cell.getNumericCellValue());
                    break;
                }
                case 6: {
                    mro.setLteNcPci((int) cell.getNumericCellValue());
                    break;
                }

            }
        }
        return mro;
    }
}
