<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Update</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<c:url var="saveUrl" value="/addTaskToUser/${userAttribute.id}?${_csrf.parameterName}=${_csrf.token}"/>
<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
    <div class="container">
        <div class="form-group">
            <select name="taskID">
                <c:forEach items="${tasks}" var="task">
                    <option value="${task.id}">${task.titleOfTask}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Name:</label>
            <input class="form-control" type="text" name="name" value="${userAttribute.name}"/><br/>
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input class="form-control" type="text" name="email" value="${userAttribute.email}"/><br/>
        </div>
        <div class="form-group">
            <label>Password:</label>
            <input class="form-control" type="password" name="password" value="${userAttribute.password}"/><br/>
        </div>
        <div class="form-group">
            <label>Title of Task:</label>
            <input class="form-control" type="text" name="titleOfTask" type="hidden"/><br/>
        </div>
        <button type="submit" class="btn btn-default">Add task</button>
    </div>
</form:form>
