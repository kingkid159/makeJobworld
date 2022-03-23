package com.job.jobPro.chart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.chart.dao.ChartDAO;
import com.job.jobPro.chart.vo.ChartVO;
@Service("ChartService")
public class ChartServiceImpl implements ChartService{
	@Autowired
	private ChartDAO chartDAO;
	@Override
	//상세그래프
	public ChartVO detailChart(String job, String jobDetail, String graphType) {
		// TODO Auto-generated method stub
		System.out.println("서비스의 job="+job);
		System.out.println("서비스의 jobDetail="+jobDetail);
		System.out.println("서비스의 graphType="+graphType);
		ChartVO chartVO = chartDAO.detailChart(job, jobDetail, graphType);
		return chartVO;
	}

}
