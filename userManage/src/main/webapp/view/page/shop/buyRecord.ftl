<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">

    <title>订单查询</title>
<link href="/view/css/public.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap3-dialog/1.35.4/css/bootstrap-dialog.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap3-dialog/1.35.4/js/bootstrap-dialog.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/i18n/defaults-zh_CN.min.js"></script>

</head>
<body style="text-align: center;background-color: #FFFFFF">

<div style="padding: 20px 20px 20px;">

    <div class="row">
        <div >
            <div class="input-group">
                <input type="text" class="form-control" name="param" id="param" placeholder="订单编号或联系方法">
                <span class="input-group-btn">
                        <button class="btn btn-default" type="button" id="aaaa">订单查询</button>
                    </span>
            </div>
        </div>
    </div>

</div>

<div class="main" id="main">


</div>

</body>
<script>
    $("#aaaa").on("click",function () {
        $(".maindiv").remove();
        $.ajax({
            async:true,
            type:"get",
            url:"/shop/getBuyRecord",
            data:{param:$("#param").val()},
            success:function (res) {
                if(res.size<1){
                    $("#main").append("<h1>无订单信息</h1>");
                }else {
                    $.each(res,function (i,value) {

                        var maindiv=$("<div class='maindiv'></div>");
                        var shopName=$("<span>商品名称:</span><span>"+value.commodityName+"</span><br>")
                        var kahao=$("<span>卡号:</span><span>"+value.cardNumber+"</span><br>");
                        var kami=$("<span>卡密:</span><span>"+value.cardNumber+"</span><br>");
                        var tops=$("<span class='tops'></span>");
                        maindiv.append(shopName);
                        maindiv.append(kahao);
                        maindiv.append(kami);
                        $("#main").append(maindiv);
                        $("#main").append(tops);
                    });
                }
            }
        });




    });


</script>
</html>