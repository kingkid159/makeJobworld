<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
 UPLOADCARE_PUBLIC_KEY="b6ffe008f9988edbd4ff"
</script>
<script charset="utf-8" src="//ucarecdn.com/widget/2.9.0/uploadcare/uploadcare.full.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/eduRegister.css">
</head>
<body>
<form action="${contextPath}/job/eduRegister.do" method="post" class="registerbox">
	<div class="title">제목:&nbsp;&nbsp;&nbsp;<input type="text" class="textinput"name="title" placeholder="제목을 입력하시오"></div>
	<div class="info">
		<div class="academyinfo">
			<div class="academylogo">
				기관로고:&nbsp;<input type="url" name="imgsrc"id="imgsrc" placeholder="이미지를 첨부하시면 자동 입력됩니다">
				<input type="hidden" role="uploadcare-uploader">
			</div>
			<div class="academyname">
				기관명:&nbsp;&nbsp;<input type="text" class="textinput" name="academy_name" placeholder="기관명을 입력하시오">
			</div>
			<div class="academyadd">
				기관주소:&nbsp;<input type="text" class="textinput" name="academy_add" placeholder="기관주소를 입력하시오">
			</div>
		</div>
	<div class="educationinfo">
		<div class="edu_field">교육분야:&nbsp;<input type="text" class="textinput" name="edu_field" placeholder="예시) 직업교육 인터넷·IT·통신·모바일·게임 웹프로그래머"></div>
		<div class="edu_type">교육형태:&nbsp;&nbsp;&nbsp;오프라인<input type="radio" name="edu_type" value="오프라인" checked>
									온라인<input type="radio" name="edu_type" value="온라인">		
		</div>
		<div class="edu_process">모집과정:&nbsp;<input type="text" class="textinput" name="edu_process" placeholder="예시) 자바,자바개발자,웹개발자"></div>
		<div class="edu_count">모집인원:&nbsp;<input type="text" class="textinput" name="edu_count" placeholder="예시) 10명"></div>
		<div class="edu_period">교육기간:&nbsp;<input type="text" class="textinput" name="edu_period" placeholder="예시) 2022.05.09~2022.11.03"></div>
		<div class="edu_location">교육지역:&nbsp;<input type="text" class="textinput" name="edu_location" placeholder="예시) 서울특별시 > 강남구"></div>
		<div class="edu_price">교육비용:&nbsp;<input type="text" class="textinput" name="edu_price" placeholder="예시) 무료,4380000원"></div>
		<div class="edu_privilege">수강특전:&nbsp;&nbsp;<input type="text" class="textinput" name="edu_privilege" placeholder="예시) 취업우대,이력서 및 자기소개서 작성법"></div> 
		<div class="edu_app_period">접수기간:&nbsp;&nbsp;<input type="text" class="textinput" name="edu_app_period" placeholder="예시) ~ 2022.09.03"></div>
		<div class="academy_phone">신청·문의번호:&nbsp;<input type="text" class="textinput" name="academy_phone" placeholder="예시) 02-1234-5678"></div>
	</div>
		<input type="hidden" name="reg_id" value="${memberVO.id}">
		<div class="btn">
			<input type="submit"class="submitbutton" value="등록하기"/>
			<input type="button" class="backbutton" onclick="location.href='${contextPath}/job/eduList.do';" value="돌아가기">
		</div>
	</div>
</form>
<script>
var singleWidget=uploadcare.SingleWidget('[role=uploadcare-uploader]');
singleWidget.onUploadComplete(function(info){
	document.getElementById('imgsrc').value = info.cdnUrl;
});
</script>
</body>
</html>