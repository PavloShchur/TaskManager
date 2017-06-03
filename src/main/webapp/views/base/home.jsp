<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="/views/tiles/header.jsp"%>

<sec:authentication property="name" />

<sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<br>
	<a href="loginpage">login</a>
	<br>
	<a href="registration">registration</a>
	<br>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin">admin page</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="profile">profile</a>
</sec:authorize>

<br>
<br>
<c:forEach var="task" items="${tasks}">
		${task.localDateTime}
		${task.titleOfTask}
		${task.descriptionOfTask}
			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<a href="buyBook/${task.id}">buy</a>
			</sec:authorize>
	<br>
</c:forEach>
<%@include file="../tiles/footer.jsp"%>