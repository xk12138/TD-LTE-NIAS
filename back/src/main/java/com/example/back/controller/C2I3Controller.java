package com.example.back.controller;

import com.example.back.common.ErrorCode;
import com.example.back.common.WebTools;
import com.example.back.config.ApplicationConfiguration;
import com.example.back.service.C2I3Service;
import com.example.back.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "c2i3")
public class C2I3Controller {
    @Autowired
    CookieService cookieService;
    @Autowired
    C2I3Service c2i3Service;

    @RequestMapping(value = "export")
    public ResponseEntity<String> exportC2I3(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        String filePath = ApplicationConfiguration.outfileDir + "tbc2i3.txt";
        File file = new File(filePath);
        if(!file.exists()) {
            c2i3Service.exportC2I3(filePath);
        }

        result.put("code", ErrorCode.SUCCESS.getValue());
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "generate")
    public ResponseEntity<String> search(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        int userId = cookieService.getUserIdByCookie(request.getCookies());
        if(userId == 0) {
            result.put("code", ErrorCode.UNAVAILABLE_COOKIE.getValue());
            return WebTools.buildJsonResponse(result);
        }

        double x=Double.parseDouble(request.getParameter("x"));


        //c2i3Service.generate(x);
        result.put("list", c2i3Service.generate(x));
        result.put("code", ErrorCode.SUCCESS.getValue());

        return WebTools.buildJsonResponse(result);
    }


}
