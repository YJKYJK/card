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

<button class="btn btn-primary" id="add">增加</button>
<button class="btn btn-info" id="modify">修改</button>
<button class="btn btn-warning" id="remove">删除</button>
</body>
<script>
$("#add").on("click",function () {
    debugger
    $.dialogView("卡密添加","/kami/gotoAddKami","","添加卡密",
            "关闭","/kami/addKami","addKami",function (res) {
               alert(res);
            })

});


</script>
</html>
