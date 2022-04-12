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
<title>게시판 목록</title>
<script>
	$(document).ready(function(){
		$("#btnWrite").click(function(){
			location.href = "${contextPath}/board/boardWrite.do";
		}); //$("#btnWrite").click(function(){
	}); //$document).ready(funtion(){
</script>
</head>
<body>
<div id="board">
<!-- 타이틀 -->
<h3>자유게시판</h3>
</div> <!-- <div id=board> -->

<!-- 전체게시물수 -->
<div id="board_total">
	전체 게시물 수  : ${boardPage.total}
</div>
<div id="board_list">
	<table id="boardTable" class="boardTable">
		<thead>
			<!-- 테이블 분류 -->
			<tr class="thead">
				<td>No</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<!-- 테이블 값 넣는 부분 -->
			<c:forEach items="${boardPage.content}" var="boardVO">
				<tr>
					<td>${boardVO.board_no}</td>
					<td><a href="${contextPath}/board/boardRead.do?board_no=${boardVO.board_no}">${boardVO.title}</a></td>
					<td>${boardVO.writer_name}</td>
					<td>${boardVO.read_cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
			<c:if test="${memberVO.id ne null}">
         <!-- 글작성 버튼 -->
      <div id="btnWrite">
         <button>게시글쓰기</button>
      </div></c:if>
</div>
			<!-- 페이징처리 부분 -->			
		<c:if test="${boardPage.hasResult()}"> 
			<div id="paging">
				<c:if test="${boardPage.startPage > 5}">
					<a class= "backAndNext_page" href="${contextPath}/board/boardPageList.do?pageNo=${boardPage.startPage - 5}">이전</a>
				</c:if>
				<c:forEach var="pNo" begin="${boardPage.startPage}" end="${boardPage.endPage}">
					<a href="${contextPath}/board/boardPageList.do?pageNo=${pNo}">${pNo}</a>
				</c:forEach>
				<c:if test="${boardPage.endPage < boardPage.totalPages}">
					<a class="backAndNext_page" href="${contextPath}/board/boardPageList.do?pageNo=${boardPage.startPage + 5}">다음</a>
				</c:if>
			</div>
		</c:if>
</body>
</html>