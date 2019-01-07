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
    <script src="js/user_list.js"></script>

</head>
<body>
<%@include file="../commons/public.jsp" %>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">用户列表</h2>
            <a href="userDetail" class="fr top_rt_btn add_icon">添加数据</a>
        </div>
        <section class="mtb">
            <label>用户名称：</label>
            <input type="text" name="keyWord" class="textbox textbox_225" placeholder="输入用户关键词"/>
            <input type="button" name="search" onclick="return commitMsg();" value="查询" class="group_btn"/>
        </section>
        <table class="table">
            <tr>
                <th>编号</th>
                <th>用户名称</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>地址</th>
                <th>权限</th>
                <th>操作</th>
            </tr>
            <c:forEach var="users" items="${userList}">
                <tr>
                    <td class="center"><a href="#">${users.userId}</a></td>
                    <td>${users.username}</td>
                    <td class="center"><c:if test="${users.sex==0}">女</c:if><c:if test="${users.sex==1}">男</c:if></td>
                    <td class="center">${users.age}</td>
                    <td class="center">${users.userPhone}</td>
                    <td class="center">${users.userAddress}</td>
                    <td class="center"><c:if test="${users.userRight==0}">普通员工</c:if><c:if
                            test="${users.userRight==1}">经理</c:if></td>
                    <td class="center">
                        <a href="preLook?userId=${users.userId}" title="预览" class="link_icon" target="_blank">&#118;</a>
                        <a href="edit?username=${users.username}" title="编辑" class="link_icon">&#101;</a>
                        <shiro:hasRole name="admin">
                            <a href="deleteOne?username=${users.username}" title="删除" class="link_icon">&#100;</a>
                        </shiro:hasRole>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <aside class="paging">
            <a href="${path}/users?pageNum=1">第一页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="${path}/users?pageNum=${pageInfo.pageNum-1}">${pageInfo.pageNum-1}</a>
            </c:if>
            <c:forEach var="page" items="${pageInfo.navigatepageNums}">
                <c:if test="${page==pageInfo.pageNum}">
                    <a href="${path}/users?pageNum=${page}">${page}</a>
                </c:if>
                <c:if test="${pageInfo.navigatepageNums}>2">
                    <a>...</a>
                </c:if>
            </c:forEach>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="${path}/users?pageNum=${pageInfo.pageNum+1}">${pageInfo.pageNum+1}</a>
            </c:if>
            <a href="${path}/users?pageNum=${pageInfo.pages}">最后一页</a>
        </aside>
    </div>
</section>
</body>
</html>
