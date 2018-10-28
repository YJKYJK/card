package com.yanyan.card.service.impl;

import com.yanyan.card.bean.BuyRecord;
import com.yanyan.card.bean.CommodityDetail;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.ShopOrder;
import com.yanyan.card.mapper.ShopOrderMapper;
import com.yanyan.card.service.BuyRecordService;
import com.yanyan.card.service.CommdityInfoService;
import com.yanyan.card.service.CommodityDetailService;
import com.yanyan.card.service.ShopOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
    @Resource
    private CommodityDetailService commodityDetailService;
    @Resource
    private BuyRecordService buyRecordService;
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

    /**
     * 发货
     * @param shopOrder
     * @return
     */
    @Override
    public boolean  modifyAll(ShopOrder shopOrder) {
        Date date=new Date();
        // 根据订单id获取该订单详细信息
        ShopOrder fullShopOrder= shopOrderMapper.getOrderById(shopOrder);
        // 将订单更改为已支付4
        fullShopOrder.setIsPay("Y");
        boolean pay = modifyShopOrder(fullShopOrder);
        if (!pay){
            return false;
        }
        //减少库存
        Boolean modifyNum = commdityInfoService.modifyNum(fullShopOrder.getCommodityId(),
                fullShopOrder.getNumber());
        if(!modifyNum){
            return false;
        }

        //获取卡密
        List<CommodityDetail> commodityDetails= commodityDetailService.getCommodityDetailByParams(fullShopOrder.getCommodityId(),
                fullShopOrder.getNumber());

        for (CommodityDetail c:commodityDetails) {
            //添加订单
            BuyRecord buyRecord=new BuyRecord();
            //订单号
            buyRecord.setBuyId(fullShopOrder.getOrderId());
            //卡号
            buyRecord.setCardNumber(c.getCardNumber());
            // 卡密
            buyRecord.setCardPassword(c.getCardPassword());
            //商品ID
            buyRecord.setCommodityId(Integer.valueOf(fullShopOrder.getCommodityId()));
            //商品名称
            buyRecord.setCommodityName(fullShopOrder.getCommodityName());
            // 购买人
            buyRecord.setUserKey(fullShopOrder.getBuyUser());
            //价格
            buyRecord.setPrice(fullShopOrder.getPrice());

            boolean b = buyRecordService.saveBuyRecord(buyRecord);
            if(!b){
                return false;
            }
        }

        return true;
    }
}
