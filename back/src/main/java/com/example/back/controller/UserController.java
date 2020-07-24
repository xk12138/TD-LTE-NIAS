package com.example.back.controller;

import com.example.back.common.ErrorCode;
import com.example.back.common.UserTools;
import com.example.back.common.WebTools;
import com.example.back.service.CookieService;
import com.example.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CookieService cookieService;

    @RequestMapping(value = "login")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<>();

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            result.put("code", ErrorCode.MISSING_REQUIRED_PARAMETERS.getValue());
            return WebTools.buildJsonResponse(result);
        }

        int userId = userService.login(account, password);
        if(userId == 0) {
            result.put("code", ErrorCode.LOGIN_FAILED.getValue());
            return WebTools.buildJsonResponse(result);
        }

        String cookie = UserTools.generateCookie(userId);
        cookieService.save(userId, cookie);

        response.addCookie(new Cookie("ta", cookie));

        result.put("code", ErrorCode.SERVER_ERROR);
        return WebTools.buildJsonResponse(result);
    }

    @RequestMapping(value = "register")
    public ResponseEntity<String> register(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<>();

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            result.put("code", ErrorCode.MISSING_REQUIRED_PARAMETERS.getValue());
            return WebTools.buildJsonResponse(result);
        }

        boolean checkAccount = userService.checkAccount(account);
        if(!checkAccount) {
            result.put("code", ErrorCode.OPERATE_FAILED.getValue());
            result.put("msg", "此用户名已被使用");
            return WebTools.buildJsonResponse(result);
        }

        int userId = userService.login(account, password);
        if(userId == 0) {
            result.put("code", ErrorCode.REGISTER_FAILED.getValue());
            return WebTools.buildJsonResponse(result);
        }

        String cookie = UserTools.generateCookie(userId);
        cookieService.save(userId, cookie);

        response.addCookie(new Cookie("ta", cookie));

        result.put("code", ErrorCode.SERVER_ERROR);
        return WebTools.buildJsonResponse(result);
    }

}
