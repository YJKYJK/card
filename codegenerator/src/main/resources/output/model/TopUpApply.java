package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TopUpApply implements Serializable {

    //用户id
    private String userId;
    //用户名称
    private String userName;
    //支付宝流水号
    private String alipayNo;
    //申请时间
    private Date applyTm;
    //是否完成
    private String isFinish;
    //申请id
    private String applyId;


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

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    public String getAlipayNo() {
        return this.alipayNo;
    }

    public void setApplyTm(Date applyTm) {
        this.applyTm = applyTm;
    }

    public Date getApplyTm() {
        return this.applyTm;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

    public String getIsFinish() {
        return this.isFinish;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getApplyId() {
        return this.applyId;
    }
}
