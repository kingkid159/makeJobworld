package com.job.jobPro.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface EduController {
	public ModelAndView eduList(HttpServletRequest request,HttpServletResponse response);
}
