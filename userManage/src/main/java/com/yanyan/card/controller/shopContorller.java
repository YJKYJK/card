package com.yanyan.card.controller;

import com.yanyan.card.bean.BuyRecord;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.bean.ShopInfo;
import com.yanyan.card.service.*;
import com.yanyan.card.util.Dto;
import com.yanyan.card.util.DtoUtil;
import com.yanyan.card.util.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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
    @Resource
    private BuyRecordService buyRecordService;
    @Resource
    private ShopInfoService shopInfoService;

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

        ShopInfo shopInfo = shopInfoService.getShopInfoById(merchant.getMerchantId());
        model.addAttribute("",shopInfo);
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

    /**
     * 根据商品ID和购买数量获取价格
     * @param commodityId
     * @param number
     * @return
     */
    @RequestMapping("/getTotalPrice")
    @ResponseBody
    public BigDecimal getTotalPrice(String commodityId, Integer number){
        BigDecimal totalPrice = commdityInfoService.getTotalPrice(commodityId, number);
        return  totalPrice;
    }

    /**
     * 获取订单信息(订单查询)
     * @param param
     * @return
     */
    @RequestMapping("/getBuyRecord")
    @ResponseBody
   public List<BuyRecord> getBuyRecord(String param){
        if(EmptyUtils.isEmpty(param)){
            return null;
        }
       List<BuyRecord> buyRecordListByMap = buyRecordService.getBuyRecordListByMap(param);
       return buyRecordListByMap;
   }

    @RequestMapping("/gotobuyRecord")
   public String gotobuyRecord(){
       return "page/shop/buyRecord";
   }


    /**
     * 修改商店信息
     * @param shopInfo
     * @return
     */
    @RequestMapping("/modifyShopInfo")
    @ResponseBody
   public Dto modifyShopInfo(ShopInfo shopInfo){
        boolean res = shopInfoService.modifyShopInfo(shopInfo);
        if(res){
            return DtoUtil.returnSuccess("修改成功");
        }
        return DtoUtil.returnFail("修改失败","01");
    }

    /**
     * 跳转到商品修改页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/gotoUpdateShop")
    public String gotoUpdateShop(HttpServletRequest request,Model model){
        MerchantInfo merchantInfo=null;
        merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchatlogin";
        }

    ShopInfo shopInfo = shopInfoService.getShopInfoById(merchantInfo.getMerchantId());
        model.addAttribute("shopInfo",shopInfo);
    return "/page/shop/updateShop";
    }

    /**
     * 根据商家id获取该商家的所有商品
     * @param request
     * @return
     */
    @RequestMapping("/getCommodityByUserId")
    @ResponseBody
    public List getCommodityByUserId(HttpServletRequest request){
        MerchantInfo merchantInfo=null;
        merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return null;
        }
        return commdityInfoService.getCommodityByUserId(merchantInfo.getMerchantId());
    }
}
