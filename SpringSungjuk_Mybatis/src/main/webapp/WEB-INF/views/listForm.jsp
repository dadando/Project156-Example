<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.spring.springsungjuk_mybatis.*" %>
<%--
create table sungjuk(
    hakbun varchar2(6),
    name varchar2(10),
    kor number(3),
    eng number(3),
    math number(3),
    tot number(3),
    avg number(5,2),
    grade varchar2(4),
    primary key(hakbun)
);
desc sungjuk;
select * from sungjuk;
--%>

<%
	ArrayList<SungjukVO> sungjuk_list = 
		(ArrayList<SungjukVO>)request.getAttribute("sungjuk_list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width=300 align=center>
	<tr align=center>
		<td colspan=2>성적목록</td>
		<td><a href="inputform.me">성적입력</a></td>
	</tr>
<%
	if(sungjuk_list.size()==0){
%>
	<tr align=center>
		<td colspan=3>입력된 성적 정보가 없습니다.</td>
	</tr>
<% 		
	}else{
	for(int i=0;i<sungjuk_list.size(); i++){
		SungjukVO vo = sungjuk_list.get(i);
%>
	<tr align=center>
		<td>
			<a href="sungjukinfo.me?hakbun=<%=vo.getHakbun() %>"><%=vo.getHakbun()%></a>
		</td>
		<td>
			<a href="sungjukupdate.me?hakbun=<%=vo.getHakbun() %>">수정</a>
		</td>
		<td>
			<a href="sungjukdelete.me?hakbun=<%=vo.getHakbun() %>">삭제</a>
		</td>
	</tr>
<%
	}}
%>
</table>
</body>
</html>