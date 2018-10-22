package com.yanyan.card.service.impl;
import com.yanyan.card.service.CommodityInfoService;
import com.yanyan.card.mapper.CommodityInfoMapper;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("commodityInfoService")
public class CommodityInfoServiceImpl implements CommodityInfoService {

    @Resource
    private CommodityInfoMapper commodityInfoMapper;

    public CommodityInfo getCommodityInfoById(Long id)throws Exception{
        return commodityInfoMapper.getCommodityInfoById(id);
    }

    public List<CommodityInfo> getCommodityInfoListByMap(Map<String,Object> param)throws Exception{
        return commodityInfoMapper.getCommodityInfoListByMap(param);
    }

    public Integer getCommodityInfoCountByMap(Map<String,Object> param)throws Exception{
        return commodityInfoMapper.getCommodityInfoCountByMap(param);
    }

    public Integer saveCommodityInfo(CommodityInfo commodityInfo)throws Exception{
            commodityInfo.setCreationDate(new Date());
            return commodityInfoMapper.saveCommodityInfo(commodityInfo);
    }

    public Integer modifyCommodityInfo(CommodityInfo commodityInfo)throws Exception{
        commodityInfo.setModifyDate(new Date());
        return commodityInfoMapper.modifyCommodityInfo(commodityInfo);
    }

    public Integer removeCommodityInfoById(Long id)throws Exception{
        return commodityInfoMapper.removeCommodityInfoById(id);
    }

    public Page<CommodityInfo> queryCommodityInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = commodityInfoMapper.getCommodityInfoCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<CommodityInfo> commodityInfoList = commodityInfoMapper.getCommodityInfoListByMap(param);
        page.setRows(commodityInfoList);
        return page;
    }

}
