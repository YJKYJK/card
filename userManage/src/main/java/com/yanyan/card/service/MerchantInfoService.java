package com.yanyan.card.service;

import com.yanyan.card.bean.MerchantInfo;

/**
 * Created by Administrator on 2018/10/17 0017.
 */
public interface MerchantInfoService {

    boolean saveMerchant(MerchantInfo merchantInfo);

    boolean quryUserByName(String userName);

     MerchantInfo login(MerchantInfo merchantInfo);

     MerchantInfo getMerchant(String merchantId);
}
