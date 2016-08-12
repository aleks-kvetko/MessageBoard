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
		<div class='left-panel'>
			<spring:message code="language" />: <a href="?lang=en">English</a> | <a href="?lang=ru">Русский</a>
			<c:set var="username">
				<sec:authentication property="principal.username" />
			</c:set>

			<p><spring:message code="messages.logged" /> <a href="<c:url value="/user/${username}" />" class='username-link'>${username}</a></p>
			<a href="<c:url value="/logout" />" ><spring:message code="messages.logout" /></a>
			<br>
			<br>
			<a href="<c:url value="/messages" />" ><spring:message code="messages" /></a>
		</div>
		<div class='center-panel'>
			<c:forEach items="${messages}" var="message" >
				<div class='message-info'>
					<a href="<c:url value="/user/${message.username}" />" class='username-link' >${message.username}</a>  <spring:message code="messages.posted" />
					<span class='time'><c:out value="${message.datetime}" /></span>
					<c:if test="${message.username==username}">
						<a href="<c:url value="/messages/edit/${message.id}" />" class='delete-link'><spring:message code="messages.edit" /></a>
					</c:if>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="<c:url value="/messages/delete/${message.id}" />" class='delete-link'><spring:message code="messages.delete" /></a>
					</sec:authorize>

				</div>
				<div class='message'>
					<c:out value="${message.text}" />
				</div>
				<br>

			</c:forEach>
		</div>

  </body>
</html>
