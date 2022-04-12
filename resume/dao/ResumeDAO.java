package com.job.jobPro.resume.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.job.jobPro.resume.vo.ResumeVO;






//상품(goods)관련 DAO 인터페이스
public interface ResumeDAO {

	//멤버조회
	/*select결과가 여러개의 컬럼이면(다양한 타입이면)	 VO혹은 DTO 또는 Map으로 처리한다
	   여기에서는 VO로 처리한다*/
	public abstract List<ResumeVO> selectResumeList() throws DataAccessException;
	
	public abstract int selectCount() throws DataAccessException;
	
	public abstract List<ResumeVO> selectResume(int startRow,int size) throws DataAccessException;
	
	public abstract ResumeVO selectById(int no) throws DataAccessException;
	
	public abstract void insert(ResumeVO resumeVO) throws DataAccessException;
	
	public abstract void update(ResumeVO resumeVO) throws DataAccessException;
	
	public abstract void delete(ResumeVO resumeVO) throws DataAccessException;

}









