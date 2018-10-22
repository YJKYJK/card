package com.yanyan.card.controller;

import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.GoodsClass;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.service.CommdityInfoService;
import com.yanyan.card.util.Dto;
import com.yanyan.card.util.DtoUtil;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/16 0016.
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
   private CommdityInfoService commdityInfoService;





    /**
     * 根据登录用户获取商品
     * @param request
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping("/queryByUser")
    @ResponseBody
    public Map<String,Object> queryByUser(HttpServletRequest request, @RequestParam(defaultValue="6")Integer pageSize, @RequestParam(defaultValue="1")Integer pageNumber){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        Page<CommodityInfo> page = commdityInfoService.queryByUser(merchantInfo,pageNumber,pageSize);
        Map<String,Object> map=new HashMap<>();
        map.put("total",page.getTotal());
        map.put("rows",page.getRows());
        map.put("pageNumber",pageNumber);

        return map;
    }


    /**
     * 跳转到商品管理页面
     * @param request
     * @return
     */
    @RequestMapping("/gotoCommodity")
    public String gotoCommodity(HttpServletRequest request){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchatlogin";
        }

        return "page/commodity/commodity";

    }


    /**
     * 跳转到商品添加页面
     * @param request
     * @return
     */
    @RequestMapping("/gotoadd")
    public String gotoadd(HttpServletRequest request){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchantlogin";
        }

        return "page/commodity/addCommodity";

    }


    /**
     * 添加商品
     * @param request
     * @param commodityInfo
     * @return
     */
    @RequestMapping("/saveCommdityInfo")
    @ResponseBody
    public Dto saveCommdityInfo(HttpServletRequest request,CommodityInfo commodityInfo){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return DtoUtil.returnFail("添加失败","01");
        }
        commodityInfo.setMerchantId(merchantInfo.getMerchantId());
        boolean res = commdityInfoService.saveCommdityInfo(commodityInfo);
        if (res){
            return DtoUtil.returnSuccess("添加成功");
        }

        return DtoUtil.returnFail("添加失败","01");
    }

    @RequestMapping("/gotoModify")
    public String gotoModify(HttpServletRequest request, CommodityInfo commodityInfo, Model model){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchatlogin";
        }
        commodityInfo.setRemark("1111");
        model.addAttribute("g",commodityInfo);
        return "page/commodity/modifyCommodity";
    }

    /**
     * 修改商品
     * @param request
     * @param commodityInfo
     * @return
     */

    @RequestMapping("/modifyCommodity")
    @ResponseBody
 public Dto modifyCommodity(HttpServletRequest request,CommodityInfo commodityInfo){
     MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
     if(EmptyUtils.isEmpty(merchantInfo)){
         return DtoUtil.returnFail("修改失败","01");
     }
     commodityInfo.setMerchantId(merchantInfo.getMerchantId());
     boolean res = commdityInfoService.modifyCommodity(commodityInfo);
     if(res){
         return DtoUtil.returnSuccess("修改成功");
     }

     return DtoUtil.returnFail("修改失败","01");
 }

    /**
     * 删除商品
     * @param request
     * @param commodityInfo
     * @return
     */
    @RequestMapping("/removeCommodity")
    @ResponseBody
    public Dto removeCommodity(HttpServletRequest request,CommodityInfo commodityInfo){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return DtoUtil.returnFail("删除失败","01");
        }
        commodityInfo.setMerchantId(merchantInfo.getMerchantId());
        boolean res = commdityInfoService.removeCommodity(commodityInfo);
        if(!res){
            return DtoUtil.returnFail("删除失败","01");

        }
        return DtoUtil.returnSuccess("删除成功");
    }

}
