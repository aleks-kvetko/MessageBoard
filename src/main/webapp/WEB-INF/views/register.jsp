<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<html>
	<head>
		<title>MessageBoard</title>
		<link rel="stylesheet" 
        type="text/css" 
        href="<c:url value="/resources/style.css" />" >
	</head>
	<body>
		<div class='left-panel'>
			<spring:message code="language" />: <a href="?lang=en">English</a> | <a href="?lang=ru">Русский</a>
		</div>
		<div class='center-panel-register'>
			<c:set var="action">
				<c:url value="/register" />
			</c:set>
			<form:form action="${action}" method="post" modelAttribute="user">
				<table class='register-table'>
					<tr>
						<td><spring:message code="userpage.username" /></td>
						<td><form:input  path="username"/></td>
						<td><form:errors path="username" cssClass="register-error" element="div"></form:errors></td>
					</tr>
					<tr>
						<td><spring:message code="userpage.password" /></td>
						<td><form:input  path="password"/></td>
						<td><form:errors path="password" cssClass="register-error" element="div"></form:errors></td>
					</tr>
					<tr>
						<td><spring:message code="userpage.firstname" /></td>
						<td><form:input  path="firstname"/></td>
						<td><form:errors path="firstname" cssClass="register-error" element="div"></form:errors></td>
					</tr>
					<tr>
						<td><spring:message code="userpage.lastname" /></td>
						<td><form:input  path="lastname"/></td>
						<td><form:errors path="lastname" cssClass="register-error" element="div"></form:errors></td>
					</tr>
					<tr>
						<td><spring:message code="userpage.email" /></td>
						<td><form:input  path="email"/></td>
						<td><form:errors path="email" cssClass="register-error" element="div"></form:errors></td>
					</tr>
				</table>
				<div align='center'><input type="submit" value="<spring:message code="register" />" ></div>
			</form:form>
  
		</div>
	</body>
</html>
