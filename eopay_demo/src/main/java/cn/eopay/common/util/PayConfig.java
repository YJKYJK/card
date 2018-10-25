package cn.eopay.common.util;

public class PayConfig {
	public static String PID = "10121";//亿发云支付的商户ID
	public static String KEY = "150OxF1v51RJ2i15RjI0211t4IxJ42IK";//亿发云支付商户的密钥
	public static String PAY_URL = "https://mpay.178v.cn/submit.php";//亿发云支付网关

	public static String NOTIFY_URL = "http://localhost:8080/notify.jsp";//商户网站的异步通知地址
	public static String RETURN_URL = "http://localhost:8080/return.jsp";//商户网站的同步跳转地址
}
