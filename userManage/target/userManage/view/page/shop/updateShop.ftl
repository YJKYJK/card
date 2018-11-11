<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">

    <title>商店信息配置</title>

    <link rel="stylesheet" href="/view/css/login.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="input-group centers" style="width: 80%">
    <form class="form-horizontal" id="shopForm" role="form">
        <div class="input-group tops" >
            <span class="input-group-addon">商店名称</span>
            <input type="text" value="${shopInfo.shopName}" name="shopName" id="shopName" class="form-control" placeholder="商店名称">
        </div>

        <div class="tops">
            <span class="">公告</span><br>
            <textarea cols="35" rows="12" name="notice" id="notice" placeholder="输入公告">${shopInfo.notice}</textarea>
        </div>



        <div class="input-group tops" >
            <span class="input-group-addon">QQ</span>
            <input type="text" value="${shopInfo.qq}" name="qq" id="qq" class="form-control" placeholder="QQ账号">
        </div>

        <div class="input-group tops" >
            <span class="input-group-addon">Q群</span>
            <input type="text" value="${shopInfo.qqGroup}" name="qqGroup" id="qq" class="form-control" placeholder="QQ群">
        </div>
        <input hidden value="${shopInfo.merchantId}" name="merchantId">

<br>
        <button type="button" class="btn btn-primary" id="update" style="width: 50%"
                data-complete-text="提交变更">提交变更
        </button>
    </form>
</div>


</body>
<script>
    $("#update").click(function(){
       $.ajax({
           async:true,
           type:"post",
           url:"/shop/modifyShopInfo",
           data:$("#shopForm").serialize(),
           success:function (res) {
               if(res.success=="true"){
                   alert("修改成功");
               }else{
                   alert("修改失败");
               }

           }
       })
    });

</script>
</html>