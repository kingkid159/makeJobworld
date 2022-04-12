package com.job.jobPro.admin.cList.service;

import com.job.jobPro.search.model.Search;

public interface AdminCListService {
	
	//공고 등록
	public void create(Search search) throws Exception;
	//공고삭제
	public void deleteClist(int c_eno) throws Exception;
}
