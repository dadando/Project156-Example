<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./resources/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
    <title>All-tion</title>
    <style>
    </style>
    <script>
	   
    </script>
</head>
<body>
    <!-- 모든 페이지 공통 영역 by 하나  -->
    <!-- 광고 배너 및 헤더 -->
    <div class="ad__banner">
        <a href="#" class="ad__banner--link">
            <img src="./resources/img/header/adEx.png" class="ad__banner--img">
            <button class="ad__banner--closeBtn"></button>
        </a>
    </div>
    <div class="header">
        <div class="upper_header">
            <div class="upper_header--nav">
                <p>
                    <a href="">고객 센터</a>
                </p>
                <ul>
                    <li>
                        <a href="#">로그인</a>
                    </li>
                    <li>
                        <a href="#">회원 가입</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="lower_header">
            <div class="lower_header--nav">
                <h1 class="logo">
                    <a href="#">ALL-TION</a>
                </h1>
                <div class="category">
                    <a class="category--drop">
                        <img src="./resources/img/header/category_tab.png">
                    </a>
                </div>
                <div class="search">
                    <select class="search--select">
                        <option value="">전체</option>
                        <option value="패션">패션</option>
                        <option value="뷰티">뷰티</option>
                        <option value="출산/유아동">출산/유아동</option>
                        <option value="전자기기">전자기기</option>
                        <option value="가전제품">가전제품</option>
                        <option value="가구/인테리어">가구/인테리어</option>
                        <option value="반려동물/취미">반려동물/취미</option>
                        <option value="도서/음반/문구">도서/음반/문구</option>
                        <option value="티켓/쿠폰">티켓/쿠폰</option>
                        <option value="스포츠">스포츠</option>
                        <option value="공구/산업용품">공구/산업용품</option>
                        <option value="기타잡화">기타잡화</option>
                    </select>
                    <input type="text" placeholder="찾으시는 상품을 입력해 주세요" class="search__input">
                </div>
                <ul class="member_info">
                <li>
                    <a href="#">
                        <span class="material-icons">perm_identity</span>
                        <span>마이 페이지</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="material-icons">turned_in_not</span>
                        <span>찜 목록</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="material-icons">access_time</span>
                        <span>참여 경매</span>
                    </a>
                </li>
            </ul>
            </div>
        </div>
    </div>
    
    <!--  !! 여기에 내용 넣기 !!  by.Hong  -->
    <div class="main_body" align="center">
        <div class="slideshow-container">

			<div class="mySlides fade">
				<div class="numbertext">1 / 3</div>
				<img src="./resources/images/1.jpg" style="width:100%">
				<div class="text">Caption One</div>
			</div>
			
			<div class="mySlides fade">
				<div class="numbertext">2 / 3</div>
				<img src="./resources/images/2.jpg" style="width:100%">
				<div class="text">Caption Two</div>
			</div>
			
			<div class="mySlides fade">
				<div class="numbertext">3 / 3</div>
				<img src="./resources/images/3.jpg" style="width:100%">
				<div class="text">Caption Three</div>
			</div>
			
			</div>
			<br>
			
			<div style="text-align:center">
				<span class="dot"></span> 
				<span class="dot"></span> 
				<span class="dot"></span> 
			</div>
    </div>
    
    <!-- 푸터 영역 -->
    <div class="footer">
        <div class="upper_footer">
            <ul class="upper_footer--list">
                <li>
                    <a href="#">
                        올션소개
                    </a>
                </li>
                <li>
                    <a href="#">
                        채용정보
                    </a>
                </li>
                <li>
                    <a href="#">
                        공지사항
                    </a>
                </li>
                <li>
                    <a href="#">
                        이용약관
                    </a>
                </li>
                <li>
                    <a href="#">
                        개인정보처리방침
                    </a>
                </li>
                <li>
                    <a href="#">
                        전자금융거래약관
                    </a>
                </li>
                <li>
                    <a href="#">
                        제휴서비스
                    </a>
                </li>
            </ul>
        </div>
        <div class="lower_footer">
            
        </div>        
    </div>
    
    <!--  스크립트 영역  -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            // 광고 없애기
            $(".ad__banner--closeBtn").click(function(){
                $(".ad__banner").hide();
			})
            
            // 헤더 고정
            var header = $('.lower_header');
            $(window).scroll(function(){
                if($(this).scrollTop() > 0){
                        header.addClass('sticky');
                   }else{
                        header.removeClass('sticky');
                   }
            })
            
            // 카테고리 누를 때마다 이동
        });
    </script>
</body>
</html>