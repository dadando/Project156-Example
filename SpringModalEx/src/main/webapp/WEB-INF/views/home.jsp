<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="./resources/css/register.css" rel="stylesheet" type="text/css">
	<style>
	/* The Modal 스타일 시작 --------------------------------> */
	/* The Modal (background) */
	.modal {
	    display: none; /* Hidden by default */
	    position: fixed; /* Stay in place */
	    z-index: 1; /* Sit on top :  숫자가 클수록 상단에 위치 */
	    left: 0;
	    top: 0;
	    width: 100%; /* Full width */
	    height: 100%; /* Full height */
	    overflow: auto; /* Enable scroll if needed */
	    background-color: rgb(0,0,0); /* Fallback color */
	    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
	
	/* Modal Content/Box */
	.modal-content {
	    background-color: #fefefe;
	    margin: 15% auto; /* 15% from the top and centered */
	    padding: 20px;
	    border: 1px solid #888;
	    width: 50%; /* Could be more or less, depending on screen size */                          
	}
	/* The Close Button */
	.close {
	    color: #aaa;
	    float: right;
	    font-size: 28px;
	    font-weight: bold;
	}
	.close:hover,
	.close:focus {
	    color: black;
	    text-decoration: none;
	    cursor: pointer;
	}
	/* The Modal 스타일 끝 <---------------------------------- */
	</style>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js" charset="utf-8"></script>
	<script>
	$(document).ready(function() {
		//Get the modal
		var modal = document.getElementById('myModal');
	
		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");
		
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];                                          
	
		// When the user clicks on the button, open the modal 
		btn.onclick = function(event) {
		    modal.style.display = "block";
		}
	
		// When the user clicks on <span> (x), close the modal
		span.onclick = function(event) {
		    modal.style.display = "none";
		}
	
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
	});
	</script>
</head>
<body>

<!-- Trigger/Open The Modal -->
<button id="myBtn">Open Modal</button>
 
<!-- The Modal -->
<div id="myModal" class="modal">
	 
	<!-- Modal content -->
	<div class="modal-content">
		<span class="close">&times;</span>                                                               
<form>
<fieldset id="join_menu">
<legend>회원 기본 정보</legend>
<ol>
  <li>
    <label for="userid">아이디</label>
    <input type="text" id="userid" name="userid" required autofocus 
			placeholder="영문,숫자 사용. 10자미만">
  </li>
  <li>
    <label for="pwd1">비밀번호</label>
    <input type="password" id="pwd1" name="pwd1" required 
			placeholder="영문,숫자 사용. 6~10자리">
  </li>
  <li>
    <label for="pwd2">비밀번호 확인</label>
    <input type="password" id="pwd2" name="pwd2" required>
  </li> 
	
	<li>
    <label for="fullname">이름</label>
    <input type="text" id="fullname" name="fullname"  required>
  </li>
	<li>		<label for="age">나이</label>
    <input id="age" name="age" type="number" min="1" max="65" step="1">
  </li> 
	<li>
		<label for="birth">생일</label>
    <input id="birth" name="birth" type="date">
  </li> 
  <li>
    <label for="email">이메일 주소</label>
    <input id="email" name="email" type="email" autocomplete="off" 
			placeholder="zoca01@icore.com" required >
  </li>
  <li>
    <label for="tel">핸드폰</label>
    <input id="tel" name="tel" type="tel" autocomplete="off">
  </li>
</ol>
</fieldset>

<fieldset>
<legend>회원 추가 정보</legend>
<ol>
 <li>
    <label for="job">직업</label>
    <input list="job" name="job" >
		<datalist id="job">
			<option value="회사원">
			<option value="교사">
			<option value="프로그래머">
			<option value="자영업">
			<option value="기타">
		</datalist>
  </li>
  <li>
		<label for="office">오피스 활용</label>
    <input id="office" name="com" type="range" min="1" max="5" step="1">
  </li>  
</ol>
</fieldset>
<fieldset>
  <button type="submit"> 입력 </button> 
</fieldset>
</form>
	</div>
 
</div>
</body>
</html>