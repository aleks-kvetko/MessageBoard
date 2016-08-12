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
			<c:set var="currentusername">
				<sec:authentication property="principal.username" />
			</c:set>
			<c:set var="action">
				<c:url value="/messages/add" />
			</c:set>
			<p><spring:message code="messages.logged" /> <a href="<c:url value="/user/${currentusername}" />" class='username-link'>${currentusername}</a></p>
			<a href="<c:url value="/logout" />" ><spring:message code="messages.logout" /></a>
			<br>
			<br>
			<a href="<c:url value="/messages" />" ><spring:message code="messages" /></a>
		</div>
		<div class='center-panel'>
			<c:if test="${currentusername==username}">
				<form method="POST" align=center>
					<c:if test="${hasError==true}">
						<div class="edit-error" align=center><spring:message code="messages.wrongsize" /></div>
					</c:if>
					<textarea name="message" cols="80" rows="5">${message}</textarea><br/>
					<input type="submit" value="<spring:message code="messages.send" />" />
				</form>
			</c:if>
			<c:if test="${currentusername!=username&&error!=true}">
				<div align=center class="messages-error" ><spring:message code="edit.wrongusername" /></div>
			</c:if>
			<c:if test="${error==true}">
				<div align=center class="messages-error" ><spring:message code="edit.wrongmessageid" /></div>
			</c:if>
		</div>
	</body>
</html>
				