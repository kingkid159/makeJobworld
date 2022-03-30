package com.job.jobPro.edu.vo;

public class EduVO {
	private int eno;
	private String title;
	private String imgsrc;
	private String academy_name;
	private String academy_phone;
	private String academy_add;
	private String edu_field;
	private String edu_type;
	private String edu_process;
	private String edu_count;
	private String edu_period;
	private String edu_location;
	private String edu_price;
	private String edu_privilege;
	private String edu_app_period;
	private String private_deleteyn;
	
	public EduVO() {
		
	}
	public EduVO(int eno,String title, String academyName, String eduPeriod, String appPeriod, String academyAdd) {
		this.eno = eno;
		this.title = title;
		this.academy_name = academyName;
		this.edu_period = eduPeriod;
		this.edu_app_period = appPeriod;
		this.academy_add = academyAdd;
	}
	
	

	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public String getAcadamy_name() {
		return academy_name;
	}
	public void setAcadamy_name(String acadamy_name) {
		this.academy_name = acadamy_name;
	}
	public String getAcadamy_phone() {
		return academy_phone;
	}
	public void setAcadamy_phone(String acadamy_phone) {
		this.academy_phone = acadamy_phone;
	}
	public String getAcadamy_add() {
		return academy_add;
	}
	public void setAcadamy_add(String acadamy_add) {
		this.academy_add = acadamy_add;
	}
	public String getEdu_field() {
		return edu_field;
	}
	public void setEdu_field(String edu_field) {
		this.edu_field = edu_field;
	}
	public String getEdu_type() {
		return edu_type;
	}
	public void setEdu_type(String edu_type) {
		this.edu_type = edu_type;
	}
	public String getEdu_process() {
		return edu_process;
	}
	public void setEdu_process(String edu_process) {
		this.edu_process = edu_process;
	}
	public String getEdu_count() {
		return edu_count;
	}
	public void setEdu_count(String edu_count) {
		this.edu_count = edu_count;
	}
	public String getEdu_period() {
		return edu_period;
	}
	public void setEdu_period(String edu_period) {
		this.edu_period = edu_period;
	}
	public String getEdu_location() {
		return edu_location;
	}
	public void setEdu_location(String edu_location) {
		this.edu_location = edu_location;
	}
	public String getEdu_price() {
		return edu_price;
	}
	public void setEdu_price(String edu_price) {
		this.edu_price = edu_price;
	}
	public String getEdu_privilege() {
		return edu_privilege;
	}
	public void setEdu_privilege(String edu_privilege) {
		this.edu_privilege = edu_privilege;
	}
	public String getEdu_app_period() {
		return edu_app_period;
	}
	public void setEdu_app_period(String edu_app_period) {
		this.edu_app_period = edu_app_period;
	}
	public String getPrivate_deleteyn() {
		return private_deleteyn;
	}
	public void setPrivate_deleteyn(String private_deleteyn) {
		this.private_deleteyn = private_deleteyn;
	}
	@Override
	public String toString() {
		return "EduVO [eno=" + eno + ", title=" + title + ", imgsrc=" + imgsrc + ", acadamy_name=" + academy_name
				+ ", acadamy_phone=" + academy_phone + ", acadamy_add=" + academy_add + ", edu_field=" + edu_field
				+ ", edu_type=" + edu_type + ", edu_process=" + edu_process + ", edu_count=" + edu_count
				+ ", edu_period=" + edu_period + ", edu_location=" + edu_location + ", edu_price=" + edu_price
				+ ", edu_privilege=" + edu_privilege + ", edu_app_period=" + edu_app_period + ", private_deleteyn="
				+ private_deleteyn + "]";
	}
	
	
}
