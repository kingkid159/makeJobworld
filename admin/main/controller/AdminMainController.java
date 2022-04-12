package com.job.jobPro.admin.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;





public interface AdminMainController {
	
	//회원 리스트
	public ModelAndView adminMain(HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	//회원 삭제 
	public String memberdelete(String id) throws Exception;


	
	
	
	

}
