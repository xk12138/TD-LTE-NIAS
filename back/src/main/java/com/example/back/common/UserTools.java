package com.example.back.common;

import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTools {

    public static String generateCookie(int userId) {
        return DigestUtils.md5DigestAsHex(("UserId=" + userId + "&Time=" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "&Copyright=Peggy").getBytes());
    }

}
