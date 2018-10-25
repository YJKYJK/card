package com.yanyan.card.service;
import com.yanyan.card.bean.ShopOder;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface ShopOderService {

    public ShopOder getShopOderById(Long id)throws Exception;

    public List<ShopOder>	getShopOderListByMap(Map<String,Object> param)throws Exception;

    public Integer getShopOderCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveShopOder(ShopOder shopOder)throws Exception;

    public Integer modifyShopOder(ShopOder shopOder)throws Exception;

    public Integer removeShopOderById(Long id)throws Exception;

    public Page<ShopOder> queryShopOderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
