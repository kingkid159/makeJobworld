package com.job.jobPro.chart.service;

import java.util.List;

import com.job.jobPro.chart.vo.ChartVO;

public interface ChartService {
	public List<ChartVO> selectDetailChart(String job,String jobDetail);
	public ChartVO selectChart(String job);
	public ChartVO selectMainChart(String job, String jobDetail, String graphType);
}
