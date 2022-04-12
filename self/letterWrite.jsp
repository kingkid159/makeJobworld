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
<script type="text/javascript">
function create_button(){
if (confirm("글을 작성하시겠습니까?") == true){    //확인
    alert("글이 작성 되었습니다.");
    $('#letter_writeForm').submit();
}else{   //취소
    return false;
}
}
</script>
</head>
<body>
	<div class="letterTitle">
		<h3>${LetterVO.lTitle} 작성해보기</h3>
	</div>
<form id="letter_writeForm" action="${contextPath}/letter/letterInsert.do" method="post">
<input type="hidden" name="userId" value= "${memberVO.id}">
<input type="hidden" name="imagefile" value= "${LetterVO.imagefile}">
<input type="hidden" name="lno" value="${LetterVO.lno}">

<input type="hidden" name="lTitle" value="${LetterVO.lTitle}">
<c:if test="${LetterVO.qes1 ne null}">
<strong>${LetterVO.qes1}</strong>
<input type="hidden" name="qes1" value="${LetterVO.qes1}">
<textarea name="res1" id="res1" class="res_area"></textarea>
<!-- <input type="text" name="res1"><br/> -->
</c:if>
<c:if test="${LetterVO.qes2 ne null}">
<strong>${LetterVO.qes2}</strong>
<input type="hidden" name="qes2" value="${LetterVO.qes2}">
<textarea name="res2" id="res2" class="res_area"></textarea>
<!-- <input type="text" name="res2"><br/> -->
</c:if>
<c:if test="${LetterVO.qes3 ne null}">
<strong>${LetterVO.qes3}</strong>
<input type="hidden" name="qes3" value="${LetterVO.qes3}">
<textarea name="res3" id="res3" class="res_area"></textarea>
<!-- <input type="text" name="res3"><br/> -->
</c:if>
<c:if test="${LetterVO.qes4 ne null}">
<strong>${LetterVO.qes4}</strong>
<input type="hidden" name="qes4" value="${LetterVO.qes4}">
<textarea name="res4" id="res4" class="res_area"></textarea>
<!-- <input type="text" name="res4"><br/> -->
</c:if>
<c:if test="${LetterVO.qes5 ne null}">
<strong>${LetterVO.qes5}</strong>
<input type="hidden" name="qes5" value="${LetterVO.qes5}">
<textarea name="res5" id="res5" class="res_area"></textarea>
<!-- <input type="text" name="res5"><br/> -->
</c:if>
<c:if test="${LetterVO.qes6 ne null}">
<strong>${LetterVO.qes6}</strong>
<input type="hidden" name="qes6" value="${LetterVO.qes6}">
<input type="text" name="res6"><br/>
</c:if>

</form>
<div id="letter_writeBtn">
<input type="submit" value="작성하기" onclick="return create_button();">
</div>
</body>
</html>