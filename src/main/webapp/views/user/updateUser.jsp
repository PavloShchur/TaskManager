    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>

<c:url var="saveUrl" value="/updateUser/${userAttribute.id}?${_csrf.parameterName}=${_csrf.token}" />
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
   <td><form:label path="password">Password</form:label></td>
   <td><form:input path="password"/></td>
  </tr>

  <select name="taskID">
   <c:forEach items="${tasks}" var="task">
    <option value="${task.id}">${task.titleOfTask}</option>
   </c:forEach>
  </select>
   
 </table> 
 <input type="submit" value="Save" />
</form:form>
