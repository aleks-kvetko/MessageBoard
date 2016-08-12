<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<c:set var="username">
		<sec:authentication property="principal.username" />
		</c:set>
		<div class='left-panel'>
			<spring:message code="language" />: <a href="?lang=en">English</a> | <a href="?lang=ru">Русский</a>
			<br>
			<br>
			<a href="<c:url value="/messages" />" ><spring:message code="messages" /></a>
		</div>

		<div class='center-panel'>
			<c:if test="${error==true}">
				<div align=center class="messages-error" ><spring:message code="userpage.wrongusername" /></div>
			</c:if>
			<c:if test="${error!=true}">   
				<div class='user-info'><h2 align='center'><spring:message code="userpage.title" /></h2>

				<c:if test="${user.username==username}">
					<p><span class='user-info-label'><spring:message code="userpage.yourprofile" /></span></p>
				</c:if>
				<p><span class='user-info-label'><spring:message code="userpage.username" /> </span>${user.username}</p>
				<c:if test="${user.username==username}">
					<p><span class='user-info-label'><spring:message code="userpage.password" /> </span>${user.password}</p>
				</c:if>
				<p><span class='user-info-label'><spring:message code="userpage.firstname" /> </span>${user.firstname}</p>
				<p><span class='user-info-label'><spring:message code="userpage.lastname" /> </span>${user.lastname}</p>
				<p><span class='user-info-label'><spring:message code="userpage.email" /> </span>${user.email}</p>
				<c:if test="${user.username==username}">
					<p><a href="<c:url value="/messages/${user.username}" />" class='userinfo-link' ><spring:message code="userpage.mymessages" /> </a></p>
				</c:if>
				<c:if test="${user.username!=username}">
					<p><a href="<c:url value="/messages/${user.username}" />" class='userinfo-link' ><spring:message code="userpage.messages" /> </a></p>
				</c:if>
  
				</div>
			</c:if>
		</div>
	</body>
</html>
