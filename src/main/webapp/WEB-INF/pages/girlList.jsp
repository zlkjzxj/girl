<%--
  Created by IntelliJ IDEA.
  User: zlkj
  Date: 2017/9/26
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>girl list</title>
</head>
<body>
<table>
    <thead>
    <td>姓名</td>
    <td>杯</td>
    <td>年龄</td>
    </thead>
    <tbody>
    <c:forEach items="${girlList}" var="obj">
        <tr>
            <td> ${obj.name}</td>
            <td> ${obj.cupSize}</td>
            <td> ${obj.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
