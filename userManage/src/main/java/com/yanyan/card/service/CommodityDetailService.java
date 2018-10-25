package com.yanyan.card.service;

import com.yanyan.card.bean.CommodityDetail;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface CommodityDetailService {
    public Integer saveList(String km,String catLine, CommodityInfo commodityInfo);
}
