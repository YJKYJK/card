package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TopUpCache implements Serializable {

    //支付宝流水号
    private String alipayNo;
    //充值时间
    private String topUpTm;
    //是否已充值 Y已充值 N 未充值
    private String isTopUp;
    //金额
    private BigDecimal money;
    //充值缓存id
    private Integer cacheId;
    //创建时间
    private Date createTm;


    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    public String getAlipayNo() {
        return this.alipayNo;
    }

    public void setTopUpTm(String topUpTm) {
        this.topUpTm = topUpTm;
    }

    public String getTopUpTm() {
        return this.topUpTm;
    }

    public void setIsTopUp(String isTopUp) {
        this.isTopUp = isTopUp;
    }

    public String getIsTopUp() {
        return this.isTopUp;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void setCacheId(Integer cacheId) {
        this.cacheId = cacheId;
    }

    public Integer getCacheId() {
        return this.cacheId;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getCreateTm() {
        return this.createTm;
    }
}
