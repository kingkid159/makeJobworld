package com.job.jobPro.letter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.letter.service.LetterService;
import com.job.jobPro.letter.vo.LetterPage;
import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;
import com.job.jobPro.member.vo.MemberVO;


@Controller("letterController")
public class LetterControllerImpl implements LetterController{
	
	//Controller<->Service<->Dao<->MyBatis<->DB
		//여기에서는  기존의 방식을 사용하여 객체를 직접 생성하여 참조변수에 할당-> 의존성적용시킬예정
		//클래스명       참조변수 = new 클래스명();
		//부모클래스명  참조변수 = new 자식클래스명();
		//인터페이스명  참조변수 = new 구현클래스명(); //현재방식
		//goodsService참조변수에  객체주소저장했던 방식이 jsp에서 사용
		//GoodsService  goodsService = new GoodsServiceImpl();
		
		//bean등록한 것을 자동주입방식으로 사용
	
	
	@Autowired
	private LetterService letterService;
	
	
	@Override
	@RequestMapping(value="/letter/letterList.do")
	public ModelAndView letterList(HttpServletRequest request
			, HttpServletResponse response)  throws Exception{
		System.out.println("letterList");
		//2.비즈니스로직수행<->Service<->Dao<->(MyBatis)<->DB
		String pageNoVal = request.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal!=null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		LetterPage letterPage = letterService.getLetterPage(pageNo);
//		System.out.println(letterPage.getContent().get(1).getlTitle());
//		//3.Model
//		//4.View
		ModelAndView mv = new ModelAndView();  //ModelAndView객체생성
	    mv.addObject("LetterPage",letterPage); //Model처리-addObject(String 속성명, Object 값)
	    System.out.println(letterPage);
	    mv.setViewName("/letter/letterList");//View지정
	    return mv;
	};
	
	@Override
	@RequestMapping(value="/letter/letterDetail.do",method=RequestMethod.GET)
	public ModelAndView letterDetail(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("letterDetail");
		//페이징처리	
		int letterNum = Integer.parseInt(no);
		ModelAndView mv = new ModelAndView(); 
		try {
			LetterVO letterVO = letterService.getLetter(letterNum);
			System.out.println(letterVO.toString());
			 mv.addObject("LetterVO",letterVO);
			 mv.setViewName("/letter/letterDetail");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	};
	
	@Override
	@RequestMapping(value="/letter/letterWrite.do",method=RequestMethod.GET)
	public ModelAndView letterWrite(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("letterWrite");
		//페이징처리	
		int letterNum = Integer.parseInt(no);
		ModelAndView mv = new ModelAndView(); 
		try {
			LetterVO letterVO  = letterService.getLetter(letterNum);
			 mv.addObject("LetterVO",letterVO);
			 mv.setViewName("/letter/letterWrite");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	}
	
	@RequestMapping(value="/letter/letterInsert.do",method=RequestMethod.POST)
	public ModelAndView letterInsert(MyLetterVO myletterVO,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("letterSave");
		System.out.println(myletterVO.toString());
		//페이징처리	
		ModelAndView mv = new ModelAndView(); 
		try {
			int result = letterService.insertLetter(myletterVO);
			 mv.setViewName("redirect:/letter/letterList.do");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	}
	
	@RequestMapping(value="/letter/letterUpdate.do",method=RequestMethod.GET)
	public ModelAndView letterUpdate(
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("letterSave");
		request.getAttribute("memberVO");
		MemberVO memberVO =(MemberVO)request.getSession(false).getAttribute("memberVO");
		
		//페이징처리	
		ModelAndView mv = new ModelAndView(); 
		try {
			 letterService.letterUpdate(memberVO.getId());
			 mv.setViewName("/letter/insertLetter");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	}
	
	
}
