package com.yanyan.card.service.impl;
import com.yanyan.card.service.GoodsClassService;
import com.yanyan.card.mapper.GoodsClassMapper;
import com.yanyan.card.bean.GoodsClass;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("goodsClassService")
public class GoodsClassServiceImpl implements GoodsClassService {

    @Resource
    private GoodsClassMapper goodsClassMapper;

    public GoodsClass getGoodsClassById(Long id)throws Exception{
        return goodsClassMapper.getGoodsClassById(id);
    }

    public List<GoodsClass> getGoodsClassListByMap(Map<String,Object> param)throws Exception{
        return goodsClassMapper.getGoodsClassListByMap(param);
    }

    public Integer getGoodsClassCountByMap(Map<String,Object> param)throws Exception{
        return goodsClassMapper.getGoodsClassCountByMap(param);
    }

    public Integer saveGoodsClass(GoodsClass goodsClass)throws Exception{
            goodsClass.setCreationDate(new Date());
            return goodsClassMapper.saveGoodsClass(goodsClass);
    }

    public Integer modifyGoodsClass(GoodsClass goodsClass)throws Exception{
        goodsClass.setModifyDate(new Date());
        return goodsClassMapper.modifyGoodsClass(goodsClass);
    }

    public Integer removeGoodsClassById(Long id)throws Exception{
        return goodsClassMapper.removeGoodsClassById(id);
    }

    public Page<GoodsClass> queryGoodsClassPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = goodsClassMapper.getGoodsClassCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<GoodsClass> goodsClassList = goodsClassMapper.getGoodsClassListByMap(param);
        page.setRows(goodsClassList);
        return page;
    }

}
