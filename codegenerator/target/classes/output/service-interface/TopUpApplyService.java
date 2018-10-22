package com.yanyan.card.service;
import com.yanyan.card.bean.TopUpApply;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface TopUpApplyService {

    public TopUpApply getTopUpApplyById(Long id)throws Exception;

    public List<TopUpApply>	getTopUpApplyListByMap(Map<String,Object> param)throws Exception;

    public Integer getTopUpApplyCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveTopUpApply(TopUpApply topUpApply)throws Exception;

    public Integer modifyTopUpApply(TopUpApply topUpApply)throws Exception;

    public Integer removeTopUpApplyById(Long id)throws Exception;

    public Page<TopUpApply> queryTopUpApplyPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
