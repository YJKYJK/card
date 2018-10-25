package com.yanyan.card.mapper;
import com.yanyan.card.bean.ShopOder;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ShopOderMapper {

	public ShopOder getShopOderById(@Param(value = "id") Long id)throws Exception;

	public List<ShopOder>	getShopOderListByMap(Map<String,Object> param)throws Exception;

	public Integer getShopOderCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveShopOder(ShopOder shopOder)throws Exception;

	public Integer modifyShopOder(ShopOder shopOder)throws Exception;

	public Integer removeShopOderById(@Param(value = "id") Long id)throws Exception;

}
