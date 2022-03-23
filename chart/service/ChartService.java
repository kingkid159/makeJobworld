package com.job.jobPro.chart.service;

import com.job.jobPro.chart.vo.ChartVO;

public interface ChartService {
	public ChartVO detailChart(String job,String jobDetail,String graphType);
}
