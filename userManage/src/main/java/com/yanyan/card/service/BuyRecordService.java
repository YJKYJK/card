package com.yanyan.card.service;

import com.yanyan.card.bean.BuyRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
public interface BuyRecordService {
    public boolean saveBuyRecord(BuyRecord buyRecord);

    public List<BuyRecord> getBuyRecordListByMap(String param);


}
