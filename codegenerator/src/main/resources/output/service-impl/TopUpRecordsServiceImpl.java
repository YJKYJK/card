package com.yanyan.card.service.impl;
import com.yanyan.card.service.TopUpRecordsService;
import com.yanyan.card.mapper.TopUpRecordsMapper;
import com.yanyan.card.bean.TopUpRecords;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("topUpRecordsService")
public class TopUpRecordsServiceImpl implements TopUpRecordsService {

    @Resource
    private TopUpRecordsMapper topUpRecordsMapper;

    public TopUpRecords getTopUpRecordsById(Long id)throws Exception{
        return topUpRecordsMapper.getTopUpRecordsById(id);
    }

    public List<TopUpRecords> getTopUpRecordsListByMap(Map<String,Object> param)throws Exception{
        return topUpRecordsMapper.getTopUpRecordsListByMap(param);
    }

    public Integer getTopUpRecordsCountByMap(Map<String,Object> param)throws Exception{
        return topUpRecordsMapper.getTopUpRecordsCountByMap(param);
    }

    public Integer saveTopUpRecords(TopUpRecords topUpRecords)throws Exception{
            topUpRecords.setCreationDate(new Date());
            return topUpRecordsMapper.saveTopUpRecords(topUpRecords);
    }

    public Integer modifyTopUpRecords(TopUpRecords topUpRecords)throws Exception{
        topUpRecords.setModifyDate(new Date());
        return topUpRecordsMapper.modifyTopUpRecords(topUpRecords);
    }

    public Integer removeTopUpRecordsById(Long id)throws Exception{
        return topUpRecordsMapper.removeTopUpRecordsById(id);
    }

    public Page<TopUpRecords> queryTopUpRecordsPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = topUpRecordsMapper.getTopUpRecordsCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<TopUpRecords> topUpRecordsList = topUpRecordsMapper.getTopUpRecordsListByMap(param);
        page.setRows(topUpRecordsList);
        return page;
    }

}
