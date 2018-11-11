package com.yanyan.card.service;

import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.bean.ShopInfo;

/**
 * Created by Administrator on 2018/11/3 0003.
 */
public interface ShopInfoService {
    public boolean saveShopInfo(MerchantInfo merchantInfo);

    public boolean modifyShopInfo(ShopInfo shopInfo);

    public ShopInfo getShopInfoById(String merchantId);
}
