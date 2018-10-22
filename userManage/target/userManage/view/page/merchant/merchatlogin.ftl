<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">
    <title>商家账号登录</title>

    <!--<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">-->
    <!--<script src="js/jquery-1.9.1.min.js" type="application/javascript"></script>-->
    <!--<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>-->
  <link rel="stylesheet" href="/view/css/login.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>用户登录</h1>
<div class="input-group centers" style="width: 80%">
    <form class="form-horizontal" id="loginForm" role="form">
        <div class="input-group tops" >
            <span class="input-group-addon">账号</span>
            <input type="text" name="userName" id="userName" class="form-control" placeholder="账号">
        </div>

        <div class="input-group tops">
            <span class="input-group-addon">密码</span>
            <input type="password" name="password" id="password" class="form-control" placeholder="密码">
        </div>



        <div class="form-group tops">
            <div class=" col-sm-10" >
                <button type="button" id="loginbtn" class="btn btn-default submitBtn">登录</button>
            </div>
        </div>

        <div class="alert alert-danger" id="sbai">
            <a href="#" class="alert-link">失败</a>
        </div>

        <div class="input-group sty-a" style="width: 100%">
            <a href="/merchant/getoRetister">我要注册</a><nbsp>  <a>忘记密码</a>
        </div>




    </form>
</div>

</body>

<script>
    $(document).ready(function(){
        $("#loginbtn").click(function () {
            var userName=$("#userName").val();
            var password=$("#password").val();
            if(userName.length<1){
                $("#sbai").css("display","block");
                $("#sbai a").html("请输入账号");
                return;
            }else if(password.length<1){
                $("#sbai").css("display","block");
                $("#sbai a").html("请输入密码");
            }else {
                $.ajax({
                    async:false,
                    type:"POST",
                    url:"/merchant/login",
                    data:$("#loginForm").serialize(),
                    success:function (res) {
                        if(res.success=="true"){
                            window.location.href="/merchant/gotoUserInfo";
                        }else {
                            $("#sbai").css("display","block");
                            $("#sbai a").html(res.msg);
                        }
                    }
                });
            }

        });


    });
</script>
</html>