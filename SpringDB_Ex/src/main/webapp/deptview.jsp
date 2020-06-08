<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.spring.DB_Ex.DeptVO" %>

<%
DeptVO deptvo = (DeptVO)request.getAttribute("deptvo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br>
<table align="center" border="1">
	<tr>
		<td width="80">&nbsp;부서번호</td>
		<td width="120">&nbsp;${deptvo['deptno']}</td>
	</tr>
	<tr>
		<td>&nbsp;부서명</td>
		<td>&nbsp;${deptvo['dname']}</td>
	</tr>
	<tr>
		<td>&nbsp;위치</td>
		<td>&nbsp;${deptvo['loc']}</td>
	</tr>
	<tr align="center">
		<td colspan="2"><a href="selectProcess.me">사원정보</a></td>
	</tr>
</table>
</body>
</html>