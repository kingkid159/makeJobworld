package com.job.jobPro.resume.vo;


public class ResumeVO {
   private int r_no;
   private String r_type;
   private String r_name;
   private String r_ex;
   private String imagefile;
   private String filename;
   private String image_form;
   
   public ResumeVO() {};
   
   public ResumeVO(int r_no, String r_type, String r_name, String r_ex) {
		super();
		this.r_no = r_no;
		this.r_type = r_type;
		this.r_name = r_name;
		this.r_ex = r_ex;
	}
   
   
	public ResumeVO(int r_no, String r_type, String r_name, String r_ex, String imagefile, String filename,
		String image_form) {

	this.r_no = r_no;
	this.r_type = r_type;
	this.r_name = r_name;
	this.r_ex = r_ex;
	this.imagefile = imagefile;
	this.filename = filename;
	this.image_form = image_form;
	}

	public String getImage_form() {
	return image_form;
	}
	
	public void setImage_form(String image_form) {
		this.image_form = image_form;
	}

	public int getR_no() {
		return r_no;
	}
	
	public void setR_no(Integer r_no) {
		this.r_no = r_no;
	}
	
	public String getR_type() {
		return r_type;
	}
	
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	
	public String getR_name() {
		return r_name;
	}
	
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	
	public String getR_ex() {
		return r_ex;
	}
	
	public void setR_ex(String r_ex) {
		this.r_ex = r_ex;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	
	public String getImagefile() {
		return imagefile;
	}

	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}

	@Override
	public String toString() {
		return "ResumeVO [r_no=" + r_no + ", r_type=" + r_type + ", r_name=" + r_name + ", r_ex=" + r_ex
				+ ", imagefile=" + imagefile + ", filename=" + filename + ", image_form=" + image_form + "]";
	}


	
   
}
