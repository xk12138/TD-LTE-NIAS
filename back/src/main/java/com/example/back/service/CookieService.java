package com.example.back.service;

import javax.servlet.http.Cookie;

public interface CookieService {

    void save(int userId, String cookie);

    int getUserIdByCookie(Cookie[] cookies);

}

