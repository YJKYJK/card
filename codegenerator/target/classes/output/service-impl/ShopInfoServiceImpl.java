package com.yanyan.card.service.impl;
import com.yanyan.card.service.ShopInfoService;
import com.yanyan.card.mapper.ShopInfoMapper;
import com.yanyan.card.bean.ShopInfo;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("shopInfoService")
public class ShopInfoServiceImpl implements ShopInfoService {

    @Resource
    private ShopInfoMapper shopInfoMapper;

    public ShopInfo getShopInfoById(Long id)throws Exception{
        return shopInfoMapper.getShopInfoById(id);
    }

    public List<ShopInfo> getShopInfoListByMap(Map<String,Object> param)throws Exception{
        return shopInfoMapper.getShopInfoListByMap(param);
    }

    public Integer getShopInfoCountByMap(Map<String,Object> param)throws Exception{
        return shopInfoMapper.getShopInfoCountByMap(param);
    }

    public Integer saveShopInfo(ShopInfo shopInfo)throws Exception{
            shopInfo.setCreationDate(new Date());
            return shopInfoMapper.saveShopInfo(shopInfo);
    }

    public Integer modifyShopInfo(ShopInfo shopInfo)throws Exception{
        shopInfo.setModifyDate(new Date());
        return shopInfoMapper.modifyShopInfo(shopInfo);
    }

    public Integer removeShopInfoById(Long id)throws Exception{
        return shopInfoMapper.removeShopInfoById(id);
    }

    public Page<ShopInfo> queryShopInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = shopInfoMapper.getShopInfoCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ShopInfo> shopInfoList = shopInfoMapper.getShopInfoListByMap(param);
        page.setRows(shopInfoList);
        return page;
    }

}
