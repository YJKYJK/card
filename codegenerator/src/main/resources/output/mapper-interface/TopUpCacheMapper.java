package com.yanyan.card.mapper;
import com.yanyan.card.bean.TopUpCache;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface TopUpCacheMapper {

	public TopUpCache getTopUpCacheById(@Param(value = "id") Long id)throws Exception;

	public List<TopUpCache>	getTopUpCacheListByMap(Map<String,Object> param)throws Exception;

	public Integer getTopUpCacheCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveTopUpCache(TopUpCache topUpCache)throws Exception;

	public Integer modifyTopUpCache(TopUpCache topUpCache)throws Exception;

	public Integer removeTopUpCacheById(@Param(value = "id") Long id)throws Exception;

}
