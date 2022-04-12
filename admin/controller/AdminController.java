package com.job.jobPro.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.resume.vo.ResumeVO;

public interface AdminController {

	public String resumeRegisterPage(
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView resumeRegister(
			ResumeVO resumeVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView resumeUpdatePage(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView resumeUpdate(ResumeVO resumeVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView resumeDelete(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public String letterRegisterPage(
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView letterRegister(LetterVO letterVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView letterUpdatePage(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView resumeUpdate(LetterVO letterVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	public ModelAndView letterDelete(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception;
	
	
}
