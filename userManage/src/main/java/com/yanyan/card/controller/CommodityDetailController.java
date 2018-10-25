package com.yanyan.card.controller;

import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.service.CommodityDetailService;
import com.yanyan.card.util.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@Controller
@RequestMapping("kami")
public class CommodityDetailController {
    @Resource
    private CommodityDetailService commodityDetailService;

    /**
     * 添加卡密
     * @param commodityInfo
     * @param km
     * @param catLine
     * @return
     */
    @RequestMapping("addKami")
    @ResponseBody
    public Integer saveList(HttpServletRequest request,CommodityInfo commodityInfo, String km, String catLine){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if (EmptyUtils.isEmpty(merchantInfo)){
            return 0;
        }
        commodityInfo.setMerchantId(merchantInfo.getMerchantId());
        Integer integer = commodityDetailService.saveList(km, catLine, commodityInfo);
        return integer;
    }

    /**
     * 跳转到卡密管理页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/gotoKami")
    public String gotoKami(HttpServletRequest request, Model model){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchatlogin";
        }
        model.addAttribute("m",merchantInfo);
        request.getSession().setAttribute("merchantInfo",merchantInfo);
        return "page/kami/kami";
    }

    /**
     * 跳转到添加卡密页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/gotoAddKami")
    public String gotoAddKami(HttpServletRequest request, Model model){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchatlogin";
        }
        model.addAttribute("m",merchantInfo);
        request.getSession().setAttribute("merchantInfo",merchantInfo);
        return "page/kami/addKami";
    }
}
