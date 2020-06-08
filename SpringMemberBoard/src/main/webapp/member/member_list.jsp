<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="java.util.*" %>
<%@ page import = "com.spring.memberboard.member.*" %>

<%
	if ((session.getAttribute("id")==null) || 
	  (!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	}
	
	ArrayList<MemberVO> member_list = 
			(ArrayList<MemberVO>)request.getAttribute("member_list");
%>
<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<table border=1 width=400 align=center>
	<tr align=center><td colspan=3>회원 목록</td></tr>
<%
	for (int i=0; i<member_list.size(); i++)
	{	
		MemberVO vo = (MemberVO)member_list.get(i);
%>
	<tr align=center>
		<td width=250>
			<a href="memberinfo.me?id=<%=vo.getId() %>"><%=vo.getId() %></a>
		</td>
		<td width=75>
			<a href="updateform.me?id=<%=vo.getId() %>">수정</a>
		</td>
		<td width=75><a href="memberdelete.me?id=<%=vo.getId() %>">삭제</a></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>