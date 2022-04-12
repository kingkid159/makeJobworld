package com.job.jobPro.mypage.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;
import com.job.jobPro.member.vo.MemberVO;
import com.job.jobPro.mypage.dao.MyPageDAO;

@Service("myPageService")
public class MyPageServiceImpl implements MyPageService {

	//field
	@Autowired
	private MyPageDAO  myPageDAO;
	
	//내 자기소개서 가져오기
	public List<MyLetterVO> selectMyLetter(String userId) throws Exception{
		System.out.println("DAO"+userId);
		List<MyLetterVO> myLetterVO = myPageDAO.selectMyLetter(userId);
		System.out.println(myLetterVO);
		return myLetterVO;
	};
	
	//회원정보수정
	@Override
	public void myPageUpdate(MemberVO memberVO) throws Exception {
		myPageDAO.memberUpdate(memberVO);
		
	}

	@Override
	public int updateMyLetter(MyLetterVO myLetterVO) {
		int result = myPageDAO.updateMyLetter(myLetterVO);
		return result;
	}
	
	@Override
	public int deleteMyLetter(int LetterNum) {
		int result = myPageDAO.deleteMyLetter(LetterNum);
		return result;
	}

	@Override
	public MyLetterVO getMyLetter(int LetterNum) {
		MyLetterVO myletterVO = myPageDAO.selectByNo(LetterNum);
		if(myletterVO==null) {
			throw new RuntimeException();
		}
		if(myletterVO.getlTitle()==null) {
			throw new RuntimeException();
		}
		return myletterVO;
	}
	
}










