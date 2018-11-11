package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityDetail implements Serializable {

    //商品ID
    private Integer commodityId;
    //卡号
    private String cardNumber;
    //卡密
    private String cardPassword;
    //是否出售
    private String isSell;
    //创建时间
    private Date createTm;
    //出售时间
    private Date sellTm;
    //id 
    private Integer cardId;
    //商家id
    private String merchantId;
    //商品名称
    private String commodityName;



    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommodityId() {
        return this.commodityId;
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

    public void setIsSell(String isSell) {
        this.isSell = isSell;
    }

    public String getIsSell() {
        return this.isSell;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getCreateTm() {
        return this.createTm;
    }

    public void setSellTm(Date sellTm) {
        this.sellTm = sellTm;
    }

    public Date getSellTm() {
        return this.sellTm;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCardId() {
        return this.cardId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityName() {
        return this.commodityName;
    }
}
