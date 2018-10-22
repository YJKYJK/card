<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.eopay.common.util.*" %>
<%@ page import="java.util.*" %>
<script type="text/javascript">
var optionType='<%=request.getAttribute("optionType")%>';
var contextPath = '<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>';
</script>
<% 
	String contextPath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	if(request.getServerPort()==80 || 443 == request.getServerPort()){
		contextPath = request.getScheme() +"://"+request.getServerName()+request.getContextPath();
	}
	session.setAttribute("contextPath",contextPath);
%>
<%
	String type = request.getParameter("type");
	String money = request.getParameter("money");
	String url = "";

	TreeMap<String,String> allParam = new TreeMap<String,String>();
	allParam.put("name", "测试商品");
	allParam.put("money", money);
	allParam.put("type", type);
	allParam.put("pid", PayConfig.PID);
	allParam.put("notify_url", PayConfig.NOTIFY_URL);
	allParam.put("return_url", PayConfig.RETURN_URL);
	allParam.put("sitename", "测试站点");
	allParam.put("out_trade_no", PayUtil.generateOrderId());
	//拼接支付链接
	url = PayConfig.PAY_URL + "?"+PayUtil.createLink(allParam, PayConfig.KEY);
	System.out.println("URL:" + url);
	if(null != url && !"".equals(url)&&type!=null){
		//直接跳转到EOPay
		out.print("<script>location.href='"+ url +"';</script>");
	}
%>
<head>
<meta http-equiv="Content-Type"   charset="UTF-8">
<script type="text/javascript">

</script>
	<title>EOPay demo </title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
    *{
        margin:0;
        padding:0;
    }
    ul,ol{
        list-style:none;
    }
    body{
        font-family: "Helvetica Neue",Helvetica,Arial,"Lucida Grande",sans-serif;
    }
    .hidden{
        display:none;
    }
    .new-btn-login-sp{
        padding: 1px;
        display: inline-block;
        width: 75%;
    }
    .new-btn-login {
        background-color: #02aaf1;
        color: #FFFFFF;
        font-weight: bold;
        border: none;
        width: 100%;
        height: 30px;
        border-radius: 5px;
        font-size: 16px;
    }
    #main{
        width:100%;
        margin:0 auto;
        font-size:14px;
    }
    .red-star{
        color:#f00;
        width:10px;
        display:inline-block;
    }
    .null-star{
        color:#fff;
    }
    .content{
        margin-top:5px;
    }
    .content dt{
        width:100px;
        display:inline-block;
        float: left;
        margin-left: 20px;
        color: #666;
        font-size: 13px;
        margin-top: 8px;
    }
    .content dd{
        margin-left:120px;
        margin-bottom:5px;
    }
    .content dd input {
        width: 85%;
        height: 28px;
        border: 0;
        -webkit-border-radius: 0;
        -webkit-appearance: none;
    }
    #foot{
        margin-top:10px;
        position: absolute;
        bottom: 15px;
        width: 100%;
    }
    .foot-ul{
        width: 100%;
    }
    .foot-ul li {
        width: 100%;
        text-align:center;
        color: #666;
    }
    .note-help {
        color: #999999;
        font-size: 12px;
        line-height: 130%;
        margin-top: 5px;
        width: 100%;
        display: block;
    }
    #btn-dd{
        margin: 20px;
        text-align: center;
    }
    .foot-ul{
        width: 100%;
    }
    .one_line{
        display: block;
        height: 1px;
        border: 0;
        border-top: 1px solid #eeeeee;
        width: 100%;
        margin-left: 20px;
    }
    .am-header {
        display: -webkit-box;
        display: -ms-flexbox;
        display: box;
        width: 100%;
        position: relative;
        padding: 7px 0;
        -webkit-box-sizing: border-box;
        -ms-box-sizing: border-box;
        box-sizing: border-box;
        background: #1D222D;
        height: 50px;
        text-align: center;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        box-pack: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        box-align: center;
    }
    .am-header h1 {
        -webkit-box-flex: 1;
        -ms-flex: 1;
        box-flex: 1;
        line-height: 18px;
        text-align: center;
        font-size: 18px;
        font-weight: 300;
        color: #fff;
    }
</style>
</head>
<body text=#000000 bgColor="#ffffff" leftMargin=0 topMargin=4>
<header class="am-header">
        <h1>EOPay demo</h1>
</header>
<div id="main">
        <form name=alipayment action='pay.jsp' method=post target="_blank">
            <div id="body" style="clear:left">
                <dl class="content">
                    <hr class="one_line">
                    <dt>付款金额：</dt>
                    <dd>
                        <input id="money" name="money" value="0.01"/>
                    </dd>
                    <hr class="one_line"/>
                    <dt>支付方式：</dt>
                    <dd>
                        <select name="type">
						<option value="alipay">支付宝</option>
						<option value="wxpay">微信</option>
						<option value="qqpay">QQ钱包</option>
					</select> 
                    </dd>
                    <hr class="one_line">
                    <dt></dt>
                    <dd id="btn-dd">
                        <span class="new-btn-login-sp">
                            <button class="new-btn-login" type="submit" style="text-align:center;">确 认</button>
                        </span>
                    </dd>
                </dl>
            </div>
		</form>
	</div>
</body>
</html>