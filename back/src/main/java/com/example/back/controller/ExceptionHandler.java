package com.example.back.controller;

import com.example.back.common.ErrorCode;
import com.example.back.common.WebTools;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<>();
        map.put("code", ErrorCode.SERVER_ERROR.getValue());
        return WebTools.buildJsonResponse(map);
    }

}
