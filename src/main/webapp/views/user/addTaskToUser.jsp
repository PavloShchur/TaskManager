<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<title>Update</title>

<c:url var="saveUrl" value="/addTaskToUser/${userAttribute.id}?${_csrf.parameterName}=${_csrf.token}"/>
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
            <td>
            <form:select path="task" items="${tasks}" itemLabel="titleOfTask" itemValue="id">
            </form:select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form:form>
