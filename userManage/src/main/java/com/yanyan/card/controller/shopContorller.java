package com.yanyan.card.controller;

import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.service.CommdityInfoService;
import com.yanyan.card.service.MerchantInfoService;
import com.yanyan.card.service.ShopClassService;
import com.yanyan.card.util.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/21 0021.
 */
@Controller
@RequestMapping("/shop")
public class shopContorller {
    @Resource
    private MerchantInfoService merchantInfoService;
    @Resource
    private ShopClassService shopClassService;
    @Resource
    private CommdityInfoService commdityInfoService;

    /**
     * 跳转到商家商店
     * @param merchantId
     * @param model
     * @return
     */
    @RequestMapping("gotoShop/{merchantId}")
    public String gotoShop(@PathVariable String merchantId,Model model){
         MerchantInfo merchant = merchantInfoService.getMerchant(merchantId);
        if(EmptyUtils.isEmpty(merchant)){
            return "page/error";
        }

        model.addAttribute("m",merchant);
        return "page/shop/shop";
    }


    /**
     * 根据商家id获取商家类别
     * @param merchantId
     * @return
     */
    @RequestMapping("/getClassById")
    @ResponseBody
    public List getClassById(String merchantId){
        return shopClassService.getClassById(merchantId);
    }


    /**
     * 根据商品分类拿该类的所有商品
     * @param classId
     * @return
     */
    @RequestMapping("/getCommodityByClass")
    @ResponseBody
    public List getCommodityByClass(String classId){
        return commdityInfoService.getCommodityByClass(classId);
    }


    /**
     * 根据商品ID获取商品详细信息
     * @param commodityId
     * @return
     */
    @RequestMapping("/getCommodityById")
    @ResponseBody
    public CommodityInfo getCommodityById(String commodityId){
        return commdityInfoService.getCommodityById(commodityId);
    }

}
