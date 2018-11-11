package com.yanyan.card.service;
import com.yanyan.card.bean.ShopInfo;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface ShopInfoService {

    public ShopInfo getShopInfoById(Long id)throws Exception;

    public List<ShopInfo>	getShopInfoListByMap(Map<String,Object> param)throws Exception;

    public Integer getShopInfoCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveShopInfo(ShopInfo shopInfo)throws Exception;

    public Integer modifyShopInfo(ShopInfo shopInfo)throws Exception;

    public Integer removeShopInfoById(Long id)throws Exception;

    public Page<ShopInfo> queryShopInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
