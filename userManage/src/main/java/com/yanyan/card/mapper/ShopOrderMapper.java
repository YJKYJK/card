package com.yanyan.card.mapper;
import com.yanyan.card.bean.ShopOrder;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ShopOrderMapper {

	Integer saveShopOrder(ShopOrder shopOrder);

	Integer modifyShopOrder(ShopOrder shopOrder);

}
