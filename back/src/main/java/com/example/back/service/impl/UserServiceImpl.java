package com.example.back.service.impl;

import com.example.back.model.User;
import com.example.back.repository.CookieRepository;
import com.example.back.repository.UserRepository;
import com.example.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CookieRepository cookieRepository;

    @Override
    public int login(String account, String password) {
        User user = userRepository.login(account, password);
        if(user == null) {
            return 0;
        }
        return user.getUserId();
    }

    @Override
    public boolean checkAccount(String account) {
        User user = userRepository.checkAccount(account);
        return user==null;
    }

    @Override
    @Transactional
    public int register(String account, String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        userRepository.save(user);
        return user.getUserId()==null? 0: user.getUserId();
    }

}
