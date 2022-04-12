package com.job.jobPro.main.model;
//일반기업
public class CList {
	private int c_no;
	private String c_name;
	private String c_postname;
	private String c_career;
	private String c_condition;
	private String c_day;
	private String c_link;
	private int job_no;
	
	public CList() {}
	
	public CList(int c_no, String c_name, String c_postname, String c_career, String c_condition, String c_day,
			String c_link, int job_no) {
		this.c_no = c_no;
		this.c_name = c_name;
		this.c_postname = c_postname;
		this.c_career = c_career;
		this.c_condition = c_condition;
		this.c_day = c_day;
		this.c_link = c_link;
		this.job_no = job_no;
	}
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_postname() {
		return c_postname;
	}
	public void setC_postname(String c_postname) {
		this.c_postname = c_postname;
	}
	public String getC_career() {
		return c_career;
	}
	public void setC_career(String c_career) {
		this.c_career = c_career;
	}
	public String getC_condition() {
		return c_condition;
	}
	public void setC_condition(String c_condition) {
		this.c_condition = c_condition;
	}
	public String getC_day() {
		return c_day;
	}
	public void setC_day(String c_day) {
		this.c_day = c_day;
	}
	public String getC_link() {
		return c_link;
	}
	public void setC_link(String c_link) {
		this.c_link = c_link;
	}
	public int getJob_no() {
		return job_no;
	}
	public void setJob_no(int job_no) {
		this.job_no = job_no;
	}

	@Override
	public String toString() {
		return "CList [c_no=" + c_no + ", c_name=" + c_name + ", c_postname=" + c_postname + ", c_career=" + c_career
				+ ", c_condition=" + c_condition + ", c_day=" + c_day + ", c_link=" + c_link + ", job_no=" + job_no
				+ "]";
	}
	

}
