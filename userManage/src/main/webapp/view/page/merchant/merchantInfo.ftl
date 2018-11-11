<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">

    <title>商家:${o.userName}</title>

    <link rel="stylesheet" href="/view/css/login.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/view/css/other.css">
</head>
<body>




<br>
<ui class="funui">
    <li onclick="location.href='/shop/gotoUpdateShop'">
        <img src="/view/imgs/零件.png">
        <span>商店管理</span>
    </li>


    <li onclick="location.href='/shopClass/gotoShopClass'">
        <img src="/view/imgs/介绍.png">
        <span>类别管理</span>
    </li>

    <li onclick="location.href='/commodity/gotoCommodity'">
        <img src="/view/imgs/商城.png">
        <span>商品管理</span>
    </li>

    <li onclick="location.href='/kami/gotoKami'">
        <img src="/view/imgs/新闻.png">
        <span>卡密管理</span>
    </li>

    <li>
        <img src="/view/imgs/新闻.png">
        <span>商品类别</span>
    </li>

    <li>
        <img src="/view/imgs/新闻.png">
        <span>订单详情</span>
    </li>

    <li>
        <img src="/view/imgs/新闻.png">
        <span>商品类别</span>
    </li>

    <li>
        <img src="/view/imgs/新闻.png">
        <span>商品类别</span>
    </li>
    <li>
        <img src="/view/imgs/新闻.png">
        <span>商品类别</span>
    </li>

</ui>



<div><a href="${contextPath}/shop/gotoShop/${o.merchantId}">进入商店</a></div>


</body>
<script>


</script>
</html>