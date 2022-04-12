package com.job.jobPro.admin.main.vo;

public class CompanyVO {
	private int total;
	private int web;
	private int dataBase;
	private int system;
	private int ai;
	private int html;
	
	public CompanyVO() {};
	public CompanyVO(int total, int web, int dataBase, int system, int ai, int html) {
		this.total = total;
		this.web = web;
		this.dataBase = dataBase;
		this.system = system;
		this.ai = ai;
		this.html = html;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
	}
	public int getDataBase() {
		return dataBase;
	}
	public void setDataBase(int dataBase) {
		this.dataBase = dataBase;
	}
	public int getSystem() {
		return system;
	}
	public void setSystem(int system) {
		this.system = system;
	}
	public int getAi() {
		return ai;
	}
	public void setAi(int ai) {
		this.ai = ai;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}

	@Override
	public String toString() {
		return "companyVO [total=" + total + ", web=" + web + ", dataBase=" + dataBase + ", system=" + system + ", ai="
				+ ai + ", html=" + html + "]";
	}

	
}
