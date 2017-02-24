<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/echart/echarts.min.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="convertCanvasToImage();">img</button>
<div id="main" style="width: 600px;height:400px;"></div>
图片
<img src="/static/image/loading.gif" id="uuid"/>

<form action="/search/toExportDocx" id="fileUp" method="post" enctype="multipart/form-data">
    <input type="file" name="image"/>
    <input type="submit" value="submit"/>
</form>
</body>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    //Converts canvas to an image
    function convertCanvasToImage() {
       // var canvas = $("canvas");
        //debugger;
        var canvas = $("#main").find("canvas")[0];
        var image = new Image();
        image.src = canvas.toDataURL("image/png");
        $("#uuid").attr("src",$("#main").find("canvas")[0].toDataURL("image/png"));
        //return image;
        //location.href = "${pageContext.request.contextPath }/search/toExportDocx?image="+$("#main").find("canvas")[0].toDataURL("image/png");
        $("input[name='image']").attr("value",$("#main").find("canvas")[0].toDataURL("image/png"));
        $("#fileUp").submit();
    }
</script>
</html>
