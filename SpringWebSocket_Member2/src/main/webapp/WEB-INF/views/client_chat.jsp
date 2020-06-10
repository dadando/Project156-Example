<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.Map" %>
<%
	String id=null;

	if (session.getAttribute("id")!=null){
		id=(String)session.getAttribute("id");
	}else{
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	}
%>
<html>
<head>
	<title>WebSocket</title>
	<script>
		
		var log = function(e){
			document.getElementById("output").textContent += (e+"\n");
		}
		w = new WebSocket("ws://localhost:8080/springspring/broadcasting");
		//w = new WebSocket("ws://localhost:8080/springwebsocket/broadcasting?id="+nicname);
		w.onopen = function(){
			alert("WebSocket Connected!!");
		}
		w.onmessage = function(e){
			log(e.data.toString());
		}
		w.onclose = function(e){
			log("WebSocket closed!");
		}
		w.onerror = function(e){
			log("WebSocket error!");
		}
		
		window.onload = function(){
			document.getElementById("send_button").onclick = function(){
				if(document.getElementById("nicname").value == ""){
					alert("별명을 입력하세요!!");
				}else{
					var nicname = document.getElementById("nicname").value;
					var input = document.getElementById("input");
					w.send(nicname + ">"+input.value);
					input.value=null;
					input.focus();
				}
			}
		}
		
	</script>
</head>
<body>
<input type="hidden" id="nicname" value=<%=id%>>
<input type="text" id="input" placeholder="input message..." size="55">
<button id="send_button">Send</button>
대화명:&nbsp; ${id} 
<p/>
<textarea id="output" readonly rows = "30" cols = "80"></textarea>
<a href="./logout.me">로그아웃</a>
<%if(id.equals("admin")){ %>
<a href="./memberlist.me">회원관리</a>
<%}%>
</body>
</html>
