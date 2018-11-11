package com.yanyan.card.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopInfo implements Serializable {

    //商家id
    private String merchantId;
    //公告
    private String notice;
    //商店名称
    private String shopName;
    //QQ账号
    private String qq;
    //QQ群
    private String qqGroup;
    //最近操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operTm;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTm;


    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNotice() {
        return this.notice;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return this.shopName;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return this.qq;
    }

    public void setQqGroup(String qqGroup) {
        this.qqGroup = qqGroup;
    }

    public String getQqGroup() {
        return this.qqGroup;
    }

    public void setOperTm(Date operTm) {
        this.operTm = operTm;
    }

    public Date getOperTm() {
        return this.operTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getCreateTm() {
        return this.createTm;
    }
}
