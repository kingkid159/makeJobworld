package com.job.jobPro.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface EduController {
	public ModelAndView eduList(HttpServletRequest request,HttpServletResponse response);
	
	public ModelAndView eduDetail(HttpServletRequest request,HttpServletResponse response);
	
	//수정
	public String eduModify(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//삭제
	public String eduDelete(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//교육등록
	   public String eduResgister(HttpServletRequest request,HttpServletResponse response) throws Exception;
	   //교육등록:교육정보+이미지정보
	   
	   String eduRegisterForm(HttpServletRequest request,HttpServletResponse response) throws Exception;

}
