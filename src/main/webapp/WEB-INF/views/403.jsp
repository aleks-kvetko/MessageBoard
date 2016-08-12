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
		</div>
		<div class='center-panel'>
			<h2><spring:message code="accessdenied" /></h2>
		</div>
	</body>
</html>
