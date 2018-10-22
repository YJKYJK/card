package com.yanyan.card.mapper;
import com.yanyan.card.bean.CommodityInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface CommodityInfoMapper {

	public CommodityInfo getCommodityInfoById(@Param(value = "id") Long id)throws Exception;

	public List<CommodityInfo>	getCommodityInfoListByMap(Map<String,Object> param)throws Exception;

	public Integer getCommodityInfoCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveCommodityInfo(CommodityInfo commodityInfo)throws Exception;

	public Integer modifyCommodityInfo(CommodityInfo commodityInfo)throws Exception;

	public Integer removeCommodityInfoById(@Param(value = "id") Long id)throws Exception;

}
