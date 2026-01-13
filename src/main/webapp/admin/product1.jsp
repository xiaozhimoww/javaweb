<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jmu.ccz.fs.pojo.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bright.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title>商品浏览</title>
</head>

<body>
<div id="brall">
    <!-- 顶部导航 -->
    <div id="nav">
        <p>商品浏览</p>
    </div>

    <!-- 消息提示：加入购物车成功/失败 -->
    <c:if test="${not empty sessionScope.msg}">
        <div style="color: green; text-align: center; margin: 10px 0;">
                ${sessionScope.msg}
        </div>
        <c:remove var="msg" scope="session" />
    </c:if>

    <!-- 商品表格 -->
    <div id="table">
        <c:choose>
            <c:when test="${pb.list.size() != 0}">
                <div id="middle">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>商品名</th>
                            <th>商品介绍</th>
                            <th>定价（元）</th>
                            <th>商品数量</th>
                            <th>购买</th>
                        </tr>
                        <c:forEach items="${pb.list}" var="p">
                            <tr>
                                <td>${p.pName}</td>
                                <td>${p.pContent}</td>
                                <td>${p.pPrice}</td>
                                <td>${p.pNumber}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/order/addToCart.action" method="post" style="display:inline;">
                                        <input type="hidden" name="pId" value="${p.pId}">
                                        <input type="number" name="quantity" min="1" max="${p.pNumber}" value="1" style="width:60px;">
                                        <input type="submit" class="btn btn-success" value="加入购物车">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                    <!-- 分页 -->
                    <div id="bottom">
                        <nav aria-label="Page navigation" style="text-align:center;">
                            <ul class="pagination">
                                <li><a href="javascript:ajaxsplit(${pb.prePage})">&laquo;</a></li>
                                <c:forEach begin="1" end="${pb.pages}" var="i">
                                    <li>
                                        <a href="javascript:ajaxsplit(${i})" style="${pb.pageNum==i?'background-color: grey;':''}">${i}</a>
                                    </li>
                                </c:forEach>
                                <li><a href="javascript:ajaxsplit(${pb.nextPage})">&raquo;</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h2 style="text-align: center;color: orangered;margin-top: 100px">暂时没有符合条件的商品！</h2>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<script type="text/javascript">
    // 查询分页
    function ajaxsplit(page){
        $.post("${pageContext.request.contextPath}/prod/ajaxsplit.action", {
            page: page,
            pname: $("#pname").val(),
            typeid: $("#typeid").val(),
            lprice: $("#lprice").val(),
            hprice: $("#hprice").val()
        }, function() {
            $("#table").load("${pageContext.request.contextPath}/customer/product1.jsp #table");
        });
    }
</script>
</body>
</html>
