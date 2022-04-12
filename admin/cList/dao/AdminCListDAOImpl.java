package com.job.jobPro.admin.cList.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.job.jobPro.search.model.Search;
@Repository("AdminGoodsDAO")
public class AdminCListDAOImpl implements AdminCListDAO {
	
	@Autowired
	private  SqlSession sqlSession;
	
	//공고등록
	@Override
	public void create(Search search)throws Exception{
		sqlSession.insert("mapper.admin.addClist",search);
	}
	
	//공고삭제
	@Override
	public void deleteClist(int c_eno)throws Exception{
		sqlSession.delete("mapper.admin.deleteClist",c_eno);
		System.out.println("adminDAO"+c_eno);
	}
}
