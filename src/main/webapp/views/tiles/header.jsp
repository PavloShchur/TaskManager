<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle='collapse' data-target='#responsive-menu'>
                <span class="sr-only">Open navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li><a href="/registration" target="_blank">Registration</a></li>
                <li><a href="/loginpage" target="_blank">Login</a></li>

                <%--<sec:authorize access="isAuthenticated()">--%>
                    <%--<li><a href="/listOfTasks" target="_blank">Tasks</a></li>--%>
                <%--</sec:authorize>--%>


                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/listOfUsers" target="_blank">Users</a></li>
                    <li><a href="/listOfTasks" target="_blank">Tasks</a></li>
                </sec:authorize>

                <li"><sec:authorize access="isAuthenticated()">
                    <form:form action="logout" method="post">
                        <button class="btn btn-default">logout</button>
                    </form:form>
                </sec:authorize>
                </li>

            </ul>
        </div>
    </div>
</div>
<div class="container">
</div>


<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8 col-md-8 col-sm-6 col-xs-4">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-6 hidden-sx"></div>
    </div>
</div>

<link href="/css/bootstrap.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
