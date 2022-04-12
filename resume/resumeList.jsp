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
	<div class="resumeTitle">
		<h3>이력서 양식</h3>
	</div>
	<div id="resumeList_container"> 
   <c:forEach var="resumeVO" items="${ResumePage.content}">
		<a href="${contextPath}/resume/resumeDetail.do?no=${resumeVO.r_no}&pageNo=${ResumePage.currentPage}">
		<ul class="resumeList_content">
		
			<li><img src="${contextPath}${resumeVO.imagefile}"/></li>
<%-- 	  		<li>번호:${resumeVO.r_no}</li> --%>
<%-- 	  		<li>분류:${resumeVO.r_type}</li> --%>
	  		<li>${resumeVO.r_name}</li>
	  		<li>${resumeVO.r_ex}</li>
	  		
	  	</ul>
	  	</a>
  </c:forEach>
   	</div> 
  
  
  
   <table id="resumeList_table">
   <c:if test="${ResumePage.hasResumes()}">
   <tr>
      <td colspan="4">
	      <c:if test="${ResumePage.startPage>5}">
	         <a class="backAndNext_page" href="resumeList.do?pageNo=${ResumePage.startPage-5}">이전</a>
	      </c:if> 
         <c:forEach var="pNo" 
              begin="${ResumePage.startPage}" 
              end="${ResumePage.endPage}">
         <a href="resumeList.do?pageNo=${pNo}">${pNo}</a>
         </c:forEach>
         
         <c:if test="${ResumePage.endPage<ResumePage.totalPages}">
         <a class="backAndNext_page" href="resumeList.do?pageNo=${ResumePage.startPage+5}">다음</a>
         </c:if>
      </td>
   </tr>
  </c:if> 
  </table>
  
</body>
</html>