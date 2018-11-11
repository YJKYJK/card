package com.yanyan.card.mapper;

import com.yanyan.card.bean.CommodityDetail;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface CommodityDetailMapper {
    Integer saveList(List<CommodityDetail> list);

    List<CommodityDetail> getCommodityDetailListByMap(Map<String,Object> params);

    Integer updateList(List<CommodityDetail> kms);

    Integer update(CommodityDetail commodityDetail);

    List<CommodityDetail> getKamiListByMap(Map<String,Object> params);

    Integer getKamiCountByMap(Map<String,Object> params);

    Integer deleteKami(CommodityDetail commodityDetail);

    CommodityDetail getKamiById(CommodityDetail commodityDetail);

    Integer modifyCommodityDetail(CommodityDetail commodityDetail);
}
