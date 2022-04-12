<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 작성</title>
<!-- <script> -->
<!-- //  	$(document).ready(function(){ -->
<!-- //  		$("#btnSave").click(function(){ -->
<!-- //  			var title=$("#title").val(); -->
<!-- //  			var content=$("content").val(); -->
 			
<!-- //  			document.boardWriteForm.action='' -->
<!-- //  			document.boardWriteForm.submit(); -->
			
<!-- //  		});//$("#btnSave").click(function(){ -->
<!-- //  	}); // $(document).ready(function(){ -->
<!-- </script> -->
</head>
<body>

<!-- 타이틀 -->
<div id="boardTitle">
	<h3>자유게시판</h3>
</div>

<form id="boardWriteForm" name="boardWriteForm" method="post" action="${contextPath}/board/insert.do">
	<div id="id_container">
	<input type="hidden"name="writer_id" id="writer_id" value="${memberVO.id}">
	</div>
	<div id="name_container">
	글쓴이 
	<input name="writer_name" id="writer_name" placeholder="이름을 입력해주세요 ">
	</div>
	<div id="title_container">
	제목
	<input name="title" id="write_title" placeholder="제목을 입력해주세요 ">
	</div>
	<div id="content_container">
<!-- 	<input type="text" name="content" id="write_content" placeholder="내용을 입력해주세요"> -->
	<textarea id="write_content"name="content" placeholder="내용을 입력해주세요"></textarea>
	</div>
	<div id="write_btn" style="text-align:center; height: 300px;" >
	<input type="submit" id="btnSave"value="확인"/>
	<input type="reset" value="취소"/>
	</div>
</form>
</body>
</html>