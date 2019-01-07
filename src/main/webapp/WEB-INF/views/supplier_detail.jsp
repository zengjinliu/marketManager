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
    <script src="js/supdetail.js"></script>
    <script src="js/judge.js"></script>
    <script src="js/judgeForm.js"></script>
    <script>
        $(function () {
            $("#a").submit(function () {
                if(${edit==1}){
                    var uri = "${path}/update";
                    $("#a").attr("action",uri).submit();
                }
            })
            if(${previous==2}){
                $("#lastLi").hide();
            }
        })
    </script>
</head>
<body>

<%@include file="../commons/public.jsp"%>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">供应商详情</h2>
            <a class="fr top_rt_btn" href="supplierList">返回供应商列表</a>
        </div>
        <form id="a" action="addSup" method="post">
            <section>
                <ul class="ulColumn2">
                    <li>
                        <span class="item_name" style="width:120px;">供应商编号：</span>
                        <input value="${supplier.supId}" name="supId" type="text" class="textbox textbox_295" placeholder="供应商编号..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">供应商名称：</span>
                        <input value="${supplier.supName}" name="supName" type="text" class="textbox" placeholder="供应商名称..."/>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">供应商描述：</span>
                        <textarea name="supDescription" type="text" class="textbox" placeholder="供应商描述...">${supplier.supDescription}</textarea>
                        <span class="errorTips"></span>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">供应商联系：</span>
                        <input value="${supplier.supContact}" name="supContact" type="text" class="textbox" placeholder="供应商联系..."/>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">供应商电话：</span>
                        <input value="${supplier.supPhone}"  name="supPhone" type="text" class="textbox" placeholder="供应商电话..."/>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">供应商传真：</span>
                        <input value="${supplier.supFax}" name="supFax" type="text" class="textbox" placeholder="供应商传真..."/>
                    </li>
                    <li>
                        <span class="item_name" style="width:120px;">供应商地址：</span>
                        <input value="${supplier.supAddress}"  name="supAddress" type="text" class="textbox" placeholder="供应商地址..."/>
                    </li>
                    <li id="lastLi">
                        <span class="item_name" style="width:120px;"></span>
                        <input type="submit" class="link_btn" onclick="return judge()"/>
                    </li>
                </ul>
            </section>
        </form>
    </div>
</section>
<script src="js/ueditor.config.js"></script>
<script src="js/ueditor.all.min.js"> </script>
</body>
</html>
