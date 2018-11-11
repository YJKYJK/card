package com.yanyan.card.pay;

import javax.servlet.http.HttpServletRequest;

public class PayConfig {
	public static String codepay_id= "115113";//亿发云支付的商户ID
	public static String token = "QGGLlkMVw36pqDW8zDEXmDtynt771QD4";//亿发云支付商户的密钥
	public static String key = "bhFyeq9Zw1VhtEtf8nxLPVfld3Qnomhb";//亿发云支付网关
	public static String notify_url = "/pay/asnyView";//商户网站的异步通知地址
	public static String RETURN_URL = "http://127.0.0.1:8080/pay/asnyView";//商户网站的同步跳转地址
}
