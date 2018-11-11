package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopOrder implements Serializable {

    //
    private String orderId;
    //商品类型名称
    private Integer classId;
    //商品ID
    private String commodityId;
    //
    private String commodityName;
    //商品数量
    private Integer number;
    //商品价格
    private BigDecimal price;
    //商品总价
    private BigDecimal totalPrice;
    //是否支付
    private String isPay;
    //操作时间
    private Date oprtTm;
    //商家id
    private String merchantId;
    //购买人(用于用户未登录)
    private String buyUser;
    //购买人id
    private String buyUserId;
    //
    private String payType;
    //是否已发货
    private String isDelivery;


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassId() {
        return this.classId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityId() {
        return this.commodityId;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getIsPay() {
        return this.isPay;
    }

    public void setOprtTm(Date oprtTm) {
        this.oprtTm = oprtTm;
    }

    public Date getOprtTm() {
        return this.oprtTm;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setBuyUser(String buyUser) {
        this.buyUser = buyUser;
    }

    public String getBuyUser() {
        return this.buyUser;
    }

    public void setBuyUserId(String buyUserId) {
        this.buyUserId = buyUserId;
    }

    public String getBuyUserId() {
        return this.buyUserId;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setIsDelivery(String isDelivery) {
        this.isDelivery = isDelivery;
    }

    public String getIsDelivery() {
        return this.isDelivery;
    }
}
