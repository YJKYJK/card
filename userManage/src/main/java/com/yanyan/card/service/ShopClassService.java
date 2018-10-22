package com.yanyan.card.service;

import com.yanyan.card.bean.GoodsClass;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/10/18 0018.
 */
public interface ShopClassService {

    Page<GoodsClass> queryByUser(MerchantInfo merchantInfo,Integer pageNumber,Integer pageSize);

    boolean saveGoodsClass(MerchantInfo merchantInfo, GoodsClass goodsClass);


    boolean modifyGoodsClass(GoodsClass goodsClass);

    boolean removeGoodsClassById(GoodsClass goodsClass);

    List<GoodsClass> getClassList(MerchantInfo merchantInfo);
    List<GoodsClass>getClassById(String merchantId);
}
