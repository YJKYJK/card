<div>
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

</div>
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
    });


</script>

