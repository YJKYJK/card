package com.yanyan.card.service.impl;

import com.yanyan.card.bean.CommodityDetail;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.mapper.CommodityDetailMapper;
import com.yanyan.card.service.CommdityInfoService;
import com.yanyan.card.service.CommodityDetailService;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Service("commodityDetailService")
public class CommodityDetailServiceImpl implements CommodityDetailService{
    @Resource
    private CommodityDetailMapper commodityDetailMapper;
    @Resource
    private  CommdityInfoService commdityInfoService;


    /**
     * 批量添加卡密
     * @param km
     * @param catLine
     * @param commodityInfo
     * @return
     */
    @Override
    public Integer saveList(String km, String catLine, CommodityInfo commodityInfo) {
        commodityInfo=commdityInfoService.getCommodityById(commodityInfo.getCommodityId()+"");
        List<CommodityDetail>commodityDetailList=new ArrayList<>();
        Date date=new Date();
        if(EmptyUtils.isEmpty(km)){
            return 0;
        }
        km=km.replace("\r","");
        String[] kms=km.split("\n");
        for (String kami:kms){
            CommodityDetail commodityDetail=new CommodityDetail();
            commodityDetail.setIsSell("N");
            commodityDetail.setCreateTm(date);
           commodityDetail.setCommodityName(commodityInfo.getCommodityName());
            commodityDetail.setMerchantId(commodityInfo.getMerchantId());
            commodityDetail.setCommodityId(commodityInfo.getCommodityId());
            String cardNumber="";
            String cardPassword="";
            int catLineIndex=kami.indexOf(catLine);
            if(catLineIndex==-1 || catLineIndex==0 || catLineIndex==kami.length()){
                cardNumber=kami;
            }else{
                cardNumber=kami.substring(0,catLineIndex);
                cardPassword=kami.substring(catLineIndex+catLine.length(),kami.length());
            }
            commodityDetail.setCardNumber(cardNumber);
            commodityDetail.setCardPassword(cardPassword);
            commodityDetailList.add(commodityDetail);
        }
        Integer integer = commodityDetailMapper.saveList(commodityDetailList);
        if(integer==0){
            return 0;
        }
        Boolean res = commdityInfoService.addNum(String.valueOf(commodityInfo.getCommodityId()), integer);
        if(!res){
            return 0;
        }


        return integer;
    }

    /**
     * 根据商品ID获取未使用的卡密,且根据购买数量分页
     * @param commodityId
     * @param number
     * @return
     */
    @Override
    public List<CommodityDetail> getCommodityDetailByParams(String commodityId, Integer number) {
        Date date=new Date();
        Map<String,Object> params=new HashMap<>();
        params.put("commodityId",commodityId);
        params.put("isSell","N");
        params.put("pageSize",number);
        List<CommodityDetail> commodityDetailByParams = commodityDetailMapper.getCommodityDetailListByMap(params);
        List<CommodityDetail> commodityDetailList=new ArrayList<>();
        for (CommodityDetail c : commodityDetailByParams) {
            c.setSellTm(date);
            c.setIsSell("Y");
            Integer update = commodityDetailMapper.update(c);
            if(update>0){
                commodityDetailList.add(c);
            }
        }
        return commodityDetailList;
    }

    /**
     * 根据条件查询卡密
     * @param commodityDetail
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<CommodityDetail> queryKamiByParams(CommodityDetail commodityDetail,Integer pageNumber,Integer pageSize) {
        if(EmptyUtils.isEmpty(pageNumber)){
            pageNumber=0;
        }

        if (EmptyUtils.isEmpty(pageSize)){
            pageSize=6;
        }
        if(pageNumber>0){
            pageNumber=(pageNumber-1)*pageSize;
        }

        Map<String,Object>params=new HashMap<>();
        params.put("merchantId",commodityDetail.getMerchantId());
        params.put("isSell",commodityDetail.getIsSell());
        params.put("commodityId",commodityDetail.getCommodityId());
        params.put("cardNumber",commodityDetail.getCardNumber());
        params.put("createTm",commodityDetail.getCreateTm());
        params.put("pageNumber",pageNumber);
        params.put("pageSize",pageSize);
        List<CommodityDetail> kamiList= commodityDetailMapper.getKamiListByMap(params);
        Integer total= commodityDetailMapper.getKamiCountByMap(params);
        Page<CommodityDetail> page=new Page<>();
        page.setRows(kamiList);
        page.setTotal(total);
        return page;
    }

    /**
     * 删除卡密
     * @param commodityDetail
     * @return
     */
    @Override
    public boolean deleteKami(CommodityDetail commodityDetail) {
        Integer integer = commodityDetailMapper.deleteKami(commodityDetail);
        if(integer>0){
            return true;
        }
        return false;
    }

    /**
     * 根据id获取卡密
     * @param commodityDetail
     * @return
     */
    @Override
    public CommodityDetail getKamiById(CommodityDetail commodityDetail) {
        return commodityDetailMapper.getKamiById(commodityDetail);
    }

    /**
     * 修改卡密信息
     * @param commodityDetail
     * @return
     */
    @Override
    public boolean modifyKami(CommodityDetail commodityDetail) {
        Integer update = commodityDetailMapper.modifyCommodityDetail(commodityDetail);
        if(update>0){
            return true;
        }
        return false;
    }


}
