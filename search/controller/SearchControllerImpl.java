package com.job.jobPro.search.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.search.service.SearchPage;
import com.job.jobPro.search.service.SearchService;

@Controller("searchController")
public class SearchControllerImpl implements SearchController {
	
	@Autowired
	public SearchService searchService;
	
	SearchPage searchPage = new SearchPage();
	@Override
	@RequestMapping(value="/search/search.do")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {
		
		String search = null;
		
		System.out.println("search컨트롤러 진입");
		if(!request.getParameter("search").equals(null)) {
			search = request.getParameter("search");
			System.out.println(search);
		}else {
			search = searchPage.getSearch();
			System.out.println(search);
		}
		
//		System.out.println(searchPage.getSearch());
		
		
		
		
		// 기본 페이지 번호
		int defaultPageNo = 1;
		// 파라미터로 받는 페이지번호
		String pageNo = request.getParameter("pageNo");
		if(pageNo!=null) { // 파라미터로 받는 페이지 번호가있으면 페이지번호를 그 값으로 지정
			defaultPageNo = Integer.parseInt(pageNo);
		}
		//searchService.search 메서드 호출하여 SearchPage 클래스변수로 값을 받음
		//사용자가 검색한 검색어와 페이지 번호를 같이 넘겨줌
		searchPage = searchService.search(search,defaultPageNo);
		System.out.println();
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchPage",searchPage);
		mav.setViewName("/search/search");
		
		
		
		
		return mav;
	}

}
