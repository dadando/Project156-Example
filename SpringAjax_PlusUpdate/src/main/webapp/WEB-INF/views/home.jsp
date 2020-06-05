<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- 
create table people(
  id varchar2(10) primary key,
  name varchar2(20),
  job varchar2(20),
  address varchar2(40),
  bloodtype varchar2(2)
);
 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>데이터 베이스 연동</title>
	<style type="text/css">
	 form{
	  width:500px;
	  margin:10px auto;
	 }
	 ul{
	  padding:0;
	  margin:0;
	  list-style:none;
	 }
	 ul li{
	  padding:0;
	  margin:0 0 10px 0;
	 }
	 label{
	  width:150px;
	  float:left;
	 }
	 table {
	  border:1px solid gray;
	  width:500px;
	  margin:0 auto;
	  border-collapse: collapse;
	 }
	 td{
	  border:1px solid gray;
	 }
	 a{
	 text-decoration: none;
	 color: hotpink;
	 }
	 a:hover{
	 color: silver;
	 }
	 a:active{
	 color: gold;
	 }
	 ul li input:focus{
	  background-color: black;
	  color: white;
	 }
	</style>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript">
	//목록
	function selectData(){
		$('#output').empty(); //table내부 내용을 제거(초기화)
		
		$.ajax({
			url:'/springajax/getPeopleJSON.do',
			//url:'./getPeopleJSON.do',
			type:'POST',
			dataType : "json", //서버에서 보내줄 데이터 타입
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			success:function(data){
				$.each(data,function(index,item){	//index: each가 실행될 때 만들어지는 일련번호(0부터 시작)
													//data는 item으로 전달된다.(People에 대한 List객체)
					var output='';
					output+='<tr align=center>';
					output+='<td width=70px>'+item.id+'</td>';
					output+='<td width=80px>'+item.name+'</td>';
					output+='<td width=100px>'+this.job+'</td>';
					output+='<td width=120px>'+this.address+'</td>';
					output+='<td width=30px>'+this.bloodtype+'</td>';
					output+='<td width=100px><a href="/springajax/selectPeople.do" class="updateform_data" id="'+item.id+'">수정</a>&nbsp;&nbsp;'
					output+='<a href="/springajax/deletePeople.do" class="delete_data" id="'+item.id+'">삭제</a></td>';
					output+='</tr>';
					console.log("output:"+output);
					$('#output').append(output); //append 첨부하다  
					//id가 output인 <table>태그안에 output이 추가된다.
				});
			},
			error:function(){
				alert("ajax통신 실패!!!");
			}
		});
	}
	
	
	$(document).ready(function(){
		$(document).on('click','#input_data',function(event){
			var params=$("#insert_form").serialize();
			alert(params);
			jQuery.ajax({
				url:'/springajax/insertPeople.do',
				type:"POST",
				data: params, // 서버로 보낼 데이터
				contentType: 'application/x-www-form-urlencoded; charset=utf-8',
				dataType: "json", // 서버에서 보내줄 데이터 타입
				success: function(retVal){
					if(retVal.res == "OK"){
						//데이터 성공일때 이벤트 작성
						selectData();
						//초기화
						$("#id").val('');
						$('#name').val('');
						$('#job').val('');
						$('#address').val('');
						$('#bloodtype').val('');
					}
					else{
						alert("Insert Fail!!");
					}
				},
				error:function(){
					alert("ajax통신 실패!!!");
				}
			});
			//기본 이벤트 제거
			event.preventDefault();
		});
		
		$(document).on('click','.updateform_data',function(event){
			jQuery.ajax({
				url:$(this).attr("href"),  //this는 가르키고 있는 해당항목을 나타낸다.(여기서는 a태그.)
				type:"GET",
				data: {'id': $(this).attr("id")},
				contentType: 'application/x-www-form-urlencoded; charset=utf-8',
				dataType: "json", // 서버에서 보내줄 데이터 타입
				success: function(vo){
					var output='';
					output+='<td><input type="hidden" name="id" value="'+vo.id+'">'+vo.id+'</td>';
					output+='<td><input type="text" size="3" name="name" value="'+vo.name+'"></td>';
					output+='<td><input type="text" size="5" name="job" value="'+vo.job+'"></td>';
					output+='<td><input type="text" size="5" name="address" value="'+vo.address+'"></td>';
					output+='<td><input type="text" size="2" name="bloodtype" value="'+vo.bloodtype+'"></td>';
					output+='<td><a href="/springajax/updatePeople.do" class="update_data">수정</a>&nbsp;&nbsp;'
					output+='<a href="/springajax/home.do">목록</a></td>';
			
					$('#'+vo.id+'').parent().parent().html(output);
					
				},
				error:function(){
					alert("ajax통신 실패!!!");
				}
			});

			event.preventDefault();
			
		});
		
		
		
		$(document).on('click','.delete_data',function(event){
			jQuery.ajax({
				url:$(this).attr("href"),  //this는 가르키고 있는 해당항목을 나타낸다.(여기서는 a태그.)
				type:"GET",
				data: {'id': $(this).attr("id")},
				contentType: 'application/x-www-form-urlencoded; charset=utf-8',
				dataType: "json", // 서버에서 보내줄 데이터 타입
				success: function(retVal){
					if(retVal.res == "OK"){
						//데이터 성공일때 이벤트 작성
						selectData();
						
					}
					else{
						alert("Delete Fail!!");
					}
				},
				error:function(){
					alert("ajax통신 실패!!!");
				}
			});

			event.preventDefault();
		});
		
		$(document).on('click','.update_data',function(event){
			var params=$("#update_form").serialize();
			alert(params);
			jQuery.ajax({
				url:$(this).attr("href"),  //this는 가르키고 있는 해당항목을 나타낸다.(여기서는 a태그.)
				type:"GET",
				data: params,
				contentType: 'application/x-www-form-urlencoded; charset=utf-8',
				dataType: "json", // 서버에서 보내줄 데이터 타입
				success: function(retVal){
					if(retVal.res == "OK"){
						//데이터 성공일때 이벤트 작성
						selectData();
						
					}
					else{
						alert("Update Fail!!");
					}
				},
				error:function(){
					alert("ajax통신 실패!!!");
				}
			});

			event.preventDefault();
		});
		
		selectData();
	});
	</script>
</head>
<body>
<form id="insert_form" method="post">
	<fieldset>
		<legend>데이터 추가</legend>
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name">
			</li>
			<li>
				<label for="job">직업</label>
				<input type="text" name="job" id="job">
			</li>
			<li>
				<label for="address">주소</label>
				<input type="text" name="address" id="address">
			</li>
			<li>
				<label for="bloodtype">혈액형</label>
				<input type="text" name="bloodtype" id="bloodtype">
			</li>
			<li>
				<input type="button" value="추가" id="input_data">
			</li>	
		</ul>
	</fieldset>
</form>
<form id="update_form" method="post">
	<table id="output"></table>
</form>
</body>
</html>