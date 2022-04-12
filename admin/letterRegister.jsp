<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="text/html; charset=UTF-8">
<title>파일 업로드</title>
<script>
function register_button(){
	if (confirm("글을 등록하시겠습니까?") == true){    //확인
	    alert("글이 등록 되었습니다.");
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
</script>
</head>
<body>
	<div class="letterTitle">
		<h3>자기소개서 샘플등록</h3>
	</div>
	<form id="letter_updateForm" action="${contextPath}/admin/letter/Register.do" method="post" enctype="multipart/form-data" onsubmit="return register_button();">
		<div id="letter_updateId">
		제목 <input id="lTitle" type="text" name="lTitle"><br/>
		</div>
		<h4 class="qna_title">Q1.</h4> 
		<textarea class="qes_textarea" name="qes1"></textarea> <br/>
		<h4 class="qna_title">A1.</h4>
		<textarea class="res_textarea" name="res1"></textarea> <br/> 
		<h4 class="qna_title">Q2.</h4>
		<textarea class="qes_textarea" name="qes2"></textarea> <br/>
		<h4 class="qna_title">A2.</h4>
		<textarea class="res_textarea" name="res2"></textarea> <br/>
		<h4 class="qna_title">Q3.</h4>
		<textarea class="qes_textarea" name="qes3"></textarea> <br/>
		<h4 class="qna_title">A3.</h4>
		<textarea class="res_textarea" name="res3"></textarea> <br/>
		<h4 class="qna_title">Q4.</h4>
		<textarea class="qes_textarea" name="qes4"></textarea> <br/>
		<h4 class="qna_title">A4.</h4>
		<textarea class="res_textarea" name="res4"></textarea> <br/>
		<h4 class="qna_title">Q5.</h4>
		<textarea class="qes_textarea" name="qes5"></textarea> <br/>
		<h4 class="qna_title">A5.</h4>
		<textarea class="res_textarea" name="res5"></textarea> <br/>
		<h4 class="qna_title">Q6.</h4>
		<textarea class="qes_textarea" name="qes6"></textarea> <br/>
		<h4 class="qna_title">A6.</h4>
		<textarea class="res_textarea" name="res6"></textarea> <br/>
		<div class="img_container">
			이미지파일:<input multiple="multiple" type="file" name="imageFile" onchange="readURL(this);"
			accept="image/*" required><br/>
			 <div class="img_content">
				<img id="preview" />
			</div>
		</div>	
		<div id="letter_updateBtn">
			<input type="submit" value="업로드">
			<input type="button" onclick='location.href="${contextPath}/admin/main.do"' value="취소">
		</div>
	</form>
</body>
</html>