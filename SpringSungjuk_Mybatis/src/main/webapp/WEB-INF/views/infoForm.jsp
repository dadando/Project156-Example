<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width=300 align="center">
	<tr align=center><td>학번 : </td><td>${vo.getHakbun()}</td></tr>
	<tr align=center><td>이름 : </td><td>${vo.getName()}</td></tr>
	<tr align=center><td>국어 : </td><td>${vo.getKor()}</td></tr>
	<tr align=center><td>영어 : </td><td>${vo.getEng()}</td></tr>
	<tr align=center><td>수학 : </td><td>${vo.getMath()}</td></tr>
	<tr align=center><td>총점 : </td><td>${vo.getTot()}</td></tr>
	<tr align=center><td>평균 : </td><td>${vo.getAvg()}</td></tr>
	<tr align=center><td>등급 : </td><td>${vo.getGrade()}</td></tr>
	<tr align=center>
		<td colspan=2><a href="listform.me">리스트로 돌아가기</a></td>
	</tr>
</table>
</body>
</html>