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
<link rel='stylesheet' href='${contextPath}/resources/css/eduList.css?ver=3'>
</head>
<body>
	<div class="contain">
		<table class='eduTable'>
			<tr class='eduTable_title'>
				<td class='eduTable_title_td'>공고제목</td>
				<td class='eduTable_title_td'>학원명</td>
				<td class='eduTable_title_td'>주소</td>
				<td class='eduTable_title_td'>교육기간</td>
				<td class='eduTable_title_td'>모집기간</td>
			</tr>
			<c:forEach var="eduVO" items="${eduPage.content}" >
			<tr class='eduTable_content'>
				<td class='title'>
					<a class='titleLink' href="${contextPath}/job/eduDetail.do?eno=${eduVO.eno}">${eduVO.title}</a>
				</td>
				<td class='academy_name'>${eduVO.acadamy_name}</td>
				<td class='academy_add'>${eduVO.edu_location}</td>
				<td class='edu_period'>${eduVO.edu_period}</td>
				<td class='edu_app_period'>${eduVO.edu_app_period}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="page_number_contain">
			<c:if test = "${eduPage.startPage > 5 }">
				<a class="page_number" href="eduList.do?pageNO=${eduPage.startPage -5 }"><</a>
			</c:if>
			<c:forEach var ="pNo"
				begin="${eduPage.startPage}"
				end="${eduPage.endPage}">
				<a class="page_number" href= "eduList.do?pageNO=${pNo}">${pNo}</a>
			</c:forEach>
			<c:if test="${eduPage.endPage <eduPage.totalPage}">
				<a class="page_number" href="eduList.do?pageNO=${eduPage.startPage + 5 }">></a>
			</c:if>
		</div>
	</div>
</body>
</html>