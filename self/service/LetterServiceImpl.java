package com.job.jobPro.letter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.letter.dao.LetterDAO;
import com.job.jobPro.letter.vo.LetterPage;
import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;







/*bean등록시
 * <bean id="goodsService"
 * 		 class="com.mycom.goods.service.GoodsServiceImpl">
 * </bean>
 */

@Service("letterService")
public class LetterServiceImpl implements LetterService {

	//Controller<->Service<->Dao<->MyBatis<->DB
	//여기에서는  기존의 방식을 사용하여 객체를 직접 생성하여 참조변수에 할당-> 의존성적용시킬예정
	//클래스명       참조변수 = new 클래스명();
	//부모클래스명  참조변수 = new 자식클래스명();
	//인터페이스명  참조변수 = new 구현클래스명(); //현재방식
	//GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	@Autowired 
	private LetterDAO letterDAO;
	private int size =6;
	//회원목록조회
	/*select결과가 여러개의 컬럼이면(다양한 타입이면)	 VO혹은 DTO 또는 Map으로 처리한다
	   여기에서는 VO로 처리한다*/
	
	@Override
	public List<LetterVO> letterList() {
		List<LetterVO> letterList = letterDAO.selectLetterList();
		System.out.println(letterList);
		return letterList;
	}
	
	@Override
	public LetterPage getLetterPage(int pageNum) {
		int total = letterDAO.selectCount();
		System.out.println("total"+total);
		List<LetterVO> content = letterDAO.selectLetter((pageNum-1)*size,(pageNum)*size);
		System.out.println("이미지폼"+content.get(1).getLno());
		return new LetterPage(total,pageNum,size,content);
	}
	
	
	@Override
	public LetterVO getLetter(int LetterNum) {
		LetterVO letterVO = letterDAO.selectByNo(LetterNum);
		if(letterVO==null) {
			throw new RuntimeException();
		}
		if(letterVO.getlTitle()==null) {
			throw new RuntimeException();
		}
		return letterVO;
	}
	
	@Override
	public int insertLetter(MyLetterVO myletterVO) {
		System.out.println(myletterVO.toString());
		int result = letterDAO.insertLetter(myletterVO);
		if(myletterVO==null) {
			throw new RuntimeException();
		}
		if(myletterVO.getlTitle()==null) {
			throw new RuntimeException();
		}
		return result;
	}
	
	@Override
	public void letterUpdate(String userId) {
		System.out.println(userId);
		letterDAO.updateLetter(userId);
		
	};
}





