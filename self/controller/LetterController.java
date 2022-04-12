package com.job.jobPro.letter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public interface LetterController {
	
	public ModelAndView letterList(
			HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	public ModelAndView letterDetail(@RequestParam(value="no") String no,HttpServletRequest request, HttpServletResponse response)  throws Exception;

	public ModelAndView letterUpdate(
			HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	public ModelAndView letterWrite(@RequestParam(value="no") String no,
			HttpServletRequest request, HttpServletResponse response)  throws Exception;

}
