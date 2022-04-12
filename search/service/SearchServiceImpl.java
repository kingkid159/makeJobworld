package com.job.jobPro.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.search.dao.SearchDAO;
import com.job.jobPro.search.model.Search;
// 검색 서비스 
@Service("searchService")
public class SearchServiceImpl implements SearchService {
	
	// 페이지에 보여줄 게시물의 개수
	public int size = 50; 
	
	@Autowired
	public SearchDAO searchdao;
	
	
	
	@Override
	public SearchPage search(String search, int pageNo) {
		System.out.println("Search서비스 진입"+"pageNo="+pageNo + "search="+search);
		
		// 사용자가 검색한 단어로 select를 실행하여 총개수를 total에 저장
		int total = searchdao.selectSearchCount(search);
		
		System.out.println("total="+total);
		//사용자가 넘겨준 검색어, 페이지번호를 객체에 저장, dao의 함수를 호출
		SearchPage searchpage = new SearchPage(search,pageNo,size);
		System.out.println(searchpage.toString());
		
		List<Search> content = searchdao.selectSearch(searchpage);
		
		return new SearchPage(search,total,pageNo,content,size);
	}

}
