package com.yanyan.card.service.impl;
import com.yanyan.card.service.ShopOderService;
import com.yanyan.card.mapper.ShopOderMapper;
import com.yanyan.card.bean.ShopOder;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("shopOderService")
public class ShopOderServiceImpl implements ShopOderService {

    @Resource
    private ShopOderMapper shopOderMapper;

    public ShopOder getShopOderById(Long id)throws Exception{
        return shopOderMapper.getShopOderById(id);
    }

    public List<ShopOder> getShopOderListByMap(Map<String,Object> param)throws Exception{
        return shopOderMapper.getShopOderListByMap(param);
    }

    public Integer getShopOderCountByMap(Map<String,Object> param)throws Exception{
        return shopOderMapper.getShopOderCountByMap(param);
    }

    public Integer saveShopOder(ShopOder shopOder)throws Exception{
            shopOder.setCreationDate(new Date());
            return shopOderMapper.saveShopOder(shopOder);
    }

    public Integer modifyShopOder(ShopOder shopOder)throws Exception{
        shopOder.setModifyDate(new Date());
        return shopOderMapper.modifyShopOder(shopOder);
    }

    public Integer removeShopOderById(Long id)throws Exception{
        return shopOderMapper.removeShopOderById(id);
    }

    public Page<ShopOder> queryShopOderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = shopOderMapper.getShopOderCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ShopOder> shopOderList = shopOderMapper.getShopOderListByMap(param);
        page.setRows(shopOderList);
        return page;
    }

}
