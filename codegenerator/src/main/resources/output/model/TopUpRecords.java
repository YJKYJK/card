package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TopUpRecords implements Serializable {

    //用户id
    private String userId;
    //用户名称
    private String userName;
    //充值金额
    private BigDecimal balance;
    //充值时间
    private Date topUpTm;
    //支付宝流水号
    private String alipayNo;
    //充值类型
    private String topUpType;
    //充值id
    private String topUpId;


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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setTopUpTm(Date topUpTm) {
        this.topUpTm = topUpTm;
    }

    public Date getTopUpTm() {
        return this.topUpTm;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    public String getAlipayNo() {
        return this.alipayNo;
    }

    public void setTopUpType(String topUpType) {
        this.topUpType = topUpType;
    }

    public String getTopUpType() {
        return this.topUpType;
    }

    public void setTopUpId(String topUpId) {
        this.topUpId = topUpId;
    }

    public String getTopUpId() {
        return this.topUpId;
    }
}
