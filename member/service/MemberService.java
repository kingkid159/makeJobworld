package com.job.jobPro.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.job.jobPro.member.vo.MemberVO;

public interface MemberService {

	//id중복확인
	public String selectOverlappedId(String id) throws Exception;
	
	
	//회원가입
	public void insertMember(MemberVO memberVO) throws Exception;

	//로그인 
	public MemberVO login(Map<String, String> loginMap) throws Exception;
	
	//회원탈퇴
	public void memberDelete(MemberVO memberVO) throws Exception;

	//아이디찾기
	public String find_id(HttpServletResponse response, String email) throws Exception;
	//비번찾기
	public String find_pw(HttpServletResponse response, String id) throws Exception;

	









	
	


}
