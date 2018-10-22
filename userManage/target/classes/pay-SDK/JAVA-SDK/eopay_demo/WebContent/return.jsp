<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cn.eopay.common.util.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>异步回调demo</title>
<%
	String linkParams = "";
	String trade_status = request.getParameter("trade_status");
	String out_trade_no = request.getParameter("out_trade_no");
	String trade_no = request.getParameter("trade_no");
	String money = request.getParameter("money");
	String type = request.getParameter("type");
	if(PayUtil.checkKey(request)){
		out.println("验证签名成功");
		if("TRADE_SUCCESS".equals(trade_status)){
			//用户支付成功， 商户在下面进行支付成功后的逻辑处理
			out.println("<br>支付成功");
		}
	}else{
		//验签失败 不作处理
		out.print("验证签名失败");
	}
%>
</body>
</html>