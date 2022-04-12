package com.job.jobPro.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.letter.vo.MyLetterVO;
import com.job.jobPro.member.vo.MemberVO;

public interface MyPageController {

	public abstract ModelAndView myPageMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	public abstract String myPageUpdate(MemberVO memberVO, HttpSession session)
			throws Exception;
	
	public ModelAndView myLetterDetail(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  
			throws Exception;
	
	public ModelAndView myLetterEdit(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	public ModelAndView myLetterUpdate(MyLetterVO myletterVO,
			HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	public ModelAndView myLetterDelete(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception;
}
