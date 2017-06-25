<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@include file="/views/tiles/header.jsp" %>


<form:form modelAttribute="user" method="post" action="/saveUser">
    ${UserNameException}
    <form:input path="name"  placeholder="username"/>
    <form:input path="email" placeholder="useremail"/>
    <form:input path="password" type="password" placeholder="userpassword"/>

    <form:select path="task" items="${tasks}" itemLabel="titleOfTask" itemValue="id"></form:select>

    <button>SAVE USER</button>

    <input type="reset" value="RESET">
</form:form>

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

