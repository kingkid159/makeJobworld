package com.job.jobPro.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.edu.service.EduPage;
import com.job.jobPro.edu.service.EduService;
@Controller("EduController")
public class EduControllerImpl implements EduController {
	@Autowired
	public EduService eduService;

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

}
