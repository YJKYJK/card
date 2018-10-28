package com.yanyan.card.service;

import com.yanyan.card.bean.CommodityDetail;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface CommodityDetailService {
    public Integer saveList(String km,String catLine, CommodityInfo commodityInfo);

    public List<CommodityDetail> getCommodityDetailByParams(String commodityId,Integer number);
}
