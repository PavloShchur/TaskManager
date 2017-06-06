<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div style="text-align: center; margin-top: 1%">

    <form:form modelAttribute="task" method="post" action="/saveTask">
        <form:input path="titleOfTask" placeholder="title of task"/>
        <form:input path="descriptionOfTask" placeholder="description of task"/>
        <button>Save</button>
        <%--<input type="submit" name="saveTask" value="SAVE" />--%>
        <%--<input type="reset" value="RESET">--%>
    </form:form>
</div>

<table class="border">
    <ol>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Username</th>
                <th>Title of task</th>
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
                        <a href="/registration">${user.name}</a>
                    </c:forEach>

                </td>
                    <%--<td>${task.user.name}</td>--%>
                <td>${task.titleOfTask}</td>
                <td>${task.descriptionOfTask}</td>
                <td><a href="/deleteTask/${task.id}">Delete</a></td>
                <td><a href="/updateTask/${task.id}" target="_blank">Update</a></td>
            </tr>
            </tbody>
            </c:forEach> </table>
    </ol>
</table>
<link href="/css/bootstrap.css" rel="stylesheet">

