package com.yanyan.card.mapper;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface CommodityInfoMapper {

//	public CommodityInfo getCommodityInfoById(@Param(value = "id") Long id)throws Exception;
//
//	public List<CommodityInfo>	getCommodityInfoListByMap(Map<String, Object> param)throws Exception;
//
//	public Integer getCommodityInfoCountByMap(Map<String, Object> param)throws Exception;
//
//	public Integer saveCommodityInfo(CommodityInfo commodityInfo)throws Exception;
//
//	public Integer modifyCommodityInfo(CommodityInfo commodityInfo)throws Exception;
//
//	public Integer removeCommodityInfoById(@Param(value = "id") Long id)throws Exception;



	Integer  saveCommdityInfo(CommodityInfo commodityInfo);

	List<CommodityInfo> queryByUser(Map<String,Object> params);


	Integer queryCountByUser(MerchantInfo merchantInfo);

	Integer modifyCommodity(CommodityInfo commodityInfo);

	Integer removeCommodity(CommodityInfo commodityInfo);

	List<CommodityInfo> getCommodityByClass(String classId);

	CommodityInfo getCommodityById(String commodityId);

	Integer modifyCommodityNum(CommodityInfo commodityInfo);

}
