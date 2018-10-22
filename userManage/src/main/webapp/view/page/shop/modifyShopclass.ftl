
<div class="input-group centers" style="width: 80%">
    <form class="form-horizontal" id="modifyGoodsClass"   role="form" method="post">
        <input hidden name="classId" value="${g.classId}">
        <div class="input-group tops" >
            <span class="input-group-addon">名称</span>
            <input type="text" name="className" value="${g.className}"  id="userName" class="form-control nu"
                   placeholder="名称">
        </div>
        <span class="ss" id="userExist" style="color: red">该用户名以存在</span>

        <div class="input-group tops">
            <span class="input-group-addon">说明</span>
            <input type="text" name="remark" value="${g.remark}" class="form-control nu" placeholder="说明">
        </div>
    </form>
</div>



