<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
    <link href="./resources/css/loginform.css" rel="stylesheet" type="text/css">
    <link href="./resources/css/modal.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js" charset="utf-8"></script>
    <script>
    //로그인 modal
    $(document).ready(function() {
	    //Get the modal
        var loginmodal = document.getElementById('loginModal');
		var joinmodal = document.getElementById('joinModal');
        // Get the button that opens the modal
        var loginbtn = document.getElementById("loginBtn");
		var joinbtn = document.getElementById("joinBtn");
		
        // Get the <span> element that closes the modal
        var close0 = document.getElementsByClassName("close")[0];                                          
		var close1 = document.getElementsByClassName("close")[1];
		var close2 = document.getElementsByClassName("close")[2];
		
        // When the user clicks on the button, open the modal 
        loginbtn.onclick = function(event) {
        	loginmodal.style.display = "block";
        }
		joinbtn.onclick = function(event){
			joinmodal.style.display = "block";
		}
        // When the user clicks on <span> (x), close the modal
        close0.onclick = function(event) {
        	loginmodal.style.display = "none";
        }
        close1.onclick = function(event){
			joinmodal.style.display = "none";
		}
        close2.onclick = function(event){
			joinmodal.style.display = "none";
		}
        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == loginmodal) {
            	loginmodal.style.display = "none";
            }
            if(event.target == joinmodal){
            	joinmodal.style.display = "none";
            }
        }
        
    });
    </script>   
</head>
<body>
<a id="loginBtn">로그인</a> <!-- Trigger/Open The loginModal-->
<a id="joinBtn">회원가입</a> <!-- Trigger/Open The joinModal-->
<!-- The Modal(로그인) -->
<div id="loginModal" class="modal">
	 
	<!-- Modal content(로그인) -->
	<div class="modal-content">
		<span class="close">&times;</span>   
		
        <fieldset id="login_menu">
            <form id="login_form" action="./login.me" method="post">
                <ul>
                    <li>
                        <label for="userId">아이디</label> <!--id의 이름이 같은 태그에 이름을 붙이는 label태그-->
                        <input type="text" id="userId" name="userId" required autofocus>
                    </li>
                    <li>
                        <label for="userPW">패스워드</label>
                        <input type="password" id="userPW" name="userPW" required>
                    </li>
                </ul>
                <button type="submit" id="login_btn">로그인</button>
            </form>
        </fieldset>
    
    </div>
</div>

<!-- The Modal(회원가입) -->
<div id="joinModal" class="modal">
	
	<!-- Modal content(회원가입) -->
	<div class="modal-content">
		<span class="close">&times;</span>
		
		<fieldset id="join_menu">
			<form id="join_form" action="./join.me" method="post">
				<ul>
					<li>
						<label for="id">아이디</label>
						<input type="text" id="id" name="id" required autofocus>
					</li>
					<li>
						<label for="password">비밀번호</label>
						<input type="password" id="password" name="password" required>
					</li>
					<!-- <li>
						<label for="password_check">비밀번호 확인</label>
						<input type="password" id="password_check" name="password_check" required>
					</li> -->
					<li>
						<label for="name">이 름</label>
						<input type="text" id="name" name="name" required>
					</li>
					<li>
						<label for="age">나 이</label>
						<input type="number" id="age" name="age" required>
					</li>
					<li>
						<label for="gender">성별</label>
						<input type="radio" id="gender" name="gender" value="남" checked>남자
						<input type="radio" id="gender" name="gender" value="여">여자
					</li>
					<li>
						<label for="email">이메일</label>
						<input type="text" id="email" name="email" required>
					</li>
				</ul>
				<button type="submit" id="join_btn">회원가입</button>
				<button class="close" id="join_close">취 소</button>
			</form>
		</fieldset>
	</div>
</div>
</body>
</html>