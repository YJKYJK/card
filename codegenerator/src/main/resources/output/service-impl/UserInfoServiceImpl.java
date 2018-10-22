package com.yanyan.card.service.impl;
import com.yanyan.card.service.UserInfoService;
import com.yanyan.card.mapper.UserInfoMapper;
import com.yanyan.card.bean.UserInfo;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.yanyan.card.util.Constants;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoById(Long id)throws Exception{
        return userInfoMapper.getUserInfoById(id);
    }

    public List<UserInfo> getUserInfoListByMap(Map<String,Object> param)throws Exception{
        return userInfoMapper.getUserInfoListByMap(param);
    }

    public Integer getUserInfoCountByMap(Map<String,Object> param)throws Exception{
        return userInfoMapper.getUserInfoCountByMap(param);
    }

    public Integer saveUserInfo(UserInfo userInfo)throws Exception{
            userInfo.setCreationDate(new Date());
            return userInfoMapper.saveUserInfo(userInfo);
    }

    public Integer modifyUserInfo(UserInfo userInfo)throws Exception{
        userInfo.setModifyDate(new Date());
        return userInfoMapper.modifyUserInfo(userInfo);
    }

    public Integer removeUserInfoById(Long id)throws Exception{
        return userInfoMapper.removeUserInfoById(id);
    }

    public Page<UserInfo> queryUserInfoPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = userInfoMapper.getUserInfoCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<UserInfo> userInfoList = userInfoMapper.getUserInfoListByMap(param);
        page.setRows(userInfoList);
        return page;
    }

}
