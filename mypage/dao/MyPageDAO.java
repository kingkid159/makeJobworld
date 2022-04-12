package com.job.jobPro.mypage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;
import com.job.jobPro.member.vo.MemberVO;

public interface MyPageDAO {


	// 회원정보 수정
	public void memberUpdate(MemberVO memberVO) throws DataAccessException;
	public List<MyLetterVO> selectMyLetter(String userID) throws DataAccessException;
	public int updateMyLetter(MyLetterVO myLetterVO) throws DataAccessException;
	public int deleteMyLetter(int letterNum) throws DataAccessException;
	public MyLetterVO selectByNo(int no) throws DataAccessException;

}
