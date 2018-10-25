package com.yanyan.card.mapper;
import com.yanyan.card.bean.CommodityDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface CommodityDetailMapper {

	public CommodityDetail getCommodityDetailById(@Param(value = "id") Long id)throws Exception;

	public List<CommodityDetail>	getCommodityDetailListByMap(Map<String,Object> param)throws Exception;

	public Integer getCommodityDetailCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveCommodityDetail(CommodityDetail commodityDetail)throws Exception;

	public Integer modifyCommodityDetail(CommodityDetail commodityDetail)throws Exception;

	public Integer removeCommodityDetailById(@Param(value = "id") Long id)throws Exception;

}
