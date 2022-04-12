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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<style>
.adminimg{
margin-top:20px; 
padding:5px;
}
.infotext{
font-size:20px;
}
.number{
font-size:28px;
margin:auto;
}
li{
 margin-bottom : 8px;
 }
.button{
   margin:5px;
   height:45px;
   width:300px;
   background-color:#ffffff;
   color:#130E68;
   border:1px solid #130E68;
   font-size:15px;
   text-align: center;
   cursor: pointer;
   }
#btnDelete{
	background-color:#ffffff;

}
 
</style>
<script>
$(document).ready(function(){
    $('#member').DataTable({
          "info" : false,
          "language": {
                "lengthMenu": " _MENU_씩 보여주기",
                "zeroRecords": "데이터가 없습니다.",
                "search" : "찾기:",
                "paginate" : {
                    "first" : "첫 페이지",
                    "last" : "마지막 페이지",
                    "next" : "다음",
                    "previous" : "이전",
                },
            }
    });
} );
</script>
<script type="text/javascript">
function delete_button(){
	if(confirm('삭제하시겠습니까?')==true){
		$('#btnForm').submit();
	}else{
		return false;
	}
}

</script>
<script language="JavaScript">  
expireDate = new Date  /// 현재의 날짜 객체를 생성합니다. 
expireDate.setMonth(expireDate.getDay()+6)  /// 현재 월에 6개월을 더합니다. 즉, 쿠키의 유효기간을 현재부터 6개월로 설정합니다. 
hitCt = eval(cookieVal("pageHit"))  /// 방문 카운트 변수이며 cookieVal 함수를 실행시킵니다. 
hitCt++  /// 방문 카운트를 1 높입니다. 
document.cookie = "pageHit="+hitCt+";expires=" + expireDate.toGMTString() /// 이곳에서 쿠키를 갱신합니다.   
function cookieVal(cookieName) {  /// cookieVal 함수를 선언합니다.   
   thisCookie = document.cookie.split("; ")  /// 쿠키의 문자열 구조가 '쿠키명=쿠키값; expires=유효기간' 이기 때문에 먼저 세미콜론(;)으로 나눕니다.(split) 
   for (i=0; i<thisCookie.length; i++) { /// ; 으로 나눈 만큼 반복문을 실행합니다. 여기서는 2번을 반복합니다.   
        if (cookieName == thisCookie[i].split("=")[0]) {  /// 먼저 thisCookie[i].split("=")[0]은 '쿠키명=쿠키값' 구조에서 =으로 나눈 배열의 첫번째 값을 지칭합니다. 즉, 쿠키명이 되겠습니다. 
             return thisCookie[i].split("=")[1]  /// thisCookie[i].split("=")[1] 은 =으로 나눈 배열의 두번째 값, 즉, 쿠키값이 됩니다. 
       }   
 }   
 return 0   
}   
</script>
</head>
<body>
<div style="width:1300px;height:2000px;margin:auto;">
   <div style="display:grid;margin:auto;justify-content: center;">
      <div style="width: 1500px; margin: 0 auto; margin-top:0px;
   padding-bottom: 10px;">
   <h1 style="text-align:center;">관리자 페이지</h1></div>
<hr/>
      <div style="display:grid; margin: 0 auto;  place-items: center; 
      grid-template-columns: repeat(6,130px 120px);height:150px; text-align: center; margin-top:10px; margin-bottom:10px;
       border-bottom: 2px solid var(--color-navy); border-top: 2px solid var(--color-navy);">

      <div style="margin:auto;">
         <div class="adminimg"><img src="${contextPath}/resources/image/etc/self.png" width="60px" height="60px"></div>  
         <div class="infotext">회원수</div>
      </div>
      <div class="number">${TotalNum.MemberTotal}명</div>
      <div>
         <div class="adminimg"><img src="${contextPath}/resources/image/etc/company.png" width="60px" height="60px"></div>
         <div class="infotext">회사수</div>
      </div>
         <div class="number">${TotalNum.CompanyTotal}회사</div>
      <div> 
        <div class="adminimg"><img src="${contextPath}/resources/image/etc/board.png" width="60px" height="60px"></div>      
         <div class="infotext">게시글 수</div>
      </div>
        <div class="number">${TotalNum.BoardTotal}개</div>
      <div>
       <div class="adminimg"><img src="${contextPath}/resources/image/etc/resuem.png" width="60px" height="60px"></div>      
         <div class="infotext">이력서 수</div>
      </div>   
         <div class="number">${TotalNum.ResumeTotal}개</div>
      <div>         
        <div class="adminimg"><img src="${contextPath}/resources/image/etc/letter.png" width="60px" height="60px"></div>
         <div class="infotext">자기소개서 수</div>
      </div>
         <div class="number">${TotalNum.LetterTotal}개</div>
      <div>         
        <div class="adminimg"><img src="${contextPath}/resources/image/etc/edu.png" width="60px" height="60px"></div>
         <div class="infotext">교육 수</div>
      </div>
         <div class="number">${TotalNum.EduTotal}개</div>
   </div>
</div>
<br/>
<div style="display:grid; grid-template-columns: 4fr 1fr 3fr;">
<div>
   <div style="width: 500px; margin: 0 auto; margin-top:10px;
      padding-bottom: 10px; border-bottom: 2px solid var(--color-navy); text-align:left;"><strong>회사 통계</strong></div>
   <br/><canvas id="an_graph" style="width:100%;height:80%;"></canvas>
</div>
<div></div>
<div>
<div style="width: 600px; margin: 0 auto; margin-top:10px;
      padding-bottom: 10px; border-bottom: 2px solid var(--color-navy); text-align:left;"><strong>작업 관리</strong></div>
<div style="padding-top:0px;">
   <ul style="list-style:none; text-align:center;">
   <li><input type="button" class="button"value="공고글작성" onclick="location.href='${contextPath}/admin/cList/add.do' "/></li>
   <li><input type="button" class="button"value="이력서샘플등록" onclick="location.href='${contextPath}/admin/resume/RegisterPage.do' "/></li>
   <li><input type="button" class="button"value="자소서샘플등록" onclick="location.href='${contextPath}/admin/letter/RegisterPage.do' "/></li>
    <li><input type="button" class="button"value="교육등록" onclick="location.href='${contextPath}/job/eduRegisterForm.do' "/></li>
<!--    <li><input type="button" class="button"value="자소서샘플등록" onclick="#"/></li> -->
   </ul>
</div>
</div>
</div>
<div style="width: 1300px; margin: 0 auto; margin-top:10px;
   padding-bottom: 10px; border-bottom: 2px solid var(--color-navy); text-align:center;"><h2>회원관리</h2></div>
<br/>
<table id="member" class="cell-border compact stripe" style="width:800px;">
   <thead>
      <tr style="background:#51B1FE;">
         <th>아이디</th>
         <th>이름</th>
         <th>성별</th>
         <th>이메일</th>
         <th>전화번호</th>
         <th>가입일</th>
         <th>희망직업</th>
         <th>삭제</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach var="member" items="${MemberList}">
   <tr>
      <td>${member.id}</td>
      <td>${member.name}</td>
      <td>${member.gender}</td>
      <td>${member.email}</td>
      <td>${member.phone}</td>
      <td>${member.regdate}</td>
      <td>${member.djob}</td>
      <td style="text-align:center;"><form action="${contextPath}/admin/memberDelete.do?id=${member.id}" id="btnForm" method="post">
          <input type="submit" name="del" id="btnDelete" value="삭제" onclick="return delete_button();">
          </form>
      </td>
      
   </tr>
   </c:forEach>
   </tbody>
</table>
</div>
<script>
/* Chart.defaults.font.size = 12; */
let an_graph = document.getElementById('an_graph').getContext('2d');
let pieChart = new Chart(an_graph,{
   type : 'pie',
   data : {
      labels : ['웹프로그램 ${CompanyVO.web}회사',
            '빅데이터/AI ${CompanyVO.ai}회사',
            '시스템 분석설계 ${CompanyVO.system}회사',
            '데이터베이스 ${CompanyVO.dataBase}회사',
            'HTML ${CompanyVO.html}회사'],
      datasets : [{
            label : '회사 수',
            backgroundColor:['rgb(255, 0, 102)','rgb(51, 102, 255)',
            'rgb(255, 153, 51)','rgb(0, 179, 0)','rgb(102, 0, 204)'],
            borderColor:['rgb(255, 0, 102)','rgb(51, 102, 255)',
            'rgb(255, 153, 51)','rgb(0, 179, 0)','rgb(102, 0, 204)'],
            data: [${CompanyVO.web},${CompanyVO.ai},
               ${CompanyVO.system},${CompanyVO.dataBase},${CompanyVO.html}],
      }]
   },
    options: {
      responsive: false,
      layout: {
            padding: 1
        },
      plugins: {
         title:{
             display: false,
   /*           position : top, */
             text: '회사 수  ${CompanyVO.total}회사',
             padding: {
                    top: 1,
                    bottom: 1
                },
             font:{
                size:25,
             }
         },
         legend: {
            display:true,
            position: 'right',
            labels:{
               color:'rgb(0, 0, 0)'
            },
   
      }
   },
} 
})
</script>
</body>
</html>