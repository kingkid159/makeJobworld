<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/chartHeader.css?ver=1">
<link rel="stylesheet" href="${contextPath}/resources/css/chart.css?ver=1">
</head>
<body>
<div class='contain'>
	<ul id="main-menu">
		<li>
			<a class='main-menu-title' href="${contextPath}/job/detailChart.do?job=웹프로그래머">웹프로게이머</a>
			<ul id="sub-menu">
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=웹프로그래머&jobDetail=웹개발">웹개발</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=웹프로그래머&jobDetail=자바">자바</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=웹프로그래머&jobDetail=백엔드">백엔드</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=웹프로그래머&jobDetail=프론트">프론트</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=웹프로그래머&jobDetail=jsp">jsp</a></li>
			</ul>
		</li>	
		<li>
			<a class='main-menu-title' href="${contextPath}/job/detailChart.do?job=퍼블리싱UI개발">HTML,퍼블리싱,UI개발</a>
			<ul id="sub-menu">
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=퍼블리싱UI개발&jobDetail=css">css</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=퍼블리싱UI개발&jobDetail=퍼블리셔">퍼블리셔</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=퍼블리싱UI개발&jobDetail=웹표준">웹표준</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=퍼블리싱UI개발&jobDetail=자바스크립">자바스크립트</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=퍼블리싱UI개발&jobDetail=xml">xml</a></li>
			</ul>
		</li>
		<li>
			<a class='main-menu-title' href="${contextPath}/job/detailChart.do?job=빅데이터AI">빅데이터·AI(인공지능)</a>
			<ul id="sub-menu">
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=데이터분석">데이터분석</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=인공지능">인공지능</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=빅데이터">빅데이터</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=파이썬">파이썬</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=머신러닝">머신러닝</a></li>
			</ul>
		</li>
		<li>
			<a class='main-menu-title' href="${contextPath}/job/detailChart.do?job=ERP·시스템분석·설계">ERP·시스템분석·설계</a>
			<ul id="sub-menu">
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=ERP·시스템분석·설계&jobDetail=projectManager">PM</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=ERP·시스템분석·설계&jobDetail=컨설팅">컨설팅</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=ERP·시스템분석·설계&jobDetail=분석,설계">분석,설계</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=ERP·시스템분석·설계&jobDetail=시스템엔지니어">시스템엔지니어</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=ERP·시스템분석·설계&jobDetail=데이터분석">데이터분석</a></li>
			</ul>
		</li>
		<li>
			<a class='main-menu-title' href="${contextPath}/job/detailChart.do?job=데이터베이스·DBA">데이터베이스·DBA</a>
			<ul id="sub-menu">
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=데이터베이스·DBA&jobDetail=SQL">SQL</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=데이터베이스·DBA&jobDetail=DBA">DBA</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=데이터베이스·DBA&jobDetail=MS-SQL">MS-SQL</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=데이터베이스·DBA&jobDetail=Oracle DB">Oracle DB</a></li>
				<li class='sub-list'><a href="${contextPath}/job/detailChart.do?job=데이터베이스·DBA&jobDetail=MySQL">MySQL</a></li>
			</ul>
		</li>
	</ul>
	<img class='chartImg' src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}.png'
	style='margin-top:50px;'>
</div>
</body>
</html>