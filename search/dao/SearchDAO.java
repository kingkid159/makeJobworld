package com.job.jobPro.search.dao;

import java.util.List;

import com.job.jobPro.search.model.Search;
import com.job.jobPro.search.service.SearchPage;

public interface SearchDAO {
	
	public int selectSearchCount (String search);
	
	public List<Search> selectSearch (SearchPage searchPage);
}
