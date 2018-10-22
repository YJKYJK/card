package com.yanyan.card.controller;

import com.yanyan.card.bean.UserInfo;
import com.yanyan.card.service.UserInfoService;
import com.yanyan.card.util.Dto;
import com.yanyan.card.util.DtoUtil;
import com.yanyan.card.util.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;


    /**
     * 注册
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping("/retister")
    @ResponseBody
    public Dto retister(HttpServletRequest request, UserInfo userInfo){
        boolean res = userInfoService.saveUserInfo(userInfo);
        if(res){
           return DtoUtil.returnSuccess("注册成功");
        }
        return DtoUtil.returnFail("注册失败","1");

    }

    /**
     * 根据用户名查询该用户是否已注册
     * @param userName
     * @return
     */
    @RequestMapping("/quryUserByName")
    @ResponseBody
    public boolean quryUserByName(String userName){
        return userInfoService.quryUserByName(userName);
    }

    /**
     * 登录
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Dto login(HttpServletRequest request,UserInfo userInfo){
        if(EmptyUtils.isEmpty(userInfo.getUserName())){
        return DtoUtil.returnFail("登录失败","01");
        }

        if(EmptyUtils.isEmpty(userInfo.getPassword())){
            return DtoUtil.returnFail("登录失败","01");
        }

        UserInfo us=null;
        us=userInfoService.login(userInfo);
        if(EmptyUtils.isEmpty(us)){
            return DtoUtil.returnFail("账号或者密码错误","01");
        }
         request.getSession().setAttribute("userInfo",us);
        return DtoUtil.returnSuccess("登录成功");
    }

    /**
     * 跳转到用户详情页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/gotoUserInfo")
    public String gotoUserInfo(HttpServletRequest request, Model model){
        Object userinfo = request.getSession().getAttribute("userInfo");
        if(EmptyUtils.isNotEmpty(userinfo)){
           model.addAttribute("o",userinfo);
          return "userInfo";
        }

      return "login";
    }


    /**
     * 从session中获取用户信息
     * @param request
     * @return
     */
    @RequestMapping("/getUserIngo")
    @ResponseBody
    public Object getUserIngo(HttpServletRequest request){
        Object userInfo = request.getSession().getAttribute("userInfo");
            return userInfo;
    }


    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("geotoLogin")
    public String geotoLogin(){
        return "login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("getoRetister")
    public String getoRetister(){
        return "retister";
    }

}
