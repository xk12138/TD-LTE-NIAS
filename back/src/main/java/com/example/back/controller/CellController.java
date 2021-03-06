package com.example.back.controller;

import com.example.back.common.ErrorCode;
import com.example.back.common.WebTools;
import com.example.back.config.ApplicationConfiguration;
import com.example.back.model.Cell;
import com.example.back.service.CellService;
import com.example.back.service.CookieService;
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
import java.util.*;

@RestController
@RequestMapping(value = "cell")
public class CellController {

    @Autowired
    CellService cellService;
    @Autowired
    CookieService cookieService;

    @RequestMapping(value = "import", consumes = "multipart/form-data;charset=utf-8")
    @CrossOrigin
    public ResponseEntity<String> importCell(HttpServletRequest request, MultipartFile file) throws IOException {
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
        List<com.example.back.model.Cell> cells = new ArrayList<>();
        int rows = sheet.getLastRowNum();
        for(int i = 1; i < rows; i++) {
            //对于每一行都进行创建然后放入列表中
            Row row = sheet.getRow(i);
            Cell cell = getCell(row);
            if(cell != null) {
                cells.add(cell);
            }
        }

        cellService.importCell(cells);

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "export")
    public ResponseEntity<String> exportCELL(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        String filePath = ApplicationConfiguration.outfileDir + "tbcell.txt";
        File file = new File(filePath);
        if(!file.exists()) {
            cellService.exportCELL(filePath);
        }

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "search_by_sector")
    public ResponseEntity<String> search_by_sector(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        int userId = cookieService.getUserIdByCookie(request.getCookies());
        if(userId == 0) {
            result.put("code", ErrorCode.UNAVAILABLE_COOKIE.getValue());
            return WebTools.buildJsonResponse(result);
        }

        String keyword = request.getParameter("keyword");


        result.put("list", cellService.search_by_sector(keyword));
        result.put("code", ErrorCode.SUCCESS.getValue());

        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "search_by_enodeB")
    public ResponseEntity<String> search_by_enodeB(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        int userId = cookieService.getUserIdByCookie(request.getCookies());
        if(userId == 0) {
            result.put("code", ErrorCode.UNAVAILABLE_COOKIE.getValue());
            return WebTools.buildJsonResponse(result);
        }

        String keyword = request.getParameter("keyword");


        result.put("list", cellService.search_by_enodeB(keyword));
        result.put("code", ErrorCode.SUCCESS.getValue());

        return WebTools.buildJsonResponse(result);
    }

    private Cell getCell(Row row) {
        if(row == null) {
            return null;
        }
        int columns = row.getPhysicalNumberOfCells();
        if(columns != 19) {
            return null;
        }
        Cell acell = new Cell();

        for (int i = 0; i < columns; i++) {
            org.apache.poi.ss.usermodel.Cell cell = row.getCell(i);
            switch (i) {
                case 0: {
                    acell.setCITY(((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue());
                    break;
                }
                case 1: {
                    acell.setSECTOR_ID(((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue());
                    break;
                }
                case 2: {
                    acell.setSECTOR_NAME(((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue());
                    break;
                }
                case 3: {
                    acell.setENODEBID((int) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 4: {
                    acell.setENODEB_NAME(((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue());
                    break;
                }
                case 5: {
                    acell.setEARFCN((int) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 6: {
                    acell.setPCI((int) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 7: {
                    acell.setPSS((int) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 8: {
                    acell.setSSS((int) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 9: {
                    acell.setTAC((int) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 10: {
                    acell.setVENDOR(((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue());
                    break;
                }
                case 11: {
                    cell.setCellType(CellType.NUMERIC);
                    acell.setLONGITUDE((float) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 12: {
                    cell.setCellType(CellType.NUMERIC);
                    acell.setLATITUDE((float) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 13: {
                    acell.setSTYLE(((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue());
                    break;
                }
                case 14: {
                    cell.setCellType(CellType.NUMERIC);
                    acell.setAZIMUTH((float) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 15: {
                    cell.setCellType(CellType.NUMERIC);
                    acell.setHEIGHT((float) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 16: {
                    cell.setCellType(CellType.NUMERIC);
                    acell.setELECTTILT((float) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 17: {
                    cell.setCellType(CellType.NUMERIC);
                    acell.setMECHTILT((float) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }
                case 18: {
                    cell.setCellType(CellType.NUMERIC);
                    acell.setTOTLETILT((float) ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue());
                    break;
                }

            }
        }
        return acell;
    }
}
