package com.yanyan.card.service;
import com.yanyan.card.bean.TopUpRecords;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface TopUpRecordsService {

    public TopUpRecords getTopUpRecordsById(Long id)throws Exception;

    public List<TopUpRecords>	getTopUpRecordsListByMap(Map<String,Object> param)throws Exception;

    public Integer getTopUpRecordsCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveTopUpRecords(TopUpRecords topUpRecords)throws Exception;

    public Integer modifyTopUpRecords(TopUpRecords topUpRecords)throws Exception;

    public Integer removeTopUpRecordsById(Long id)throws Exception;

    public Page<TopUpRecords> queryTopUpRecordsPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
