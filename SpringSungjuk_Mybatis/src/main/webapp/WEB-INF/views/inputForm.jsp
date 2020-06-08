<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form name="inputform" action="./inputprocess.me" method="post">
<table border=1 align=center>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>성적입력 페이지</font></b>
		</td>
	</tr>
	<tr><td>학번 : </td><td><input type="text" name="hakbun"/></td></tr>
	<tr><td>이름 : </td><td><input type="text" name="name"/></td></tr>
	<tr><td>국어 : </td><td><input type="text" name="kor"/></td></tr>
	<tr><td>영어 : </td><td><input type="text" name="eng"/></td></tr>
	<tr><td>수학 : </td><td><input type="text" name="math"/></td></tr>
	<tr>
		<td colspan="2" align="center">
			<a href="javascript:inputform.submit()">성적입력</a>&nbsp;&nbsp;
			<a href="javascript:inputform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>