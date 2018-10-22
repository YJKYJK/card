package com.yanyan.card.service.impl;

import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.bean.UserInfo;
import com.yanyan.card.mapper.MerchantInfoMapper;
import com.yanyan.card.service.MerchantInfoService;
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

    /**
     * 商家注册
     * @param merchantInfo
     * @return
     */
    @Override
    public boolean saveMerchant(MerchantInfo merchantInfo) {
        Date date=new Date();
        String userId=date.getTime()+ UUID.randomUUID().toString().substring(0,12);
        merchantInfo.setMerchantId(userId);
        merchantInfo.setCreateTm(date);
        merchantInfo.setOperTm(date);
        //如果用户名已存在,注册失败
        if(this.quryUserByName(merchantInfo.getUserName())){
            return false;
        }
        Integer integer = merchantInfoMapper.saveMerchantInfo(merchantInfo);
        if(integer>0){
            return true;
        }
        return false;
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
