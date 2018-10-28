package com.yanyan.card.mapper;
import com.yanyan.card.bean.BuyRecord;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface BuyRecordMapper {
//
//	public BuyRecord getBuyRecordById(@Param(value = "id") Long id)throws Exception;
//
//	public List<BuyRecord>	getBuyRecordListByMap(Map<String, Object> param)throws Exception;
//
//	public Integer getBuyRecordCountByMap(Map<String, Object> param)throws Exception;
//
//	public Integer saveBuyRecord(BuyRecord buyRecord)throws Exception;

//	public Integer modifyBuyRecord(BuyRecord buyRecord)throws Exception;
//
//	public Integer removeBuyRecordById(@Param(value = "id") Long id)throws Exception;


	public Integer saveBuyRecord(BuyRecord buyRecord);

	public List<BuyRecord>	getBuyRecordListByMap(Map<String, Object> param);

}
