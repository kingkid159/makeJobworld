package com.job.jobPro.edu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.job.jobPro.edu.vo.EduVO;

public interface EduDAO {
	public int selectEduCount();
	public List<EduVO> EduList(int startPage, int size);
	
	//상세조회
	public EduVO selectEduDetail(int eno);
	
	//수정
	public void eduModify(Map newEduMap);
	
	//삭제
	public void eduDelete(int eno);
	
	public void insertEdu(Map newEduMap) throws DataAccessException;

}
