<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">
    <title>${shopInfo.shopName}</title>

  <link href="/view/css/public.css" rel="stylesheet">
   <link href="/view/css/login.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap3-dialog/1.35.4/css/bootstrap-dialog.min.css" rel="stylesheet">

    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap3-dialog/1.35.4/js/bootstrap-dialog.min.js"></script>
    <script src="/view/js/dialog.js"></script>

</head>
<body>
<h2 class="centers">${m.userName}的店铺</h2>
<button type="button" class="btn btn-primary btn-lg">联系商家</button>
<button type="button" id="buyRecord" class="btn btn-primary btn-lg">订单查询</button>


<div class="shop">
    <div class="hk">
        <span class="sp-h">公告</span>
        <div>${shopInfo.notice}</div>
    </div>
</div>

<form action="/pay/gotopay" method="post" id="payfrom">


<div class="shop">
    <div class="hk">
        <span class="sp-h">商品分类</span>
        <select class="selectpicker form-control nu"  id="goodsClass" name="classId"></select>
    </div>
</div>


<div class="shop">
    <div class="hk">
        <span class="sp-h">商品</span>
        <select class="selectpicker form-control nu"  id="commodity" name="commodityId"></select>
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
                <input type="number" value="0" id="number" name="number" class="numbers"/>
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
        <input type="text" name="buyUser" id="userName" class="form-control nu"
               placeholder="该联系方式用于查找订单">
    </div>
</div>


    <div class="shop">
        <div class="hk">
        <dt>支付方式：</dt>
        <dd>
            <select name="payType" class="selectpicker form-control nu">
                <option value="1">支付宝</option>
                <option value="3">微信</option>
                <option value="2">QQ钱包</option>
            </select>
            </div>
    </div>

<div class="shop">
    <div class="hk">
        <ui class="uiclass">
            <li>
                <span>应付金额:</span>
            </li>
            <li>
                <span class="totalpric" id="totalpric">0.00</span>元
            </li>
            <li>
                <button type="submit" class="btn btn-primary">确认支付</button>
            </li>

        </ui>
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
        sss();
    });






    /**
     * 根据商品ID获取商品信息
     * @type {*}
     */
    function sss() {
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
                     $("#number").val(0);
                     $("#num").html(res.num);
                    $("#totalpric").html("0.00");

                }
            });

        }

    }
    sss();
    $("#commodity").on("change",function () {
        sss();
    });


    /**
     * 价格
     */
$("#number").on("change",function () {
    var shopId=$('#commodity option:selected') .val();
    var number=$("#number").val();
    if(number=="" || number==null){
        return;
    }
    $.ajax({
        async:false,
        type:"get",
        url:"/shop/getTotalPrice",
        data:{commodityId:shopId,number:number},
        success:function (res) {
            $("#totalpric").html(res);
        }
    })
})

    $("#buyRecord").on("click",function () {
        location.href="/shop/gotobuyRecord";
    })


    $("#payfrom").on("submit",function () {
        var userName=$("#userName").val();
        if(userName.length<6){
            $.dialogTitle("提示","联系方式必须大于6位数","知道了");
            return false;
        }

        var number =$("#number").val();
       if(number<1){
           $.dialogTitle("提示","购买数量不能小于1","知道了");
           return false;
       }

        return true;

    })



</script>
</html>
