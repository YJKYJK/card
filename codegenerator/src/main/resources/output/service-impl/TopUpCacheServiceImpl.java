package com.yanyan.card.service.impl;
import com.yanyan.card.service.TopUpCacheService;
import com.yanyan.card.mapper.TopUpCacheMapper;
import com.yanyan.card.bean.TopUpCache;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("topUpCacheService")
public class TopUpCacheServiceImpl implements TopUpCacheService {

    @Resource
    private TopUpCacheMapper topUpCacheMapper;

    public TopUpCache getTopUpCacheById(Long id)throws Exception{
        return topUpCacheMapper.getTopUpCacheById(id);
    }

    public List<TopUpCache> getTopUpCacheListByMap(Map<String,Object> param)throws Exception{
        return topUpCacheMapper.getTopUpCacheListByMap(param);
    }

    public Integer getTopUpCacheCountByMap(Map<String,Object> param)throws Exception{
        return topUpCacheMapper.getTopUpCacheCountByMap(param);
    }

    public Integer saveTopUpCache(TopUpCache topUpCache)throws Exception{
            topUpCache.setCreationDate(new Date());
            return topUpCacheMapper.saveTopUpCache(topUpCache);
    }

    public Integer modifyTopUpCache(TopUpCache topUpCache)throws Exception{
        topUpCache.setModifyDate(new Date());
        return topUpCacheMapper.modifyTopUpCache(topUpCache);
    }

    public Integer removeTopUpCacheById(Long id)throws Exception{
        return topUpCacheMapper.removeTopUpCacheById(id);
    }

    public Page<TopUpCache> queryTopUpCachePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = topUpCacheMapper.getTopUpCacheCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<TopUpCache> topUpCacheList = topUpCacheMapper.getTopUpCacheListByMap(param);
        page.setRows(topUpCacheList);
        return page;
    }

}
