package com.yanyan.card.service;

import com.yanyan.card.bean.CommodityDetail;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.util.Page;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface CommodityDetailService {
    Integer saveList(String km,String catLine, CommodityInfo commodityInfo);

    List<CommodityDetail> getCommodityDetailByParams(String commodityId,Integer number);

    Page<CommodityDetail>queryKamiByParams(CommodityDetail commodityDetail,Integer pageNumber,Integer pageSize);

    boolean deleteKami(CommodityDetail commodityDetail);

    CommodityDetail getKamiById(CommodityDetail commodityDetail);

    boolean modifyKami(CommodityDetail commodityDetail);

}
