package com.example.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cookie")
public class Cookie {

    @Id
    @Column(name = "cookie_id")
    private String cookieId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "expiry_time")
    private Date expiryTime;

    public Cookie() {}
    public Cookie(int userId, String cookieId) {
        this.userId = userId;
        this.cookieId = cookieId;
        this.expiryTime = new Date(new Date().getTime() + 7776000000L);     //设置Cookie有效期三个月
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "cookieId='" + cookieId + '\'' +
                ", userId=" + userId +
                ", expiryTime=" + expiryTime +
                '}';
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }
}
