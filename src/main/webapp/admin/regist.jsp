<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
<div id="login">
    <div id="top">
        <img src="${pageContext.request.contextPath}/images/cloud.jpg" />
        <span>REGIST</span>
    </div>

    <div id="bottom">
        <form action="${pageContext.request.contextPath}/regist/doRegist.action" method="post">
            <table border="0px" id="table">

                <tr>
                    <td class="td1">用户类型：</td>
                    <td>
                        <select name="userType" class="td2">
                            <option value="admin" selected>管理员</option>
                            <option value="customer">顾客</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="td1">用户名：</td>
                    <td><input type="text" placeholder="Username" class="td2" name="name"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><span style="color:red">${errmsg}</span></td>
                </tr>

                <tr>
                    <td class="td1">密码：</td>
                    <td><input type="password" placeholder="Password" class="td2" name="pwd"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><span style="color:red">${errmsg}</span></td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="注册" class="td3">
                        <a href="${pageContext.request.contextPath}/admin/login.jsp">
                            <input type="button" value="返回登录" class="td3">
                        </a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
