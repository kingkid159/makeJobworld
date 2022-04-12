<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
h3{
	margin-top: 30px;
   text-align:center;
   }
   .text{
   	height:30px;
   	width: 300px;

   }
   .input{
   margin-top: 30px;
   text-align: center;
   }
   .submit{
   height:30px;
   width: 150px;
  background-color: #130E68;
  color: #ffffff;
  border:none
   }
   .click{
   margin: auto;
   margin-top: 30px;
   text-align: center;

   }
   .button{
   margin: auto;
   height:30px;
  background-color: #ffffff;
  color: #130E68 ;
  border:1px solid #130E68;
   }
   .label{
   margin-top: 15px;
   margin-left:50px;
   }
  .input-form { 
  height:570px;
  margin-top: 80px;
  margin:0 auto;
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  padding-bottom: 50px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  
     } 
</style>
</head>
<body><div class="input-form">
<h3>공고등록</h3>
<form method="post" action="${contextPath}/admin/goods/addsuccess.do">
					<div class="input"><input id="c_name"  class="text"name="c_name" placeholder="회사명" required/></div>
					<div class="input"><input type="text"class="text" id="c_postname" name="c_postname" placeholder="공고제목"required/></div>
					<div class="input"><input type="text" class="text"id="c_career" name="c_career"placeholder="지원자격" required/></div>
					<div class="input"><input type="text"class="text" id="c_condition" name="c_condition"placeholder="근무요건"required/></div>
					<div class="input"><input type="text"class="text"id="c_day" name="c_day"placeholder="마감일"required/></div>
					<div class="input"><input type="url" class="text"id="c_link" name="c_link"placeholder="주소"required/></div>
					<div class="label"><label for="c_jobno"required>직종</label>
						<select id="c_jobno" name="c_jobno">
						    <option value="12000">분석·설계</option>
						    <option value="13630">consulting</option>
						    <option value="14620">Publisher</option>
						    <option value="14690">jsp</option>
						    <option value="13780">MySQL</option>
						    <option value="14810">Oracle</option>
						    <option value="14860">PM</option>
						    <option value="14940">MS-SQL</option>
						    <option value="16182">DBA</option>
						    <option value="16187">JAVA</option>
						   <option value="16617">웹표준</option>
						   <option value="16765">back-end</option>
						   <option value="16766">front</option>
						   <option value="16883">CSS</option>
						  <option value="16903">데이터분석</option>
						   <option value="16935">SQL</option>
						   <option value="16941">JavaScript</option>
						   <option value="16942">xml</option>
						   <option value="16979">빅데이터</option>
						   <option value="16980">인공지능</option>
						   <option value="16981">데이터분석</option>
						   <option value="16982">Python</option>
						   <option value="16983">머신러닝</option>
						   <option value="16993">System Engineer</option>
						   <option value="17111 ">웹개발</option>
						   
						    
						 </select></div>
					<div class="click"><input type="submit"class="submit" value="등록하기"/>
					<input type="button" class="button"value="관리자페이지" onclick="location.href='${contextPath}/admin/main.do' "/></div>
</form>
</div>
</body>
</html>