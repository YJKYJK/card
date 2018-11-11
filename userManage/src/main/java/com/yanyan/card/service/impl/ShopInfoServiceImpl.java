package com.yanyan.card.service.impl;

import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.bean.ShopInfo;
import com.yanyan.card.mapper.ShopInfoMapper;
import com.yanyan.card.service.ShopInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/11/3 0003.
 */
@Service("shopInfoService")
public class ShopInfoServiceImpl implements ShopInfoService {
    @Resource
    private ShopInfoMapper shopInfoMapper;

    /**
     * 添加商店信息
     * @param merchantInfo
     * @return
     */
    @Override
    public boolean saveShopInfo(MerchantInfo merchantInfo) {
        //添加商店信息
        ShopInfo shopInfo=new ShopInfo();
        //商店名称默认为用户名
        shopInfo.setShopName(merchantInfo.getUserName());
        //商店id
        shopInfo.setMerchantId(merchantInfo.getMerchantId());
        //商家QQ
        shopInfo.setQq(merchantInfo.getQq());
        //创建时间
        shopInfo.setCreateTm(merchantInfo.getCreateTm());
        //操作时间
        shopInfo.setOperTm(merchantInfo.getCreateTm());
        Integer integer = shopInfoMapper.saveShopInfo(shopInfo);
        if(integer>0){
            return true;
        }
        return false;
    }





    /**
     * 修改商店信息
     * @param shopInfo
     * @return
     */
    @Override
    public boolean modifyShopInfo(ShopInfo shopInfo) {
        Integer integer = shopInfoMapper.modifyShopInfo(shopInfo);
        if (integer>0){
            return true;
        }
        return false;
    }


    /**
     * 根据商家id拿商店信息
     * @param merchantId
     * @return
     */
    @Override
    public ShopInfo getShopInfoById(String merchantId) {
        return shopInfoMapper.getShopInfoById(merchantId);
    }
}
