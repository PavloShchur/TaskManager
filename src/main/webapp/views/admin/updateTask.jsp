<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.06.2017
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="saveUrl" value="/updateTask/${taskAttribute.id}" />
<form:form modelAttribute="taskAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="localDateTime">Time</form:label></td>
            <td><form:input path="localDateTime" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="titleOfTask">Title</form:label></td>
            <td><form:input path="titleOfTask"/></td>
        </tr>

        <tr>
            <td><form:label path="descriptionOfTask">Description</form:label></td>
            <td><form:input path="descriptionOfTask"/></td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>
