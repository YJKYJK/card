package com.yanyan.card.service;
import com.yanyan.card.bean.UserInfo;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Page;


public interface UserInfoService {
  // 用户注册
  boolean saveUserInfo(UserInfo userInfo);


  //根据用户名查询该用户是否存在
  boolean quryUserByName(String userName);

  UserInfo login(UserInfo userInfo);
}
