<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원관리 시스템 회원정보 수정 페이지</title>
</head>
<body>
<form name="updateform" action="memberupdate.me" method="post">
<input type="hidden" name="id" value="${id }">
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>정보 수정 페이지</font></b>
		</td>
	</tr>
	<tr><td>수정할 아이디 : </td><td>${id }</td></tr>
	<tr><td>비밀번호 : </td><td><input type="password" name="password"/></td></tr>
	<tr><td>이메일 주소 : </td><td><input type="text" name="email" size=30/></td></tr>
	<tr>
		<td colspan="2" align=center>
			<a href="javascript:updateform.submit()">수정</a>&nbsp;&nbsp;
			<a href="javascript:updateform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>