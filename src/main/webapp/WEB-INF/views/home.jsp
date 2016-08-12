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
			<spring:message code="language" />: <a href="?lang=en">English</a> | <a href="?lang=ru">Русский</a>
			
			<sec:authorize access="isAnonymous()">
				<p><spring:message code="messages.guest" /></p>
				<a href="<c:url value="/login" />" ><spring:message code="login" /></a>
			</sec:authorize>
		
			<sec:authorize access="isAuthenticated()">
				<c:set var="username">
					<sec:authentication property="principal.username" />
				</c:set>
				<c:set var="action">
					<c:url value="/messages/add" />
				</c:set>
				<p><spring:message code="messages.logged" /> <a href="<c:url value="/user/${username}" />" class='username-link'>${username}</a></p>
				<a href="<c:url value="/logout" />" ><spring:message code="messages.logout" /></a>
			</sec:authorize>
		</div>

		<div class='center-panel' align='center'>
			<h1><spring:message code="home.welcome" /></h1>
			<sec:authorize access="isAnonymous()">
				<h3><spring:message code="home.higuest" /></h3>
				<h3><a href="<c:url value="/messages" />" ><spring:message code="messages" /></a></h3>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<c:set var="username">
					<sec:authentication property="principal.username" />
				</c:set>
	
	
				<sec:authorize access="hasRole('ROLE_USER')">
					<h3><spring:message code="home.hiuser" arguments="${username}" /></h3>
				</sec:authorize>
	
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<h3><spring:message code="home.hiadmin" arguments="${username}" /></h3>
				</sec:authorize>
	
				<h3> <a href="<c:url value="/messages" />"><spring:message code="messages" /></a></h3>
				<h3> <a href="<c:url value="/user/${username}" />"><spring:message code="home.gotoprofile" /></a></h3>
			</sec:authorize>
		</div>




	</body>
</html>
