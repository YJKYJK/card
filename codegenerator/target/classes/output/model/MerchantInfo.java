package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MerchantInfo implements Serializable {

    //商家id
    private String merchantId;
    //商家名称
    private String userName;
    //商家密码
    private String password;
    //商家手机号
    private String phone;
    //商家QQ
    private String qq;
    //创建时间
    private Date createTm;
    //用户余额
    private BigDecimal balance;
    //用户最后操作时间
    private Date operTm;


    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
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
