package com.job.jobPro.resume.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.resume.vo.ResumeVO;


/*SqlSessionFactory 에서 SqlSession 만들기
SqlSessionFactory 이름에서 보듯이 SqlSession 인스턴스를 만들수 있다.
SqlSession 은 데이터베이스에 대해 SQL명령어를 실행하기 위해 필요한 모든 메소드를 가지고 있다. 
그래서 SqlSession 인스턴스를 통해 직접 SQL 구문을 실행할 수 있다.*/
/*bean 등록시
 * <bean id="goodsDAO"  class="com.mycom.goods.dao.GoodsDAOImpl">
 * </bean>
 */

@Repository("resumeDAO")
public class ResumeDAOImpl implements ResumeDAO {
	
	//SQL 세션 AUTOWIRED
	@Autowired
	SqlSession sqlSession;
	
	//이력서 조회
	@Override
	public List<ResumeVO> selectResumeList() {
		System.out.println("ResumeVO");
		List<ResumeVO> resumeList =(ArrayList)sqlSession.selectList("mapper.resume.selectResumeList");
		System.out.println(resumeList);
		return resumeList;
	}
	
	//페이징 처리
	//이력서 총 갯수
	@Override 
	public int selectCount() {
		System.out.println("selectCount");
		int pageNumber = sqlSession.selectOne("mapper.resume.selectPageNum");
		return pageNumber;
	}
	
	//한 페이지에 보여줄 이력서 숫자 
	@Override
	public List<ResumeVO> selectResume(int startRow,int size){
	 Map map = new HashMap();
	 map.put("startRow", startRow);
	 map.put("size", size);
	 System.out.println("selectResume");
	 System.out.println(startRow);
	 System.out.println(size);
	 List<ResumeVO> result = (ArrayList)sqlSession.selectList("mapper.resume.selectResumeNo",map);
	 return result;
	}
	
	//선택한 이력서 내용
	@Override
	public ResumeVO selectById(int no) {
		System.out.println(no);
		ResumeVO resumeVO = (ResumeVO)sqlSession.selectOne("mapper.resume.selectNoResume",no);
		System.out.println(resumeVO.toString());
		return resumeVO;
	}
	
	//이력서 입력
	@Override
	public void insert(ResumeVO resumeVO) {
		int result =sqlSession.insert("mapper.member.insertResume",resumeVO);
		System.out.println("이력서가 입력되었습니다."+result);
	}
	
	//이력서 업데이트
	@Override
	public void update(ResumeVO resumeVO) {
		int result =sqlSession.update("mapper.member.updateResume",resumeVO);
		System.out.println("이력서가 업데이트 되었습니다."+result);
	}
	
	//이력서 삭제 
	@Override
	public void delete(ResumeVO resumeVO) {
		int result =sqlSession.delete("mapper.member.deleteResume",resumeVO);
		System.out.println("이력서가 삭제되었습니다."+result);
	}
	
	
}
   







