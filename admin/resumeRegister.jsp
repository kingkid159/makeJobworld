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

function comfirmURL(input) {
	  var fileForm = /(.*?)\.(xls|xlsx|pdf|hwp)$/;
	  var fileName = input.files[0].name;
	  if(!fileName.match(fileForm)){
		  alert("(xlsx,pdf,hwp)파일만 가능합니다. 다시 한번 확인해주세요.");
		  return ;
	  } 
}
</script>
</head>
<body>
	<div class="resumeTitle">
		<h3>이력서 등록</h3>
	</div>
	<form id="resumeUpdate_form" action="${contextPath}/admin/resume/Register.do" method="post" enctype="multipart/form-data" onsubmit="return register_button();">
		<div id="title_content">	
			이력서 제목 <input id="r_name" type="text" name="r_name" required>
			확장자명:
			<select  name="image_form" required>
				<option value="[DOCX]" selected="selected">[DOCX]</option>
				<option value="[HWP]">[HWP]</option>
				<option value="[PDF]">[PDF]</option>
				<option value="[EXCEL]">[EXCEL]</option>
			</select>
			<br/>
		이력서 타입 <input type="text" name="r_type" required><br/>
		</div>
		<div id="ex_content">
			<textarea id="r_ex" name="r_ex" placeholder="이력서 설명"></textarea>
<%-- 			<input id="r_ex" type="text" name="r_ex" value="${ResumeVO.r_ex}"> --%>
		</div>
		<div id="img_content">
			<span>이미지파일: <input id="r_file" multiple="multiple" type="file" name="imageFile" onchange="readURL(this);"  accept="image/*" value="${ResumeVO.imagefile}" required></span><br/>
			<img id="preview" /><br/>
		</div>
		<div id="file_content">
			다운로드파일:<input multiple="multiple" type="File" name="downFile" onchange="comfirmURL(this);" 
			accept=".xls,.xlsx,.pdf,.hwp" required><br/>
		</div>
		<div id="btn_content">
			<input class="resume_btn" type="submit" value="업로드" >
			<input type="button" class="resume_btn" onclick="location.href='${contextPath}/admin/main.do'" value="취소">
		</div>
	</form>
</body>
</html>