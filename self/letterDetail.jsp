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
<script>
function delete_button(){
	if (confirm("글을 삭제하시겠습니까?") == true){    //확인
	    alert("글이 삭제 되었습니다.");
	    document.form.submit();
	}else{   //취소
	    return false;
	}
}
</script>
</head>
<body>
	<div class="letterTitle">
		<h3>${LetterVO.lTitle}</h3>
	</div>
<table id="letter_detailTable">
	<tr>
		<td><strong>${LetterVO.qes1}</strong><br/></td>
	</tr>
	<tr>
		<td>${LetterVO.res1}</td>
	</tr>
	<tr>
		<td><strong>${LetterVO.qes2}</strong><br/></td>
	</tr>
	<tr>
		<td>${LetterVO.res2}</td>
	</tr>
	<tr>
		<td><strong>${LetterVO.qes3}</strong><br/></td>
	</tr>
	<tr>
		<td>${LetterVO.res3}</td>
	</tr>
	<tr>
		<td><strong>${LetterVO.qes4}</strong><br/></td>
	</tr>
	<tr>
		<td>${LetterVO.res4}</td>
	</tr>
	<tr>
		<td><strong>${LetterVO.qes5}</strong><br/></td>
	</tr>
	<tr>
		<td>${LetterVO.res5}</td>
	</tr>
	<tr>
		<td><strong>${LetterVO.qes6}</strong><br/></td>
	</tr>
	<tr>
		<td>${LetterVO.res6}</td>
	</tr>
</table>
<div id="letter_detailbtn">
	<a href="${contextPath}/letter/letterWrite.do?no=${LetterVO.lno}">글쓰기</a>
	<c:if test="${memberVO.adminok eq 'Y'}">
		<a href="${contextPath}/admin/letter/UpdatePage.do?no=${LetterVO.lno}">수정하기</a>
		<a href="${contextPath}/admin/letter/Delete.do?no=${LetterVO.lno}" onclick="return delete_button();">삭제하기</a>
	</c:if>
</div>

</body>
</html>