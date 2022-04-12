package com.job.jobPro.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.job.jobPro.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	//필드 -[접근제어] [속성] 데이터타입 필드명[=] new  SqlSession(~);
	//@Autowired를 가진   클래스의 전역변수선언만하면 객체가 자동으로 주입->Spring의 의존성
	//자동주입 : 등록된 Bean의 주소가 자동으로 주입
	@Autowired
	private  SqlSession sqlSession;
	
	//id중복확인
		@Override
		public String selectOverlappedId(String id) throws DataAccessException {
			return (String)sqlSession.selectOne("mapper.member.selectOverlappedId",id);
		}
	
	//회원가입
	@Override
	public void insertMember(MemberVO memberVO) throws DataAccessException {
		//insert의 리턴유형은 int : insert가 성공적으로 실행된 record수
		//여기에서는 1을 리턴받으면 insert성공
		int result 
		 = sqlSession.insert("mapper.member.insertMember", memberVO);
		System.out.println("insertMember()의 실행결과 result="+result);//확인용
	}

	//로그인처리
		@Override
		public MemberVO login(Map<String, String> loginMap) throws DataAccessException {
			return (MemberVO)sqlSession.selectOne("mapper.member.login", loginMap);
		}
		
		
		//회원탈퇴
		@Override
		public void memberDelete(MemberVO memberVO) throws DataAccessException {
			sqlSession.delete("mapper.member.memberDelete", memberVO);
			
		}
		
		// 아이디 찾기
		public String find_id(String email) throws DataAccessException{
			return sqlSession.selectOne("mapper.member.find_id", email);
		}
		
		// 아이디 찾기
		public String find_pw(String id) throws DataAccessException{
			return sqlSession.selectOne("mapper.member.find_pw", id);
		}
		
	
}






