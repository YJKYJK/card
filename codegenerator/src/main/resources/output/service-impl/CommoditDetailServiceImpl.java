package com.yanyan.card.service.impl;
import com.yanyan.card.service.CommoditDetailService;
import com.yanyan.card.mapper.CommoditDetailMapper;
import com.yanyan.card.bean.CommoditDetail;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("commoditDetailService")
public class CommoditDetailServiceImpl implements CommoditDetailService {

    @Resource
    private CommoditDetailMapper commoditDetailMapper;

    public CommoditDetail getCommoditDetailById(Long id)throws Exception{
        return commoditDetailMapper.getCommoditDetailById(id);
    }

    public List<CommoditDetail> getCommoditDetailListByMap(Map<String,Object> param)throws Exception{
        return commoditDetailMapper.getCommoditDetailListByMap(param);
    }

    public Integer getCommoditDetailCountByMap(Map<String,Object> param)throws Exception{
        return commoditDetailMapper.getCommoditDetailCountByMap(param);
    }

    public Integer saveCommoditDetail(CommoditDetail commoditDetail)throws Exception{
            commoditDetail.setCreationDate(new Date());
            return commoditDetailMapper.saveCommoditDetail(commoditDetail);
    }

    public Integer modifyCommoditDetail(CommoditDetail commoditDetail)throws Exception{
        commoditDetail.setModifyDate(new Date());
        return commoditDetailMapper.modifyCommoditDetail(commoditDetail);
    }

    public Integer removeCommoditDetailById(Long id)throws Exception{
        return commoditDetailMapper.removeCommoditDetailById(id);
    }

    public Page<CommoditDetail> queryCommoditDetailPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = commoditDetailMapper.getCommoditDetailCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<CommoditDetail> commoditDetailList = commoditDetailMapper.getCommoditDetailListByMap(param);
        page.setRows(commoditDetailList);
        return page;
    }

}
