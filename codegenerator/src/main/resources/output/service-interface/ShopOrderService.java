package com.yanyan.card.service;
import com.yanyan.card.bean.ShopOrder;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface ShopOrderService {

    public ShopOrder getShopOrderById(Long id)throws Exception;

    public List<ShopOrder>	getShopOrderListByMap(Map<String,Object> param)throws Exception;

    public Integer getShopOrderCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveShopOrder(ShopOrder shopOrder)throws Exception;

    public Integer modifyShopOrder(ShopOrder shopOrder)throws Exception;

    public Integer removeShopOrderById(Long id)throws Exception;

    public Page<ShopOrder> queryShopOrderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
