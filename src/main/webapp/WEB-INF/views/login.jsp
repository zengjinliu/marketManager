<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>后台登录</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <style>
        body {
            height: 100%;
            background: #16a085;
            overflow: hidden;
        }

        canvas {
            z-index: -1;
            position: absolute;
        }
    </style>
    <script src="js/jquery.js"></script>
    <script src="js/verificationNumbers.js"></script>
    <script src="js/Particleground.js"></script>
    <script>
        $(document).ready(function () {


            //粒子背景特效
            $('body').particleground({
                dotColor: '#5cbdaa',
                lineColor: '#5cbdaa'
            });
            //验证码
            createCode();
            // //测试提交，对接程序删除即可
            $(".submit_btn").click(function () {
                if (validate()) {
                    location.href = "index.html";
                } else if (!validate()) {
                    return false;
                }

            });
        });
    </script>

</head>
<body>
<form action="login" method="post">
    <dl class="admin_login">
        <dt>
            <strong>超市账单管理系统</strong>
            <em>Supermarket Bill Management System</em>
        </dt>
        <dd class="user_icon">
            <input id="name" type="text" name="username" placeholder="用户名" class="login_txtbx"/>
            <span id="tip" style="color: red"></span>
        </dd>
        <dd class="pwd_icon">
            <input id="pwd" type="password" name="password" placeholder="密码" class="login_txtbx"/>
        </dd>
        <dd class="val_icon">
            <div class="checkcode">
                <input type="text" id="J_codetext" name="vCode" placeholder="验证码" maxlength="4" class="login_txtbx">
                <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
            </div>
            <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
        </dd>
        <dd>
            <input type="submit" value="立即登陆" class="submit_btn"/>
        </dd>
        <dd>
            <p>© 2015-2018 LX 版权所有</p>
            <p>LX-20180224-1</p>
        </dd>
    </dl>
</form>

</body>
</html>
