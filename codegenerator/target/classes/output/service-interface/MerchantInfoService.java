package com.yanyan.card.service;
import com.yanyan.card.bean.MerchantInfo;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface MerchantInfoService {

    public MerchantInfo getMerchantInfoById(Long id)throws Exception;

    public List<MerchantInfo>	getMerchantInfoListByMap(Map<String,Object> param)throws Exception;

    public Integer getMerchantInfoCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveMerchantInfo(MerchantInfo merchantInfo)throws Exception;

    public Integer modifyMerchantInfo(MerchantInfo merchantInfo)throws Exception;

    public Integer removeMerchantInfoById(Long id)throws Exception;

    public Page<MerchantInfo> queryMerchantInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
