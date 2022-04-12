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
<title>게시판 상세보기</title>
<script>
   $(document).ready(function(){
      $("#btnUpdate").click(function(){
         var writer_id=$("#writer_id").val();
         var writer_name=$("#writer_name").val();
         var title=$("#title").val();
         var content=$("#content").val();
         document.boardRead.action="${contextPath}/board/boardUpdate.do?board_no=${boardVO.board_no}"
         document.boardRead.submit();
      });
      
      $("#btnDelete").click(function(){
         document.boardRead.action="${contextPath}/board/boardDelete.do?board_no=${boardVO.board_no}"
         document.boardRead.submit();
      });
   });
</script>
</head>
<body>
<div  id="boardTitle">
   <h3>자유게시판</h3>
</div>
   <form id="boardReadForm" name="boardRead" method="post">
      <input type="hidden"name="writer_id" id="writer_id" value="${memberVO.id}">
      <div id="read_titleContainer">
         <input name="title" id="read_title" value="${boardVO.title}"/>
      </div>
      <div id="read_nameContainer">
         글쓴이
         <input name="writer_name" id="writer_name" value="${boardVO.writer_name}"/>
      </div>
      <div id="read_cpmtentContainer">
         <input name="content" id="read_content" value="${boardVO.content}"/>
      </div>
      <div id="read_btn" style="text-align:center;">
      <c:if test="${boardVO.writer_id eq memberVO.id}">
      <input type="button" id="btnUpdate" value="수정"></c:if>
      <c:if test="${memberVO.adminok eq 'Y' ||  boardVO.writer_id eq memberVO.id}">
      <input type="button" id="btnDelete" value="삭제"></c:if>
      </div>
   </form>
   
</body>
</html>