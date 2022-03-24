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
<!-- <script>

	$(document).ready(function button(){
		$("#button").click(function(){
			$.ajax({type : 'get',
					url :'/job/detailChart.do',
					async : false,
					data : 	{job:"빅데이터AI",
							jobDetail:"머신러닝"}
					success: function(data,textStatus){
						var job = data.job;
						var jobDetail = data.jobDetail;
						var StrDom="";
						strDom += "'<img src=' + job + '_'+jobDetail+'근무형태.png'+'>'";
						$('#image').append(strDom);
					}
			});
		});
		
	});
</script> -->
</head>
<body>


<c:if test="${chartVO.job eq '전체'}">
	<a href='${contextPath}/job/detailChart.do?job=빅데이터AI'>빅데이터 AI</a>
	<a href='${contextPath}/job/detailChart.do?job=웹프로그래머'>웹프로그래머</a>
	<a href='${contextPath}/job/detailChart.do?job=퍼블리싱UI개발'>퍼블리싱UI개발</a>
	<a href='#'>빅데이터 AI</a>
	<a href='#'>빅데이터 AI</a>
	<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}_${chartVO.graphType}.png' alt="전체그래프">
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}$&jobDetail=${chartVO.jobDetail}">${chartVO.jobDetail}</a>
</c:if>
<c:if test="${chartVO.job eq '빅데이터AI'}">
	<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}.png' alt="직종그래프">
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=데이터분석">데이터분석</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=머신러닝">머신러닝</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=빅데이터">빅데이터</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=인공지능">인공지능</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=파이썬">파이썬</a>
</c:if>
<c:if test="${chartVO.job eq '웹프로그래머'}">
	<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}.png' alt="직종그래프">
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=jsp">jsp</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=백엔드">백엔드</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=웹개발">웹개발</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=자바">자바</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=프론트">프론트</a>
</c:if>
<c:if test="${chartVO.job eq '퍼블리싱UI개발'}">
	<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}.png' alt="직종그래프">
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=css">css</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=xml">xml</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=웹표준">웹표준</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=자바스크립">자바스크립</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=퍼블리셔">퍼블리셔</a>
</c:if>
<c:if test="${chartVO.job eq '#'}">
	<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}.png' alt="직종그래프">
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=데이터분석">데이터분석</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=머신러닝">머신러닝</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=빅데이터">빅데이터</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=인공지능">인공지능</a>
	<a href="${contextPath}/job/detailChart.do?job=${chartVO.job}&jobDetail=파이썬">파이썬</a>
</c:if>
		

	
	<%-- 
	<a href='${contextPath}/job/detailChart.do?job=웹프로그래머'>웹프로그래머</a>
	<a href='${contextPath}/job/detailChart.do?job=퍼블리싱UI개발'>퍼블리싱UI개발</a>
		<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}_${chartVO.graphType}.png' alt="전체그래프">
		<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_전체.png' alt="직종전체그래프">
		<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}_${chartVO.graphType}.png' alt="직무별그래프">
		<button id='button'>데이터분석</button>
		<a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=머신러닝">머신러닝</a>
		<a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=빅데이터">빅데이터</a>
		<a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=인공지능">인공지능</a>
		<a href="${contextPath}/job/detailChart.do?job=빅데이터AI&jobDetail=파이썬">파이썬</a>
		<img src='${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}_근무형태.png' alt="직종근무형태그래프">
		<div id="image"></div>
		a
	<div>${chartVO.job}${chartVO.jobDetail}${chartVO.graphType}
	${chartVO.job}_${chartVO.jobDetail}_${chartVO.graphType}</div>
	 --%>
</body>
</html>