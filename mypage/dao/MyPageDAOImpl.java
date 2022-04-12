package com.job.jobPro.mypage.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;
import com.job.jobPro.member.vo.MemberVO;

@Repository("myPageDAO")
public class MyPageDAOImpl implements MyPageDAO {

	//필드 -[접근제어] [속성] 데이터타입 필드명[=] new  SqlSession(~);
	//@Autowired를 가진   클래스의 전역변수선언만하면 객체가 자동으로 주입->Spring의 의존성
	//자동주입 : 등록된 Bean의 주소가 자동으로 주입
	@Autowired
	private  SqlSession sqlSession;
		
		//회원정보수정
		@Override
		public void memberUpdate(MemberVO memberVO) throws DataAccessException {
			System.out.println(memberVO);
				sqlSession.update("mapper.myPage.memberUpdate", memberVO); 

		}
		//내 자기소개서 가져오기
		@Override
		public List<MyLetterVO> selectMyLetter(String userId) throws DataAccessException{
			System.out.println("dao 진입");
			System.out.println(userId);
			List<MyLetterVO> result = (ArrayList)sqlSession.selectList("mapper.myPage.selectMyLetter",userId);
			return result;
		};
		//내 자기소개서 보기
		@Override
		public MyLetterVO selectByNo(int no) {
			System.out.println(no);
			MyLetterVO myLetterVO = (MyLetterVO)sqlSession.selectOne("mapper.myPage.selectNoMyLetter",no);
			System.out.println(myLetterVO.toString());
			return myLetterVO;
		}
		
		
		//자기소개서 업데이트
		@Override
		public int updateMyLetter(MyLetterVO myLetterVO) {
			System.out.println("update");
			int result =sqlSession.update("mapper.myPage.updateMyLetter",myLetterVO);
			System.out.println("내 자기소개서가 업데이트 되었습니다."+result);
			return result;
		}
		
		//이력서 삭제 
		@Override
		public int deleteMyLetter(int letterNum) {
			int result =sqlSession.delete("mapper.myPage.deleteMyLetter",letterNum);
			System.out.println("내 자기소개서가 삭제되었습니다."+result);
			return result;
		}
}






