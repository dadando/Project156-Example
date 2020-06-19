<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.spring.bid.board.BoardVO" %>
<%
	String id = null;
	if(session.getAttribute("id")!=null){
		id = (String)session.getAttribute("id");
	}
	ArrayList<BoardVO> boardList = (ArrayList<BoardVO>)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue (); 
	int nowpage=((Integer)request.getAttribute("page")).intValue(); 
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue ();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 접속중인 사용자: ${id}
<table width=570 border="0" cellpadding="0" cellspacing="0" align="center">
	<tr align="center" valign="middle"> 
		<td colspan="4"> 게시판 MVC </td> 
		<td align=right> <font size=2>글 개수  : ${listcount }</font></td> 
	</tr>
	<tr align="center" valign="middle" bordercolor="#333333"> 
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26"> 
			<div align="center">번호</div> 
		</td> 
		<td style="font-family:Tahoma;font-size:8pt;" width="50%"> 
			<div align="center">제목</div> 
		</td> 
		<td style="font-family:Tahoma;font-size:8pt;" width="14%"> 
			<div align="center">작성자</div> 
		</td> 
		<td style="font-family:Tahoma;font-size:8pt;" width="17%"> 
			<div align="center">날짜</div>
		</td> 
		<td style="font-family:Tahoma;font-size:8pt;" width="11%"> 
			<div align="center">조회수</div> 
		</td> 
	</tr>
	<%
		int num = listcount -((nowpage- 1)* 10);
		for(int i=0;i<boardList.size();i++){
			BoardVO bvo = (BoardVO)boardList.get(i);
	%>
	<tr align="center" valign="middle" bordercolor="#333333" 
		onmouseover="this.style.backgroundColor='F8F8F8'" 
		onmouseout="this.style.backgroundColor=''"> 
		<td height="23" style="font-family:Tahoma;font-size:10pt;"> 
			<%=bvo.getNum()%>
			<%--=num --%>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;"> 
			<div align="left"> 
			<a href="./boarddetail.bo?num=<%=bvo.getNum()%>">
			<%=bvo.getSubject() %></a>
			</div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;"> 
			<div align="center"><%=bvo.getId() %></div> 
		</td> 
		<td style="font-family:Tahoma;font-size:10pt;"> 
			<div align="center"><%=bvo.getBoarddate()%></div> 
		</td> 
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bvo.getReadcount()%></div> 
		</td> 	
	</tr>
	<%num--;} %> <!-- for문 끝 -->
	<tr align=center height=20> 
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;> 
			<%if(nowpage<=1){ %> 
			[이전]&nbsp; 
			<%}else{ %> 
			<a href="./boardlist.bo?page=<%=nowpage-1 %>"> [이전]</a>&nbsp; 
			<%} %> 
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./boardlist.bo?page=<%=a %>">[<%=a %>]</a>
				<%} %>
			<%} %>
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{%>
			<a href="./boardlist.bo?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<tr align="right"> 
		<td colspan="5"> 
			<%if(id!=null && id.equals("admin")){%> 
				<a href="./memberlist.me">[회원관리]</a> 
			<%}%>   
			<a href="./boardwrite.bo">[글쓰기]</a> 
		</td> 
	</tr>
	<tr align="center">
		<td colspan="5">
			<a href="./logout.me">[로그아웃]</a>
		<td>
	</tr>
</table>
</body>
</html>