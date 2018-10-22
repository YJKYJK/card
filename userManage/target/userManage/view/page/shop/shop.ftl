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
<h2 class="centers">${m.userName}的店铺</h2>



<div class="shop">
    <div class="hk">
        <span class="sp-h">商品分类</span>
        <select class="selectpicker form-control nu"  id="goodsClass" name="goodsClass"></select>
    </div>
</div>


<div class="shop">
    <div class="hk">
        <span class="sp-h">商品分类</span>
        <select class="selectpicker form-control nu"  id="commodity" name="commodity"></select>
    </div>
</div>



<div class="shop">
    <span class="sp-h">商品详情</span>
    <div class="details">
        <div class="imgdiv">
            <img src="" class="imgs" id="pic"/>
        </div>
      <span id="remark"></span>

    </div>
<div>
        <ui class="uiclass">
            <li>
                <span>商品单价</span>
            </li>
            <li>
                <span>购买数量</span>
            </li>
            <li>
                <span>商品库存</span>
            </li>

            <li>
                <span id="price">0.00</span>
            </li>
            <li>
                <input type="number" value="1" id="number"/>
            </li>
            <li>
                <span id="num">0</span>
            </li>

        </ui>
</div>
</div>

<div class="shop">
    <div class="hk">
        <span class="sp-h">联系方式</span>
        <input type="text" name="className" id="userName" class="form-control nu"
               placeholder="该联系方式用于查找订单">
    </div>
</div>




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






    /**
     * 根据商品ID获取商品信息
     * @type {*}
     */

    function getShopdetail() {
        var shopId=$('#commodity option:selected') .val();
        if(shopId!=null|| shopId!="undefined"){

            $.ajax({
                async:false,
                type:"get",
                url:"/shop/getCommodityById",
                data:{commodityId:shopId},
                success:function (res) {
                     $("#pic").attr("src",res.pic);
                     $("#remark").html(res.remark);
                     $("#price").html(res.price);
                     $("#price").val(1);
                     $("#num").html(res.num);

                }
            });

        }

    }
    getShopdetail();
    $("#commodity").on("change",function () {
        getShopdetail();
    });






</script>
</html>
