package com.yanyan.card.service;
import com.yanyan.card.bean.CommodityDetail;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface CommodityDetailService {

    public CommodityDetail getCommodityDetailById(Long id)throws Exception;

    public List<CommodityDetail>	getCommodityDetailListByMap(Map<String,Object> param)throws Exception;

    public Integer getCommodityDetailCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveCommodityDetail(CommodityDetail commodityDetail)throws Exception;

    public Integer modifyCommodityDetail(CommodityDetail commodityDetail)throws Exception;

    public Integer removeCommodityDetailById(Long id)throws Exception;

    public Page<CommodityDetail> queryCommodityDetailPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
