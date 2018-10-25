package com.yanyan.card.pay;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class PayUtil {

	public static String generateOrderId(){
		String keyup_prefix=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String keyup_append=String.valueOf(new Random().nextInt(899999)+100000);
		String pay_orderid=keyup_prefix+keyup_append;//订单号
		return pay_orderid;
	}

	public static String createLink(TreeMap<String,String> hm , String key){
		String result = "";
		Set<String> parm = hm.keySet();
		for(String one : parm ){
			String value = hm.get(one);
			result = result + one + "=" + value + "&";
		}
		result = result.substring(0,result.length()-1);
		System.out.println("拼接字符:"+result + key);
		String sign = toMD5(result + key);
		System.out.println("生成的sign:"+sign);
		result = result + "&sign=" + sign;
		System.out.println("测试到EOPAY的key:"+result);
		return result;
	}

	public static String toMD5(String plainText ) {
		if(plainText == null || "".equals(plainText.trim())){
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes("UTF-8"));
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if(i<0) i+= 256;
				if(i<16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "123456";
		}
	}

	//校验是否为window系统服务器
	public static boolean isWindow(){
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("win")){
			return true;
		}else{
			return false;
		}
	}

	public static boolean checkKey(HttpServletRequest request){
		String money = "money=" + request.getParameter("money")+"&";
		String name = request.getParameter("name");
		if("GET".equalsIgnoreCase(request.getMethod())
				&&isWindow()){
//			try {
//				name = new String(name.getBytes("ISO-8859-1"),"utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
		}
		name = "name=" + name+"&";
		String out_trade_no = "out_trade_no=" + request.getParameter("out_trade_no")+"&";
		String pid = "pid=" + request.getParameter("pid")+"&";
		String trade_no = "trade_no=" + request.getParameter("trade_no")+"&";
		String trade_status = "trade_status="+ request.getParameter("trade_status") +"&";
		String type = "type=" + request.getParameter("type");
		String allStr = money + name + out_trade_no + pid + trade_no + trade_status + type + PayConfig.KEY;
		System.out.println("all param + key :" + allStr);
		System.out.println("sign from eopay :" + request.getParameter("sign"));
		return toMD5( allStr ).equals(request.getParameter("sign"));
	}
}
