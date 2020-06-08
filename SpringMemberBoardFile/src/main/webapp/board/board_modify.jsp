<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.spring.memberboard.board.*" %>
<%
	String id=(String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="boardmodify.bo" method="post" name="modifyform">
${vo.num}
	<input type="hidden" name="num" value="${vo.num}"> 
	<input type="hidden" name="id" value="<%=id %>">
	<table cellpadding="0" cellspacing="0"> 
		<tr align="center" valign="middle"> 
			<td colspan="5"> MVC게시판  </td> 
		</tr>
		<tr> 
			<td height="16" style="font-family:돋음; font-size:12"> 
				<div align="center">제 목 </div> 
			</td> 
			<td> 
				<input name="subject" size="50" maxlength="100" value="${vo.subject }">
			</td> 
		</tr>
		<tr> 
			<td style="font-family:돋음; font-size:12"> 
				<div align="center">내 용 </div> 
			</td> 
			<td> 
				<textarea name="content" cols="67" rows="15"></textarea> 
			</td> 
		</tr>
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr align="center" valign="middle">
			<td colspan="5"> 
				<font size=2> 
				<a href="javascript:modifyform.submit()">[수정]</a>&nbsp;&nbsp; 
				<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp; 
				</font> 
			</td> 
		</tr> 	
	</table>
</form>
</body>
</html>