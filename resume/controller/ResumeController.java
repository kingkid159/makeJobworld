package com.job.jobPro.resume.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public interface ResumeController {
	
	public ModelAndView resumeList(
			HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	public ModelAndView resumeDetail(@RequestParam(value="no") String no,HttpServletRequest request, HttpServletResponse response)  throws Exception;
}
