package com.yanyan.card.bean;

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
    //
    private Date createTm;
    //
    private Date operTm;


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

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getCreateTm() {
        return this.createTm;
    }

    public void setOperTm(Date operTm) {
        this.operTm = operTm;
    }

    public Date getOperTm() {
        return this.operTm;
    }
}
