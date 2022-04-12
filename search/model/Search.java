package com.job.jobPro.search.model;

// DB에서 가져온 정보를 저장, 제공하는 클래스
public class Search {
	public int c_eno;
	public int c_no;
	public String c_name;
	public String c_postname;
	public String c_career;
	public String c_condition;
	public String c_day;
	public int c_jobno;
	public String c_link;
	
	public Search() {}
	
	
	public Search(int c_eno, int c_no, String c_name, String c_postname, String c_career, String c_condition,
			String c_day, int c_jobno, String c_link) {
		this.c_eno = c_eno;
		this.c_no = c_no;
		this.c_name = c_name;
		this.c_postname = c_postname;
		this.c_career = c_career;
		this.c_condition = c_condition;
		this.c_day = c_day;
		this.c_jobno = c_jobno;
		this.c_link = c_link;
	}


	public int getC_eno() {
		return c_eno;
	}

	public void setC_eno(int c_eno) {
		this.c_eno = c_eno;
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

	public int getC_jobno() {
		return c_jobno;
	}

	public void setC_jobno(int c_jobno) {
		this.c_jobno = c_jobno;
	}

	public String getC_link() {
		return c_link;
	}

	public void setC_link(String c_link) {
		this.c_link = c_link;
	}


	@Override
	public String toString() {
		return "Search [c_eno=" + c_eno + ", c_no=" + c_no + ", c_name=" + c_name + ", c_postName=" + c_postname
				+ ", c_career=" + c_career + ", c_condition=" + c_condition + ", c_day=" + c_day + ", c_jobno="
				+ c_jobno + ", c_link=" + c_link + "]";
	}
	
	
	
}
