<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>

<script type="text/javascript">
	//검색기능 함수 등 예정
</script>
</head>
<body>


<div id="head_link">
		<ul>
		   <c:choose>
		    <%-- test="로그인되어 있으면서  회원정보가 비어있지 않으면" --%>
		   	<c:when test="${isLogOn==true and not empty memberVO}">
			   <li><a href="${contextPath}/member/logout.do">로그아웃</a></li>
			    <li><a href="${contextPath}/mypage/mypage.do">마이페이지</a></li>
			     <li><a href="${contextPath}/member/delete.do">회원탈퇴</a></li>
			     <li><a href="${contextPath}/resume/resumeList.do">보고서</a></li>
			     <li><a href="${contextPath}/admin/resume/RegisterPage.do">보고서 입력</a></li>
			     <li><a href="${contextPath}/letter/letterList.do">자기소개서</a></li>
			     <li><a href="${contextPath}/admin/letter/RegisterPage.do">자기소개서 입력</a></li>
			</c:when>
			<c:otherwise>   
			<%-- test="그외의 경우" --%>
			   <li><a href="${contextPath}/member/login.do">로그인</a></li>
			   <li><a href="${contextPath}/member/member.do">회원가입</a></li> 
			</c:otherwise>  
		   </c:choose>	
			<%-- test="로그인되어 있으면서  회원id가 'admin'이면" --%>
		   <c:if test="${isLogOn==true and memberVO.id=='admin'}">	 
			
		   </c:if>	
		</ul>
	</div>
			 
</body>
</html>