<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 12:57
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
    <script src="js/bill.js"></script>
    <script src="js/billCommit.js"></script>
    <script>
        $(function () {
            if (${n==1}){
                $("#c").hide();
            }
        });
    </script>
    <script>
        $(function () {
            $("#a option").each(function () {
                var val = $(this).val();
                if (${supId==val}){
                    $("#a option:eq(val)").attr("selected",true);
                }
            })
            $("#editBill").submit(function () {
                if (${change==1}){
                    var val = $("#aa").val();
                    var uri = "${path}/updateBill?supName="+val;
                    $("#editBill").attr("action",uri).submit();
                }
            })
        })
    </script>
</head>
<body>
<%@include file="../commons/public.jsp" %>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">账单详情</h2>
            <a class="fr top_rt_btn" href="billList">返回账单列表</a>
        </div>
        <form id="editBill" action="addBill" method="post">
            <section>
                <ul class="ulColumn2">
                    <li>
                        <span class="item_name" style="width:120px;">账单编号：</span>
                        <C:if test="${change==1}">
                            <input value="${bill.billId}" readonly="readonly" name="billId" type="text" class="textbox textbox_295" placeholder="账单编号..."/>
                            <span class="errorTips"></span>
                        </C:if>
                        <C:if test="${change!=1}">
                            <input value="${bill.billId}"  name="billId" type="text" class="textbox textbox_295" placeholder="账单编号..."/>
                            <span class="errorTips"></span>
                        </C:if>

                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">交易金额：</span>
                        <input value="${bill.dealPrice}"  name="dealPrice" type="text" class="textbox" placeholder="交易金额..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">交易单位：</span>
                        <input value="${bill.dealUnit}" name="dealUnit" type="text" class="textbox"placeholder="交易单位..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">交易数量：</span>
                        <input value="${bill.productAmount}" name="productAmount" type="text" class="textbox" placeholder="交易数量..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">商品名称：</span>
                        <input value="${bill.productName}" name="productName" type="text" class="textbox" placeholder="商品名称..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">商品描述：</span>
                        <textarea name="productDescription" type="text" class="textbox" placeholder="商品描述...">${bill.productDescription}</textarea>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">是否付款：</span>
                        <select  name="payStatus" class="select">
                            <c:if test="${bill.payStatus==1}">
                                <option value="1" selected="selected">是</option>
                                <option value="0">否</option>
                            </c:if>
                            <c:if test="${bill.payStatus==0}">
                                <option value="1" >是</option>
                                <option value="0" selected="selected">否</option>
                            </c:if>
                            <c:if test="${empty  bill.payStatus}">
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </c:if>
                        </select>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">所属供应商：</span>
                        <%--添加的页面--%>
                        <c:if test="${empty bill&&change!=1}">
                            <select id="a" name="supId" class="select">
                                <c:forEach items="${supplierList}" var="suppliers">
                                    <option id="${suppliers.supId}" value="${suppliers.supId}">${suppliers.supName}</option>
                                </c:forEach>
                            </select>
                        </c:if>
                        <%--预览是的页面--%>
                        <c:if test="${bill!=null}">
                        <select class="select">
                            <option id="aa" selected="selected">${supplier.supName}</option>
                        </select>
                        </c:if>
                    </li>
                    <li id="c">
                        <span class="item_name" style="width:120px;"></span>
                        <input type="submit" class="link_btn" onclick="return commitBill()"/>
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
