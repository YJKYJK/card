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
    //用户id
    private String userId;


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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }
}
