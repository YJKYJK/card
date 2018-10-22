package com.yanyan.card.mapper;
import com.yanyan.card.bean.TopUpRecords;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface TopUpRecordsMapper {

	public TopUpRecords getTopUpRecordsById(@Param(value = "id") Long id)throws Exception;

	public List<TopUpRecords>	getTopUpRecordsListByMap(Map<String, Object> param)throws Exception;

	public Integer getTopUpRecordsCountByMap(Map<String, Object> param)throws Exception;

	public Integer saveTopUpRecords(TopUpRecords topUpRecords)throws Exception;

	public Integer modifyTopUpRecords(TopUpRecords topUpRecords)throws Exception;

	public Integer removeTopUpRecordsById(@Param(value = "id") Long id)throws Exception;

}
