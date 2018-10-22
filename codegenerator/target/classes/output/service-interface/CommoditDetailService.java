package com.yanyan.card.service;
import com.yanyan.card.bean.CommoditDetail;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface CommoditDetailService {

    public CommoditDetail getCommoditDetailById(Long id)throws Exception;

    public List<CommoditDetail>	getCommoditDetailListByMap(Map<String,Object> param)throws Exception;

    public Integer getCommoditDetailCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveCommoditDetail(CommoditDetail commoditDetail)throws Exception;

    public Integer modifyCommoditDetail(CommoditDetail commoditDetail)throws Exception;

    public Integer removeCommoditDetailById(Long id)throws Exception;

    public Page<CommoditDetail> queryCommoditDetailPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
