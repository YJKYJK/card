package com.yanyan.card.service.impl;
import com.yanyan.card.service.CommodityDetailService;
import com.yanyan.card.mapper.CommodityDetailMapper;
import com.yanyan.card.bean.CommodityDetail;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("commodityDetailService")
public class CommodityDetailServiceImpl implements CommodityDetailService {

    @Resource
    private CommodityDetailMapper commodityDetailMapper;

    public CommodityDetail getCommodityDetailById(Long id)throws Exception{
        return commodityDetailMapper.getCommodityDetailById(id);
    }

    public List<CommodityDetail> getCommodityDetailListByMap(Map<String,Object> param)throws Exception{
        return commodityDetailMapper.getCommodityDetailListByMap(param);
    }

    public Integer getCommodityDetailCountByMap(Map<String,Object> param)throws Exception{
        return commodityDetailMapper.getCommodityDetailCountByMap(param);
    }

    public Integer saveCommodityDetail(CommodityDetail commodityDetail)throws Exception{
            commodityDetail.setCreationDate(new Date());
            return commodityDetailMapper.saveCommodityDetail(commodityDetail);
    }

    public Integer modifyCommodityDetail(CommodityDetail commodityDetail)throws Exception{
        commodityDetail.setModifyDate(new Date());
        return commodityDetailMapper.modifyCommodityDetail(commodityDetail);
    }

    public Integer removeCommodityDetailById(Long id)throws Exception{
        return commodityDetailMapper.removeCommodityDetailById(id);
    }

    public Page<CommodityDetail> queryCommodityDetailPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = commodityDetailMapper.getCommodityDetailCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<CommodityDetail> commodityDetailList = commodityDetailMapper.getCommodityDetailListByMap(param);
        page.setRows(commodityDetailList);
        return page;
    }

}
