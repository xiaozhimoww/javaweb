<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>

<body>
<div id="login">
    <div id="top">
        <img src="${pageContext.request.contextPath}/images/cloud.jpg" />
        <span>LOGIN</span>
    </div>

    <div id="bottom">
        <form action="${pageContext.request.contextPath}/login/doLogin.action" method="post">
            <table border="0px" id="table">
                <!-- 用户类型选择 -->
                <tr>
                    <td class="td1">用户类型：</td>
                    <td>
                        <select name="userType" class="td2">
                            <option value="admin" selected>管理员</option>
                            <option value="customer">顾客</option>
                        </select>
                    </td>
                </tr>

                <!-- 用户名输入 -->
                <tr>
                    <td class="td1">用户名：</td>
                    <td><input type="text" placeholder="Username" class="td2" name="name" value="admin"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><span id="nameerr" style="color:red">${errmsg}</span></td>
                </tr>

                <!-- 密码输入 -->
                <tr>
                    <td class="td1">密码：</td>
                    <td><input type="password" placeholder="Password" class="td2" name="pwd" value="000000"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><span id="pwderr" style="color:red">${errmsg}</span></td>
                </tr>

                <!-- 提交按钮 -->
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="登录" class="td3">
                        <a href="${pageContext.request.contextPath}/admin/regist.jsp">
                            <input type="button" value="注册" class="td3">
                        </a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
