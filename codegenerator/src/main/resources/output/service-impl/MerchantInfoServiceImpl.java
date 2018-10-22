package com.yanyan.card.service.impl;
import com.yanyan.card.service.MerchantInfoService;
import com.yanyan.card.mapper.MerchantInfoMapper;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("merchantInfoService")
public class MerchantInfoServiceImpl implements MerchantInfoService {

    @Resource
    private MerchantInfoMapper merchantInfoMapper;

    public MerchantInfo getMerchantInfoById(Long id)throws Exception{
        return merchantInfoMapper.getMerchantInfoById(id);
    }

    public List<MerchantInfo> getMerchantInfoListByMap(Map<String,Object> param)throws Exception{
        return merchantInfoMapper.getMerchantInfoListByMap(param);
    }

    public Integer getMerchantInfoCountByMap(Map<String,Object> param)throws Exception{
        return merchantInfoMapper.getMerchantInfoCountByMap(param);
    }

    public Integer saveMerchantInfo(MerchantInfo merchantInfo)throws Exception{
            merchantInfo.setCreationDate(new Date());
            return merchantInfoMapper.saveMerchantInfo(merchantInfo);
    }

    public Integer modifyMerchantInfo(MerchantInfo merchantInfo)throws Exception{
        merchantInfo.setModifyDate(new Date());
        return merchantInfoMapper.modifyMerchantInfo(merchantInfo);
    }

    public Integer removeMerchantInfoById(Long id)throws Exception{
        return merchantInfoMapper.removeMerchantInfoById(id);
    }

    public Page<MerchantInfo> queryMerchantInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = merchantInfoMapper.getMerchantInfoCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<MerchantInfo> merchantInfoList = merchantInfoMapper.getMerchantInfoListByMap(param);
        page.setRows(merchantInfoList);
        return page;
    }

}
