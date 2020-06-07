<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/6/1
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script>

        $(document).ready(function () {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/JWGL_war/student/courses",
                //dataType: 'json',
                dataType: 'JSONP',
                jsonp:"jsonpCallback",
                jsonpCallback:" callback",
                success: function(msg){
                    alert(msg);
                }
            });
        });





    </script>
</head>
<body>
<h1><a href="TestCourse">点我测试</a></h1>
</body>
</html>
