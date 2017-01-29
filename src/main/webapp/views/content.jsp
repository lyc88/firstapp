<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/18
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/template.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/static/js/jqPaginator.min.js" type="text/javascript"></script>
</head>
<body>
    <h1>hello word!<a href="${pageContext.request.contextPath }/search/toSearch">go search</a></h1>
</body>
</html>
