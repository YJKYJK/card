package com.yanyan.card.mapper;

import com.yanyan.card.bean.CommodityDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface CommodityDetailMapper {
    public Integer saveList(List<CommodityDetail> list);
    List<CommodityDetail> getCommodityDetailListByMap(Map<String,Object> params);
    Integer updateList(List<CommodityDetail> kms);
    Integer update(CommodityDetail commodityDetail);
}
