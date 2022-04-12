package com.job.jobPro.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.resume.dao.ResumeDAO;
import com.job.jobPro.resume.vo.ResumePage;
import com.job.jobPro.resume.vo.ResumeVO;





/*bean등록시
 * <bean id="goodsService"
 * 		 class="com.mycom.goods.service.GoodsServiceImpl">
 * </bean>
 */

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	//Controller<->Service<->Dao<->MyBatis<->DB
	//여기에서는  기존의 방식을 사용하여 객체를 직접 생성하여 참조변수에 할당-> 의존성적용시킬예정
	//클래스명       참조변수 = new 클래스명();
	//부모클래스명  참조변수 = new 자식클래스명();
	//인터페이스명  참조변수 = new 구현클래스명(); //현재방식
	//GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	@Autowired 
	private ResumeDAO resumeDAO;
	private int size =6;
	//회원목록조회
	/*select결과가 여러개의 컬럼이면(다양한 타입이면)	 VO혹은 DTO 또는 Map으로 처리한다
	   여기에서는 VO로 처리한다*/
	
	@Override
	public List<ResumeVO> resumeList() {
		System.out.println("디테일");
		List<ResumeVO> ResumeList = resumeDAO.selectResumeList();
		System.out.println(ResumeList);
		return ResumeList;
	}
	
	@Override
	public ResumePage getResumePage(int pageNum) {
		int total = resumeDAO.selectCount();
		System.out.println("total"+total);
		List<ResumeVO> content = resumeDAO.selectResume((pageNum-1)*size,(pageNum)*size);
		return new ResumePage(total,pageNum,size,content);
	}
	
	@Override
	public ResumeVO getResume(int NoticeNum) {
		ResumeVO resumeVO = resumeDAO.selectById(NoticeNum);
		if(resumeVO==null) {
			throw new RuntimeException();
		}
		if(resumeVO.getR_ex()==null) {
			throw new RuntimeException();
		}
		return resumeVO;
		
	}
	
	
}





