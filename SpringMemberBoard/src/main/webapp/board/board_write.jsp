<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String id=(String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form name = "board_write" action="./boardinsert.bo" method="post">
<input type="hidden" name="id" value="<%=id %>"/>
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle"> 
		<td colspan="5"> 게시판 MVC </td> 
	</tr>
	<tr> 
		<td style="font-family:돋음; font-size:12" height="16">
		<div align="center">글쓴이</div>
	   	</td> 
	   	<td><%=id %></td> 
	</tr> 
	<tr> 
		<td style="font-family:돋음; font-size:12" height="16"> 
	    	<div align="center">제 목 </div>
	    </td> 
	    <td> 
	    	<input name="subject" type="text" size="50" 
	    		maxlength="100" value=""/> 
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
			<a href="javascript:board_write.submit()">[등록]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>