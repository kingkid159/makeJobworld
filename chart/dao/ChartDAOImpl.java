package com.job.jobPro.chart.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.job.jobPro.chart.vo.ChartVO;
@Repository("chartDAO")
public class ChartDAOImpl implements ChartDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ChartVO selectMainChart(String job, String jobDetail, String graphType) {
		// TODO Auto-generated method stub
		ChartVO chartVO = new ChartVO(job,jobDetail,graphType);
		System.out.println("DAOselectMainChart"+chartVO);
		ChartVO result = 
				(ChartVO)sqlSession.selectOne("mapper.chart.selectMainChart",chartVO);
		System.out.println("result"+result);
		return result;
	}
	@Override
	public List<ChartVO> selectDetailChart(String job, String jobDetail) {
		// TODO Auto-generated method stub
		System.out.println("DAOselectDetailjob"+job);
		System.out.println("DAOselectDetailjobDetail"+jobDetail);
		ChartVO chartVO = new ChartVO(job,jobDetail);
		System.out.println("chartVO"+chartVO);
		List<ChartVO> result =
				(ArrayList)sqlSession.selectList("mapper.chart.selectDetailChart",chartVO);
		System.out.println("result="+result);
		return result;
	}
	@Override
	public ChartVO selectChart(String job) {
		// TODO Auto-generated method stub
		System.out.println("DAOselectjob="+job);
		ChartVO result = 
				(ChartVO)sqlSession.selectOne("mapper.chart.selectChart",job);
		System.out.println("result"+result);
		return result;
	}

}
