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
	<div class="resumeTitle">
		<h3>이력서 양식</h3>
	</div>
<table id="resumeDetail_table">
	<tr>
		<td class="resumeDetail_title"><h2>${ResumeVO.r_name}</h2></td>
	</tr>
	<tr>
		<td class="resumeDetail_ex"><div class="resumeDetail_ex">${ResumeVO.r_ex}</div></td>
	</tr>
	<tr>
		<td class="resumeDetail_type"><div class="resumeDetail_type">(${ResumeVO.r_type})</div></td>
	</tr>
	<tr>
		<td class="resumeDetail_img"><img src="${contextPath}${ResumeVO.imagefile}"/><br/> </td>
	</tr>
	<tr>
		<td class="resumeDetail_down"><a href="${contextPath}${ResumeVO.filename}" download="${ResumeVO.r_name}.${ResumeVO.image_form}"><button>다운로드</button></a></td>
	</tr>
	
</table>
	<div id="footer_menu">
		<c:if test="${memberVO.adminok eq 'Y'}">
		<a href="${contextPath}/admin/resume/UpdatePage.do?no=${ResumeVO.r_no}">수정</a>
		<a href="${contextPath}/admin/resume/Delete.do?no=${ResumeVO.r_no}" onclick="return delete_button();">삭제</a>
		</c:if>
		<a href="${contextPath}/resume/resumeList.do">목록으로</a>
	</div>
</body>
</html>