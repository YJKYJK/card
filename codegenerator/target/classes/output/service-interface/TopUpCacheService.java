package com.yanyan.card.service;
import com.yanyan.card.bean.TopUpCache;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface TopUpCacheService {

    public TopUpCache getTopUpCacheById(Long id)throws Exception;

    public List<TopUpCache>	getTopUpCacheListByMap(Map<String,Object> param)throws Exception;

    public Integer getTopUpCacheCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveTopUpCache(TopUpCache topUpCache)throws Exception;

    public Integer modifyTopUpCache(TopUpCache topUpCache)throws Exception;

    public Integer removeTopUpCacheById(Long id)throws Exception;

    public Page<TopUpCache> queryTopUpCachePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
