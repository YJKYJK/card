package com.yanyan.card.service;

import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.util.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018/10/16 0016.
 */
public interface CommdityInfoService {


    public Page<CommodityInfo>queryByUser(MerchantInfo merchantInfo, Integer pageNumber, Integer pageSize);

    public boolean saveCommdityInfo(CommodityInfo commodityInfo);

    public boolean modifyCommodity(CommodityInfo commodityInfo);

    public boolean removeCommodity(CommodityInfo commodityInfo);

    public List<CommodityInfo> getCommodityByClass(String classId);

    public List<CommodityInfo> getCommodityByUserId(String merchantId);


    public CommodityInfo getCommodityById(String commodityId);

    public BigDecimal getTotalPrice(String commodityId,Integer num);

    public Boolean addNum(String commodityId,Integer num);

    Boolean modifyNum(String commodityId, Integer number);

    Boolean checknum(String commodityId, Integer number);


}
