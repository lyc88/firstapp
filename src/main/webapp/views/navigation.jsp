<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/18
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css" href="${pageContext.request.contextPath }/static/base.css"></style>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/zTree/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/zTree/css/zTreeStyle/zTreeStyle.css"
          type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/zTree/js/jquery-1.4.4.min.js"></script>
    <%--<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>--%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/zTree/js/jquery.ztree.all.js"></script>

    <script type="application/javascript">

        var zTreeObj;
        var zTreeObj1;
        var newNodes = [{name: "newNode1"}, {name: "newNode2"}, {name: "newNode3"}];
        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            callback: {
                onClick: zTreeOnClick
            }
        };


        function zTreeOnClick(event, treeId, treeNode) {
            console.log(treeNode.tId + ", " + treeNode.name + "--" + event.type + "--" + treeId + treeNode.id);
            console.log(treeNode.getParentNode());
            if (treeNode.name == "test1_1") {
                zTreeObj.addNodes(treeNode, -1, newNodes, true);
                console.log(treeNode.getPath());
            }
        }
        ;
        // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
        var zNodes = [
            {
                id: 1, name: "test1", open: true, children: [
                {name: "test1_1",}, {name: "test1_2"}]
            },
            {
                id: 2, name: "test2", open: false, children: [
                {name: "test2_1"}, {name: "test2_2"}]
            }
        ];
        $(document).ready(function () {
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);

            zTreeObj1 = $.fn.zTree.init($("#treeDemo1"), setting, zNodes);
        });

    </script>
    <script type="application/javascript">
        var zTreeObj12;
        var zNodes1 = [
            {name: "3000个节点", id: "-1", count: 1, times: 1, isParent: true}
            //{name: "1000个节点", id: "2", count: 1000, times: 1, isParent: true},
            //{name: "2000个节点", id: "3", count: 2000, times: 1, isParent: true}
        ];
        var setting1 = {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: 0
            },
            callback: {
                onClick: zTreeOnClick
                //onAsyncSuccess: zTreeOnAsyncSuccess
            },
            async: {
                enable: true,
                contentType: "application/x-www-form-urlencoded",
                url: "${pageContext.request.contextPath }/subject/asyntree",
                autoParam: ["id=pId"]
            }
        };

        function zTreeOnClick(event, treeId, treeNode) {
            //console.log(treeNode.tId + ", " + treeNode.name + "--" + event.type + "--" + treeId + treeNode.id);

            if (treeNode.name == "test1_1") {
                zTreeObj.addNodes(treeNode, -1, newNodes, true);
                console.log(treeNode.getPath());
            }
        };
            // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
            $(document).ready(function () {
                zTreeObj12 = $.fn.zTree.init($("#asyntree"), setting1, zNodes1);
            });


    </script>

    <script type="application/javascript">
        /* function jsoncallback(result) {
         //alert(result);
         for(var i in result) {
         alert(i+":"+result[i]);//循环输出a:1,b:2,etc.
         }
         }*/
        $(function () {
            /*$.ajax({
             type: "get",
             url:"http://127.0.0.1:8080/hello/subject/tree1",
             dataType:'jsonp',
             data:null,
             //jsonp:'jsoncallback',
             //jsonpCallback: "success_jsonpCallback",
             success:function(result) {
             console.log(result);
             }
             });*/

            /* $.ajax({
             type: "get",
             url:"http://192.168.16.177:9000/home",
             dataType:'jsonp',
             data:null,
             //jsonp:'jsoncallback',
             //jsonpCallback: "success_jsonpCallback",
             success:function(result) {
             console.log(result);
             }
             });*/
        });


    </script>
</head>
<body>
navigation
<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
<div>
    <ul id="treeDemo1" class="ztree"></ul>
</div>

<div>
    <ul id="asyntree" class="ztree"></ul>
</div>
</body>
</html>
