
<div class="input-group centers" style="width: 80%">
    <form class="form-horizontal" id="modifyCommodity"   role="form" method="post">
        <input hidden name="classId" value="${g.classId}">
        <input hidden name="commodityId" value="${g.commodityId}">
        <div class="input-group tops" >
            <input type="text" name="commodityName" value="${g.commodityName}"  id="commodityName" class="form-control nu"
                   placeholder="商品名称">
        </div>

        <div class="input-group tops" >
            <input type="number" name="price" value="${g.price}"  id="price" class="form-control nu"
                   placeholder="商品价格">
        </div>

        <div class="input-group tops">
            <textarea name="remark" value="${g.remark}" class="form-control nu" placeholder="说明"></textarea>
        </div>
    </form>
</div>



