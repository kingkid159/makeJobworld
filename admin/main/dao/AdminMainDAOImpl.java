package com.job.jobPro.admin.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.admin.main.vo.CompanyVO;
import com.job.jobPro.member.vo.MemberVO;





@Repository("adminMemberDAO")
public class AdminMainDAOImpl implements AdminMainDAO {

	//필드 -[접근제어] [속성] 데이터타입 필드명[=] new  SqlSession(~);
	//@Autowired를 가진   클래스의 전역변수선언만하면 객체가 자동으로 주입->Spring의 의존성
	//자동주입 : 등록된 Bean의 주소가 자동으로 주입
	@Autowired
	private  SqlSession sqlSession;

		//회원 리스트
		@Override
		public List<MemberVO> selectMemberDetail()throws Exception{
			return (ArrayList)sqlSession.selectList("mapper.adminMain.selectMemberDetail");
		}
		
		//회원 수 
		@Override
		public int selectMemberNum() throws Exception{
			return sqlSession.selectOne("mapper.adminMain.selectMemberTotal");
		}
		
		@Override
		public int selectCompanyNum() throws Exception{
			return sqlSession.selectOne("mapper.adminMain.selectCompanyTotal");
		}
		
		@Override
		public int selectBoardNum() throws Exception{
			return sqlSession.selectOne("mapper.adminMain.selectBoardTotal");
		}
		
		@Override
		public int selectLetterNum() throws Exception{
			return sqlSession.selectOne("mapper.adminMain.selectLetterTotal");
		}
		
		@Override
		public int selectEduNum() throws Exception{
			return sqlSession.selectOne("mapper.adminMain.selectEduTotal");
		}
		
		@Override
		public int selectResumeNum() throws Exception{
			return sqlSession.selectOne("mapper.adminMain.selectResumeTotal");
		}
		
		@Override
		public CompanyVO getCompany() throws Exception {
			CompanyVO companyVO = (CompanyVO)sqlSession.selectOne("mapper.adminMain.selectCompany");
			return companyVO;
		}
		
		
		
		//회원 삭제 
		@Override
		public void deleteMember(String id) throws Exception {
			sqlSession.delete("mapper.adminMain.deleteMember", id);
		}
}






