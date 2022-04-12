<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />     
<!DOCTYPE html>
<html>
<head>
<!-- <style>
img {width:200px; height:200px;}
</style> -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>
	<div class="letterTitle">
		<h3>합격 자기소개서</h3>
	</div>
	<div id="letter_container">
   <c:forEach var="letterVO" items="${LetterPage.content}"> 
<%--   	*번호:${letterVO.lno}<br/> --%>
	<a href="${contextPath}/letter/letterDetail.do?no=${letterVO.lno}&pageNo=${LetterPage.currentPage}">
		<div id="letter_contant">
			<img src="${contextPath}${letterVO.imagefile}"/>
			<p>${letterVO.lTitle}</p>
  			<span>[${letterVO.lTitle}] ${letterVO.qes1} </span>
  		</div>
  	</a>
  </c:forEach>
  </div>  
    <table id="letter_pagingTable">
   <c:if test="${LetterPage.hasLetters()}">
	   <tr>
	      <td colspan="4">
		      <c:if test="${LetterPage.startPage>5}">
		         <a class="backAndNext_page" href="letterList.do?pageNo=${LetterPage.startPage-5}">이전</a>
		      </c:if> 
	         <c:forEach var="pNo" 
	              begin="${LetterPage.startPage}" 
	              end="${LetterPage.endPage}">
	         <a href="letterList.do?pageNo=${pNo}">${pNo}</a>
	         </c:forEach>
	         
	         <c:if test="${LetterPage.endPage<LetterPage.totalPages}">
	         <a class="backAndNext_page" href="letterList.do?pageNo=${LetterPage.startPage+5}">다음</a>
	         </c:if>
	      </td>
	   </tr>
	  </c:if> 
  </table> 
</body>
</html>