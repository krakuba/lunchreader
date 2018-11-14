<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pl-PL">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Basic reader</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<c:url value="/css/main.css" />" rel="stylesheet"  type="text/css" />
</head>
<body>
<nav class="navbar navbar-dark bg-dark" id="navbar">
    <div id="navdiv_left"></div>
    <div id="navdiv_right">
        <span class="navbar-brand mb-0 h1">Lunch Menu</span>
    </div>
</nav>
<div class="container">
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th>NASZE MIEJSCE</th>
        <tr>
        </thead>
        <tbody class="table-body">
        <c:forEach items="${naszemiejsceMenu}" var="opt">
        <tr class="tr_hover">
            <td class="desc"><c:out value="${opt.option}" /></td>
            <td class="price"><c:out value="${opt.price}" /></td>
        </tr>
        </c:forEach>
        <tbody>

        <thead>
        <tr>
            <th>RESTRO</th>
        <tr>
        </thead>
        <tbody class="table-body">
        <c:forEach items="${restroMenu}" var="opt">
        <tr class="tr_hover">
            <td class="desc"><c:out value="${opt.option}" /></td>
            <td class="price"><c:out value="${opt.price}" /></td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
</body>
<footer></footer>
</html>