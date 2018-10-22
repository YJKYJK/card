package com.yanyan.card.controller;

import com.yanyan.card.bean.GoodsClass;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.service.ShopClassService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/18 0018.
 */
@Controller
@RequestMapping("shopClass")
public class ShopClassController {


    @Resource
    private ShopClassService shopClassService;

    /**
     * 跳转到商品类别管理
     * @param request
     * @return
     */
    @RequestMapping("/gotoShopClass")
    public String gotoShopClass(HttpServletRequest request){
        MerchantInfo merchantInfo=null;
        merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchatlogin";
        }
        return "page/shop/shopClass";
    }


    /**
     * 根据登录用户获取商品类别
     * @param request
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping("/queryByUser")
    @ResponseBody
    public Map<String,Object> queryByUser(HttpServletRequest request,@RequestParam(defaultValue="6")Integer pageSize,@RequestParam(defaultValue="1")Integer pageNumber){


      MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        Page<GoodsClass> page = shopClassService.queryByUser(merchantInfo,pageNumber,pageSize);
        Map<String,Object> map=new HashMap<>();
        map.put("total",page.getTotal());
        map.put("rows",page.getRows());
        map.put("pageNumber",pageNumber);

        return map;
    }

    /**
     * 跳转到商品类别添加页面
     * @param request
     *
     * @return
     */
    @RequestMapping("/gotoAddShopClass")
    public String gotoAddShopClass(HttpServletRequest request){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchantlogin";
        }

        return "page/shop/addShopclass";
    }


    /**
     * 添加类别
     * @param request
     * @param goodsClass
     * @return
     */
    @RequestMapping("/saveGoodsClass")
    @ResponseBody
    public Dto saveGoodsClass(HttpServletRequest request,GoodsClass goodsClass){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");

        boolean res = shopClassService.saveGoodsClass(merchantInfo, goodsClass);
        if(res){
          return   DtoUtil.returnSuccess("添加成功");
        }

        return DtoUtil.returnFail("添加失败","01");
    }


    /**
     * 跳转商品类别修改页面
     * @param request
     * @param goodsClass
     * @param model
     * @return
     */
    @RequestMapping("/gotoModify")
    public String gotoModify(HttpServletRequest request,GoodsClass goodsClass,Model model){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchantlogin";
        }
        model.addAttribute("m",merchantInfo);
        model.addAttribute("g",goodsClass);
        return "page/shop/modifyShopclass";
    }

    /**
     * 修改类别
     * @param request
     * @param goodsClass
     * @return
     */
    @RequestMapping("/modifyGoodsClass")
    @ResponseBody
    public Dto modifyGoodsClass(HttpServletRequest request,GoodsClass goodsClass){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return DtoUtil.returnFail("修改失败","01");
        }
        goodsClass.setMerchantId(merchantInfo.getMerchantId());
        boolean res = shopClassService.modifyGoodsClass(goodsClass);
        if(!res){
            return DtoUtil.returnFail("修改失败","01");
        }
        return DtoUtil.returnSuccess("修改成功");

    }

    /**
     * 删除类别
     * @param request
     * @param goodsClass
     * @return
     */
    @RequestMapping("/removeGoodsClassById")
    @ResponseBody
    public Dto removeGoodsClassById(HttpServletRequest request,GoodsClass goodsClass){
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return DtoUtil.returnFail("删除失败","01");
        }
        goodsClass.setMerchantId(merchantInfo.getMerchantId());
        boolean res = shopClassService.removeGoodsClassById(goodsClass);
        if(!res){
            return DtoUtil.returnFail("删除失败","01");
        }
        return DtoUtil.returnSuccess("删除成功");
    }

    /**
     * 获取该用户的所有类别
     * @param request
     * @return
     */
    @RequestMapping("/getClassList")
    @ResponseBody
    public List getClassList(HttpServletRequest request){
        List<GoodsClass> list=new ArrayList<>();
        MerchantInfo  merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(!EmptyUtils.isEmpty(merchantInfo)){
            list= shopClassService.getClassList(merchantInfo);
        }
        return list;
    }


}
