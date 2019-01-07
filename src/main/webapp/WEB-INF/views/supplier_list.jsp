<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("path", request.getContextPath());%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台管理系统</title>
    <meta name="author" content="DeathGhost" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/sup.js"></script>
    <script>
        function findLikeSup() {
            var supname = $("input[name='supname']").val();
            var supdesc = $("input[name='supdesc']").val();
            if (supname==''&&supdesc==''){
                return false;
            }else if (supname!='') {
                window.location.href = "findLikeSupplier?supname="+supname;
            }else if (supdesc!='') {
                window.location.href = "findLikeSuppliers?supdesc="+supdesc;
            }
        }
    </script>
</head>
<body>
<%@include file="../commons/public.jsp"%>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">供应商列表</h2>
            <a href="exportExcel" class="fr top_rt_btn add_icon">导出数据</a>
            <a href="goaddSup" class="fr top_rt_btn add_icon">添加数据</a>
        </div>
        <section class="mtb">
            <label>供应商名称：</label>
            <input type="text" name="supname"  class="textbox textbox_225" placeholder="输入供应商名称关键词"/>
            <label>供应商描述：</label>
            <input type="text" name="supdesc"  class="textbox textbox_225" placeholder="输入供应商描述关键词"/>
            <input type="button" value="查询" onclick="return findLikeSup()" class="group_btn"/>
        </section>
        <table class="table">
            <tr>
                <th>编号</th>
                <th>供应商名称</th>
                <th>供应商描述</th>
                <th>联系人</th>
                <th>电话</th>
                <th>传真</th>
                <th>地址</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${supplierList}" var="sups">
                <tr>
                    <td class="center"><a href="#">${sups.supId}</a></td>
                    <td>${sups.supName}</td>
                    <td class="center">${sups.supDescription}</td>
                    <td class="center">${sups.supContact}</td>
                    <td class="center">${sups.supPhone}</td>
                    <td class="center">${sups.supFax}</td>
                    <td class="center">${sups.supAddress}</td>
                    <td class="center">
                        <a href="prevLook?id=${sups.supId}" title="预览" class="link_icon" target="_blank">&#118;</a>
                        <a href="editSup?id=${sups.supId}" title="编辑" class="link_icon">&#101;</a>
                        <shiro:hasRole name="admin">
                            <a href="delSup?id=${sups.supId}" title="删除" class="link_icon">&#100;</a>
                        </shiro:hasRole>
                    </td>
                </tr>
            </c:forEach>


        </table>

        <%--分页--%>
        <aside class="paging">
            <a href="${path}/supplierList?pageNum=1">第一页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="${path}/supplierList?pageNum=${pageInfo.pageNum-1}">${pageInfo.pageNum-1}</a>
            </c:if>
            <c:forEach var="page" items="${pageInfo.navigatepageNums}">
                <c:if test="${page==pageInfo.pageNum}">
                    <a href="${path}/supplierList?pageNum=${page}">${page}</a>
                </c:if>
                <c:if test="${pageInfo.navigatepageNums}>2">
                    <a>...</a>
                </c:if>
            </c:forEach>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="${path}/supplierList?pageNum=${pageInfo.pageNum+1}">${pageInfo.pageNum+1}</a>
            </c:if>
            <a href="${path}/supplierList?pageNum=${pageInfo.pages}">最后一页</a>
        </aside>
    </div>
</section>
</body>
</html>
