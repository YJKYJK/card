package com.yanyan.card.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommodityInfo implements Serializable {

    //商品id
    private Integer commodityId;
    //类名
    private String className;
    //类别id
    private Integer classId;
    //商品名称
    private String commodityName;
    //商家id
    private String merchantId;
    //商品价格
    private BigDecimal price;
    //商品数量
    private Integer num;
    //商品说明
    private String remark;
    //图片
    private String pic;
    //创建时间
    private Date createTm;
    //操作时间
    private Date operTm;
    //已售数量
    private Integer selled;


    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommodityId() {
        return this.commodityId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassId() {
        return this.classId;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return this.pic;
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

    public void setSelled(Integer selled) {
        this.selled = selled;
    }

    public Integer getSelled() {
        return this.selled;
    }
}
