package com.yanyan.card.mapper;
import com.yanyan.card.bean.ShopInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ShopInfoMapper {

	public ShopInfo getShopInfoById(@Param(value = "id") Long id)throws Exception;

	public List<ShopInfo>	getShopInfoListByMap(Map<String,Object> param)throws Exception;

	public Integer getShopInfoCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveShopInfo(ShopInfo shopInfo)throws Exception;

	public Integer modifyShopInfo(ShopInfo shopInfo)throws Exception;

	public Integer removeShopInfoById(@Param(value = "id") Long id)throws Exception;

}
