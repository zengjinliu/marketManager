<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 13:00
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
    <script>

        (function($){
            $(window).load(function(){

                $("a[rel='load-content']").click(function(e){
                    e.preventDefault();
                    var url=$(this).attr("href");
                    $.get(url,function(data){
                        $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                        //scroll-to appended content
                        $(".content").mCustomScrollbar("scrollTo","h2:last");
                    });
                });

                $(".content").delegate("a[href='top']","click",function(e){
                    e.preventDefault();
                    $(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
                });

            });
        })(jQuery);
    </script>
    <script>
        function findLikeBill() {

            var word = $("input[name='word']").val();
            var payStatus = $("#pay option:selected").text();
            if (word == '') {
                window.location.href = "findLikeByPayStatus?payStatus="+payStatus;
            } else {
                window.location.href = "findLikeBill?word=" + word+"&&"+"payStatus="+payStatus;
            }
        }
    </script>
</head>
<body>
<%@include file="../commons/public.jsp"%>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">账单列表</h2>
            <a href="exportExcelBill" class="fr top_rt_btn add_icon">导出数据</a>
            <a href="goAddBill" class="fr top_rt_btn add_icon">添加数据</a>
        </div>
        <section class="mtb">
            <label>商品名称：</label>
            <input type="text" name="word" class="textbox textbox_225" placeholder="输入商品名称关键词"/>
            <label>是否付款：</label>
            <select id="pay">
                <option>是</option>
                <option>否</option>
            </select>
            <input type="button" value="查询" onclick="return findLikeBill()" class="group_btn"/>
        </section>
        <table class="table">
            <tr>
                <th>账单编号</th>
                <th>商品名称</th>
                <th>商品数量</th>
                <th>交易金额</th>
                <th>是否付款</th>
                <th>交易单位</th>
                <th>供应商名称</th>
                <th>商品描述</th>
                <th>账单时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${billList}" var="bills">
                <tr>
                    <td class="center"><a href="#">${bills.billId}</a></td>
                    <td>${bills.productName}</td>
                    <td class="center">${bills.productAmount}</td>
                    <td class="center"><strong class="rmb_icon">${bills.dealPrice}</strong></td>
                    <td class="center"><c:if test="${bills.payStatus==0}">否</c:if><c:if test="${bills.payStatus==1}">是</c:if></td>
                    <td class="center">${bills.dealUnit}</td>
                    <td class="center">${bills.supplier.supName}</td>
                    <td class="center">${bills.productDescription}</td>
                    <td class="center">${bills.creatTime}</td>
                    <td class="center">
                        <a href="preLookBill?billId=${bills.billId}" title="预览" class="link_icon" target="_blank">&#118;</a>
                        <a href="editBill?billId=${bills.billId}" title="编辑" class="link_icon">&#101;</a>
                        <a href="delBill?billId=${bills.billId}" title="删除" class="link_icon">&#100;</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <aside class="paging">
            <a href="${path}/billList?pageNum=1">第一页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="${path}/billList?pageNum=${pageInfo.pageNum-1}">${pageInfo.pageNum-1}</a>
            </c:if>
            <c:forEach var="page" items="${pageInfo.navigatepageNums}">
                <c:if test="${page==pageInfo.pageNum}">
                    <a href="${path}/billList?pageNum=${page}">${page}</a>
                </c:if>
                <c:if test="${pageInfo.navigatepageNums}>2">
                    <a>...</a>
                </c:if>
            </c:forEach>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="${path}/billList?pageNum=${pageInfo.pageNum+1}">${pageInfo.pageNum+1}</a>
            </c:if>
            <a href="${path}/billList?pageNum=${pageInfo.pages}">最后一页</a>
        </aside>
    </div>
</section>
</body>
</html>
