<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function modify_button(){
	if (confirm("글을 수정하시겠습니까?")){    //확인
	    alert("글이 수정 되었습니다.");
	 	 $('#letter_writeForm').submit();
	}else{   //취소
	    return false;
	}
}
</script>
<style>
#letter_writeForm .res_area {
   width: 1150px; height: 500px;
   white-space: normal;
   resize: none;
   margin-top:20px;
   margin-bottom: 20px;
}
</style>

<body>
<div class="letterTitle">
      <h3>${MyLetterVO.lTitle}</h3>
</div>
<form id="letter_writeForm" action="${contextPath}/mypage/myLetterUpdate.do" method="post">
<input type="hidden" name="userId" value= "${memberVO.id}">
<input type="hidden" name="imagefile" value= "${MyLetterVO.imagefile}">
<input type="hidden" name="lno" value="${MyLetterVO.lno}">
<input type="hidden" name="mlno" value="${MyLetterVO.mlno}">
<input type="hidden" name="lTitle" value="${MyLetterVO.lTitle}">
<c:if test="${MyLetterVO.qes1 ne null}">
<strong>${MyLetterVO.qes1}</strong><br/>
<input type="hidden" name="qes1" value="${MyLetterVO.qes1}">
<textarea name="res1" class="res_area">${MyLetterVO.res1}"</textarea><br/>
</c:if>
<c:if test="${MyLetterVO.qes2 ne null}">
<strong>${MyLetterVO.qes2}</strong><br/>
<input type="hidden" name="qes2" value="${MyLetterVO.qes2}">
<textarea name="res2" class="res_area">${MyLetterVO.res2}</textarea><br/>
</c:if>
<c:if test="${MyLetterVO.qes3 ne null}">
<strong>${MyLetterVO.qes3}</strong><br/>
<input type="hidden" name="qes3" value="${MyLetterVO.qes3}">
<textarea name="res3" class="res_area">${MyLetterVO.res3}</textarea><br/>
</c:if>
<c:if test="${MyLetterVO.qes4 ne null}">
<strong>${MyLetterVO.qes4}</strong><br/>
<input type="hidden" name="qes4" value="${MyLetterVO.qes4}">
<textarea name="res4" class="res_area">${MyLetterVO.res4}</textarea><br/>
</c:if>
<c:if test="${MyLetterVO.qes5 ne null}">
<strong>${MyLetterVO.qes5}</strong><br/>
<input type="hidden" name="qes5" value="${MyLetterVO.qes5}">
<textarea name="res5" class="res_area">${MyLetterVO.res5}</textarea><br/>
</c:if>
<c:if test="${MyLetterVO.qes6 ne null}">
<strong>${MyLetterVO.qes6}</strong><br/>
<input type="hidden" name="qes6" value="${MyLetterVO.qes6}">
<textarea name="res6" class="res_area">${MyLetterVO.res6}</textarea><br/>
</c:if>
</form>
<div id="letter_updateBtn">
	<input type="submit" value="수정하기" onclick="return modify_button();">
</div>
</body>
</html>