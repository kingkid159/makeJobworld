package com.job.jobPro.edu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.job.jobPro.edu.service.EduPage;
import com.job.jobPro.edu.vo.EduVO;
@Repository("EduDAO")
public class EduDAOImpl implements EduDAO {
	
	@Autowired
	private SqlSession sqlSession;
	//전체 게시물 수를 확인하기위한 쿼리
	@Override
	public int selectEduCount() {
		int result = (Integer)sqlSession.selectOne("selectEduCount");
		return result;
	}
	//한 페이지에 보여줄 게시물을 불러오는 쿼리
	@Override
	public List<EduVO> EduList(int startNo,int size) {
		System.out.println("DAOSize="+size);
		EduPage eduPage = new EduPage(startNo,size);
		System.out.println("DAO에EduPage="+eduPage);
		//불러올것이 여러개이니 selectOne이 아닌 selectList를 사용한다.
		List<EduVO>result = (ArrayList)sqlSession.selectList("selectEduList",eduPage);
		return result;
	}
	
	//상세페이지
	@Override
	public EduVO selectEduDetail(int eno) {
		System.out.println("eno="+eno);
		EduVO result=(EduVO)sqlSession.selectOne("mapper.education.selectEduDetail", eno);
		return result;
	}
	//수정
	@Override
	public void eduModify(Map newEduMap) {
		sqlSession.update("eduModify",newEduMap);
	}
	//삭제
	@Override
	public void eduDelete(int eno) {
		sqlSession.update("eduDelete",eno);
	}
	
	//등록
	   @Override
	   public void insertEdu(Map newEduMap) throws DataAccessException {
	      sqlSession.insert("mapper.education.insertEduRegister",newEduMap);
	      
	   }
}
