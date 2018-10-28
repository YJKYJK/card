package com.yanyan.card.mapper;

import com.yanyan.card.bean.ShopOrder;

public interface ShopOrderMapper {

	Integer saveShopOrder(ShopOrder shopOrder);

	Integer modifyShopOrder(ShopOrder shopOrder);

	ShopOrder getOrderById(ShopOrder shopOrder);

}
