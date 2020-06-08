<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드 완료</h1>
	이름: ${name}<br><br>
	<c:if test="${not empty fileName}">
		파라미터 이름: ${paramName} <br>
		파일명: ${fileName} <br>
		파일 사이즈: ${filesize} <br>
		<a href="${downlink}">다운로드</a><br>
		<img src="<spring:url value='/upload/${storedFileName}' />" /><br><br>
		<img src="/fileupload/upload/${storedFileName }"/>
	</c:if>
	<br>
</body>
</html>