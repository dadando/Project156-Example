<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form name="updateform" action="updateform.me" method="post">
<input type="hidden" name="hakbun" value="${hakbun}">
<table border=1 align="center">
	<tr>
		<td colspan="2" align="center">
			<b><font size=5>성적 수정 페이지</font></b>
		</td>
	</tr>
	<tr><td>수정할 학번</td><td>${vo.hakbun}</td></tr> <!-- ${hakbun} -->
	<tr><td>이름</td><td>${vo.name }</td></tr>		<!-- ${name} -->
	<tr><td>국어</td><td><input type="text" name="kor"></td></tr>
	<tr><td>영어</td><td><input type="text" name="eng"></td></tr>
	<tr><td>수학</td><td><input type="text" name="math"></td></tr>
	<tr>
		<td colspan="2" align="center"><a href="javascript:updateform.submit()">성적수정</a>&nbsp;&nbsp;
		<a href="javascript:updateform.reset()">다시입력</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>