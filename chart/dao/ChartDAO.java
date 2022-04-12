package com.job.jobPro.chart.dao;

import java.util.List;

import com.job.jobPro.chart.vo.ChartVO;

public interface ChartDAO {
	public List<ChartVO> selectDetailChart(String job,String jobDetail);
	public ChartVO selectChart(String job);
	public ChartVO selectMainChart(String job, String jobDetail, String graphType);
}
