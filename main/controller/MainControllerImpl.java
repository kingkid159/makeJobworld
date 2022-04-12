package com.job.jobPro.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.main.model.CList;
import com.job.jobPro.main.model.Cmain;
import com.job.jobPro.main.service.MainService;

@Controller("mainController")
public class MainControllerImpl implements MainController {
	@Autowired
	public MainService mainService;
	
	
	@Override
	@RequestMapping(value="/main/main.do",method=RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		List<Cmain> cmainList=mainService.cmainList();
		List<CList> cList=mainService.cList();
		System.out.println("메인 진입");
		ModelAndView mav = new ModelAndView();
		mav.addObject("cmainList",cmainList);//추천기업
		mav.addObject("cList",cList);//일반기업
		mav.setViewName("/main/main");//View지정
		return mav;
	}

}
