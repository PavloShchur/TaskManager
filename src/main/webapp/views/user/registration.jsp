<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form modelAttribute="user" method="post" action="/saveUser">
    ${UserNameException}
    <form:input path="name" placeholder="username"/>
    <form:input path="email" placeholder="useremail"/>
    <form:input path="password" placeholder="userpassword"/>

    <form:select path="task" items="${tasks}" itemLabel="titleOfTask" itemValue="id"/>

    <input type="submit" name="saveUser" value="SAVE" />
    <input type="reset" value="RESET">
</form:form>

<table class="border">
    <ol>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Task</th>
                <th>Username</th>
                <th>Email</th>
                <th>Password</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            </thead>
            <c:forEach var="user" items="${users}">
                <tbody>
                <tr>
                    <td><a href="/listOfTasks">${user.task.titleOfTask}</a></td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td><a href="/deleteUser/${user.id}">Delete</a></td>
                    <td><a href="/updateUser/${user.id}" target="_blank">Update</a></td>
                    <br>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </ol>
</table>
