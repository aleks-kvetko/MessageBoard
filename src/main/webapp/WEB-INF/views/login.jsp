<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
			<spring:message code="language" />: <a href="<c:url value='/login?lang=en' />">English</a> | <a href="<c:url value='/login?lang=ru' />">Русский</a>
		</div>
		<div class='center-panel'>
			<div class="login-box">
				<c:if test="${error==true}">
					<div class="login-error"><spring:message code="badcredentials" /></div>
				</c:if>
				<c:if test="${logout==true}">
					<div class="login-message"><spring:message code="logoutsuccess" /></div>
				</c:if>
		
				<c:if test="${regsuccess==true}">
					<div class="login-message"><spring:message code="register.success" /></div>
				</c:if>

				<form action="<c:url value='/login' />" method='POST'>

					<table>
						<tr>
							<td><spring:message code="username" /></td>
							<td><input type='text' name='username' value=''></td>
						</tr>
						<tr>
							<td><spring:message code="password" /></td>
							<td><input type='password' name='password' /></td>
						</tr>
						<tr>
							<td></td>
							<td><input  type="submit" value="<spring:message code="login" />" /></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</table>

					<a href="<c:url value="/register" />"><spring:message code="register" /></a></br>
					<a href="<c:url value="/home" />"><spring:message code="asguest" /></a>
				</form>
			</div>
		</div>


	</body>
  
</html>
