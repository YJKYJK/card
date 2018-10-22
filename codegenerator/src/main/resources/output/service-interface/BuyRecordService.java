package com.yanyan.card.service;
import com.yanyan.card.bean.BuyRecord;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface BuyRecordService {

    public BuyRecord getBuyRecordById(Long id)throws Exception;

    public List<BuyRecord>	getBuyRecordListByMap(Map<String,Object> param)throws Exception;

    public Integer getBuyRecordCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveBuyRecord(BuyRecord buyRecord)throws Exception;

    public Integer modifyBuyRecord(BuyRecord buyRecord)throws Exception;

    public Integer removeBuyRecordById(Long id)throws Exception;

    public Page<BuyRecord> queryBuyRecordPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
