package com.yanyan.card.service.impl;

import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.mapper.CommodityInfoMapper;
import com.yanyan.card.service.CommdityInfoService;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2018/10/16 0016.
 */
@Service("commdityInfoService")
public class CommdityInfoServiceImpl implements CommdityInfoService {
    @Resource
    private CommodityInfoMapper commodityInfoMapper;


    /**
     * 获取该商家所有商品
     * @param merchantInfo
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<CommodityInfo> queryByUser(MerchantInfo merchantInfo, Integer pageNumber, Integer pageSize) {
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
        List<CommodityInfo> commodityInfos = commodityInfoMapper.queryByUser(params);
        Integer total = commodityInfoMapper.queryCountByUser(merchantInfo);
        Page page=new Page();
        page.setRows(commodityInfos);
        page.setTotal(total);
        return page;
    }

    /**
     * 添加商品
     * @param commodityInfo
     * @return
     */
    public boolean saveCommdityInfo(CommodityInfo commodityInfo){
        Date date=new Date();
        commodityInfo.setCreateTm(date);
        commodityInfo.setNum(0);
        commodityInfo.setOperTm(date);
        Integer integer = commodityInfoMapper.saveCommdityInfo(commodityInfo);
        if (integer>0){
            return true;
        }
        return false;
    }

    /**
     * 修改
     * @param commodityInfo
     * @return
     */
    @Override
    public boolean modifyCommodity(CommodityInfo commodityInfo) {
        Date date=new Date();
        commodityInfo.setOperTm(date);
        Integer integer = commodityInfoMapper.modifyCommodity(commodityInfo);
        if(integer>0){
            return true;
        }
        return false;
    }


    /**
     * 删除商品
     * @param commodityInfo
     * @return
     */
    @Override
    public boolean removeCommodity(CommodityInfo commodityInfo) {
        Integer integer = commodityInfoMapper.removeCommodity(commodityInfo);
        if (integer>0){
            return true;
        }
        return false;
    }

    /**
     * 根据商品类型获取商品
     * @param classId
     * @return
     */
    @Override
    public List<CommodityInfo> getCommodityByClass(String classId) {
        List<CommodityInfo> commodityByClass = commodityInfoMapper.getCommodityByClass(classId);
        return commodityByClass;
    }

    /**
     * 根据商品ID拿商品所有信息
     * @param commodityId
     * @return
     */
    @Override
    public CommodityInfo getCommodityById(String commodityId) {
        return commodityInfoMapper.getCommodityById(commodityId);
    }

    /**
     * 根据商品数量和商品ID获取商品价格
     * @param commodityId
     * @param num
     * @return
     */
    @Override
    public BigDecimal getTotalPrice(String commodityId, Integer num) {
        CommodityInfo commodity = commodityInfoMapper.getCommodityById(commodityId);
        BigDecimal totalPrice=commodity.getPrice();
        totalPrice= totalPrice.multiply(BigDecimal.valueOf(num));
        return totalPrice;
    }


}
