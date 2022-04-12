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
function delete_button(){
if (confirm("글을 삭제하시겠습니까?") == true){    //확인
    alert("글이 삭제 되었습니다.");
    location.href="${contextPath}/mypage/myLetterDelete.do?no=${MyLetterVO.mlno}";
}else{   //취소
    return;
}
}
</script>
</head>
<body>
<div class="letterTitle">
      <h3>${MyLetterVO.lTitle}</h3>
</div>
<table id="letter_detailTable">
	<tr>
		<td class="title"><strong>${MyLetterVO.qes1}</strong><br/></td>
	</tr>
	<tr>
		<td class="title">${MyLetterVO.res1}</td>
	</tr>
	<tr>
		<td class="title"><strong>${MyLetterVO.qes2}</strong><br/></td>
	</tr>
	<tr>
		<td class="title">${MyLetterVO.res2}</td>
	</tr>
	<tr>
		<td class="title"><strong>${MyLetterVO.qes3}</strong><br/></td>
	</tr>
	<tr>
		<td class="title">${MyLetterVO.res3}</td>
	</tr>
	<tr>
		<td class="title"><strong>${MyLetterVO.qes4}</strong><br/></td>
	</tr>
	<tr>
		<td class="title">${MyLetterVO.res4}</td>
	</tr>
	<tr>
		<td class="title"><strong>${MyLetterVO.qes5}</strong><br/></td>
	</tr>
	<tr>
		<td class="title">${MyLetterVO.res5}</td>
	</tr>
	<tr>
		<td class="title"><strong>${MyLetterVO.qes6}</strong><br/></td>
	</tr>
	<tr>
		<td class="title">${MyLetterVO.res6}</td>
	</tr>
</table>
<div id="letter_detailbtn">
<a href="${contextPath}/mypage/myLetterEdit.do?no=${MyLetterVO.mlno}">수정하기</a>
<a href="#" onclick="delete_button();">삭제하기</a>
</div>
</body>
</html>