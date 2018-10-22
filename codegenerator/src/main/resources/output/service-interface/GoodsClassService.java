package com.yanyan.card.service;
import com.yanyan.card.bean.GoodsClass;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface GoodsClassService {

    public GoodsClass getGoodsClassById(Long id)throws Exception;

    public List<GoodsClass>	getGoodsClassListByMap(Map<String,Object> param)throws Exception;

    public Integer getGoodsClassCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveGoodsClass(GoodsClass goodsClass)throws Exception;

    public Integer modifyGoodsClass(GoodsClass goodsClass)throws Exception;

    public Integer removeGoodsClassById(Long id)throws Exception;

    public Page<GoodsClass> queryGoodsClassPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
