package com.yanyan.card.service.impl;
import com.yanyan.card.service.TopUpApplyService;
import com.yanyan.card.mapper.TopUpApplyMapper;
import com.yanyan.card.bean.TopUpApply;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("topUpApplyService")
public class TopUpApplyServiceImpl implements TopUpApplyService {

    @Resource
    private TopUpApplyMapper topUpApplyMapper;

    public TopUpApply getTopUpApplyById(Long id)throws Exception{
        return topUpApplyMapper.getTopUpApplyById(id);
    }

    public List<TopUpApply> getTopUpApplyListByMap(Map<String,Object> param)throws Exception{
        return topUpApplyMapper.getTopUpApplyListByMap(param);
    }

    public Integer getTopUpApplyCountByMap(Map<String,Object> param)throws Exception{
        return topUpApplyMapper.getTopUpApplyCountByMap(param);
    }

    public Integer saveTopUpApply(TopUpApply topUpApply)throws Exception{
            topUpApply.setCreationDate(new Date());
            return topUpApplyMapper.saveTopUpApply(topUpApply);
    }

    public Integer modifyTopUpApply(TopUpApply topUpApply)throws Exception{
        topUpApply.setModifyDate(new Date());
        return topUpApplyMapper.modifyTopUpApply(topUpApply);
    }

    public Integer removeTopUpApplyById(Long id)throws Exception{
        return topUpApplyMapper.removeTopUpApplyById(id);
    }

    public Page<TopUpApply> queryTopUpApplyPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = topUpApplyMapper.getTopUpApplyCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<TopUpApply> topUpApplyList = topUpApplyMapper.getTopUpApplyListByMap(param);
        page.setRows(topUpApplyList);
        return page;
    }

}
