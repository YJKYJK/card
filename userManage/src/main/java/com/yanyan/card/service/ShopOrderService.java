package com.yanyan.card.service;

import com.yanyan.card.bean.ShopOrder;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface ShopOrderService {
    ShopOrder getFullShopOrder(ShopOrder shopOrder);

   boolean saveShopOrder(ShopOrder shopOrder);

   boolean modifyShopOrder(ShopOrder shopOrder);

   boolean modifyAll(ShopOrder shopOrder);
}
