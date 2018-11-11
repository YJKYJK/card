<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">
    <title>${m.userName}:卡密管理</title>


    <link href="/view/css/shop.css" rel="stylesheet">
    <link href="/view/css/login.css" rel="stylesheet">
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
    <script src="/view/js/dialog.js"></script>
</head>
<body>
<h2 class="centers">卡密管理</h2>

<div id="toolbar">
    <button class="btn btn-primary" id="add">增加</button>
    <button class="btn btn-info" id="modify">修改</button>
    <button class="btn btn-warning" id="remove">删除</button>

    <div>
        <form>
            <div class="input-group tops" >
                <span class="input-group-addon">商品</span>
                <select name="commodityId" id="commodityId" class="form-control">
                    <option value="">全部</option>
                </select>
                <span class="input-group-addon">是否出售</span>
                <select name="isSell" id="isSell" class="form-control">
                    <option value="">全部</option>
                    <option value="Y">是</option>
                    <option value="N">否</option>
                </select>
            </div>


        </form>
    </div>
    <button class="btn btn-info" id="seach">查询</button>
</div>



<table id="tb_kami" class="table table-striped">

    <thead>
    <tr>


    </tr>
    </thead>
</table>

</body>
<script>

$('#tb_kami').bootstrapTable({
    url: '/kami/queryKami',         //请求后台的URL（*）
    //请求方式（*）
    toolbar: '#toolbar',                //工具按钮用哪个容器
    striped: true,                      //是否显示行间隔色
    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    pagination: true,                   //是否显示分页（*）
    sortable: false,                     //是否启用排序
    sortOrder: "asc",                   //排序方式
    singleSelect : true,
    queryParamsType:'limit',
    //请求服务器时所传的参数
    showColumns   : false,
    queryParams: queryParams,//传递参数（*）
    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
    pageNumber:1,                             //初始化加载第一页，默认第一页
    pageSize: 6,                       //每页的记录行数（*）
    pageList: [6],  //每页的记录行数（*）
    // clickToSelect: true,
    columns: [{
        field:"checked",
        checkbox:true
    }, {
        field: 'commodityId',
        title: '商品ID',
        visible: false},
        {
            field: 'cardId',
            title: 'ID',
            visible: false},
        {
            field: 'commodityName',
            title: '名称',
            visible: true},
        {
            field: 'cardNumber',
            title: '卡号',
            visible: true},
        {
            field: 'isSell',
            title: '是否出售',
            visible: true}]

});


//请求服务数据时所传参数
function queryParams(params){
    return {
        pageSize : params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        pageNumber : params.offset/params.limit+1, //当前页面,默认是上面设置的1(pageNumber)
        commodityId:$('#commodityId').val(),
        isSell:$('#isSell').val()
    }
}


    $("#add").click(function () {


        $.dialogView("卡密添加", "/kami/gotoAddKami", "", "添加卡密",
                "关闭", "/kami/addKami", "addKami", function (res) {
            if(res>0){
                $.dialogTitle("添加成功","本次添加"+res+"条卡密","知道了");
                $("#tb_kami").bootstrapTable('refresh', {url:"/kami/queryKami"});
            }else {
                $.dialogTitle("添加失败","添加卡密失败,请检查卡密格式或者商品类型","知道了");
            }

                });
    });



//获取该商家所有商品
getShop();
function getShop() {
    $.ajax({
        async: false,
        type: "get",
        url: "/shop/getCommodityByUserId",
        success: function (res) {
            var se = $("#commodityId");

            $.each(res, function (i, value) {
                var opt = $("<option value=" + value.commodityId + ">" + value.commodityName + "</option>");
                se.append(opt);
            });
        }
    });

}
//搜索
$('#seach').on("click",function () {
    $("#tb_kami").bootstrapTable('refresh', {url:"/kami/queryKami"});
});


//删除卡密
$("#remove").click(function () {
    var a= $("#tb_kami").bootstrapTable('getSelections');
    if(a.length<1){
        $.dialogTitle("提示","请选择一条要修改的数据","确定");
        return;
    }
    var cardId=a[0].cardId;

    var params={
        cardId:cardId
    }

    $.dialogConfirm("删除提示","是否确定删除?","确定删除","取消",function (res) {
        if(res){
            $.ajax({async:false, type:"POST", url:"/kami/deleteKami",
                data:params,
                success:function (res) {
                    if(res.success=="true"){
                        $.dialogTitle("成功提示","删除成功","确定");
                        $("#tb_kami").bootstrapTable('refresh', {url:"/kami/queryKami"});

                    }else {
                        $.dialogTitle("失败提示",res.msg,"确定");
                    }

                }
            })
        }
    });



});


/**
 * 修改卡密
 */
$("#modify").on("click",function () {
    var a= $("#tb_kami").bootstrapTable('getSelections');
    if(a.length<1){
        $.dialogTitle("提示","请选择一条要修改的数据","确定");
    }else {

        var cardId=a[0].cardId;
        var data="?cardId="+cardId;


        $.dialogView("卡密修改","/kami/gotoModifyKami",data,
                "确定","取消","/kami/modifyKami","modifyKami",function (res) {

                    if(res.success=="true"){
                        $.dialogTitle("成功提示","修改成功","确定");
                        $("#tb_kami").bootstrapTable('refresh', {url:"/kami/queryKami"});

                    }else {
                        $.dialogTitle("失败提示",res.msg,"确定");
                    }


                });

    }

});

</script>
</html>
