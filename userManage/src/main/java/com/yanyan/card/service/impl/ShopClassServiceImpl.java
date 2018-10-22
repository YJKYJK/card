package com.yanyan.card.service.impl;

import com.yanyan.card.bean.GoodsClass;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.mapper.GoodsClassMapper;
import com.yanyan.card.service.ShopClassService;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/18 0018.
 */
@Service("shopClassService")
public class ShopClassServiceImpl implements ShopClassService{

  @Resource
    private GoodsClassMapper goodsClassMapper;


  /**
     * 获取该商家的所有分类
     * @param merchantInfo
     * @return
     */
    @Override
    public Page<GoodsClass> queryByUser(MerchantInfo merchantInfo,Integer pageNumber,Integer pageSize) {
        if(EmptyUtils.isEmpty(pageNumber)){
            pageNumber=0;
        }

        if (EmptyUtils.isEmpty(pageSize)){
            pageSize=6;
        }
        if(pageNumber>0){
            pageNumber=(pageNumber-1)*pageSize;
        }

        Map<String,Object> params=new HashMap<>();
        params.put("merchantInfo",merchantInfo);
        params.put("pageNumber",pageNumber);
        params.put("pageSize",pageSize);

        List<GoodsClass> goodsClassList=goodsClassMapper.queryByUser(params);
        Integer total = goodsClassMapper.queryCountByUser(merchantInfo);
        Page<GoodsClass> page=new Page<>();
        page.setRows(goodsClassList);
        page.setTotal(total);

        return page;
    }


    /**
     * 添加类别
     * @param merchantInfo
     * @param goodsClass
     * @return
     */
    @Override
    public boolean saveGoodsClass(MerchantInfo merchantInfo,GoodsClass goodsClass) {
        Date date=new Date();
        goodsClass.setMerchantId(merchantInfo.getMerchantId());
        goodsClass.setCreateTm(date);
        goodsClass.setOperTm(date);
        Integer integer = goodsClassMapper.saveGoodsClass(goodsClass);
        if(integer>0){
            return true;
        }
        return false;
    }


    /**
     * 修改类别
     * @param goodsClass
     * @return
     */
    @Override
    public boolean modifyGoodsClass(GoodsClass goodsClass){
        Date date=new Date();
        goodsClass.setOperTm(date);
        Integer integer = goodsClassMapper.modifyGoodsClass(goodsClass);
        if(integer>0){
            return  true;
        }
        return false;
    }


    /**
     * 删除类别
     * @param goodsClass
     * @return
     */
    @Override
    public boolean removeGoodsClassById(GoodsClass goodsClass) {
        Integer integer = goodsClassMapper.removeGoodsClassById(goodsClass);
        if(integer>0){
            return true;
        }
        return false;
    }


    /**
     * 获取所有商品类别
     * @param merchantInfo
     * @return
     */
    public List<GoodsClass> getClassList(MerchantInfo merchantInfo){
        Integer total = goodsClassMapper.queryCountByUser(merchantInfo);
        Map<String,Object> params=new HashMap<>();
        params.put("merchantInfo",merchantInfo);
        params.put("pageNumber",0);
        params.put("pageSize",total);
        List<GoodsClass> goodsClassList=goodsClassMapper.queryByUser(params);
       return goodsClassList;
    }


    /**
     * 根据商家id获取商品列表
     * @param merchantId
     * @return
     */
    public List<GoodsClass>getClassById(String merchantId){
        MerchantInfo merchantInfo=new MerchantInfo();
        merchantInfo.setMerchantId(merchantId);
        return this.getClassList(merchantInfo);
    }

}
