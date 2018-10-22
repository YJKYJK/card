package com.yanyan.card.mapper;
import com.yanyan.card.bean.TopUpApply;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface TopUpApplyMapper {

	public TopUpApply getTopUpApplyById(@Param(value = "id") Long id)throws Exception;

	public List<TopUpApply>	getTopUpApplyListByMap(Map<String,Object> param)throws Exception;

	public Integer getTopUpApplyCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveTopUpApply(TopUpApply topUpApply)throws Exception;

	public Integer modifyTopUpApply(TopUpApply topUpApply)throws Exception;

	public Integer removeTopUpApplyById(@Param(value = "id") Long id)throws Exception;

}
