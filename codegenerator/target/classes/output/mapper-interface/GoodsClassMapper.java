package com.yanyan.card.mapper;
import com.yanyan.card.bean.GoodsClass;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface GoodsClassMapper {

	public GoodsClass getGoodsClassById(@Param(value = "id") Long id)throws Exception;

	public List<GoodsClass>	getGoodsClassListByMap(Map<String,Object> param)throws Exception;

	public Integer getGoodsClassCountByMap(Map<String,Object> param)throws Exception;

	public Integer saveGoodsClass(GoodsClass goodsClass)throws Exception;

	public Integer modifyGoodsClass(GoodsClass goodsClass)throws Exception;

	public Integer removeGoodsClassById(@Param(value = "id") Long id)throws Exception;

}
