package com.job.jobPro.member.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.job.jobPro.member.vo.MemberVO;

public interface MemberDAO {

	//추상메서드
	//id중복확인
	public String selectOverlappedId(String id) throws DataAccessException;
	//회원가입
	public void  insertMember(MemberVO memberVO) throws DataAccessException;
	
	//로그인처리
	public MemberVO login(Map<String, String> loginMap) throws DataAccessException;
	
	// 회원 탈퇴
	public void memberDelete(MemberVO memberVO)	throws DataAccessException;
	
	//아이디 찾기
	public String find_id(String email) throws DataAccessException;
	
	//비번 찾기
	public String find_pw(String id) throws DataAccessException;
	





	




}
