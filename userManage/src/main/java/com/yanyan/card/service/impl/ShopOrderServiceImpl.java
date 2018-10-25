package com.yanyan.card.service.impl;

import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.ShopOrder;
import com.yanyan.card.mapper.ShopOrderMapper;
import com.yanyan.card.service.CommdityInfoService;
import com.yanyan.card.service.ShopOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Service("shopOrderService")
public class ShopOrderServiceImpl implements ShopOrderService{
    @Resource
    private CommdityInfoService commdityInfoService;

    @Resource
    private ShopOrderMapper shopOrderMapper;

    @Override
    public ShopOrder getFullShopOrder(ShopOrder shopOrder) {
        Date date=new Date();
        CommodityInfo commodity = commdityInfoService.getCommodityById(shopOrder.getCommodityId());
        //订单号
        String orderId=date.getTime()+UUID.randomUUID().toString().substring(0,6);
        shopOrder.setOrderId(orderId);
        //价格
        shopOrder.setPrice(commodity.getPrice());
        //总价
        BigDecimal totalPrice = commdityInfoService.getTotalPrice(shopOrder.getCommodityId(), shopOrder.getNumber());
        shopOrder.setTotalPrice(totalPrice);
        //操作时间
        shopOrder.setOprtTm(date);
        //名字
        shopOrder.setCommodityName(commodity.getCommodityName());
        //是否支付
        shopOrder.setIsPay("N");

        saveShopOrder(shopOrder);

        return shopOrder;
    }


    /**
     * 添加订单
     * @param shopOrder
     * @return
     */
    @Override
    public boolean saveShopOrder(ShopOrder shopOrder) {
        Integer b = shopOrderMapper.saveShopOrder(shopOrder);
        if(b>0){
            return true;
        }
        return false;
    }


    /**
     * 修改订单
     * @param shopOrder
     * @return
     */
    @Override
    public boolean modifyShopOrder(ShopOrder shopOrder) {
        Date date=new Date();
        shopOrder.setOprtTm(date);
        Integer integer = shopOrderMapper.modifyShopOrder(shopOrder);
        if (integer>0){
            return true;
        }
        return false;
    }
}
