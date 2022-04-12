package com.job.jobPro.search.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.search.model.Search;
import com.job.jobPro.search.service.SearchPage;

@Repository("SearchDAO")
public class SearchDAOImpl implements SearchDAO {
	
	@Autowired
	private  SqlSession sqlSession;
	
	@Override
	public int selectSearchCount(String search) {
		System.out.println("DAO count 접근");
		int select = sqlSession.selectOne("mapper.search.selectSearchCount",search);
		return select;
	}
	
	@Override
	public List<Search> selectSearch (SearchPage searchPage) {
		List<Search> selectSearch = (ArrayList)sqlSession.selectList("mapper.search.selectSearch",searchPage);
		return selectSearch;
	}

}
