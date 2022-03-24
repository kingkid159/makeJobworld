<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
#main_menu{
	background-color:skyblue;
}
a {
	display:block;	/*범위 확장*/
	text-decoration:none;
	color:white;
}
.sub_menu{
	display:none;	/*서브메뉴들 숨김*/
}
.selec{
	background: green; color: red;
}
</style>
<script>
	$(document).ready(function(){
		//메뉴 슬라이드
		$('#main_menu > li > a').click(function(){
			$(this).next($('.snd_menu')).slideToggle('fast');
		})
		$('.snd_menu > li > a').click(function(e){
			e.stopPropagation();
			$(this).next($('.trd_menu')).slideToggle('fast');
		})
		
		//버튼 클릭 시 스타일 변경
		$('li > a').focus(function(){
			$(this).addClass('selec');
		})
		$('li > a').blur(function(){
			$(this).removeClass('selec');
		})
	})
</script>
<title>side.jsp</title>
</head>
<body>
<nav>
	<ul id="main_menu">
		<li><a href="#">통계</a>
		<ul class="snd_menu sub_menu">
			<li><a href="#">웹프로게이머</a>
				<ul class="trd_munu sub_menu">
					<li><a href="#">웹개발</a></li>
					<li><a href="#">자바</a></li>
					<li><a href="#">백엔드</a></li>
					<li><a href="#">프론트</a></li>
					<li><a href="#">jsp</a></li>
				</ul>
			</li>
			
			<li><a href="#">HTML,퍼블리싱,UI개발</a>
				<ul class="trd_munu sub_menu">
					<li><a href="#">css</a></li>
					<li><a href="#">퍼블리셔</a></li>
					<li><a href="#">웹표준</a></li>
					<li><a href="#">자바스크립트</a></li>
					<li><a href="#">xml</a></li>
				</ul>
			</li>
			
			<li><a href="#">빅데이터</a>
				<ul class="trd_munu sub_menu">
					<li><a href="#">데이터분석</a></li>
					<li><a href="#">인공지능</a></li>
					<li><a href="#">빅데이터</a></li>
					<li><a href="#">파이썬</a></li>
					<li><a href="#">머신러닝</a></li>
				</ul>
			</li>
			
			<li><a href="#">시스템분석</a>
				<ul class="trd_munu sub_menu">
					<li><a href="#">pm</a></li>
					<li><a href="#">컨설팅</a></li>
					<li><a href="#">분석,설계</a></li>
					<li><a href="#">시스템엔지니어</a></li>
					<li><a href="#">데이터분석</a></li>
				</ul>
			</li>
			
			<li><a href="#">데이터베이스</a>
				<ul class="trd_munu sub_menu">
					<li><a href="#">SQL</a></li>
					<li><a href="#">DBA</a></li>
					<li><a href="#">MS-SQL</a></li>
					<li><a href="#">Oracle DB</a></li>
					<li><a href="#">MySQL</a></li>
				</ul>
			</li>
		
		</ul>
	</li>
</nav>
</body>
</html>