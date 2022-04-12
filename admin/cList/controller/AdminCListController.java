package com.job.jobPro.admin.cList.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.search.model.Search;

public interface AdminCListController {
	//공고등록
	public ModelAndView addClist(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	//공고등록성공
	public String addSuccess(Search search,HttpServletRequest request, HttpServletResponse response) throws Exception;
	//공고 삭제
	String deleteClist(int c_eno) throws Exception;
}
