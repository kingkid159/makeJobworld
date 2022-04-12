package com.job.jobPro.edu.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.edu.service.EduPage;
import com.job.jobPro.edu.service.EduService;
import com.job.jobPro.edu.vo.EduVO;
@Controller("EduController")
public class EduControllerImpl implements EduController {
	private static final RequestMethod[] Req = null;
	@Autowired
	public EduService eduService;

	//학원 목록페이지
	@Override
	@RequestMapping(value="/job/eduList.do")
	public ModelAndView eduList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("eduController!");
		String strNo = request.getParameter("pageNO");
		//페이지 기본값 1페이지
		int pageNo = 1;
		//페이지 파라미터를 받았을경울 pageNo에 새 값 저장
		if(strNo != null) {
			pageNo=Integer.parseInt(strNo);
		}
		EduPage eduPage = eduService.eduList(pageNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/job/eduList");
		mav.addObject("eduPage",eduPage);
		return mav;
	}

	//학원 상세페이지
	@Override
	@RequestMapping(value="/job/eduDetail.do")
	public ModelAndView eduDetail(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("상세페이지이동");
		int eno=Integer.parseInt( request.getParameter("eno"));
		EduVO eduVO = eduService.eduDetail(eno);
		ModelAndView mv = new ModelAndView();
		mv.addObject("eduVO",eduVO);
		mv.setViewName("/job/eduDetail");
		return mv;
	}
	
	//수정
	@Override
	@RequestMapping(value="/job/eduModify.do", method=RequestMethod.POST)
	public String eduModify(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		Map newEduMap = new HashMap();
		
		Enumeration enu = request.getParameterNames();
		while( enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = request.getParameter(name);
			newEduMap.put(name,value);
		}
		System.out.println("eduControllerModify의 newEduMap="+newEduMap);
		eduService.serviceModify(newEduMap);
		return "redirect:eduList.do";
	}
	
	//삭제
	@Override
	@RequestMapping(value="/job/eduDelete.do")
	public String eduDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String strEno = request.getParameter("eno");
		int eno = Integer.parseInt(strEno);
		System.out.println("eduControllerDelete의 eno="+eno);
		eduService.eduDelete(eno);
		return "redirect:eduList.do";
	}
	//등록
	   @Override
	   @RequestMapping(value="/job/eduRegister.do",method=RequestMethod.POST)
	   public String eduResgister(HttpServletRequest request, HttpServletResponse response)
	         throws Exception {
	      System.out.println("요청함수eduResgister()-진입");
	      
	      request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html; charset=utf-8");
	      
	      //교육정보 + 이미지경로를 담기위한 Map생성
	      Map<String,String> newEduMap = new HashMap();
	      
	      //파라미터명목록 가져오기
	      Enumeration enu=request.getParameterNames();
	      while(enu.hasMoreElements()) {
	         String name=(String)enu.nextElement();//파라미터명
	         String value=request.getParameter(name);//user 선택입력값
	         
	         newEduMap.put(name,value);
	      }
	      System.out.println("map="+newEduMap);
	      HttpSession session=request.getSession();
	      EduVO eduVO=(EduVO)session.getAttribute("eduVO");
	      System.out.println("EduContollerImpl.eduResgister의 EduVO="+eduVO);
	      //String reg_id=(String)session.getAttribute("id");
	      //System.out.println(reg_id);
	      
	      //String reg_id=memberVO.getId();
	      //System.out.println("reg_id="+reg_id);
	      eduService.insertEdu(newEduMap);
	      //Model //View
	      //ModelAndView mav = new ModelAndView();
	      //mav.setViewName("/job/eduList");
	      return "redirect:/job/eduList.do";
	   }
	   
	   @Override
	   @RequestMapping(value="/job/eduRegisterForm.do")
	   public String eduRegisterForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      return "/job/eduRegister";
	   }
}
