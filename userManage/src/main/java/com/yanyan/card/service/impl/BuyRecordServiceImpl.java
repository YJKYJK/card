package com.yanyan.card.service.impl;

import com.yanyan.card.bean.BuyRecord;
import com.yanyan.card.mapper.BuyRecordMapper;
import com.yanyan.card.service.BuyRecordService;
import com.yanyan.card.util.EmptyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
@Service("buyRecordService")
public class BuyRecordServiceImpl implements BuyRecordService {
    @Resource
    private BuyRecordMapper buyRecordMapper;


    /**
     * 添加订单
     * @param buyRecord
     * @return
     */
    @Override
    public boolean saveBuyRecord(BuyRecord buyRecord) {
        Date date=new Date();
        buyRecord.setBuyTm(date);
        Integer integer = buyRecordMapper.saveBuyRecord(buyRecord);
        if(integer>0){
            return true;
        }

        return false;
    }

    /**
     * 订单查询
     * @param param
     * @return
     */
    @Override
    public List<BuyRecord> getBuyRecordListByMap(String param) {
        Map<String,Object> params=new HashMap<>();
        params.put("userKey",param);
        List<BuyRecord> buyRecordListByMap =null;
        buyRecordListByMap= buyRecordMapper.getBuyRecordListByMap(params);
        if(buyRecordListByMap.size()<1){
            params=new HashMap<String,Object>();
            params.put("buyId",param);
            buyRecordListByMap= buyRecordMapper.getBuyRecordListByMap(params);
        }
        return buyRecordListByMap;
    }
}
