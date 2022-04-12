package com.job.jobPro.search.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface SearchController {
	
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response);
}
