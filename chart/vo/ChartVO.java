package com.job.jobPro.chart.vo;

public class ChartVO {
	private String job;
	private String jobDetail;
	private String graphType;
	
	public ChartVO(String job, String jobDetail, String graphType) {
		this.job=job;
		this.jobDetail=jobDetail;
		this.graphType=graphType;
	}
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getJobDetail() {
		return jobDetail;
	}
	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
	}
	public String getGraphType() {
		return graphType;
	}
	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}
	
}
