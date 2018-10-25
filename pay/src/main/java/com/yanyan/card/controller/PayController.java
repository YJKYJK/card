package com.yanyan.card.controller;
import com.yanyan.card.bean.ShopOrder;
import com.yanyan.card.pay.PayConfig;
import com.yanyan.card.pay.PayUtil;
import com.yanyan.card.service.ShopOrderService;
import org.springframework.stereotype.Controller;
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
    public String gotopay(HttpServletRequest request, ShopOrder shopOrder){
        String url="";
        String type=shopOrder.getPayType();
//        String type = request.getParameter("type");

        String money=shopOrder.getTotalPrice().toString();
//        String money = request.getParameter("money");
//        String url = "";
        TreeMap<String,String> allParam=new TreeMap();
        allParam.put("name",shopOrder.getCommodityName());
        allParam.put("money", money);
       allParam.put("type", type);
       allParam.put("pid", PayConfig.PID);
       allParam.put("notify_url", PayConfig.NOTIFY_URL);
       allParam.put("return_url", PayConfig.RETURN_URL);
       allParam.put("sitename", "测试站点");
        url = PayConfig.PAY_URL + "?"+PayUtil.createLink(allParam, PayConfig.KEY);
        if(null != url && !"".equals(url)&&type!=null){



         }

        return url;

    }
}
