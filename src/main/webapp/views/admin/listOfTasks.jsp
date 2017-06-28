<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@include file="/views/tiles/header.jsp" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type=""></script>

    <form:form modelAttribute="task" method="post" action="/saveTask">
        <div class="container">
            <div class="form-group">
                <label for="titleOfTask">Name:</label>
                <form:input class="form-control" path="titleOfTask" placeholder="title of task"/>
            </div>
            <div class="form-group">
                <label for="descriptionOfTask">Email:</label>
                <form:input class="form-control" path="descriptionOfTask" placeholder="description of task"/>
            </div>
            <button type="submit" class="btn btn-default">Save</button>
        </div>
    </form:form>

<table class="border">
    <ol>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Username</th>
                <th>Title of task</th>
                <th>Time</th>
                <th>Description</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach var="task" items="${tasks}">
                <td>
                    <c:forEach var="user" items="${task.users}">
                        <a href="/listOfUsers">${user.name}</a>
                    </c:forEach>

                </td>
                <td>${task.titleOfTask}</td>
                <td>${task.localDateTime}</td>
                <td>${task.descriptionOfTask}</td>
                <td><a href="/deleteTask/${task.id}">Delete</a></td>

                <c:if test="${task.users.size() == 0}">

                    <td><a href="/updateTaskWithoutUser/${task.id}" target="_blank">Update</a></td>

                </c:if>

                <c:if test="${task.users.size() != 0}">
                    <c:forEach var="user" items="${task.users}">
                        <td><a href="/updateTask/${task.id}/${user.id}" target="_blank">UpdateUser</a></td>
                    </c:forEach>
                </c:if>

            </tr>
            </tbody>
            </c:forEach> </table>
    </ol>
</table>
<link href="/css/bootstrap.css" rel="stylesheet">

