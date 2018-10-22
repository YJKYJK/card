
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">
    <title>商品管理</title>


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
<h1>商品管理</h1>

<table id="tb_class" class="table-responsive">
    <div id="toolbar">
        <button class="btn btn-primary" id="add">增加</button>
        <button class="btn btn-info" id="modify">修改</button>
        <button class="btn btn-warning" id="remove">删除</button>
    </div>
    <thead>
    <tr>


    </tr>
    </thead>
</table>
</body>
</html>


</body>



<script>




        $('#tb_class').bootstrapTable({
            url: '/commodity/queryByUser',         //请求后台的URL（*）
                                //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            singleSelect : true,
            queryParamsType:'limit',
            queryParams:queryParams,        //请求服务器时所传的参数
            showColumns   : false,
            // queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
             pageNumber:1,                             //初始化加载第一页，默认第一页
            pageSize: 6,                       //每页的记录行数（*）
            pageList: [6],  //每页的记录行数（*）
          // clickToSelect: true,
            columns: [{
               field:"checked",
                checkbox:true
            },
                {
                field: 'commodityId',
                title: '',
                visible: false
                },
                {
                    field: 'remark',
                    title: '',
                    visible: false
                },
                {
                    field: 'classId',
                    title: '',
                    visible: false
                },
                {
                    field: 'commodityName',
                    title: '名称',
                    visible: true
                },
                {
                    field: 'price',
                    title: '价格',
                    visible: true
                },
                {
                    field: 'className',
                    title: '类别',
                    visible: true
                },
                {
                    field: 'num',
                    title: '数量',
                    visible: true
                },
                {
                    field: 'createTm',
                    title: '添加时间',
                    visible: true
                }]

        });


        //请求服务数据时所传参数
        function queryParams(params){
            return {
                pageSize : params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
                pageNumber : params.offset/params.limit+1, //当前页面,默认是上面设置的1(pageNumber)
            }
        }


        /**
         * 添加
         */
        $('#add').click(function () {
            $.dialogView("商品添加","/commodity/gotoadd","",
                    "确定","取消","/commodity/saveCommdityInfo","lForm",function (res) {
                if(res.success=="true"){
                    $.dialogTitle("成功提示","添加成功","确定");
                    $("#tb_class").bootstrapTable('refresh', {url:"/commodity/queryByUser"});

                }else {
                    $.dialogTitle("失败提示",res.msg,"确定");
                }
                    });
        });


        /**
         * 修改商品
         */

        $("#modify").click(function () {
            var a= $("#tb_class").bootstrapTable('getSelections');
            if(a.length<1){
                $.dialogTitle("提示","请选择一条要修改的数据","确定");
            }
            var commodityId=a[0].commodityId;
            var commodityName=a[0].commodityName;
            var price=a[0].price;
            var pic=a[0].pic;
            var remark=a[0].remark;

            var data="?commodityId="+commodityId+"&remark="+remark+"&commodityName="+commodityName+
            "&price="+price+"&pic="+pic;

            $.dialogView("商品类别修改","/commodity/gotoModify",data,
                    "确定","取消","/commodity/modifyCommodity","modifyCommodity",function (res) {

                        if(res.success=="true"){
                            $.dialogTitle("成功提示","修改成功","确定");
                            $("#tb_class").bootstrapTable('refresh', {url:"/commodity/queryByUser"});

                        }else {
                            $.dialogTitle("失败提示",res.msg,"确定");
                        }


                    });
        });


$("#remove").click(function () {
    var a= $("#tb_class").bootstrapTable('getSelections');
    if(a.length<1){
        $.dialogTitle("提示","请选择一条要修改的数据","确定");
    }
    var commodityId=a[0].commodityId;

    var params={
        commodityId:commodityId
    }

    $.dialogConfirm("删除提示","是否确定删除?","确定删除","取消",function (res) {
        if(res){
            $.ajax({async:false, type:"POST", url:"/commodity/removeCommodity",
                data:params,
                success:function (res) {
                    if(res.success=="true"){
                        $.dialogTitle("成功提示","删除成功","确定");
                        $("#tb_class").bootstrapTable('refresh', {url:"/commodity/queryByUser"});

                    }else {
                        $.dialogTitle("失败提示",res.msg,"确定");
                    }

                }
            })
        }
    });



});



</script>
</html>
