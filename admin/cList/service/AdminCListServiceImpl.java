package com.job.jobPro.admin.cList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.admin.cList.dao.AdminCListDAO;
import com.job.jobPro.admin.cList.dao.AdminCListDAO;

import com.job.jobPro.search.model.Search;
@Service("adminGoodsService")
public class AdminCListServiceImpl implements AdminCListService {
	
	@Autowired
	private AdminCListDAO adminCListDAO;
	Search search = new Search();

	//공고 등록
	@Override
	public void create(Search search) throws Exception {
		adminCListDAO.create(search);
	}
	//공고 삭제
	public void deleteClist(int c_eno)throws Exception {
		adminCListDAO.deleteClist(c_eno);
		System.out.println("admin서비스"+c_eno);
		
	}
}
