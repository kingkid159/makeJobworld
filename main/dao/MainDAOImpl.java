package com.job.jobPro.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.main.model.CList;
import com.job.jobPro.main.model.Cmain;
@Repository("MainDAO")
public class MainDAOImpl implements MainDAO {
	
	@Autowired
	private  SqlSession sqlSession;
	@Override
	public List<Cmain> selectCmain() {//추천기업
		List<Cmain> selectCmain= (ArrayList)sqlSession.selectList("mapper.main.selectCmain");
		return selectCmain;
	}
	public List<CList> selectCList() {//일반기업
		List<CList> selectCList= (ArrayList)sqlSession.selectList("mapper.main.selectCList");
		return selectCList;
	}
}
