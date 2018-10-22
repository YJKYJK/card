<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=decice-width,inital-scale=2,maximum-scale=1,minimum-scale=1,minimum-scale=1,user-scalable=no">
    <title>注册</title>

    <link rel="stylesheet" href="/view/css/login.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/view/css/other.css">
</head>
<body>

<h1>用户注册</h1>
<div class="input-group centers" style="width: 80%">
    <form class="form-horizontal" id="form"   role="form" method="post">
        <div class="input-group tops" >
            <span class="input-group-addon">用户名</span>
            <input type="text" name="userName" id="userName" class="form-control nu"
                   placeholder="用户名">
        </div>
        <span class="ss" id="userExist" style="color: red">该用户名以存在</span>

        <div class="input-group tops">
            <span class="input-group-addon">密码</span>
            <input type="password" name="password" class="form-control nu" placeholder="密码">
        </div>


        <div class="input-group tops">
            <span class="input-group-addon">QQ</span>
            <input type="text" name="qq" class="form-control nu" placeholder="手机号">
        </div>

        <div class="input-group tops">
            <span class="input-group-addon">手机号</span>
            <input type="text" name="phone" class="form-control nu" placeholder="手机号" >
        </div>

        <div class="form-group tops">
            <div class=" col-sm-10" >
                <button type="button" id="retister" class="btn btn-default submitBtn">注册</button>
            </div>
        </div>

        <div class="alert alert-danger" id="danger">
            <a href="#" class="alert-link">请完全输入。</a>
        </div>

        <div class="alert alert-success" id="success">
            <a href="#" class="alert-link">恭喜你,注册成功。</a>
        </div>

        <div class="alert alert-danger" id="sbai">
            <a href="#" class="alert-link">注册失败,请重新注册。</a>
        </div>



        <div class="input-group sty-a" style="width: 100%">
            <a href="login.loginftl">返回登录</a><nbsp>
        </div>
    </form>
</div>
<input hidden id="tj">

</body>



<script>
    $(document).ready(function(){

        $("#retister").on("click",function () {
            var isY=true;
            $(".nu").each(function () {
               var s=$(this).val();
               if(s.length<1){
                   isY=false;
                   $("#danger").css("display","block");
                   $("#sbai").css("display","none");
                   $("#success").css("display","none");
               }
            });

            if(isY){
                $("#danger").css("display","none");
                $.ajax({
                    type:"post",
                    url:"/user/retister",
                    data:$("#form").serialize(),
                    success:function (res) {
                        if(res.success=='true'){
                            $("#success").css("display","block");
                            $("#sbai").css("display","none");
                        }else {
                            $("#success").css("display","none");
                            $("#sbai").css("display","block");
                        }

                    }

                });
            }
        });

        
        $("#userName").on("change",function () {
            var userName=$(this).val();
            $.ajax({
                type:"get",
                url:"/user/quryUserByName",
                data:{userName:userName},
                success:function (res) {
                    if(res){
                        $("#userExist").css("display","block");
                    }else {
                        $("#userExist").css("display","none");
                    }
                }
            });
        });








    });



</script>
</html>