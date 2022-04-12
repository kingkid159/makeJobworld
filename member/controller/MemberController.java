package com.job.jobPro.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.member.vo.MemberVO;

public interface MemberController {
	
	/*참고 ResponseEntity는 
	 * 서버가 클라이언트에게 보내주는 리소스,상태코드,상태메세지등을 포함시켜줄 때 주로 사용
	 * HttpEntity클래스를 상속받아 구현한 클래스가 RequestEntity, ResponseEntity
	 * HttpStatus.OK : 200(성공): 서버가 요청을 제대로 처리했다는 뜻이다. 
		                        이는 주로 서버가 요청한 페이지를 제공했다는 의미로 쓰인다.*/
	
	//id중복확인
	public ResponseEntity overlappedId(String id, HttpServletRequest request, 
				HttpServletResponse response) throws Exception;
		
	
	//회원가입
	public ResponseEntity insertMember(MemberVO memberVO,HttpServletRequest request, 
				HttpServletResponse response) throws Exception;
		
	//회원가입요청시 호출되는 요청함수
	public String memberForm(HttpServletRequest request,
				HttpServletResponse response);
	
	
	//로그인폼 요청시  호출되는 요청함수
	public String loginform(HttpServletRequest request,
				HttpServletResponse response) throws Exception;

	//로그인 
	public ModelAndView login(Map<String, String> loginMap, ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
		
	//로그아웃 처리
	public ModelAndView login(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception;

	//main2
	public String main2(HttpServletRequest request,
				HttpServletResponse response) throws Exception;
	//마이페이지
	public abstract String myPageMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	//탈퇴
	public String del(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	

}
