<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"
   isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html> 
<html lang="ko"> 

<head> 
   <meta charset="UTF-8"> 
   <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
   <title>회원가입</title> 
   
   <!-- Bootstrap CSS --> 
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
   
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
   
   <style>
   
   a {
   color:black;}
   .miniSearchFrm_box {
   height:auto;
   }
   h4{
   text-align:center;
   } 
   body { 
   min-height: 100vh; 
   background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c)); 
   background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%); 
   background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%); 
   background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%); 
   background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%); 
   } 
   
   .input-form { 
   max-width: 680px; 
   margin-top: 80px; 
   padding: 32px; 
   background: #fff; 
   -webkit-border-radius: 10px; 
   -moz-border-radius: 10px; 
   border-radius: 10px; 
   -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15); 
   -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
    box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
     } 
     
   #confirmMsg{
      color:red;
   
   }
    </style>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">
   /* 자바 스크립트 함수 선언(비밀번호 확인) */


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

<script>

function fn_overlapped(){
   
   var userId = $("#id").val();
   
   if(userId==''){ 
     alert("ID를 입력하세요");
     $("#id").focus(); 
     return;
   }
   
   $.ajax({
       async:false, 
       type:"post", 
       url:"${contextPath}/member/overlappedId.do",
       data: {id:userId},
       success:function (data,textStatus){
           
          
         if(data=='false'){
            alert("사용할 수 있는 ID입니다");   
            
            $("#id2").prop("disabled",true);  
            
            $("#btnOverlapped").prop("disabled",true);
         
            $("#id").val(userid);
            
         }else{
            alert("사용할 수 없는 ID입니다");
            $("#id2").focus();
         }
       },
       error:function(data,textStatus){
         alert("에러가 발생했습니다.");
       }
   });
}

 //----------------------------------
 //달력선택 datepicker
   
    $.datepicker.setDefaults({
        dateFormat: 'yymmdd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true ,
        changeYear: true,
        changeMonth: true,
        yearRange: 'c-100:c+10',
        showAnim: "fade",
        closeText: '닫기',
        yearSuffix: '년'
    });

    $(function() {
        $("#birth").datepicker();
        
        
    });
</script>
   
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
   
   //다음 주소 API
   function execDaumPostcode(){
      new daum.Postcode({
         oncomplete: function(data) {
          
            var roadAddr = data.roadAddress; 
            var extraRoadAddr = ''; 

            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
            }
       
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
     
            if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

         
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("roadAddress").value = roadAddr;
            document.getElementById("jibunAddress").value = data.jibunAddress;

            if(roadAddr !== ''){
               document.getElementById("extraAddress").value = extraRoadAddr;
            } else {
               document.getElementById("extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
         
            if(data.autoRoadAddress) {
               var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
               guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
               guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
               var expJibunAddr = data.autoJibunAddress;
               guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
               guideTextBox.style.display = 'block';
            } else {
               guideTextBox.innerHTML = '';
               guideTextBox.style.display = 'none';
            }
         }
      }).open();
   }
</script> 
</head> 

<body> 
   <div class="container"> 
   <div class="input-form-backgroud row"> 
   <div class="input-form col-md-12 mx-auto"> 
      
      <h4 class="mb-3">회원가입</h4>
    <form class="validation-form" action="${contextPath}/member/homes.do" method="POST" > 
    <div class="row"> 
    
       <!-- 아이디 -->
       <div class="col-md-6 mb-3">
     <label for="name">아이디(4자이상)</label> 
     <input type="text" class="form-control" name="id" id="id" placeholder="" value="" minlength="4" maxlength="15" required> 
     <input type="hidden"   name="id2"  id="id2"/>
     <input type="button"  id="btnOverlapped" value="중복체크" onClick="fn_overlapped()" />
        <div class="invalid-feedback"> 아이디를 입력해주세요. </div> 
        
     </div> <div class="col-md-6 mb-3"> 
     
     <!-- 비밀번호 -->
     <label for="nickname">비밀번호(6자이상)</label> 
     <input type="password" class="form-control" name="password" id="password" placeholder="" value="" minlength="4" maxlength="15" required>  
     <input type="password" class="form-control" name="passwordConfrim" id="passwordConfrim" minlength="6" maxlength="15" placeholder="비밀번호 확인"> 
     <span id ="confirmMsg"></span>
     <div class="invalid-feedback"> 비밀번호를 입력해주세요. 
     </div> 
   </div> 
 </div> 
    <!-- 이름 -->
    <div class="mb-3"> 
     <label for="name">이름</label> 
     <input type="name" class="form-control" id="name" name="name" placeholder="홍길동" required> 
     <div class="invalid-feedback"> 이름을 입력해주세요. 
     </div> 
   </div> 
    
    <!-- 생년월일 -->
    <div>
       <div class="mb-3"> 
          <lable for="birth">생년월일</lable>
         <input type="text" class="form-control" name="birth"id="birth" required>
         <div class="invalid-feedback"> 생년월일을 입력해주세요.
         </div>
   </div>
 
    
    <!-- 이메일 -->
     <div class="mb-3"> <br/>
     <label for="email">이메일</label> 
     <input type="email" class="form-control" id="email"  name="email" placeholder="www@naver.com" required> 
     <div class="invalid-feedback"> 이메일을 입력해주세요. 
     </div> 
   </div> 
   
   
   
   <!-- 핸드폰번호 -->
    <div>
          <label for="phone">핸드폰 번호</label>
            <br/>
            <input type="text" name="phone" class="form-control" id="phone1" maxlength=11 required>
           <div class="invalid-feedback"> 번호를 입력해주세요.
         <c:if test="${errors.phone}"><span class='error'>핸드폰 번호를 입력하세요</span></c:if>
   </div>  
   
   <!-- 주소 -->
    <div class='mb-3' required> <br/>
    <label for="address" >주소</label><br/>
           
         <input type="text" class="form-control" name="address" id="postcode" placeholder="우편번호" required><br/>
         <input class='execDaum' type="button" onclick="execDaumPostcode()" value="우편번호 찾기" ><br>
         <input type="text" class="form-control" name="address"id="roadAddress" placeholder="도로명주소">
         <input type="hidden" class="form-control" id="jibunAddress" placeholder="지번주소">
         <span id="guide" style="color:#999;display:none"></span>
         <input type="text" class="form-control" name="address" id="detailAddress" placeholder="상세주소">
         <input type="hidden" id="extraAddress" placeholder="참고항목">
        <div class="invalid-feedback">  주소를 입력해주세요.</div> 
   
   <!-- 성별 -->
   </div>
    <div class='mb-3'>    
    <label for="sex">성별</label><br/>
   <input type='radio' name='gender' value='남'  onclick='checkOnlyOne(this)'    required/> 남자
   <input type='radio' name='gender' value='여' onclick='checkOnlyOne(this)'   required/> 여자
    <div class="invalid-feedback">  성별을 확인해주세요.</div> 
    </br></div>
    
    
    <!-- 희망직종 -->
     <div class='mb-3'>
    <label for="job">희망직종</label><br/>
   <input type='radio' style="color:green"; name='djob' value='웹프로그래머' onclick='checkOnlyOne(this)'/> 웹프로그래머
   <input type='radio' name='djob' value='데이터베이스' onclick='checkOnlyOne(this)'/> 데이터베이스
   <input type='radio' name='djob' value='시스템분석설계' onclick='checkOnlyOne(this)'/> 시스템분석설계
   <input type='radio' name='djob' value='빅데이터AI' onclick='checkOnlyOne(this)'/>  빅데이터AI
   <input type='radio' name='djob' value='HTML' onclick='checkOnlyOne(this)'/> HTML
   
   
    </br></div>
   
   
     <!-- 등급 -->
     <div class='mb-3'>
    <label for="job">등급</label><br/>
   <input type='radio' style="color:green"; name='grade' value='일반' onclick='checkOnlyOne(this)'/> 일반
   <input type='radio' name='grade' value='기업' onclick='checkOnlyOne(this)'/> 기업
   
   
    </br></div>
   
   <!-- 개인정보수집 동의 -->
   <div class="custom-control custom-checkbox"> 
   <input type="checkbox" class="custom-control-input" id="aggrement" required> 
   <br/><br/>
   <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label> 
   </div> 
   <div class="mb-4"></div> 
   <button class="btn btn-primary btn-lg btn-block" type="submit">회원가입</button> 
   
   </form> 
   </div> 
  </div> 
     <!-- 상표 -->
  <footer class="my-3 text-center text-small"> 
  <p class="mb-1">&copy;재성</p> 
  </footer> 
  </div> 
  <script> 
     window.addEventListener('load', 
           ()=> { const forms = document.getElementsByClassName('validation-form');
     Array.prototype.filter.call(forms, (form) => { form.addEventListener('submit', function (event) { 
        if (form.checkValidity() === false) { 
           event.preventDefault(); event.stopPropagation();} 
     form.classList.add('was-validated'); }, false); }); }, false); 
     </script> 
  </body> 
 </html>
