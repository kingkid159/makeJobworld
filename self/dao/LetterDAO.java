package com.job.jobPro.letter.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;







//상품(goods)관련 DAO 인터페이스
public interface LetterDAO {

	//멤버조회
	/*select결과가 여러개의 컬럼이면(다양한 타입이면)	 VO혹은 DTO 또는 Map으로 처리한다
	   여기에서는 VO로 처리한다*/
	public abstract List<LetterVO> selectLetterList() throws DataAccessException;
	
	public abstract int selectCount() throws DataAccessException;
	
	public abstract List<LetterVO> selectLetter(int startRow,int size) throws DataAccessException;
	
	public abstract LetterVO selectByNo(int no) throws DataAccessException;
	
	public abstract int insertLetter(MyLetterVO myletterVO) throws DataAccessException;
	
	public abstract void updateLetter(String userID) throws DataAccessException;
	
	public abstract void deleteLetter(LetterVO letterVO) throws DataAccessException;


}









