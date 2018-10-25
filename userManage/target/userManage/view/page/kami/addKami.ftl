<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">
    <title>${m.userName}</title>

  <link href="/view/css/public.css" rel="stylesheet">
   <link href="/view/css/login.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>

</head>
<body>
<h2 class="centers">${m.userName}:卡密管理</h2>

<form id="addKami" class="form-horizontal" role="form" method="post">
<div class="shop">
    <div class="hk">
        <span class="sp-h">商品分类</span>
        <select class="selectpicker form-control nu"  id="goodsClass" name="classId"></select>
    </div>
</div>
<div class="shop">
    <div class="hk">
        <span class="sp-h">商品分类</span>
        <select class="selectpicker form-control nu"  id="commodity" name="commodityId"></select>
    </div>
</div>
    <div class="shop">
        <div class="hk">
            <span class="sp-h">卡密分割符</span>
            <input class="form-control nu" name="catLine">
        </div>
    </div>

    <div class="shop">
        <div class="hk">
            <span class="sp-h">卡密</span>
            <textarea class="form-control nu" name="km"></textarea>
        </div>
    </div>

</form>

</body>
<script>
    $.ajax({
    async:false,
        type:"get",
        url:"/shop/getClassById",
        data:{merchantId:"${m.merchantId}"},
        success:function (res) {
            var se=$("#goodsClass");
            $.each(res,function (i,value) {
                var opt=$("<option value=" + value.classId + ">" + value.className + "</option>");
                se.append(opt);
            })
        }
    });


    /**
     * 根据商品class获取商品
     * @param classId
     */
    function getShop(classId) {
        $.ajax({
            async:false,
            type:"get",
            url:"/shop/getCommodityByClass",
            data:{classId:classId},
            success:function (res) {

                $("#commodity option").remove();
                var se=$("#commodity");

                $.each(res,function (i,value) {
                    var opt=$("<option value=" + value.commodityId + ">" + value.commodityName + "</option>");
                    se.append(opt);
                })
            }
        });
    }

    /**
     * 获取该类下的所有商品
     * @type {*}
     */
    var selectedVal=$('#goodsClass option:selected') .val();
    getShop(selectedVal);

    $("#goodsClass").on("change",function () {

        selectedVal=$('#goodsClass option:selected') .val();
        getShop(selectedVal);
        getShopdetail();
    });


</script>
</html>
