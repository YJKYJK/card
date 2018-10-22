package com.yanyan.card.service.impl;

import com.yanyan.card.bean.UserInfo;
import com.yanyan.card.mapper.UserInfoMapper;
import com.yanyan.card.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;


/**
 * Created by Administrator on 2018/10/11 0011.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private UserInfoMapper userInfoMapper;


    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @Override
    public boolean saveUserInfo(UserInfo userInfo) {
        Date date=new Date();
        String userId=date.getTime()+UUID.randomUUID().toString().substring(0,12);
        userInfo.setUserId(userId);
        userInfo.setCreateTm(date);
        userInfo.setOperTm(date);
        //如果用户名已存在,注册失败
        if(this.quryUserByName(userInfo.getUserName())){
            return false;
        }
        Integer integer = userInfoMapper.saveUserInfo(userInfo);
        if(integer>0){
            return true;
        }
        return false;
    }


    /**
     * 根据用户名查询该用户是否存在
     * @param userName
     * @return
     */
    @Override
    public boolean quryUserByName(String userName) {
        Integer res = userInfoMapper.quryUserByName(userName);
        if(res>0){
            return true;
        }
        return false;

    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo us = userInfoMapper.login(userInfo);

            return us;

    }
}
