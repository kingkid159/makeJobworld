<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" href="${contextPath}/resources/css/eduDetail.css?ver=3">
</head>
<body>
	<div class="detailbox">
		<div class='title'>${eduVO.title}</div>
		<div class="info">
			<div class="academyinfo">
				<img src='${eduVO.imgsrc}' width='210' height='150'><br/>
				<div class="academyname">
					${eduVO.academy_name}	
				</div>
				<div class="academyadd">
					<div class='category'>회사주소</div>
					<div class='content'>${eduVO.academy_add}</div>
				</div>
			</div>
			<div class="educationinfo">
				<div class="category">교육분야</div>
				<div class='content'>${eduVO.edu_field}</div>
				<div class="category">교육형태</div>
				<div class='content'>${eduVO.edu_type}</div>
				<div class="category">모집과정</div>
				<div class='content'>${eduVO.edu_process}</div>
				<div class="category">모집인원</div>
				<div class='content'>${eduVO.edu_count}</div>
				<div class="category">교육기간</div>
				 <div class='content'>${eduVO.edu_period}</div>
				<div class="category">교육지역</div>
				<div class='content'>${eduVO.edu_location}</div>
				<div class="category">교육비용</div>
				<div class='content'>${eduVO.edu_price}</div>
				<div class="category">수강특전</div>
				<div class='content'>${eduVO.edu_privilege}</div>
				<div class="category">접수기간</div>
				<div class='content'>${eduVO.edu_app_period}</div>
				<div class="category">신청·문의</div>
				<div class='content'>${eduVO.academy_phone}</div>
				<c:if test="${memberVO.id eq eduVO.reg_id or memberVO.id eq 'admin'}">
					<div class='buttonContain'>
						<button class='btnModify' data-filter='ModifyForm'>수정</button>
						<a class='btnDelete'href="${contextPath}/job/eduDelete.do?eno=${eduVO.eno}">삭제</a>
					</div>
				</c:if>
			</div>
		</div>
		<div style="margin:70px; text-align:center;">	
			<a id="backbtn" href="${contextPath}/job/eduList.do">목록</a>
		</div>	
	</div>
	
<c:if test="${memberVO.id eq eduVO.reg_id or memberVO.id eq 'admin'}">
	<div class='formContain'>
		<form class='form' action="${contextPath}/job/eduModify.do" method="post" data-type='ModifyForm'>
			<div class="detailbox">
				<div class='title'>
					<input class='titleV' type="text" name="title" value="${eduVO.title}">
				</div>
				<div class="infoM">
					<div class="academyinfo">
						<img src='${eduVO.imgsrc}' width='200' height='150'><br/>
						<div class="academynameM">
							<input class="academynameValue" type="text" name="academy_name" value="${eduVO.academy_name}">
						</div>
						<div class="academyaddM">
							<span class='category'>회사주소</span>
							<div class='content'>
								<input type="text" name="academy_add" value="${eduVO.academy_add}">
							</div>
						</div>
					</div>
					<div class="educationinfo">
						<div class="category">교육분야</div>
						<div class='content'>
							<input class='contentV'type="text" name="edu_field" value="${eduVO.edu_field}">
						</div>
						<div class="category">교육형태</div>
						<div class='content'>
							<input class='contentV' type="text" name="edu_type" value="${eduVO.edu_type}">
						</div>
						<div class="category">모집과정</div>
						<div class='content'>
							<input class='contentV' type="text" name="edu_process" value="${eduVO.edu_process}">
						</div>
						<div class="category">모집인원</div>
						<div class='content'>
							<input class='contentV' type="text" name="edu_count" value="${eduVO.edu_count}">
						</div>
						<div class="category">교육기간</div>
						 <div class='content'>
						 	<input class='contentV' type="text" name="edu_period" value="${eduVO.edu_period}">
						 </div>
						<div class="category">교육지역</div>
						<div class='content'>
							<input class='contentV' type="text" name="edu_location" value="${eduVO.edu_location}">
						</div>
						<div class="category">교육비용</div>
						<div class='content'>
							<input class='contentV' type="text" name="edu_price" value="${eduVO.edu_price}">
						</div>
						<div class="category">수강특전</div>
						<div class='content'>
							<input class='contentV' type="text" name="edu_privilege" value="${eduVO.edu_privilege}">
						</div>
						<div class="category">접수기간</div>
						<div class='content'>
							<input class='contentV' type="text" name="edu_app_period" value="${eduVO.edu_app_period}">
						</div>
						<div class="category">신청·문의</div>
						<div class='content'>
							<input class='contentV' type="text" name="academy_phone" value="${eduVO.academy_phone}">
						</div>
						<div class='buttonContain'>
							<input class='btnModify' type="submit" value="수정">
							<a class='btnDelete' href="${contextPath}/job/eduDelete.do?eno=${eduVO.eno}">삭제</a>
						</div>
					</div>
				</div>		
			</div>
			<input type="hidden" name="eno" value="${eduVO.eno}">
			<input type="hidden" name="imgsrc" value="${eduVO.imgsrc}">
			<div style="margin:70px; text-align:center;">	
			<a id="backbtn" href="${contextPath}/job/eduList.do">목록</a>
		</div>	
		</form>
	</div>
</c:if>
<script>
	'use strict';
	var button = document.querySelector('.btnModify');
	var form = document.querySelector('.form');
	var detail = document.querySelector('.detailbox');
	button.addEventListener('click',(e)=>{
		var filter = e.target.dataset.filter;
		console.log(filter);
			if(filter === form.dataset.type){
				form.classList.add('visible');
				detail.classList.add('invisible');
			}
		
	});
</script>
</body>
</html>