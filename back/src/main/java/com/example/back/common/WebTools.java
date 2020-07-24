package com.example.back.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Map;

public class WebTools {

    public static String map2string(Map<String, Object> map) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{\"code\": " +  ErrorCode.JSON_STRINGIFY_FAILED.getValue() + "}";
    }

    public static ResponseEntity<String> buildJsonResponse(Map<String, Object> map) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return (ResponseEntity<String>)ResponseEntity.status(200).headers(headers).body(map2string(map));
    }

}
