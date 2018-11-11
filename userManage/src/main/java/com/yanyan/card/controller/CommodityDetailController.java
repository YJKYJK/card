package com.yanyan.card.controller;

import com.yanyan.card.bean.CommodityDetail;
import com.yanyan.card.bean.CommodityInfo;
import com.yanyan.card.bean.GoodsClass;
import com.yanyan.card.bean.MerchantInfo;
import com.yanyan.card.service.CommodityDetailService;
import com.yanyan.card.util.Dto;
import com.yanyan.card.util.DtoUtil;
import com.yanyan.card.util.EmptyUtils;
import com.yanyan.card.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/25 0025.
 * 卡密管理
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

    /**
     * 根据条件查询卡密
     * @param request
     * @param commodityDetail
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping("queryKami")
    @ResponseBody
    public Map<String,Object> queryKami(HttpServletRequest request,CommodityDetail commodityDetail,
                                        @RequestParam(defaultValue="6")Integer pageSize,
                                        @RequestParam(defaultValue="1")Integer pageNumber){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return null;
        }
        commodityDetail.setMerchantId(merchantInfo.getMerchantId());
        Page<CommodityDetail> page = commodityDetailService.queryKamiByParams(commodityDetail, pageNumber, pageSize);
        Map<String,Object> map=new HashMap<>();
        map.put("total",page.getTotal());
        map.put("rows",page.getRows());
        map.put("pageNumber",pageNumber);
        return map;
    }

    @RequestMapping("/deleteKami")
    @ResponseBody
    public Dto deleteKami(HttpServletRequest request,CommodityDetail commodityDetail){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return DtoUtil.returnFail("删除失败","01");
        }
        commodityDetail.setMerchantId(merchantInfo.getMerchantId());
        boolean b = commodityDetailService.deleteKami(commodityDetail);
        if(b){
            return DtoUtil.returnSuccess("删除成功");
        }
        return DtoUtil.returnFail("删除失败","01");
    }

    /**
     * 跳转到修改卡密页面
     * @param request
     * @param commodityDetail
     * @param model
     * @return
     */
    @RequestMapping("/gotoModifyKami")
    public String gotoModifyKami(HttpServletRequest request,CommodityDetail commodityDetail,Model model){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return "page/merchant/merchatlogin";
        }
        commodityDetail.setMerchantId(merchantInfo.getMerchantId());
        commodityDetail=commodityDetailService.getKamiById(commodityDetail);
        model.addAttribute("g",commodityDetail);
        return "page/kami/modifyKami";
    }


    /**
     * 修改卡密
     * @param request
     * @param commodityDetail
     * @return
     */
    @RequestMapping("/modifyKami")
    @ResponseBody
    public Dto modifyKami(HttpServletRequest request,CommodityDetail commodityDetail){
        MerchantInfo merchantInfo= (MerchantInfo) request.getSession().getAttribute("merchantInfo");
        if(EmptyUtils.isEmpty(merchantInfo)){
            return DtoUtil.returnFail("修改失败","01");
        }
        commodityDetail.setMerchantId(merchantInfo.getMerchantId());
        boolean b = commodityDetailService.modifyKami(commodityDetail);
        if(b){
            return DtoUtil.returnSuccess("修改成功");
        }

        return DtoUtil.returnFail("修改失败","01");
    }
}
