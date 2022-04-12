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
<title>search</title>
</head>
<body>
<div id="search_container">
<div id="search_content">
<h3>${searchPage.search} 검색결과</h3>


	<table id="search_table">
		<thead>
		<tr class="thead">
			<td>글 번호</td>
			<td>회사명</td>
			<td>공고제목</td>
			<td>지원자격</td>
			<td>근무요건</td>
			<td>마감일</td>
		</tr>
		</thead>
		<c:if test="${searchPage.hasNoResult()}">
			<tr>
				<td colspan="6">게시글이 없습니다.</td>
			</tr>
		</c:if>
	<tbody>
	<c:forEach var="search" items="${searchPage.content}">
		<tr>
			<td>${search.c_no}</td>
			<td>${search.c_name}</td>
			<td><a href="${search.c_link}">${search.c_postname}</a></td>
			<td>${search.c_career}</td>
			<td>${search.c_condition}</td>
			<td>${search.c_day}</td>
			<c:if test="${memberVO.id eq 'admin'}">
			<td><form action="${contextPath}/admin/goods/delete.do?c_eno=${search.c_eno}" method="post">
				<input type="submit" id="cDelete" value="삭제"></c:if>
			</form></td>
		</tr>
	</c:forEach>
	<!-- 게시글이 있으면 -->
	<c:if test="${searchPage.hasResult()}"> 
		<tr class="paging">
			<td>
				<c:if test="${searchPage.startPage > 5}">
					<a class="backAndNext_page" href="${contextPath}/search/search.do?search=${searchPage.search}&pageNo=${searchPage.startPage - 5}">이전</a>
				</c:if>
				<c:forEach var="pNo" begin="${searchPage.startPage}" end="${searchPage.endPage}">
					<a href="${contextPath}/search/search.do?search=${searchPage.search}&pageNo=${pNo}">${pNo}</a>
				</c:forEach>
				<c:if test="${searchPage.endPage < searchPage.totalPages}">
					<a class="backAndNext_page" href="${contextPath}/search/search.do?search=${searchPage.search}&pageNo=${searchPage.startPage + 5}">다음</a>
				</c:if>
			</td>
		</tr>
	</c:if>
	</tbody>
	</table>
	</div>
</div>
</body>
</html>