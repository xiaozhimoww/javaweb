<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增商品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
<div id="addAll">
    <div id="nav">
        <p>商品管理 &gt; 新增商品</p>
    </div>

    <div id="table">
        <form action="${pageContext.request.contextPath}/prod/save.action" method="post" id="myform">
            <table>
                <tr>
                    <td class="one">商品名称</td>
                    <td><input type="text" name="pName" class="two"></td>
                </tr>
                <tr class="three">
                    <td></td>
                    <td><span id="pnameerr"></span></td>
                </tr>

                <tr>
                    <td class="one">商品介绍</td>
                    <td><input type="text" name="pContent" class="two"></td>
                </tr>
                <tr class="three">
                    <td></td>
                    <td><span id="pcontenterr"></span></td>
                </tr>

                <tr>
                    <td class="one">定价</td>
                    <td><input type="number" name="pPrice" class="two"></td>
                </tr>
                <tr class="three">
                    <td></td>
                    <td><span id="priceerr"></span></td>
                </tr>

                <tr>
                    <td class="one">总数量</td>
                    <td><input type="number" name="pNumber" class="two"></td>
                </tr>
                <tr class="three">
                    <td></td>
                    <td><span id="numerr"></span></td>
                </tr>

                <tr>
                    <td class="one">类别</td>
                    <td>
                        <select name="typeId">
                            <c:forEach items="${ptlist}" var="type">
                                <option value="${type.typeId}">${type.typeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="three">
                    <td></td>
                    <td><span></span></td>
                </tr>

                <tr>
                    <td>
                        <input type="submit" value="提交" class="btn btn-success">
                    </td>
                    <td>
                        <input type="reset" value="取消" class="btn btn-default" onclick="myclose(${param.page})">
                        <script type="text/javascript">
                            function myclose(ispage) {
                                window.location="${pageContext.request.contextPath}/prod/split.action?page="+ispage;
                            }
                        </script>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
