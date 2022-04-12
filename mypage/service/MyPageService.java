package com.job.jobPro.mypage.service;


import java.util.List;

import com.job.jobPro.letter.vo.MyLetterVO;
import com.job.jobPro.member.vo.MemberVO;

public interface MyPageService {

	//회원정보 수정
	public void myPageUpdate(MemberVO memberVO) throws Exception;
	//내 자기소개서 가져오기
	public List<MyLetterVO> selectMyLetter(String userId) throws Exception;

	public MyLetterVO getMyLetter(int LetterNum) ;
	
	public int updateMyLetter(MyLetterVO myLetterVO);
	
	public int deleteMyLetter(int LetterNum);


}
