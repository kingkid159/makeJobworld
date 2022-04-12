package com.job.jobPro.admin.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.resume.vo.ResumeVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	SqlSession sqlSession;
	//////////////////////////////////////////////////////////////////////////////
	//이력서 등록
	@Override
	public int resumeRegister(ResumeVO resumeVO) {
		System.out.println("insertResumeDAO");
		System.out.println(resumeVO);
		int result = sqlSession.insert("mapper.admin.resumeRegister",resumeVO);
		System.out.println("result"+result);
		return result;
	}
	
	@Override
	public int resumeUpdate(ResumeVO resumeVO) {
		System.out.println("updateResumeDAO"+resumeVO);
		int result = sqlSession.update("mapper.admin.resumeUpdate",resumeVO);
		System.out.println(result);
		return result;
	}
	
	@Override
	public int resumeDelete(int resumeNo) {
		System.out.println("deleteResumeDAO");
		int result = sqlSession.delete("mapper.admin.resumeDelete",resumeNo);
		System.out.println(result);
		return result;
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	//자기소개서 등록
	@Override
	public int letterRegister(LetterVO letterVO) {
		System.out.println("insertResumeDAO");
		int result = sqlSession.insert("mapper.admin.letterRegister",letterVO);
		System.out.println(result);
		return result;
	}
	
	@Override
	public int letterUpdate(LetterVO letterVO) {
		System.out.println("updateLetterDAO");
		System.out.println("update"+letterVO);
		int result = sqlSession.update("mapper.admin.letterUpdate",letterVO);
		System.out.println(result);
		return result;
	}
	
	@Override
	public int letterDelete(int letterNo) {
		System.out.println("letterDeleteDAO");
		int result = sqlSession.delete("mapper.admin.letterDelete", letterNo);
		System.out.println(result);
		return result;
	}
}
