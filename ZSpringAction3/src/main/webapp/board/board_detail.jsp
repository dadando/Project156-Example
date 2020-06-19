<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.bid.board.*" %>
<%
	String id=(String)session.getAttribute("id");
	BoardVO bvo = (BoardVO)request.getAttribute("bvo");
	String writerId = bvo.getId();
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
			width:500px;
		}
		
	</style>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function goBack() {
		  window.history.back();
		}
		
		$(document).ready(function(){
			bidList(); //페이지 로딩시 응찰 목록 출력 
		});
		
		//해당 경매의 일련 번호
		var bno = <%=bvo.getNum()%>;
		var sessionid = '<%=id%>';	  
		//즉시구매가를 경매의 상한가로 설정.
		var limit_price = <%=bvo.getEnd_price()%>;
		
		function bidList(){
			$.ajax({
				url : '/bid/bid_list.bo',
				type : 'post',
				data : {'bno':bno},
				dataType : 'json',
				contentType : 'application/x-www-form-urlencoded; charset=utf-8',
				success : function(data){
					var a='';
					$.each(data,function(key,value){
						a += '<div class="divArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
						a += '<div class="divInfo'+value.cno+'">'+'응찰번호: '+value.bidno+' /응찰가격:'+value.now_price+' /응찰자 : '+value.writer+' /시간: 몇시간전';
						a += '</div></div>';
						//응찰하다가 응찰가격이 즉시구매가랑 동일하게 될때 
						//응찰리스트 추가 후 응찰하기 버튼 비활성화
						if(value.now_price==limit_price){
							document.getElementById("bid_btn").disabled = true;
						}
					});
					$(".bid_list").html(a);
				},
				error:function(){
					alert("ajax통신 실패(list)!!!");		
				}
			});
		}
		
		//응찰하기 
		function bidInsert(){
			$.ajax({
				url: '/bid/bid_insert.bo',
				type : 'POST',
				data : {'bno':bno,'writer':sessionid},
				success : function(data){
					if(data==1){
						bidList(); //페이지 로딩시 응찰 목록 갱신
						window.location.reload(true);
					}
					
				},
				error:function(){
					alert("ajax통신 실패(insert)");
				}
			});
		}
		
	</script>
	
</head>
<body>
<div align="center">
<fieldset id="board_detail_form">
<legend>경매장</legend>	
	<ul>
		<li>
			<label for="id">판매자</label>
			<%=bvo.getId() %>
		</li>
		<li>
			<label for="subject">제 목</label>
			<%=bvo.getSubject() %>
		</li>
		<li>
			<label for="start_price">시작가</label>
			<%=bvo.getStart_price() %>
		</li>
		<li>
			<label for="now_price">현재가</label>
			<%=bvo.getNow_price() %>
		</li>
		<li>
			<label for="end_price">즉시 구매가</label>
			<%=bvo.getEnd_price() %>
		</li>
		<li>
			<label for="boarddate">등록일</label>
			<%=bvo.getBoarddate() %>
		</li>
	</ul>
	<button type="button" id="bid_btn" onclick="bidInsert()">응찰하기</button>
	<button onclick="goBack()">뒤로가기</button>
	<%if(id.equals(writerId)){ %>
	<button onclick="location.href='#'">삭제</button>
	<%} %>
</fieldset>
<div>응찰자 리스트</div>
<fieldset class="bid_list">
	
</fieldset>
</div>
</body>
</html>