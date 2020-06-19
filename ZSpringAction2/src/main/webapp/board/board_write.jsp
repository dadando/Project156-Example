<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		ul{
			list-style:none;
			margin:0px;
    		padding: 0px;
   			width:100%;
		}
		li{
			padding: 5px 10px;
			margin-bottom: 2px;
		}
		label{
			float: left;
			font-size: 13px;
			width: 110px;
		    font-style: italic;
		    font-weight: bold;
		}
		fieldset{
			width:400px;
		}
		
	</style>
	<script>
		function goBack() {
		  window.history.back();
		}
	</script>
</head>
<body>
<div align="center">
<fieldset id="board_write_form">
<legend>경매 등록</legend>
<form name = "board_write" action="./boardinsert.bo" method="post">
<input type="hidden" name="id" value="<%=id %>"/>
	<ul align="center" cellpadding="0" cellspacing="0">
		<li>
			<label>판매자 아이디</label>
			<%=id %>
		</li>
		<li>
			<label for="subject">제목</label>
			<input type="text" id="subject" name="subject" required>
		</li>
		<li>
			<label for="start_price">시작가</label>
			<input type="number" id="start_price" name="start_price" required>
		</li>
		<li>
			<label for="end_price">즉시 구매가</label>
			<input type="number" id="end_price" name="end_price" required>
		</li>
	</ul>
	<button type="submit">등록</button>
	<button onclick="goBack()">뒤로</button>
</form>
</fieldset>
</div>
</body>
</html>