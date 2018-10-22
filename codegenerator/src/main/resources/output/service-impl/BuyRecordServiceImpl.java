package com.yanyan.card.service.impl;
import com.yanyan.card.service.BuyRecordService;
import com.yanyan.card.mapper.BuyRecordMapper;
import com.yanyan.card.bean.BuyRecord;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("buyRecordService")
public class BuyRecordServiceImpl implements BuyRecordService {

    @Resource
    private BuyRecordMapper buyRecordMapper;

    public BuyRecord getBuyRecordById(Long id)throws Exception{
        return buyRecordMapper.getBuyRecordById(id);
    }

    public List<BuyRecord> getBuyRecordListByMap(Map<String,Object> param)throws Exception{
        return buyRecordMapper.getBuyRecordListByMap(param);
    }

    public Integer getBuyRecordCountByMap(Map<String,Object> param)throws Exception{
        return buyRecordMapper.getBuyRecordCountByMap(param);
    }

    public Integer saveBuyRecord(BuyRecord buyRecord)throws Exception{
            buyRecord.setCreationDate(new Date());
            return buyRecordMapper.saveBuyRecord(buyRecord);
    }

    public Integer modifyBuyRecord(BuyRecord buyRecord)throws Exception{
        buyRecord.setModifyDate(new Date());
        return buyRecordMapper.modifyBuyRecord(buyRecord);
    }

    public Integer removeBuyRecordById(Long id)throws Exception{
        return buyRecordMapper.removeBuyRecordById(id);
    }

    public Page<BuyRecord> queryBuyRecordPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = buyRecordMapper.getBuyRecordCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<BuyRecord> buyRecordList = buyRecordMapper.getBuyRecordListByMap(param);
        page.setRows(buyRecordList);
        return page;
    }

}
