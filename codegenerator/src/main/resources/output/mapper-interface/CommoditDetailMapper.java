package com.yanyan.card.mapper;
import com.yanyan.card.bean.CommoditDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface CommoditDetailMapper {

	public CommoditDetail getCommoditDetailById(@Param(value = "id") Long id)throws Exception;

	public List<CommoditDetail>	getCommoditDetailListByMap(Map<String,Object> param)throws Exception;

	public Integer getCommoditDetailCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveCommoditDetail(CommoditDetail commoditDetail)throws Exception;

	public Integer modifyCommoditDetail(CommoditDetail commoditDetail)throws Exception;

	public Integer removeCommoditDetailById(@Param(value = "id") Long id)throws Exception;

}
