<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/28
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>basePath${basePath}--- hello:${pageContext.request.contextPath }
    <title>Title</title>
    <style type="text/css" href="${pageContext.request.contextPath }/static/base.css"></style>
    <style type="text/css">
        div{
            margin:5px 5px 5px 5px;
            border: 2px;
        }
        #header{
            background: seagreen;
            height: 150px;
            text-align: center;
        }
        #left{
            background: grey;
            width: 200px;
            float: left;
            height: 500px;
        }
        #right{
            background:#00B83F;
            float: right;
            height: 800px;
            width: 766px;
        }

        #page > li{
            display: inline-block;
            margin: 0 3px;
        }
        .active>a{
            color: #fff;
            border: 1px solid #02B686;
            background: #02B686;
        }
        .hide{
            display: none;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/template.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/static/js/jqPaginator.min.js" type="text/javascript"></script>
</head>
<body>
<div id="header">
    <form>
        <input name="q" id="q" type="text"/>
        <input type="button" onclick="search();" value="收索">
    </form>
    <h3>共 <span id="numFound">${map.numFound}</span> 条记录</h3>
    <h4>用时 <span id="time">${map.time}</span>秒</h4>
</div>
<div id="left">
    <c:forEach items="${map.listFact}" var="bean">
        <div name="factDesc">${bean.name}</div>
        <ul class="hide">
            <c:forEach items="${bean.values}" var="value">
                <%--<li>${value.name} ${value.count}</li>--%>
                <li>${value}</li>
            </c:forEach>
        </ul>
    </c:forEach>
</div>
<div id="right">
    <ul id="contentOne">

    </ul>
    <ul id="page"></ul>
</div>

</body>
<script type="application/javascript">
    //分页插件
    $.jqPaginator('#page', {
        totalPages: parseInt('${page.totalPage}'),
        visiblePages: 10,
        currentPage: 1,
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            var q = $("#q").val();
            $("#loading").removeClass().addClass("displayLoading");
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath }/search/searchAll/"+num,
                data :{"q":q},
                dataType:"json",
                success: function(data){
                    //debugger;
                    var html = template('content',{"list" : data.queryResponseBeans});
                    $('#contentOne').empty().append(html);
                    $("#loading").removeClass().addClass("noneLoading");
                },
                error: function(json){
                    alert("服务器连接超时,请稍后再试！");
                    return false;
                }
            });
        }
    });

    function search(){
        var q = $("#q").val();
        if(!q){
            alert("检索词不能为空！");
        }else {
            var num = 1;
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath }/search/searchAll/"+num,
                data :{"q":q},
                dataType:"json",
                success: function(data){
                    var html = template('content',{"list" : data.queryResponseBeans});

                    var leftHtml = template('leftFact',{"list" : data.listFact});
                    $('#left').empty().append(leftHtml);

                    $('#contentOne').empty().append(html);
                    $("#numFound").text(data.numFound);
                    $("#time").text(data.time);
                    $("#page").jqPaginator('option',{currentPage: 1});
                    $('#page').jqPaginator('option',{totalPages: data.page.totalPage==0?1:data.page.totalPage});
                    $("#loading").removeClass().addClass("noneLoading");
                },
                error: function(json){
                    alert("服务器连接超时,请稍后再试！");
                    return false;
                }
            });
        }
    }


</script>
<script type="text/javascript">
    //滑动效果
    $(function(){
        $("body").on("click","div[name='factDesc']",function(){
            //alert($(this).next("ul").is(":hidden"));
            if($(this).next("ul").is(":hidden")){
                $(this).next("ul").fadeIn();
            }else{
                $(this).next("ul").fadeOut();
            }
        });
    });

</script>
<!-- 内容 -->
<script type="text/html" id="content">
    {{each list as obj i}}
    <li><div>{{#obj.fileName}} {{obj.fileSize}}</div><div>{{obj.filePath}}</div>
        <div>{{obj.fileType}}</div></li>
    {{/each}}
</script>
<!--左侧导航 -->
<script type="text/html" id="leftFact">
    {{each list as obj i}}
        <div name="factDesc">{{obj.desc}}</div>
        <ul class="hide">
            {{each obj.value as obj1 i}}
                <li>{{obj1.name}}({{obj1.value}})</li>
            {{/each}}
        </ul>
    {{/each}}
</script>
</html>

