package com.yanyan.card.controller;
import com.yanyan.card.bean.BuyRecord;
import com.yanyan.card.bean.ShopOrder;
import com.yanyan.card.pay.PayConfig;

import com.yanyan.card.service.BuyRecordService;
import com.yanyan.card.service.CommdityInfoService;
import com.yanyan.card.service.ShopOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Resource
    private ShopOrderService shopOrderService;
    @Resource
    private BuyRecordService buyRecordService;
    @Resource
    private CommdityInfoService commdityInfoService;

    /**
     * 去支付
     * @param request
     * @param shopOrder
     * @param model
     * @return
     */
    @RequestMapping("/gotopay")
    public String gotopay(HttpServletRequest request, ShopOrder shopOrder, Model model){
        Boolean res = commdityInfoService.checknum(shopOrder.getCommodityId(), shopOrder.getNumber());
        if(!res){
             return "/page/shop/buyError";
        }
        shopOrder=shopOrderService.getFullShopOrder(shopOrder);
        String url="";
        String type=shopOrder.getPayType();

        String money=shopOrder.getTotalPrice().toString();

//        TreeMap<String,String> allParam=new TreeMap();
//        allParam.put("name",shopOrder.getCommodityName());
//        allParam.put("money", money);
//        allParam.put("type", type);
//        allParam.put("sitename", "测试站点");
//        allParam.put("out_trade_no",shopOrder.getOrderId());
        String returnUrl="http://"+request.getServerName()+":"+request.getServerPort()+PayConfig.notify_url;

        url="http://codepay.fateqq.com:52888/creat_order?id="+PayConfig.codepay_id
                +"&pay_id="+shopOrder.getOrderId()
                +"&price="+money+"&type="+type+"&token="+PayConfig.token+"&param="+""+"&notify_url="
                +returnUrl+"&return_url="+returnUrl;
        System.out.println(returnUrl);

     model.addAttribute("url",url);
        return "/pay";

    }

    @RequestMapping("asnyView")
    public String asnyView(HttpServletRequest request,Model model) throws NoSuchAlgorithmException {


        String key = "bhFyeq9Zw1VhtEtf8nxLPVfld3Qnomhb"; //记得更改 http://codepay.fateqq.com 后台可设置
        Map<String,String> params = new HashMap<String,String>(); //申明hashMap变量储存接收到的参数名用于排序
        Map requestParams = request.getParameterMap(); //获取请求的全部参数
        String valueStr = ""; //申明字符变量 保存接收到的变量
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            valueStr = values[0];
            //乱码解决，这段代码在出现乱码时使用。如果sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);//增加到params保存
        }
        List<String> keys = new ArrayList<String>(params.keySet()); //转为数组
        Collections.sort(keys); //重新排序
        String prestr = "";
        String sign= params.get("sign"); //获取接收到的sign 参数

        for (int i = 0; i < keys.size(); i++) { //遍历拼接url 拼接成a=1&b=2 进行MD5签名
            String key_name = keys.get(i);
            String value = params.get(key_name);
            if(value== null || value.equals("") ||key_name.equals("sign")){ //跳过这些 不签名
                continue;
            }
            if (prestr.equals("")){
                prestr =  key_name + "=" + value;
            }else{
                prestr =  prestr +"&" + key_name + "=" + value;
            }
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((prestr+key).getBytes());
        String  mySign = new BigInteger(1, md.digest()).toString(16).toLowerCase();
        if(mySign.length()!=32)mySign="0"+mySign;
        if(mySign.equals(sign)){
            //编码要匹配 编码不一致中文会导致加密结果不一致
            //参数合法处理业务
            //request.getParameter("pay_no") 流水号
           String orderId= request.getParameter("pay_id");
            //request.getParameter("money") 付款金额
            //request.getParameter("price") 提交的金额
//		out.print("ok");

            ShopOrder shopOrder=new ShopOrder();
                shopOrder.setOrderId(orderId);
                shopOrderService.modifyAll(shopOrder);
            List<BuyRecord> buyRecordListByMap = buyRecordService.getBuyRecordListByMap(orderId);
            model.addAttribute("o",buyRecordListByMap);
            model.addAttribute("success","ok");
            return "page/shop/cards";
        }else{
            model.addAttribute("error","签名验证失败");

        }

        return "payasnyView";




//        String linkParams = "";
//        String trade_status = request.getParameter("trade_status");
//        String out_trade_no = request.getParameter("out_trade_no");
//        String trade_no = request.getParameter("trade_no");
//        String money = request.getParameter("money");
//        String type = request.getParameter("type");
//        if(PayUtil.checkKey(request)){
//            if("TRADE_SUCCESS".equals(trade_status)){
//                //用户支付成功， 商户在下面进行支付成功后的逻辑处理
//                ShopOrder shopOrder=new ShopOrder();
//                shopOrder.setOrderId(out_trade_no);
//                shopOrderService.modifyAll(shopOrder);
//                model.addAttribute("paySuccess","支付成功");
//
//
//            }
//        }else{
//            //验签失败 不作处理
//            model.addAttribute("error","签名验证失败");
//        }
//        return "payasnyView";
    }

//    @RequestMapping("gotoCards")
//    public String gotoCards(Model model){
//
//        List<BuyRecord> buyRecordListByMap = buyRecordService.getBuyRecordListByMap("154108489786602ff55");
//        model.addAttribute("o",buyRecordListByMap);
//        return "page/shop/cards";
//    }


}
