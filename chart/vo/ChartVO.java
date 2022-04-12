package com.job.jobPro.chart.vo;

public class ChartVO {
	private String job;
	private String job_detail;
	private String graph_type;
	
	public ChartVO() {
		
	}
	public ChartVO(String job) {
		this.job=job;
	}
	public ChartVO(String job, String jobDetail) {
		this.job=job;
		this.job_detail=jobDetail;
	}
	public ChartVO(String job, String jobDetail,String graphType) {
		this.job=job;
		this.job_detail=jobDetail;
		this.graph_type = graphType;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getJobDetail() {
		return job_detail;
	}
	public void setJobDetail(String jobDetail) {
		this.job_detail = jobDetail;
	}
	public String getGraphType() {
		return graph_type;
	}
	public void setGraphType(String graphType) {
		this.graph_type = graphType;
	}


	@Override
	public String toString() {
		return "ChartVO [job=" + job + ", jobDetail=" + job_detail + ", graphType=" + graph_type + "]";
	}
	
}
