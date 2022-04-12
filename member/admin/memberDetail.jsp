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
<title>layout</title>

</head>
<body>
	<div>
		<h2>회원 리스트</h2>
	</div>
	<form id="adminMemberList" name="adminMemberList" method="post">
		<div>
			<table>
				<tr>
					<td>회원 아이디</td>
					<td>회원 이름</td>
					<td>회원 성별</td>
					<td>이메일</td>
					<td>핸드폰번호</td>
					<td>주소</td>
					<td>생일</td>
					<td>가입일 </td>
					<td>희망직종 </td>
					<td>회원 삭제 </td>
				</tr>
				<c:forEach items="${memberList}" var="mList">
					<tr>
						<td>${mList.id}</td>
						<td>${mList.name}</td>
						<td>${mList.gender}</td>
						<td>${mList.email}</td>
						<td>${mList.phone}</td>
						<td>${mList.address}</td>
						<td>${mList.birth}</td>
						<td>${mList.regdate}</td>
						<td>${mList.djob}</td>
						<td><form action="/member/admin/memberDelete.do?id=${mList.id}" method="post">
						<input type="submit" id="btnDelete" value="삭제">
						</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</form>
</body>
</html>