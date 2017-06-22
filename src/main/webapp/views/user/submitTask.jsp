<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.06.2017
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<title>Update</title>

<c:url var="saveUrl" value="/submitTask/${userAttribute.id}" />
<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>

        <tr>
            <td><form:label path="task">Task</form:label></td>
            <td>${userConfirmTask.titleOfTask}</td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>

</body>
</html>
