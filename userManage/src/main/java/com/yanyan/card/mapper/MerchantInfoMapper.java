package com.yanyan.card.mapper;
import com.yanyan.card.bean.MerchantInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface MerchantInfoMapper {

//	public MerchantInfo getMerchantInfoById(@Param(value = "id") Long id)throws Exception;
//
//	public List<MerchantInfo>	getMerchantInfoListByMap(Map<String, Object> param)throws Exception;
//
//	public Integer getMerchantInfoCountByMap(Map<String, Object> param)throws Exception;

	public Integer saveMerchantInfo(MerchantInfo merchantInfo);
	public  Integer quryUserByName(String userName);

	MerchantInfo login(MerchantInfo merchantInfo);

	MerchantInfo getMerchant(String merchantId);

//	public Integer modifyMerchantInfo(MerchantInfo merchantInfo)throws Exception;
//
//	public Integer removeMerchantInfoById(@Param(value = "id") Long id)throws Exception;

}
