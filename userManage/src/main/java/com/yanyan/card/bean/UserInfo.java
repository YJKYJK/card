package com.yanyan.card.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserInfo implements Serializable {

    //用户id
    private String userId;
    //用户名称
    private String userName;
    //用户密码
    private String password;
    //用户手机号
    private String phone;
    //用户QQ
    private String qq;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTm;
    //用户余额
    private BigDecimal balance;
    //用户最后操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operTm;


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return this.qq;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getCreateTm() {
        return this.createTm;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setOperTm(Date operTm) {
        this.operTm = operTm;
    }

    public Date getOperTm() {
        return this.operTm;
    }
}
