package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BuyRecord implements Serializable {

    //购买记录id
    private String buyId;
    //商品ID
    private Integer commodityId;
    //商品名称
    private String commodityName;
    // 卡密 卡号
    private String cardNumber;
    //卡密 密码
    private String cardPassword;
    //购买时间
    private Date buyTm;
    //价格
    private BigDecimal price;
    //购买用户名
    private String userName;
    //用户id
    private String userId;
    //用户未登录时购买
    private String userKey;
    //商家id
    private String merchantId;
    //商家名称
    private String merchantName;


    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public String getBuyId() {
        return this.buyId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommodityId() {
        return this.commodityId;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public String getCardPassword() {
        return this.cardPassword;
    }

    public void setBuyTm(Date buyTm) {
        this.buyTm = buyTm;
    }

    public Date getBuyTm() {
        return this.buyTm;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantName() {
        return this.merchantName;
    }
}
