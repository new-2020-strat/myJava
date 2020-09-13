<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数的绑定</title>
</head>
<body>
    <h3>基本类型的数据绑定</h3>
    <a href="/springmvc/bindData/basicType?uname=qilvbin">点击</a>
    <h3>绑定到基本javabean类Account实体类中</h3>
    <form action="/springmvc/bindData/saveAccount" method="post">
        姓名：<input type="text" name="uname"/><br>
        密码：<input type="text" name="password"/><br>
        金额：<input type="text" name="money"/><br>
        <input type="submit" value="提交"/><br>
    </form>
    <h3>绑定到基本javabean类Account引用User的实体类中</h3>
    <form action="/springmvc/bindData/saveAccountWithUser" method="post">
        姓名：<input type="text" name="uname"/><br>
        密码：<input type="text" name="password"/><br>
        金额：<input type="text" name="money"/><br>
        用户名字：<input type="text" name="user.name"/><br>
        用户年龄：<input type="text" name="user.age"/><br>
        <input type="submit" value="提交"/>
    </form>
    <h3>绑定到list和map装中</h3>
    <form action="/springmvc/bindData/saveAccountListAndMap" method="post">
        姓名：<input type="text" name="uname"/><br>
        密码：<input type="text" name="password"/><br>
        金额：<input type="text" name="money"/><br>
        这组用户封装到list第一个元素：<br>
        用户名字：<input type="text" name="list[0].name"/><br>
        用户年龄：<input type="text" name="list[0].age"/><br>
        这组用户封装到map的key="one"的元素：<br>
        用户名字：<input type="text" name="map['one'].name"/><br>
        用户年龄：<input type="text" name="map['one'].age"/><br>
        <input type="submit" value="提交"/>
    </form>
    <h3>自定义数据类型转换(Date)</h3>
    <form action="/springmvc/bindData/saveUser" method="post">
        用户名字：<input type="text" name="name"/><br>
        用户年龄：<input type="text" name="age"/><br>
        用户生日：<input type="text" name="date"/><br>
        <input type="submit" value="提交"/>
    </form>
    <h3>获取原生态Servlet</h3>
    <a href="/springmvc/bindData/getOriginServlet">点击</a>
    <h3>获取请求头</h3>
    <a href="/springmvc/bindData/getRequestHeader">点击</a>
    <h3>获取请求体</h3>
    <form action="/springmvc/bindData/getRequestBody" method="post">
        用户名字：<input type="text" name="name"/><br>
        用户年龄：<input type="text" name="age"/><br>
        用户生日：<input type="text" name="date"/><br>
        <input type="submit" value="提交"/>
    </form>
    <h3>测试前台参数key和后台方法参数不一致</h3>
    <a href="/springmvc/bindData/requestParameterDifferent?uname=祁侣彬">点击</a>
    <h3>rest编程风格</h3>
    <a href="/springmvc/bindData/restProgramType/20">点击</a>
    <h3>获取cookie中的值</h3>
    <a href="/springmvc/bindData/getCookie">点击</a>

    <h3>ModelAttribute注解</h3>
    <form action="/springmvc/bindData/testModelModelAttribute" method="post">
        用户名字：<input type="text" name="name"/><br>
        用户年龄：<input type="text" name="age"/><br>
       <%-- 用户生日：<input type="text" name="date"/><br>--%>
        <input type="submit" value="提交"/>
    </form>
    <h3>SessionAttribute注解</h3>
    <a href="/springmvc/bindData/testSessionAttribute">测试session中存入值userName=binbin</a><br>
    <a href="/springmvc/bindData/getSession">测试获取session值</a><br>
    <a href="/springmvc/bindData/deleteSession">测试删除session值</a><br>
</body>
</html>
