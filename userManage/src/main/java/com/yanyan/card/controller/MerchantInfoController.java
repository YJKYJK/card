package com.yanyan.card.controller;

import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.bean.UserInfo;
import com.yanyan.card.mapper.MerchantInfoMapper;
import com.yanyan.card.service.MerchantInfoService;
import com.yanyan.card.util.Dto;
import com.yanyan.card.util.DtoUtil;
import com.yanyan.card.util.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/17 0017.
 */
@Controller
@RequestMapping("/merchant")
public class MerchantInfoController{

    @Resource
    private MerchantInfoService merchantInfoService;

    @RequestMapping("/retister")
    @ResponseBody
    public Dto retister(HttpServletRequest request,MerchantInfo merchantInfo){
        boolean res= merchantInfoService.saveMerchant(merchantInfo);
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
        return merchantInfoService.quryUserByName(userName);
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("geotoLogin")
    public String geotoLogin(){
        return "page/merchant/merchatlogin";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("getoRetister")
    public String getoRetister(){
        return "page/merchant/merchantRetister";
    }


    @RequestMapping("/login")
    @ResponseBody
    public Dto login(HttpServletRequest request,MerchantInfo merchantInfo){
        if(EmptyUtils.isEmpty(merchantInfo.getUserName())){
            return DtoUtil.returnFail("登录失败","01");
        }

        if(EmptyUtils.isEmpty(merchantInfo.getPassword())){
            return DtoUtil.returnFail("登录失败","01");
        }

        MerchantInfo mi=null;
        mi=merchantInfoService.login(merchantInfo);
        if(EmptyUtils.isEmpty(mi)){
            return DtoUtil.returnFail("账号或者密码错误","01");
        }
        request.getSession().setAttribute("merchantInfo",mi);
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
        Object merchantInfo = request.getSession().getAttribute("merchantInfo");


        if(EmptyUtils.isNotEmpty(merchantInfo)){
            String contextPath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
            if(request.getServerPort()==80 || 443 == request.getServerPort()){
                contextPath = request.getScheme() +"://"+request.getServerName()+request.getContextPath();
            }
            model.addAttribute("contextPath",contextPath);
            model.addAttribute("o",merchantInfo);



            return "page/merchant/merchantInfo";
        }

        return "page/merchant/merchatlogin";
    }



}
