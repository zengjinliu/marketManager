<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("path", request.getContextPath());%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台管理系统</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/adduser.js"></script>
    <script src="js/user_detail.js"></script>
    <script>
        $(function () {
            $("#f").submit(function () {
                if(${edit==1}){
                    var uri = "${path}/modUser";
                    $("#f").attr("action",uri).submit();
                }
            })
            if (${n==1}){
                $("#a").hide();
            }
        })
    </script>
</head>
<body>
<%@include file="../commons/public.jsp" %>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">用户详情</h2>
            <a href="users" class="fr top_rt_btn">返回用户列表</a>
        </div>
        <form id="f" action="addUser" method="post">
            <section>
                <ul class="ulColumn2" >
                    <li>
                        <span class="item_name" style="width:120px;">用户编号：</span>
                        <c:if test="${edit==1}">
                            <input value="${user.userId}" readonly="readonly" name="userId" type="text" class="textbox textbox_295" placeholder="用户编号..."/>
                            <span id="error0" class="errorTips"></span>
                        </c:if>
                        <c:if test="${edit!=1}">
                            <input value="${user.userId}"  name="userId" type="text" class="textbox textbox_295" placeholder="用户编号..."/>
                            <span id="error0" class="errorTips"></span>
                        </c:if>

                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">用户名称：</span>
                        <input value="${user.username}"  name="username" type="text" class="textbox" placeholder="用户名称..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">用户密码：</span>
                        <input value="${user.password}" name="password" type="password" class="textbox" placeholder="用户密码..."/>
                        <span class="errorTips"></span>
                    </li>

                        <li>
                            <span class="item_name" style="width:120px;">确认密码：</span>
                            <input value="${user.password}"  name="checkpwd" type="password" class="textbox" placeholder="确认密码..."/>
                            <span class="errorTips"></span>
                        </li>

                    <li>
                        <span class="item_name" style="width:120px;">用户性别：</span>
                        <select name="sex" class="select">
                            <c:if test="${user.sex==1}">
                                <option value="1" selected="selected">男</option>
                                <option value="0" ></option>
                            </c:if>
                            <c:if test="${user.sex==0}">
                                <option value="1" ></option>
                                <option value="0" selected="selected">女</option>
                            </c:if>
                            <c:if test="${empty user.sex}">
                                <option value="1" >男</option>
                                <option value="0" >女</option>
                            </c:if>


                        </select>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">用户年龄：</span>
                        <input value="${user.age}" name="age" type="text" class="textbox" placeholder="用户年龄..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">用户电话：</span>
                        <input value="${user.userPhone}" name="userPhone" type="text" class="textbox" placeholder="用户电话..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">用户地址：</span>
                        <textarea  name="userAddress" type="text" class="textbox" placeholder="用户地址...">${user.userAddress}</textarea>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">用户权限：</span>
                        <c:if test="${user.userRight==0}">

                            <input type="radio" class="textbox" checked="checked" name="userRight"/>
                            <label>普通员工</label>
                            <input type="radio" class="textbox" name="userRight"/>
                            <label>经理</label>
                        </c:if>
                        <c:if test="${user.userRight==1}">

                            <input type="radio" class="textbox" name="userRight"/>
                            <label>普通员工</label>
                            <input type="radio" class="textbox" checked="checked" name="userRight"/>
                            <label>经理</label>
                        </c:if>
                        <c:if test="${empty user.userRight}">

                            <input type="radio" class="textbox" name="userRight"/>
                            <label>普通员工</label>
                            <input type="radio" class="textbox"  name="userRight"/>
                            <label>经理</label>
                        </c:if>
                    </li>
                    <li id="a">
                        <span class="item_name" style="width:120px;"></span>
                        <input name="submit" type="submit" class="link_btn" onclick="return func()"/>
                    </li>
                </ul>
            </section>
        </form>
    </div>
</section>
<script src="js/ueditor.config.js"></script>
<script src="js/ueditor.all.min.js"></script>
</body>
</html>
