package com.job.jobPro.chart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.chart.dao.ChartDAO;
import com.job.jobPro.chart.vo.ChartVO;
@Service("ChartService")
public class ChartServiceImpl implements ChartService{
	@Autowired
	private ChartDAO chartDAO;
	
	@Override
	public ChartVO selectMainChart(String job, String jobDetail, String graphType) {
		// TODO Auto-generated method stub
		System.out.println("서비스의 selectMainChart="+job+jobDetail+graphType);
		ChartVO chartVO = chartDAO.selectMainChart(job,jobDetail,graphType);
		return chartVO;
	}
	@Override
	//상세그래프
	public ChartVO selectChart(String job) {
		// TODO Auto-generated method stub
		System.out.println("서비스의 selectjob="+job);
		ChartVO chartVO = chartDAO.selectChart(job);
		System.out.println("serviceChartVO"+chartVO);
		return chartVO;
	}
	@Override
	public List<ChartVO> selectDetailChart(String job, String jobDetail) {
		// TODO Auto-generated method stub
		System.out.println("서비스의 job="+job);
		System.out.println("서비스의 jobDetail="+jobDetail);
		List<ChartVO> chartVO = chartDAO.selectDetailChart(job, jobDetail);
		return chartVO;
	}
	

}
