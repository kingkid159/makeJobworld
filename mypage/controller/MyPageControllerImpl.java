package com.job.jobPro.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;
import com.job.jobPro.member.vo.MemberVO;
import com.job.jobPro.mypage.service.MyPageService;

@Controller("myPageController")
public class MyPageControllerImpl implements MyPageController {

	@Autowired
	MyPageService myPageService;
	
	//mypage
	@Override
	@RequestMapping("/mypage/mypage.do")
	public ModelAndView myPageMain(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("MyPageController의 myPageMain()진입~~");
		ModelAndView mv = new ModelAndView();
		try {
		MemberVO memberVO =(MemberVO)request.getSession(false).getAttribute("memberVO");
		System.out.println(memberVO.getId());
		List<MyLetterVO> myLetterVO = myPageService.selectMyLetter(memberVO.getId());
		mv.addObject("myLetter", myLetterVO);
		mv.setViewName("/mypage/mypage");
		System.out.println(myLetterVO.get(1));
		}catch (Exception e){
			
		}
		return mv;
	}


	@Override
	@RequestMapping(value="/mypage/Update.do", method = RequestMethod.POST)
	public String myPageUpdate(MemberVO memberVO, HttpSession session) throws Exception{
		System.out.println(memberVO.toString());
		myPageService.myPageUpdate(memberVO);
		
		session.invalidate();
		
		return "redirect:/member/login.do";
	}
	
	
	@Override
	@RequestMapping(value="/mypage/myLetterDetail.do",method=RequestMethod.GET)
	public ModelAndView myLetterDetail(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("myLetterDetail");
		//페이징처리	
		int letterNum = Integer.parseInt(no);
		ModelAndView mv = new ModelAndView(); 
		try {
			MyLetterVO myLetterVO = myPageService.getMyLetter(letterNum);
			System.out.println(myLetterVO.toString());
			 mv.addObject("MyLetterVO",myLetterVO);
			 mv.setViewName("/mypage/myLetterDetail");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	};
	
	@Override
	@RequestMapping(value="/mypage/myLetterEdit.do",method=RequestMethod.GET)
	public ModelAndView myLetterEdit(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("MyletterEdit");
		//페이징처리	
		int letterNum = Integer.parseInt(no);
		ModelAndView mv = new ModelAndView(); 
		try {
			MyLetterVO myLetterVO = myPageService.getMyLetter(letterNum);
			 mv.addObject("MyLetterVO",myLetterVO);
			 mv.setViewName("/mypage/myLetterEdit");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	}
	
	@Override
	@RequestMapping(value="/mypage/myLetterUpdate.do",method=RequestMethod.POST)
	public ModelAndView myLetterUpdate(MyLetterVO myLetterVO,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("letterUpdate");
		System.out.println(myLetterVO.toString());
		//페이징처리	
		ModelAndView mv = new ModelAndView(); 
		try {
			int result = myPageService.updateMyLetter(myLetterVO);
			int letterNum = myLetterVO.getMlno();
			MyLetterVO myLetterVO2 = myPageService.getMyLetter(letterNum);
			mv.addObject("Result",result);
			mv.addObject("MyLetterVO",myLetterVO2);
			mv.setViewName("/mypage/myLetterUpdate");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	}
	
	@Override
	@RequestMapping(value="/mypage/myLetterDelete.do",method=RequestMethod.GET)
	public ModelAndView myLetterDelete(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception{
		System.out.println("letterWrite");
		//페이징처리	
		int letterNum = Integer.parseInt(no);
		System.out.println(no);
		ModelAndView mv = new ModelAndView(); 
		try {
			int result = myPageService.deleteMyLetter(letterNum);
			 mv.addObject("result",result);
			 mv.setViewName("redirect:/mypage/mypage.do");
		}catch(RuntimeException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return mv;
	}
	
	
}
