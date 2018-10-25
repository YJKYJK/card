package com.yanyan.card.mapper;
import com.yanyan.card.bean.ShopOrder;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ShopOrderMapper {

	public ShopOrder getShopOrderById(@Param(value = "id") Long id)throws Exception;

	public List<ShopOrder>	getShopOrderListByMap(Map<String,Object> param)throws Exception;

	public Integer getShopOrderCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveShopOrder(ShopOrder shopOrder)throws Exception;

	public Integer modifyShopOrder(ShopOrder shopOrder)throws Exception;

	public Integer removeShopOrderById(@Param(value = "id") Long id)throws Exception;

}
