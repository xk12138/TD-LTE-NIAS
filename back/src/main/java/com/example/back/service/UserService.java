package com.example.back.service;

public interface UserService {

    int login(String account, String password);

    boolean checkAccount(String account);

    int register(String account, String password);

}
