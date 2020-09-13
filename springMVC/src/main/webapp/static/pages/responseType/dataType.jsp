<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>响应类型</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function() {
            $("#btn").click(function () {
                //发送ajax请求
                $.ajax({
                    url:"/springmvc/responseType/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"name":"祁侣彬","age":26}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data.name);
                    }
                })
            });
        })
    </script>
</head>
<body>
    <h3>测试返回值是String</h3>
    <a href="/springmvc/responseType/StringType">点击</a><br>
    <h3>测试返回值void</h3>
    <a href="/springmvc/responseType/testVoid">点击</a><br>
    <h3>测试转发和重定向</h3>
    <a href="/springmvc/responseType/testForwardOrRedirect">点击</a><br>
    <h3>发送ajax请求</h3>
    <button id="btn">点击</button>
    <h3>传统的文件上传</h3>
    <form action="/springmvc/responseType/testUpLoadFile1" method="post" enctype="multipart/form-data">
        <input type="file" name="upLoad"/><br>
        <input type="submit" value="点击">
    </form>
    <h3>MVC的文件上传</h3>
    <form action="/springmvc/responseType/testUpLoadFile2" method="post" enctype="multipart/form-data">
        <input type="file" name="upLoad"/><br>
        <input type="submit" value="文件上传">
    </form>
    <h3>测试异常</h3>
    <a href="/springmvc/responseType/testException">点击</a>
    <h3>测试拦截器</h3>
    <a href="/springmvc/responseType/testIntercepter">点击</a>
</body>
</html>
