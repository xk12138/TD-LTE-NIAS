package com.example.back.repository;

import com.example.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where account=:account and password=:password", nativeQuery = true)
    User login(@Param(value = "account") String account, @Param(value = "password") String password);

    @Query(value = "select * from user where account=:account", nativeQuery = true)
    User checkAccount(@Param(value = "account") String account);

}
