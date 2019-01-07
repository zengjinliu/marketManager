<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    $(function () {
        $(".clear_icon").click(function () {
           alert("清除缓存成功!");
        })
    })
</script>
<header>
    <h1><img src="images/admin_logo.png"/></h1>
    <ul class="rt_nav">
        <li><a href="index" target="_blank" class="website_icon">站点首页</a></li>
        <li><a href="clear" class="clear_icon">清除缓存</a></li>
        <li><a href="#" class="admin_icon"><shiro:principal></shiro:principal></a></li>
        <li><a href="editUser?username=<%=session.getAttribute("username")%>" class="set_icon">账号设置</a></li>
        <li><a href="logout" class="quit_icon">安全退出</a></li>
    </ul>
</header>
<aside class="lt_aside_nav content mCustomScrollbar">
    <h2><a href="index">起始页</a></h2>
    <ul>
        <li>
            <dl>
                <dt>账单管理</dt>
                <!--当前链接则添加class:active-->
                <dd><a href="billList" class="active">账单列表</a></dd>
                <dd><a href="billDetail">账单详情</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>供应商管理</dt>
                <dd><a href="supplierList">供应商列表</a></dd>
                <dd><a href="supplierDetail">供应商详情</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>用户管理</dt>
                <dd><a href="users">用户列表</a></dd>
                <dd><a href="userDetail">用户详情</a></dd>
            </dl>
        </li>
        <li>
            <p class="btm_infor">© LX 版权所有</p>
        </li>
    </ul>
</aside>