<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    <h3>测试表现层查询</h3><br>
    <a href="/ssm/account/findAll">点击</a><br>
    <h3>测试表现层保存</h3><br>
    <form action="/ssm/account/save" method="post">
        编号：<input type="text" name="id"/><br>
        姓名：<input type="text" name="name"/><br>
        金额：<input type="text" name="money"/><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>