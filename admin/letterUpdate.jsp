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
function update_button(){
	if (confirm("글을 수정하시겠습니까?") == true){    //확인
	    alert("글이 수정 되었습니다.");
	    document.form.submit();
	}else{   //취소
	    return false;
	}
}
function readURL(input) {
	  var fileForm = /(.*?)\.(jpg|jpeg|png|PNG|gif|bmp|pdf)$/;
	  var imgName = input.files[0].name;

	  if(!imgName.match(fileForm)){
		  alert("이미지 파일만 가능합니다. 다시 한번 확인해주세요.");
		  return ;
	  } 
	  if (input.files && input.files[0]) {
		var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('preview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('preview').src = "";
	  }
}
$(function(){
	var res_height=$('.res_textarea').prop('scrollHeight');
	var qes_height=$('.qes_textarea').prop('scrollHeight');
	$('.res_textarea').css('height',res_height);
	$('.qes_textarea').css('height',qes_height);	
});

</script>
</head>
<body>
	<div class="letterTitle">
		<h3>합격 자기소개서 수정</h3>
	</div>
<form id="letter_updateForm" action="${contextPath}/admin/letter/Update.do" method="post" enctype="multipart/form-data"  onsubmit ="return update_button();">
		<div id="letter_updateId">
			제목 <input id="lTitle" type="text" name="lTitle" value="${LetterVO.lTitle}"><br/>
		</div>
		<h4 class="qna_title">Q1.</h4> 
<%-- 		<input type="text" name="qes1" value="${LetterVO.qes1}"><br/> --%>
		<textarea class="qes_textarea" name="qes1">${LetterVO.qes1}</textarea> <br/>
		<h4 class="qna_title">A1.</h4>
			<%-- 		답변1:<input type="text" name="res1" value="${LetterVO.res1}"><br/> --%>
		<textarea class="res_textarea" name="res1">${LetterVO.res1}</textarea> <br/> 
		<h4 class="qna_title">Q2.</h4>
<%-- 		질문2:<input type="text" name="qes2" value="${LetterVO.qes2}"><br/> --%>
		<textarea class="qes_textarea" name="qes2">${LetterVO.qes2}</textarea> <br/>
		<h4 class="qna_title">A2.</h4>
<%-- 		답변2:<input type="text" name="res2" value="${LetterVO.res2}"><br/> --%>
		<textarea class="res_textarea" name="res2">${LetterVO.res2}</textarea> <br/>
		<h4 class="qna_title">Q3.</h4>
<%-- 		질문3:<input type="text" name="qes3" value="${LetterVO.qes3}"><br/> --%>
		<textarea class="qes_textarea" name="qes3">${LetterVO.qes3}</textarea> <br/>
		<h4 class="qna_title">A3.</h4>
<%-- 		답변3:<input type="text" name="res3" value="${LetterVO.res3}"><br/> --%>
		<textarea class="res_textarea" name="res3">${LetterVO.res3}</textarea> <br/>
		<h4 class="qna_title">Q4.</h4>
<%-- 		질문4:<input type="text" name="qes4" value="${LetterVO.qes4}"><br/> --%>
		<textarea class="qes_textarea" name="qes4">${LetterVO.qes4}</textarea> <br/>
		<h4 class="qna_title">A4.</h4>
<%-- 		답변4:<input type="text" name="res4" value="${LetterVO.res4}"><br/> --%>
		<textarea class="res_textarea" name="res4">${LetterVO.res4}</textarea> <br/>
		<h4 class="qna_title">Q5.</h4>
<%-- 		질문5:<input type="text" name="qes5" value="${LetterVO.qes5}"><br/> --%>
		<textarea class="qes_textarea" name="qes5">${LetterVO.qes5}</textarea> <br/>
		<h4 class="qna_title">A5.</h4>
<%-- 		답변5:<input type="text" name="res5" value="${LetterVO.res5}"><br/> --%>
		<textarea class="res_textarea" name="res5">${LetterVO.res5}</textarea> <br/>
		<h4 class="qna_title">Q6.</h4>
<%-- 		질문6:<input type="text" name="qes6" value="${LetterVO.qes6}"><br/> --%>
		<textarea class="qes_textarea" name="qes6">${LetterVO.qes6}</textarea> <br/>
		<h4 class="qna_title">A6.</h4>
<%-- 		답변6:<input type="text" name="res6" value="${LetterVO.res6}"><br/> --%>
		<textarea class="res_textarea" name="res6">${LetterVO.res6}</textarea> <br/>
		<div class="img_container">
			이미지파일: <input multiple="multiple" type="file" name="imageFile" onchange="readURL(this);" 
			 accept="image/*" value="${LetterVO.imagefile}" required><br/>
			 <div class="img_content">
				<img id="preview" /><br/>
			</div>		 
			 <input type="hidden" name="lno" value="${LetterVO.lno}">
			 <input type="hidden" name="no" value="${LetterVO.lno}">
		 </div>
	<input type="submit" value="수정하기">
<%-- 	<a href="${contextPath}/letter/letterList.do">[취소하기]</a> --%>
	<input type="button" value="취소하기" onclick='location.href="${contextPath}/letter/letterList.do"' />
</form>
<div id="letter_updateBtn">
</div>
</body>
</html>