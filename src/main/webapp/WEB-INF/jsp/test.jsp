<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pl-PL">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Basic reader</title>
</head>
<style>
    table, tr, td {
        border: 1px solid black;
    }
</style>
<body>
Nasze miejsce:
<table style="border: 1px solid black; ">
    <c:forEach items="${naszemiejsceMenu}" var="opt">
        <tr>
            <td><c:out value="${opt.name}" /></td>
            <td><c:out value="${opt.option}" /></td>
            <td><c:out value="${opt.price}" /></td>
        </tr>
    </c:forEach>
</table>
<%--Restro:--%>
<%--<table style="border: 1px solid black; ">--%>
    <%--<c:forEach items="${restroMenu}" var="opt">--%>
        <%--<tr>--%>
            <%--<td><c:out value="${opt.name}" /></td>--%>
            <%--<td><c:out value="${opt.option}" /></td>--%>
            <%--<td><c:out value="${opt.price}" /></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
</body>
</html>