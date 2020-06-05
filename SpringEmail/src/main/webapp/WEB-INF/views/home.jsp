<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<br>
<form action="auth.do" method="POST">
<table border="1" width="450" height="70" align = "center">
	<div style="text-align:center;">
		<tr>
			<td align="center">
				이메일: <input type="email" name="email" placeholder="이메일주소를 입력해주세요.">
				<button type="submit" name="submit">이메일 인증</button>
			</td>
		</tr>
	</div>
</table>
</form>
</body>
</html>
