package com.yanyan.card.controller;
import com.yanyan.card.bean.ShopOrder;
import com.yanyan.card.pay.PayConfig;
import com.yanyan.card.pay.PayUtil;
import com.yanyan.card.service.ShopOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Resource
    private ShopOrderService shopOrderService;

    @RequestMapping("/gotopay")
    public String gotopay(HttpServletRequest request, ShopOrder shopOrder,Model model){
        shopOrder=shopOrderService.getFullShopOrder(shopOrder);
        String url="";
        String type=shopOrder.getPayType();

        String money=shopOrder.getTotalPrice().toString();

        TreeMap<String,String> allParam=new TreeMap();
        allParam.put("name",shopOrder.getCommodityName());
        allParam.put("money", money);
       allParam.put("type", type);
       allParam.put("pid", PayConfig.PID);
       allParam.put("notify_url", PayConfig.NOTIFY_URL);
       allParam.put("return_url", PayConfig.RETURN_URL);
       allParam.put("sitename", "测试站点");
        allParam.put("out_trade_no",shopOrder.getOrderId());
        url = PayConfig.PAY_URL + "?"+PayUtil.createLink(allParam, PayConfig.KEY);
//        if(null != url && !"".equals(url)&&type!=null){
//
//
//
//         }
     model.addAttribute("url",url);
        return "/pay";

    }

    @RequestMapping("asnyView")
    public String asnyView(HttpServletRequest request,Model model){
        String linkParams = "";
        String trade_status = request.getParameter("trade_status");
        String out_trade_no = request.getParameter("out_trade_no");
        String trade_no = request.getParameter("trade_no");
        String money = request.getParameter("money");
        String type = request.getParameter("type");
        if(PayUtil.checkKey(request)){
            model.addAttribute("success","签名验证成功");
            if("TRADE_SUCCESS".equals(trade_status)){
                //用户支付成功， 商户在下面进行支付成功后的逻辑处理
                ShopOrder shopOrder=new ShopOrder();
                shopOrder.setOrderId(out_trade_no);
                shopOrder.setIsPay("Y");
                shopOrderService.modifyShopOrder(shopOrder);
                model.addAttribute("paySuccess","支付成功");

            }
        }else{
            //验签失败 不作处理
            model.addAttribute("error","签名验证成功");
        }
        return "payasnyView";
    }


}
