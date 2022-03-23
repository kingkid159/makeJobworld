package com.job.jobPro.chart.dao;

import com.job.jobPro.chart.vo.ChartVO;

public interface ChartDAO {
	public ChartVO detailChart(String job,String jobDetail,String graphType);
}
