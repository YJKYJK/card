package com.yanyan.card.service.impl;

import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.bean.ShopInfo;
import com.yanyan.card.bean.UserInfo;
import com.yanyan.card.mapper.MerchantInfoMapper;
import com.yanyan.card.mapper.ShopInfoMapper;
import com.yanyan.card.service.MerchantInfoService;
import com.yanyan.card.service.ShopInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/17 0017.
 */
@Service("mrchantInfoService")
public class MerchantInfoServiceImpl implements MerchantInfoService{
@Resource
private MerchantInfoMapper merchantInfoMapper;

@Resource
private ShopInfoService shopInfoService;

    /**
     * 商家注册
     * @param merchantInfo
     * @return
     */
    @Override
    public boolean saveMerchant(MerchantInfo merchantInfo) {
        Date date=new Date();
        String userId=date.getTime()+ UUID.randomUUID().toString().substring(0,12);
        //商家id
        merchantInfo.setMerchantId(userId);
        merchantInfo.setCreateTm(date);
        merchantInfo.setOperTm(date);
        //如果用户名已存在,注册失败
        if(this.quryUserByName(merchantInfo.getUserName())){
            return false;
        }
        Integer integer = merchantInfoMapper.saveMerchantInfo(merchantInfo);
        if(integer<1){
            return false;
        }

        boolean b = shopInfoService.saveShopInfo(merchantInfo);
        if(!b){
            return false;
        }

        return true;
    }


    /**
     * 判断该商家名是否存在
     * @param userName
     * @return
     */
    @Override
    public boolean quryUserByName(String userName) {
        Integer integer = merchantInfoMapper.quryUserByName(userName);
        if(integer>0){
            return true;
        }
        return false;
    }


    /**
     * 登录
     * @param merchantInfo
     * @return
     */
    @Override
    public MerchantInfo login(MerchantInfo merchantInfo) {
        MerchantInfo us = merchantInfoMapper.login(merchantInfo);

        return us;

    }

    @Override
    public MerchantInfo getMerchant(String merchantId) {
        MerchantInfo merchant = merchantInfoMapper.getMerchant(merchantId);
        return merchant;
    }
}
