<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>

/* BASIC */

html {
  background-color: #56baed;
}

body {
  font-family: "Poppins", sans-serif;
  height: 100vh;
 
}

a {
  color: black;
  display:inline-block;
  text-decoration: none;
  font-weight: 400;
  text-align:center;
}

h2 {
  text-align: center;
  font-size: 16px;
  font-weight: 600;
  text-transform: uppercase;
  display:inline-block;
  margin: 40px 8px 10px 8px; 
  color: #cccccc;
}



/* STRUCTURE */

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;

}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  text-align: center;
}

#formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 25px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}



/* TABS */

h2.inactive {
  color: #cccccc;
}

h2.active {
  color: #0d0d0d;
  border-bottom: 2px solid #5fbae9;
}



/* FORM TYPOGRAPHY*/

input[type=button], input[type=submit], input[type=reset]  {
  background-color: #56baed;
  border: none;
  color: white;
  padding: 15px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 13px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 20px 40px 20px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {
  background-color: #39ace7;
}

input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
  -moz-transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -o-transform: scale(0.95);
  -ms-transform: scale(0.95);
  transform: scale(0.95);
}

.form-control {
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}

input[type=text]:focus {
  background-color: #fff;
  border-bottom: 2px solid #5fbae9;
}

input[type=text]:placeholder {
  color: #cccccc;
}



/* ANIMATIONS */

/* Simple CSS3 Fade-in-down Animation */
.fadeInDown {
  -webkit-animation-name: fadeInDown;
  animation-name: fadeInDown;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}

@-webkit-keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

/* Simple CSS3 Fade-in Animation */
@-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

.fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}

.fadeIn.first {
  -webkit-animation-delay: 0.4s;
  -moz-animation-delay: 0.4s;
  animation-delay: 0.4s;
}

.fadeIn.second {
  -webkit-animation-delay: 0.6s;
  -moz-animation-delay: 0.6s;
  animation-delay: 0.6s;
}

.fadeIn.third {
  -webkit-animation-delay: 0.8s;
  -moz-animation-delay: 0.8s;
  animation-delay: 0.8s;
}

.fadeIn.fourth {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}

/* Simple CSS3 Fade-in Animation */
.underlineHover:after {
  display: block;
  left: 0;
  bottom: -10px;
  width: 0;
  height: 2px;
  background-color: #56baed;
  content: "";
  transition: width 0.2s;
}

.underlineHover:hover {
  color: #0d0d0d;
}

.underlineHover:hover:after{
  width: 100%;
}


#password { 
   -webkit-text-security: disc; 
}

#password5 { 
   -webkit-text-security: disc; 
}

#passwordConfrim { 
   -webkit-text-security: disc; 
}

/* OTHERS */

*:focus {
    outline: none;
} 

#icon {
  width:60%;
}

h3 {
   color:#4287f5;

}

a {
   text-align:center; 

}

#confirmMsg{
      color:red;
   
   }
.miniSearchFrm_box {
	height: auto;
}
</style>

<script>
$(function(){
    $("#passwordConfrim").keyup(function(){
        if ($("#password").val()!=$("#passwordConfrim").val()){
           
            $('#confirmMsg').html('비밀번호가 일치 하지 않습니다.')
        }else{
           
          $('#confirmMsg').html('비밀번호가 일치합니다.')
        }
    })
})

</script>
<c:if test="${not empty message}">
<script>

   //window가 로드가 완료되면 result()메서드 호출
   window.onload=function(){
     result();
   }
   
   function result(){
      alert("아이디나  비밀번호가 틀립니다. 다시 로그인해주세요");
   }
</script>
</c:if>
<head>
<meta charset="EUC-KR">
<title>회원정보 변경 및 조회</title>
</head>

<body>
<div class="wrapper fadeInDown" style="background-color:white;">
  <div id="formContent">
    <!-- Tabs Titles -->
   <form>
   <img src="https://static.nid.naver.com/images/web/user/default.png">
   <h3><td>${memberVO.name}님</td><br/></h3>
   
   <h5><span style="margin-left:-58px;">아이디 : ${memberVO.id}</span><br/></h5>
   <h5><span style="margin-left:20px;">이메일 : ${memberVO.email}</span><br/></h5>
   
   </form>

    
    <form class="h" action="${contextPath}/mypage/Update.do" method="POST">
       <br/>
     <span>새로운 비밀번호</span>
     <td><input type="text"  style="margin-left:20px;" class="form-control" name='password' id='password'   value='${memberVO.password}'></td>
     <input type="text" style="margin-left:20px;" class="form-control" name="passwordConfrim" value='${memberVO.password}' id="passwordConfrim" minlength="6" maxlength="15" placeholder="비밀번호 확인"><br/> 
     <span id ="confirmMsg"></span><br/>
     
     <span>핸드폰 번호</span></br>
     <td><input type='text' style="margin-left:20px;" class="form-control" name='phone' id='phone'   value='${memberVO.phone}' ></td><br/>
     
     <span>주소</span></br>
     <td><input type='text' style="margin-left:20px;" class="form-control" name='address' id='address'   value='${memberVO.address}' ></td><br/>
       
       <span>직업</span></br>
     <td><input type='text' style="margin-left:20px;" class="form-control" name='djob5' id='djob5'   value='${memberVO.djob}' disabled></td><br/>
       
     <br/> 
     <span>직업 변경</span></br>
     <input type='radio' name='djob' value='웹프로그래머' /> 웹프로그래머
     <input type='radio' name='djob' value='데이터베이스' /> 데이터베이스
     <input type='radio' name='djob' value='시스템분석설계' /> 시스템분석설계 <br/>
     <input type='radio' name='djob' value='빅데이터AI' />  빅데이터AI
     <input type='radio' name='djob' value='HTML' /> HTML
   
   
     <td><input type='hidden' class="form-control" name='id' id='id'   value='${memberVO.id}' ></td><br/>
   
 <tr/>
 
 

                  
               
               <div class="form-group">
         <br/><br/>   
         </div>
          <input type="submit" class="fadeIn fourth" value="변경하기">
   </form>
     
      <br/>
      
      
      <form style="text-align:center">
      <h2 style="color:var(--color-navy); font-size:20px;">작성한 자기소개서 </h2>         
   <c:forEach var="myVO" items="${myLetter}" varStatus="status">
   <table style="margin:auto;">
   <td><span style="color:var(--color-navy);">${status.index +1}.</span> <a style="color:#aab0b5;" href="${contextPath}/mypage/myLetterDetail.do?no=${myVO.mlno}">${myVO.lTitle}</a></td></br>
   </table>
   </c:forEach>
    </form>

  

  </div>
</div>

   
</body>
</html>