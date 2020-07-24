package com.example.back.service.impl;

import com.example.back.model.Cookie;
import com.example.back.repository.CookieRepository;
import com.example.back.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CookieServiceImpl implements CookieService {

    @Autowired
    CookieRepository cookieRepository;

    @Override
    @Transactional
    public void save(int userId, String cookie) {
        Cookie newCookie = new Cookie(userId, cookie);
        cookieRepository.save(newCookie);
    }

    @Override
    public int getUserIdByCookie(javax.servlet.http.Cookie[] cookies) {
        if(cookies == null) {
            return 0;
        }
        Date now = new Date();
        for(javax.servlet.http.Cookie cookie: cookies) {
            if(cookie.getName().equals("ta")) {
                Cookie targetCookie = cookieRepository.findById(cookie.getValue()).orElse(null);
                if(targetCookie != null && targetCookie.getExpiryTime().after(now)) {
                    return targetCookie.getUserId();
                }
            }
        }
        return 0;
    }

}
