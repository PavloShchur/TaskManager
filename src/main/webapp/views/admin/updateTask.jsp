<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@include file="/views/tiles/header.jsp" %>

<c:url var="saveUrl" value="/updateTask/${taskAttribute.id}/${user.userId}" />
<form:form modelAttribute="taskAttribute" method="POST" action="${saveUrl}">
    <div class="container">
    <div class="form-group">
        <label for="localDateTime">Time:</label>
        <form:input class="form-control"  path="localDateTime" type="text"/>
    </div>
    <div class="form-group">
        <label for="titleOfTask">Title:</label>
        <form:input class="form-control" path="titleOfTask" type="text" placeholder="titleOfTask"/>
    </div>
    <div class="form-group">
        <label for="descriptionOfTask">Description:</label>
        <form:input class="form-control" path="descriptionOfTask" type="text" placeholder="descriptionOfTask"/>
    </div>
    <button type="submit" class="btn btn-default">Save changes</button>
    </div>
</form:form>
