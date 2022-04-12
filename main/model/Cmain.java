package com.job.jobPro.main.model;
//추천번호
public class Cmain {
	private int c_no; //공고번호
	private String c_logo;//회사로고
	private String c_name;//회사이름
	private String c_postname;//공고제목
	private String c_link; //공고링크
	private int c_jobno;//직종번호
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_logo() {
		return c_logo;
	}
	public void setC_logo(String c_logo) {
		this.c_logo = c_logo;
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
	public String getC_link() {
		return c_link;
	}
	public void setC_link(String c_link) {
		this.c_link = c_link;
	}
	public int getC_jobno() {
		return c_jobno;
	}
	public void setC_jobno(int c_jobno) {
		this.c_jobno = c_jobno;
	}
	//기본생성자
	public Cmain() {}
	
	public Cmain(int c_no, String c_logo, String c_name, String c_postname, String c_link, int c_jobno) {
		this.c_no = c_no;
		this.c_logo = c_logo;
		this.c_name = c_name;
		this.c_postname = c_postname;
		this.c_link = c_link;
		this.c_jobno = c_jobno;
	}
	@Override
	public String toString() {
		return "Cmain [c_no=" + c_no + ", c_logo=" + c_logo + ", c_name=" + c_name + ", c_postname=" + c_postname
				+ ", c_link=" + c_link + ", c_jobno=" + c_jobno + "]";
	}

}
