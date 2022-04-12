<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />     
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
글번호 : ${MyMyLetterVO.lno}<br/>
<form action="${contextPath}/mypage/myLetterUpdate.do" method="post">
<input type="hidden" name="userId" value="${memberVO.id}">
<input type="hidden" name="imagefile" value="${MyLetterVO.imagefile}">
<input type="hidden" name="lno" value="${MyLetterVO.lno}">
글 제목 : ${MyLetterVO.lTitle}<br/>
<input type="hidden" name="lTitle" value="${MyLetterVO.lTitle}">
<c:if test="${MyLetterVO.qes1 ne null}">
${MyLetterVO.qes1}<br/>
<input type="hidden" name="qes1" value="${MyLetterVO.qes1}">
<input type="text" name="res1"><br/>
</c:if>
<c:if test="${MyLetterVO.qes2 ne null}">
${MyLetterVO.qes2}<br/>
<input type="hidden" name="qes2" value="${MyLetterVO.qes2}">
<input type="text" name="res2"><br/>
</c:if>
<c:if test="${MyLetterVO.qes3 ne null}">
${MyLetterVO.qes3}<br/>
<input type="hidden" name="qes3" value="${MyLetterVO.qes3}">
<input type="text" name="res3"><br/>
</c:if>
<c:if test="${MyLetterVO.qes4 ne null}">
${MyLetterVO.qes4}<br/>
<input type="hidden" name="qes4" value="${MyLetterVO.qes4}">
<input type="text" name="res4"><br/>
</c:if>
<c:if test="${MyLetterVO.qes5 ne null}">
${MyLetterVO.qes5}<br/>
<input type="hidden" name="qes5" value="${MyLetterVO.qes5}">
<input type="text" name="res5"><br/>
</c:if>
<c:if test="${MyLetterVO.qes6 ne null}">
${MyLetterVO.qes6}<br/>
<input type="hidden" name="qes6" value="${MyLetterVO.qes6}">
<input type="text" name="res6"><br/>
</c:if>
<input type="submit" value="수정하기">
</form>
</body>
</html>