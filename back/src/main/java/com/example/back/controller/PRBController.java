package com.example.back.controller;


import com.example.back.common.ErrorCode;
import com.example.back.common.WebTools;
import com.example.back.config.ApplicationConfiguration;
import com.example.back.model.PRB;
import com.example.back.service.CookieService;
import com.example.back.service.PRBService;
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
@RequestMapping(value = "prb")
public class PRBController {

    @Autowired
    PRBService prbService;
    @Autowired
    CookieService cookieService;

    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @RequestMapping(value = "import", consumes = "multipart/form-data;charset=utf-8")
    @CrossOrigin
    public ResponseEntity<String> importPRB(HttpServletRequest request, MultipartFile file) throws IOException {
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
        List<PRB> prbs = new ArrayList<>();
        int rows = sheet.getLastRowNum();
        for(int i = 1; i < rows; i++) {
            //对于每一行都进行创建然后放入列表中
            Row row = sheet.getRow(i);
            PRB prb = getPRB(row);
            if(prb != null) {
                prbs.add(prb);
            }
        }

        prbService.importPRB(prbs);

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "export")
    public ResponseEntity<String> exportCELL(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        String filePath = ApplicationConfiguration.outfileDir + "tbprb.txt";
        File file = new File(filePath);
        if(!file.exists()) {
            prbService.exportPRB(filePath);
        }

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "generate")
    public ResponseEntity<String> generate(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        int userId = cookieService.getUserIdByCookie(request.getCookies());
        if(userId == 0) {
            result.put("code", ErrorCode.UNAVAILABLE_COOKIE.getValue());
            return WebTools.buildJsonResponse(result);
        }


        String filePath = ApplicationConfiguration.outfileDir + "tbprbnew.txt";
        File file = new File(filePath);
        if(!file.exists()) {
            prbService.generate();
            prbService.exportPRBnew(filePath);
        }


        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "search")
    public ResponseEntity<String> search(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        int userId = cookieService.getUserIdByCookie(request.getCookies());
        if(userId == 0) {
            result.put("code", ErrorCode.UNAVAILABLE_COOKIE.getValue());
            return WebTools.buildJsonResponse(result);
        }



        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    private PRB getPRB(Row row) {
        if(row == null) {
            return null;
        }
        int columns = row.getPhysicalNumberOfCells();
        if(columns != 105) {
            return null;
        }
        PRB prb = new PRB();
        for (int i = 0; i < columns; i++) {
            Cell cell = row.getCell(i);
            switch (i) {
                case 0: {
                    try {
                        prb.set起始时间(dateFormat.parse(cell.getStringCellValue()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return null;
                    }
                    break;
                }
                case 1: {
                    prb.set周期((int) cell.getNumericCellValue());
                    break;
                }
                case 2: {
                    prb.set网元名称(cell.getStringCellValue());
                    break;
                }
                case 3: {
                    prb.set小区(cell.getStringCellValue());
                    break;
                }
                case 4: {
                    prb.set小区名(cell.getStringCellValue());
                    break;
                }
                case 5: {
                    prb.set第0个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 6: {
                    prb.set第1个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 7: {
                    prb.set第2个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 8: {
                    prb.set第3个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 9: {
                    prb.set第4个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 10: {
                    prb.set第5个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 11: {
                    prb.set第6个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 12: {
                    prb.set第7个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 13: {
                    prb.set第8个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 14: {
                    prb.set第9个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 15: {
                    prb.set第10个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 16: {
                    prb.set第11个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 17: {
                    prb.set第12个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 18: {
                    prb.set第13个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 19: {
                    prb.set第14个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 20: {
                    prb.set第15个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 21: {
                    prb.set第16个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 22: {
                    prb.set第17个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 23: {
                    prb.set第18个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 24: {
                    prb.set第19个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 25: {
                    prb.set第20个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 26: {
                    prb.set第21个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 27: {
                    prb.set第22个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 28: {
                    prb.set第23个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 29: {
                    prb.set第24个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 30: {
                    prb.set第25个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 31: {
                    prb.set第26个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 32: {
                    prb.set第27个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 33: {
                    prb.set第28个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 34: {
                    prb.set第29个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 35: {
                    prb.set第30个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 36: {
                    prb.set第31个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 37: {
                    prb.set第32个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 38: {
                    prb.set第33个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 39: {
                    prb.set第34个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 40: {
                    prb.set第35个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 41: {
                    prb.set第36个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 42: {
                    prb.set第37个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 43: {
                    prb.set第38个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 44: {
                    prb.set第39个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 45: {
                    prb.set第40个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 46: {
                    prb.set第41个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 47: {
                    prb.set第42个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 48: {
                    prb.set第43个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 49: {
                    prb.set第44个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 50: {
                    prb.set第45个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 51: {
                    prb.set第46个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 52: {
                    prb.set第47个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 53: {
                    prb.set第48个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 54: {
                    prb.set第49个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 55: {
                    prb.set第50个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 56: {
                    prb.set第51个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 57: {
                    prb.set第52个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 58: {
                    prb.set第53个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 59: {
                    prb.set第54个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 60: {
                    prb.set第55个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 61: {
                    prb.set第56个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 62: {
                    prb.set第57个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 63: {
                    prb.set第58个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 64: {
                    prb.set第59个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 65: {
                    prb.set第60个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 66: {
                    prb.set第61个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 67: {
                    prb.set第62个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 68: {
                    prb.set第63个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 69: {
                    prb.set第64个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 70: {
                    prb.set第65个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 71: {
                    prb.set第66个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 72: {
                    prb.set第67个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 73: {
                    prb.set第68个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 74: {
                    prb.set第69个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 75: {
                    prb.set第70个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 76: {
                    prb.set第71个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 77: {
                    prb.set第72个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 78: {
                    prb.set第73个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 79: {
                    prb.set第74个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 80: {
                    prb.set第75个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 81: {
                    prb.set第76个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 82: {
                    prb.set第77个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 83: {
                    prb.set第78个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 84: {
                    prb.set第79个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 85: {
                    prb.set第80个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 86: {
                    prb.set第81个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 87: {
                    prb.set第82个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 88: {
                    prb.set第83个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 89: {
                    prb.set第84个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 90: {
                    prb.set第85个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 91: {
                    prb.set第86个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 92: {
                    prb.set第87个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 93: {
                    prb.set第88个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 94: {
                    prb.set第89个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 95: {
                    prb.set第90个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 96: {
                    prb.set第91个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 97: {
                    prb.set第92个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 98: {
                    prb.set第93个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 99: {
                    prb.set第94个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 100: {
                    prb.set第95个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 101: {
                    prb.set第96个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 102: {
                    prb.set第97个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 103: {
                    prb.set第98个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }
                case 104: {
                    prb.set第99个PRB上检测到的干扰噪声的平均值((int) cell.getNumericCellValue());
                    break;
                }

            }
        }
        return prb;
    }


}
