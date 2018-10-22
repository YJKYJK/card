package com.yanyan.card.service;
import com.yanyan.card.bean.UserInfo;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface UserInfoService {

    public UserInfo getUserInfoById(Long id)throws Exception;

    public List<UserInfo>	getUserInfoListByMap(Map<String,Object> param)throws Exception;

    public Integer getUserInfoCountByMap(Map<String,Object> param)throws Exception;

    public Integer saveUserInfo(UserInfo userInfo)throws Exception;

    public Integer modifyUserInfo(UserInfo userInfo)throws Exception;

    public Integer removeUserInfoById(Long id)throws Exception;

    public Page<UserInfo> queryUserInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
