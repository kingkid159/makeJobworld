package com.job.jobPro.admin.cList.dao;


import com.job.jobPro.search.model.Search;

public interface AdminCListDAO {
	
	//공고등록
	public void create(Search search) throws Exception;
	//공고삭제
	public void deleteClist(int c_eno) throws Exception;
}
