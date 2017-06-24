<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Update</title>

<c:url var="saveUrl" value="/addTaskToUser/${userAttribute.id}?${_csrf.parameterName}=${_csrf.token}"/>
<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
    <%--<table>--%>
    <%--<tr>--%>
    <%--<td><form:label path="id">Id</form:label></td>--%>
    <%--<td><form:input path="id" disabled="true"/></td>--%>
    <%--</tr>--%>

    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td><form:label path="id">Id</form:label></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td><form:input path="id" disabled="true"/></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>

    <%--<tr>--%>
    <%--<td><form:label path="name">Name</form:label></td>--%>
    <%--<td><form:input path="name"/></td>--%>
    <%--</tr>--%>

    <%--<tr>--%>
    <%--<td><form:label path="email">Email</form:label></td>--%>
    <%--<td><form:input path="email"/></td>--%>
    <%--</tr>--%>

    <%--<tr>--%>
    <%--<td><form:label path="task">Task</form:label></td>--%>
    <%--<td>--%>
    <%--<form:select path="task" items="${tasks}" itemLabel="titleOfTask" itemValue="id">--%>
    <%--</form:select>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <%--</table>--%>

    <select name="taskID">
        <c:forEach items="${tasks}" var="task">
            <option value="${task.id}">${task.titleOfTask}</option>
        </c:forEach>
    </select>

    <input name="id" disabled="true"/>
    <input type="text" name="name" value="${userAttribute.name}"/><br/>
    <input type="text" name="email" value="${userAttribute.email}"/><br/>
    <input type="password" name="password" value="${userAttribute.password}"/><br/>
    <input type="text" name="titleOfTask" type="hidden"/><br/>

    <input type="submit" value="Save"/>
</form:form>
