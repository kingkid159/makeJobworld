package com.job.jobPro.chart.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.chart.vo.ChartVO;
@Repository("chartDAO")
public class ChartDAOImpl implements ChartDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public ChartVO detailChart(String job, String jobDetail, String graphType) {
		// TODO Auto-generated method stub
		ChartVO result =
				(ChartVO)sqlSession.selectOne("mapper.chart.selectChart");
		return result;
	}

}
