package com.example.back.controller;
import com.example.back.common.ErrorCode;
import com.example.back.common.WebTools;
import com.example.back.config.ApplicationConfiguration;
import com.example.back.model.C2Inew;
import com.example.back.service.C2InewService;
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
@RequestMapping(value = "c2i")
public class C2InewController {
    @Autowired
    CookieService cookieService;
    @Autowired
    C2InewService c2iService;

    @RequestMapping(value = "export")
    public ResponseEntity<String> exportC2Inew(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        String filePath = ApplicationConfiguration.outfileDir + "tbc2inew.txt";
        File file = new File(filePath);
        if(!file.exists()) {
            c2iService.exportC2Inew(filePath);
        }

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

}
