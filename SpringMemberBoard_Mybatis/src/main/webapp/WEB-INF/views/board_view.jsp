<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="com.spring.memberboard_mybatis.*" %>
<%
	String sessionid = null;
	if(session.getAttribute("id")!=null){
		sessionid = (String)session.getAttribute("id");
	}
	BoardVO bvo = (BoardVO)request.getAttribute("bvo");
	String writerid = bvo.getId();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" align=center>
	<tr align="center" valign="middle">
		<td colspan="5">MVC 게시판</td>
	</tr>
	<tr> 
		<td style="font-family: 돋음; font-size:12" height="16"> 
			<div align="center">제 목 &nbsp;&nbsp;</div>
		</td>
		<td style="font-family: 돋음; font-size:12"> 
		${bvo.getSubject()}
		</td> 
	</tr>
	<tr bgcolor="cccccc"> 
		<td colspan="2" style="height:1px;"> </td> 
	</tr>
	<tr> 
		<td style="font-family:돋음; font-size:12"><div align="center">내 용 </div> </td> 
		<td style= 돋음 "font-family: ; font-size:12"> 
			<table border=0 width=490 height=250 style="table-layout:fixed"> 
				<tr> <td valign=top style= 돋음 "font-family: ; font-size:12"> 
					${bvo.getContent()} </td> 
				</tr> 
			</table> 
		</td> 
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">첨부파일</div>
		</td>
		<td style="font-family:돋음; font-size:12">
		<%if(!(bvo.getOrg_file()==null)){ %>
		<a href="./filedownload.bo?num=<%=bvo.getOrg_file()%>&of=<%=bvo.getUp_file()%>&of2=<%=bvo.getOrg_file()%>">
			<%=bvo.getOrg_file()%>
		</a>
		<%} %>
		</td>
	</tr> 
	<tr bgcolor="cccccc"> 
		<td colspan="2" style="height:1px;"></td> 
	</tr> 
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5"> 
			<font size=2> 
			<a href="./boardreplyform.bo?num=${bvo.getNum()}">[답변]</a>&nbsp;&nbsp; 
			<%if((sessionid!=null && sessionid.equals(writerid))||(sessionid.equals("admin"))){%>
			<a href="./boardmodifyform.bo?num=${bvo.getNum()}">[수정]</a>&nbsp;&nbsp; 
			<a href="./boraddelete.bo?num=${bvo.getNum()}">[삭제]</a>&nbsp;&nbsp; 
			<%} %>
			<a href="./boardlist.bo">[목록]</a>&nbsp;&nbsp; 
			</font> 
		</td> 
	</tr>
</table>
</body>
</html>