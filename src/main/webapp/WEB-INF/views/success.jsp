<%@ page import="java.text.SimpleDateFormat" %><%--
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
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style>
        .dataStatistic {
            width: 400px;
            height: 200px;
            border: 1px solid #ccc;
            margin: 0 auto;
            margin: 10px;
            overflow: hidden
        }

        #cylindrical {
            width: 400px;
            height: 200px;
            margin-top: -15px
        }

        #line {
            width: 400px;
            height: 200px;
            margin-top: -15px
        }

        #pie {
            width: 400px;
            height: 200px;
            margin-top: -15px
        }
    </style>
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script>

        (function ($) {
            $(window).load(function () {

                $("a[rel='load-content']").click(function (e) {
                    e.preventDefault();
                    var url = $(this).attr("href");
                    $.get(url, function (data) {
                        $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                        //scroll-to appended content
                        $(".content").mCustomScrollbar("scrollTo", "h2:last");
                    });
                });

                $(".content").delegate("a[href='top']", "click", function (e) {
                    e.preventDefault();
                    $(".content").mCustomScrollbar("scrollTo", $(this).attr("href"));
                });

            });
        })(jQuery);
    </script>
</head>
<body>
<%@include file="../commons/public.jsp" %>
<section class="rt_wrap content mCustomScrollbar">

    <div class="rt_content">
        <h1 style="color:red;font-size:20px;font-weight:bold;text-align:center;">欢迎访问账单管理系统</h1>
        <!--统计图-->
        <section style="overflow:hidden">
            <!--柱状图-->
            <div class="dataStatistic fl">
                <div id="cylindrical">
                </div>
            </div>
            <!--线性图-->
            <div class="dataStatistic fl">
                <div id="line">
                </div>
            </div>
            <!--饼状图-->
            <div class="dataStatistic fl">
                <div id="pie">
                </div>
            </div>
        </section>
        <!--点击加载-->
        <script>
            $(document).ready(function () {
                $("#loading").click(function () {
                    $(".loading_area").fadeIn();
                    $(".loading_area").fadeOut(1500);
                });
            });
        </script>
        <section class="loading_area">
            <div class="loading_cont">
                <div class="loading_icon"><i></i><i></i><i></i><i></i><i></i></div>
                <div class="loading_txt">
                    <mark>数据正在加载，请稍后！</mark>
                </div>
            </div>
        </section>
        <!--结束加载-->
        <!--弹出框效果-->
        <script>
            $(document).ready(function () {
                //弹出文本性提示框
                $("#showPopTxt").click(function () {
                    $(".pop_bg").fadeIn();
                });
                //弹出：确认按钮
                $(".trueBtn").click(function () {
                    alert("你点击了确认！");//测试
                    $(".pop_bg").fadeOut();
                });
                //弹出：取消或关闭按钮
                $(".falseBtn").click(function () {
                    alert("你点击了取消/关闭！");//测试
                    $(".pop_bg").fadeOut();
                });
            });
        </script>
        <!--结束：以下内容则可删除，仅为素材引用参考-->
    </div>
</section>
<script src="js/amcharts.js" type="text/javascript"></script>
<script src="js/serial.js" type="text/javascript"></script>
<script src="js/pie.js" type="text/javascript"></script>
<script type="text/javascript">
    //柱形图数据
    var json = [];
    //折线图数据
    var lineData = [];
    //饼状图数据
    var pieData = [];
    $(document).ready(function (e) {
        //获取柱状图的方法
        getBillJson();
        //获取折线图的方法
        getLineData();
        //获取饼状图数据
        getPieData();
        //获取
        GetSerialChart();
        MakeChart(pieData);
    });

    //柱状图数据
    function getBillJson() {
        $.ajax({
            url: "${path}/getJson",
            type: "post",
            dataType: "json",
            async: false,
            success: function (result) {
                if (result.code == 0) {
                    var bills = result.data;
                    for (var i = 0; i < bills.length; i++) {
                        var creatTime = bills[i].creatTime;
                        var dealPrice = bills[i].dealPrice;
                        var row = {};
                        //将时间格式化
                        var oldTime = fmtDate(creatTime);
                        row.name = oldTime;
                        row.value = dealPrice;
                        json.push(row);
                    }
                }
            },
            error: function () {
            }
        })
    }

    //折线图数据
    function getLineData() {
        $.ajax({
            url: "${path}/getLineJson",
            type: "post",
            dataType: "json",
            async: false,
            success: function (result) {
                if (result.code == 0) {
                    var bills = result.data;
                    for (var i = 0; i < bills.length; i++) {
                        var creatTime = bills[i].creatTime;
                        var billId = bills[i].billId;
                        var col = {};
                        //将时间格式化
                        var oldTime = fmtDate(creatTime);
                        col.day = oldTime;
                        col.lineVal = billId;
                        lineData.push(col);
                    }
                }
            },
            error: function () {
                alert("查询数据失败");
            }
        });

    }

    //获取饼状图数据
    function getPieData() {
        $.ajax({
            url: "${path}/getPieData",
            type: "post",
            dataType: "json",
            async: false,
            success: function (result) {
                if (result.code == 0) {
                    var pies = result.data;
                    for (var i = 0; i < pies.length; i++) {
                        var creatTime = pies[i].creatTime;
                        var supId = pies[i].supId;
                        var fmtTime = fmtDate(creatTime);
                        var pie = {};
                        pie.row = fmtTime;
                        pie.col = supId;
                        pieData.push(pie);
                    }
                }
            },
            error: function () {
                alert("查询失败");
            }
        });

    }

    //柱状图
    function GetSerialChart() {

        chart = new AmCharts.AmSerialChart();
        chart.dataProvider = json;
        //json数据的key
        chart.categoryField = "name";
        //不选择
        chart.rotate = false;
        //值越大柱状图面积越大
        chart.depth3D = 20;
        //柱子旋转角度角度
        chart.angle = 30;
        var mCtCategoryAxis = chart.categoryAxis;
        mCtCategoryAxis.axisColor = "#efefef";
        //背景颜色透明度
        mCtCategoryAxis.fillAlpha = 0.5;
        //背景边框线透明度
        mCtCategoryAxis.gridAlpha = 0;
        mCtCategoryAxis.fillColor = "#efefef";
        var valueAxis = new AmCharts.ValueAxis();
        //左边刻度线颜色
        valueAxis.axisColor = "#ccc";
        //标题
        valueAxis.title = "3D柱状图Demo";
        //刻度线透明度
        valueAxis.gridAlpha = 0.2;
        chart.addValueAxis(valueAxis);
        var graph = new AmCharts.AmGraph();
        graph.title = "value";
        graph.valueField = "value";
        graph.type = "column";
        //鼠标移入提示信息
        graph.balloonText = "时间:金额[[category]] [[value]]";
        //边框透明度
        graph.lineAlpha = 0.3;
        //填充颜色
        graph.fillColors = "#b9121b";
        graph.fillAlphas = 1;

        chart.addGraph(graph);

        // CURSOR
        var chartCursor = new AmCharts.ChartCursor();
        chartCursor.cursorAlpha = 0;
        chartCursor.zoomable = false;
        chartCursor.categoryBalloonEnabled = false;
        chart.addChartCursor(chartCursor);

        chart.creditsPosition = "top-right";

        //显示在Main div中
        chart.write("cylindrical");
    }

    //折线图
    AmCharts.ready(function () {
        var chart = new AmCharts.AmSerialChart();
        chart.dataProvider = lineData;
        chart.categoryField = "day";
        chart.angle = 30;
        chart.depth3D = 20;
        //标题
        chart.addTitle("每日交易账单数", 15);
        var graph = new AmCharts.AmGraph();
        chart.addGraph(graph);
        graph.valueField = "lineVal";
        //背景颜色透明度
        graph.fillAlphas = 0.3;
        //类型
        graph.type = "line";
        //圆角
        graph.bullet = "round";
        //线颜色
        graph.lineColor = "#8e3e1f";
        //提示信息
        graph.balloonText = "[[day]]: [[lineVal]]";
        var categoryAxis = chart.categoryAxis;
        categoryAxis.autoGridCount = false;
        categoryAxis.gridCount = json.length;
        categoryAxis.gridPosition = "start";
        chart.write("line");
    });

    //饼图根据json数据生成饼状图，并将饼状图显示到div中
    function MakeChart(value) {
        chartData = eval(value);
        //饼状图
        chart = new AmCharts.AmPieChart();
        chart.dataProvider = chartData;
        //标题
        chart.addTitle("每月供应商数", 15);
        //标题数据
        chart.titleField = "row";
        //值数据
        chart.valueField = "col";
        //边框线颜色
        chart.outlineColor = "#fff";
        //边框线的透明度
        chart.outlineAlpha = .8;
        //边框线的狂宽度
        chart.outlineThickness = 1;
        chart.depth3D = 20;
        chart.angle = 30;
        chart.write("pie");
    }
</script>
<script>
    function fmtDate(obj) {
        var date = new Date(obj);
        var y = 1900 + date.getYear();
        var m = "0" + (date.getMonth() + 1);
        var d = "0" + date.getDate();
        return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length);
    }
</script>
</body>
</html>
