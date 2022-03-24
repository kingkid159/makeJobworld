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
<link rel="stylesheet" href="${contextPath}/resources/css/chart.css">
</head>
<body>
<div class="contain">
	<div class="buttonContain">
	<c:forEach var="chartVO" items="${chartVO}">
		<button class="grpahTypeBTN">${chartVO.graphType}</button>
	</c:forEach>
	</div>
	<br>
	<c:forEach var="chartVO" items="${chartVO}">
		<div class="imgContain">
			<img class='chartImg'src="${contextPath}/resources/image/시각화자료/${chartVO.job}_${chartVO.jobDetail}_${chartVO.graphType}.png" alt="상세그래프">
		</div>
	</c:forEach>
</div>
</body>
</html>