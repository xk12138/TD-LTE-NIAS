package com.example.back.repository;

import com.example.back.model.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookieRepository extends JpaRepository<Cookie, String> {
}
