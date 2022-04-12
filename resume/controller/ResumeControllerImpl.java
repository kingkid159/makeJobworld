package com.job.jobPro.resume.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.resume.service.ResumeService;
import com.job.jobPro.resume.vo.ResumePage;
import com.job.jobPro.resume.vo.ResumeVO;






@Controller("resumeController")
public class ResumeControllerImpl implements ResumeController{
	
	//Controller<->Service<->Dao<->MyBatis<->DB
		//여기에서는  기존의 방식을 사용하여 객체를 직접 생성하여 참조변수에 할당-> 의존성적용시킬예정
		//클래스명       참조변수 = new 클래스명();
		//부모클래스명  참조변수 = new 자식클래스명();
		//인터페이스명  참조변수 = new 구현클래스명(); //현재방식
		//goodsService참조변수에  객체주소저장했던 방식이 jsp에서 사용
		//GoodsService  goodsService = new GoodsServiceImpl();
		
		//bean등록한 것을 자동주입방식으로 사용
	
	
	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	@RequestMapping(value="/resume/resumeList.do")
	public ModelAndView resumeList(HttpServletRequest request
			, HttpServletResponse response)  throws Exception{
		System.out.println("resumeList");
		//2.비즈니스로직수행<->Service<->Dao<->(MyBatis)<->DB
		String pageNoVal = request.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal!=null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ResumePage resumePage = resumeService.getResumePage(pageNo);
		System.out.println(resumePage.getContent().get(1).getR_ex());
//		//3.Model
//		//4.View
		ModelAndView mv = new ModelAndView();  //ModelAndView객체생성
	    mv.addObject("ResumePage",resumePage); //Model처리-addObject(String 속성명, Object 값)
	    mv.setViewName("/resume/resumeList");//View지정
	    return mv;
	};
	
	@Override
	@RequestMapping(value="/resume/resumeDetail.do",method=RequestMethod.GET)
	public ModelAndView resumeDetail(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("resumeDetail");
		//페이징처리	
		int resumeNum = Integer.parseInt(no);
		ModelAndView mv = new ModelAndView(); 
		try {
			ResumeVO resumeVO = resumeService.getResume(resumeNum);
//			System.out.println(article.getContent());
			System.out.println("resumeDetail"+resumeVO.toString());
			 mv.addObject("ResumeVO",resumeVO);
			 mv.setViewName("/resume/resumeDetail");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	};
	
}
