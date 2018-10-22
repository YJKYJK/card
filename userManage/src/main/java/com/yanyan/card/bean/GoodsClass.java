package com.yanyan.card.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsClass implements Serializable {

    //类别id
    private Integer classId;
    //类别名称
    private String className;
    //商家id
    private String merchantId;
    //说明
    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTm;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operTm;

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getOperTm() {
        return operTm;
    }

    public void setOperTm(Date operTm) {
        this.operTm = operTm;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassId() {
        return this.classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }
}
