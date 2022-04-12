<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<div id="content">
<div id="container">
	<h3 >추천기업</h3>
	<c:forEach var="cl" items="${cmainList}">
	<a href="${cl.c_link}">
		<ul class="cmain_box" >
			<li class="cmain_logo"><img src="${cl.c_logo}"/></li>
			<li class="cmain_text">${cl.c_name}</li>
			<li class="cmain_content">${cl.c_postname}</li>
		</ul>
	</a>
	</c:forEach>
</div>
</div>
<div id="tableContainer">
<h3>공고 리스트</h3>
<table id="cTable">
	<thead>
		<tr class="thead">
			<td>회사명</td>
			<td>공고제목</td>
			<td>지원자격</td>
			<td>근무요건</td>
			<td>마감일</td>
		</tr>
	</thead>	
	<tbody>
	<c:forEach var="cList" items="${cList}">
		<tr>
			<td>${cList.c_name}</td>
			<td><a href="${cList.c_link}">${cList.c_postname}</a></td>
			<td>${cList.c_career}</td>
			<td>${cList.c_condition}</td>
			<td>${cList.c_day}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>