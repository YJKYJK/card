package com.yanyan.card.service;
import com.yanyan.card.bean.CommodityInfo;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface CommodityInfoService {

    public CommodityInfo getCommodityInfoById(Long id)throws Exception;

    public List<CommodityInfo>	getCommodityInfoListByMap(Map<String,Object> param)throws Exception;

    public Integer getCommodityInfoCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveCommodityInfo(CommodityInfo commodityInfo)throws Exception;

    public Integer modifyCommodityInfo(CommodityInfo commodityInfo)throws Exception;

    public Integer removeCommodityInfoById(Long id)throws Exception;

    public Page<CommodityInfo> queryCommodityInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
