<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@include file="/views/tiles/header.jsp" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type=""></script>

<div class="container">
    <form:form modelAttribute="user" method="post" action="/saveUser">
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input class="form-control"  path="name" type="text" placeholder="username"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input class="form-control" path="email" type="text" placeholder="useremail"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:input class="form-control" path="password" type="password" placeholder="userpassword"/>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>
</div>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <table class="border">
        <ol>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Task</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
                </thead>
                <c:forEach var="user" items="${users}">
                    <tbody>
                    <tr>

                        <td><a href="/listOfTasks" target="_blank">${user.task.titleOfTask}</a></td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td><a href="/deleteUser/${user.id}">Delete</a></td>
                        <td><a href="/updateUser/${user.id}" target="_blank">Update</a></td>
                        <td><a href="/addTaskToUser/${user.id}" target="_blank">Add Task</a></td>
                        <br>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </ol>
    </table>
</sec:authorize>

<%@include file="../tiles/footer.jsp" %>
<link href="/css/bootstrap.css" rel="stylesheet">



