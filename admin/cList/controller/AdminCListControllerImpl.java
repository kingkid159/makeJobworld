package com.job.jobPro.admin.cList.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.admin.cList.service.AdminCListService;

import com.job.jobPro.search.model.Search;

@Controller("adminGoodsController")
public class AdminCListControllerImpl implements AdminCListController {
	@Autowired
	private AdminCListService adminCListService;
	
	Search search = new Search();

	// 공고등록
	@Override
	@RequestMapping(value = "/admin/cList/add.do", method = RequestMethod.GET)
	public ModelAndView addClist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/cList/add");
		return mav;
	}
	//공고등록성공
	@Override
	 @RequestMapping(value="/admin/goods/addsuccess.do", method=RequestMethod.POST)
	 public String addSuccess(@ModelAttribute Search search,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(search);
		//search.setC_jobno(1); //임시
		adminCListService.create(search);
		 return "redirect:/search/search.do?search="; 
		 }
	
	//검색페이지에서 공고삭제 
	@Override
	@RequestMapping(value="/admin/goods/delete.do", method=RequestMethod.POST)
	public String deleteClist(@RequestParam(value="c_eno",required = false) int c_eno) throws Exception{
		adminCListService.deleteClist(c_eno);
		System.out.println("admin컨트롤러"+c_eno);
		return "redirect:/search/search.do?search=";
	}
}
