package com.yanyan.card.service.impl;
import com.yanyan.card.service.ShopOrderService;
import com.yanyan.card.mapper.ShopOrderMapper;
import com.yanyan.card.bean.ShopOrder;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("shopOrderService")
public class ShopOrderServiceImpl implements ShopOrderService {

    @Resource
    private ShopOrderMapper shopOrderMapper;

    public ShopOrder getShopOrderById(Long id)throws Exception{
        return shopOrderMapper.getShopOrderById(id);
    }

    public List<ShopOrder> getShopOrderListByMap(Map<String,Object> param)throws Exception{
        return shopOrderMapper.getShopOrderListByMap(param);
    }

    public Integer getShopOrderCountByMap(Map<String,Object> param)throws Exception{
        return shopOrderMapper.getShopOrderCountByMap(param);
    }

    public Integer saveShopOrder(ShopOrder shopOrder)throws Exception{
            shopOrder.setCreationDate(new Date());
            return shopOrderMapper.saveShopOrder(shopOrder);
    }

    public Integer modifyShopOrder(ShopOrder shopOrder)throws Exception{
        shopOrder.setModifyDate(new Date());
        return shopOrderMapper.modifyShopOrder(shopOrder);
    }

    public Integer removeShopOrderById(Long id)throws Exception{
        return shopOrderMapper.removeShopOrderById(id);
    }

    public Page<ShopOrder> queryShopOrderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = shopOrderMapper.getShopOrderCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ShopOrder> shopOrderList = shopOrderMapper.getShopOrderListByMap(param);
        page.setRows(shopOrderList);
        return page;
    }

}
