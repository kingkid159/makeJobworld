package com.job.jobPro.letter.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;



/*SqlSessionFactory 에서 SqlSession 만들기
SqlSessionFactory 이름에서 보듯이 SqlSession 인스턴스를 만들수 있다.
SqlSession 은 데이터베이스에 대해 SQL명령어를 실행하기 위해 필요한 모든 메소드를 가지고 있다. 
그래서 SqlSession 인스턴스를 통해 직접 SQL 구문을 실행할 수 있다.*/
/*bean 등록시
 * <bean id="goodsDAO"  class="com.mycom.goods.dao.GoodsDAOImpl">
 * </bean>
 */

@Repository("letterDAO")
public class LetterDAOImpl implements LetterDAO {
	
	//SQL 세션 AUTOWIRED
	@Autowired
	SqlSession sqlSession;
	
	//이력서 조회
	@Override
	public List<LetterVO> selectLetterList() {
		System.out.println("LetterVO");
		List<LetterVO> letterList =(ArrayList)sqlSession.selectList("mapper.letter.selectLetterList");
		System.out.println(letterList);
		return letterList;
	}
	
	//페이징 처리
	//이력서 총 갯수
	@Override 
	public int selectCount() {
		System.out.println("selectCountletter");
		int pageNumber = sqlSession.selectOne("mapper.letter.selectPageNum");
		return pageNumber;
	}
	
	//한 페이지에 보여줄 이력서 숫자 
	@Override
	public List<LetterVO> selectLetter(int startRow,int size){
	 Map map = new HashMap();
	 map.put("startRow", startRow);
	 map.put("size", size);
	 System.out.println("selectLetter");
	 System.out.println(startRow);
	 System.out.println(size);
	 List<LetterVO> result = (ArrayList)sqlSession.selectList("mapper.letter.selectLetterNo",map);
	 System.out.println("result"+result);
	 return result;
	}
	
	//선택한 이력서 내용
	@Override
	public LetterVO selectByNo(int no) {
		System.out.println(no);
		LetterVO letterVO = (LetterVO)sqlSession.selectOne("mapper.letter.selectNoLetter",no);
		System.out.println(letterVO.toString());
		return letterVO;
	}

	//이력서 입력
	@Override
	public int insertLetter(MyLetterVO myletterVO) {
		System.out.println(myletterVO.toString());
		int result =sqlSession.insert("mapper.letter.insertLetter",myletterVO);
		System.out.println("이력서가 입력되었습니다."+result);
		return result;
	}
	
	//이력서 업데이트
	@Override
	public void updateLetter(String userID) {
		int result =sqlSession.update("mapper.letter.updateResume",userID);
		System.out.println("이력서가 업데이트 되었습니다."+result);
	}
	
	//이력서 삭제 
	@Override
	public void deleteLetter(LetterVO letterVO) {
		int result =sqlSession.delete("mapper.letter.deleteResume",letterVO);
		System.out.println("이력서가 삭제되었습니다."+result);
	}
	
	
}
   







