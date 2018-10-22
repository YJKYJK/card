

<div class="input-group centers" style="width: 80%">
    <form class="form-horizontal" id="lForm"   role="form" method="post">
        <div class="input-group tops" >
            <input name="className" hidden id="className">
            <span class="input-group-addon">商品名称</span>
            <input type="text" name="commodityName" id="commodityName" class="form-control nu"
                   placeholder="商品名称">
        </div>




        <div class="input-group tops">
            <span class="input-group-addon">商品价格</span>
            <input type="number" name="price" id="price" class="form-control nu"
                   placeholder="商品价格">
        </div>


        <div class="input-group tops" >
            <span class="input-group-addon">商品类别</span>
            <select class="selectpicker form-control nu" id="goodsClass" name="classId">
            </select>
        </div>



        <div class="input-group tops">
            <span class="input-group-addon">说明</span>
            <input type="text" name="remark" class="form-control nu" placeholder="说明">
        </div>

    </form>
</div>

<script>

    $.ajax(
        {
            async:false,
            type:"get",
            url:"/shopClass/getClassList",
            data:{},
            success:function (res) {
                var se=$("#goodsClass");
                $.each(res,function (i,value) {
                    if(i==0){
                        $("#className").val(value.className);
                    }
                    var opt=$("<option value=" + value.classId + ">" + value.className + "</option>");
                    se.append(opt);
                })
        }
    });


    $("#goodsClass").on('change',function () {
        var va=$("#goodsClass option:selected").html()
        $("#className").val(va);
    })


</script>



