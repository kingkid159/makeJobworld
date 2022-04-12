package com.job.jobPro.letter.vo;


public class MyLetterVO {
	private String userId;
	int mlno;
	int lno;
	private String lTitle;
	private String qes1;
	private String res1;
	private String qes2;
	private String res2;
	private String qes3;
	private String res3;
	private String qes4;
	private String res4;
	private String qes5;
	private String res5;
	private String qes6;
	private String res6;
	private String imagefile;
	
	public MyLetterVO() {}

	public MyLetterVO(String userId, int mlno, int lno, String lTitle, String qes1, String res1, String qes2,
			String res2, String qes3, String res3, String qes4, String res4, String qes5, String res5, String qes6,
			String res6, String imagefile) {
		this.userId = userId;
		this.mlno = mlno;
		this.lno = lno;
		this.lTitle = lTitle;
		this.qes1 = qes1;
		this.res1 = res1;
		this.qes2 = qes2;
		this.res2 = res2;
		this.qes3 = qes3;
		this.res3 = res3;
		this.qes4 = qes4;
		this.res4 = res4;
		this.qes5 = qes5;
		this.res5 = res5;
		this.qes6 = qes6;
		this.res6 = res6;
		this.imagefile = imagefile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMlno() {
		return mlno;
	}

	public void setMlno(int mlno) {
		this.mlno = mlno;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getlTitle() {
		return lTitle;
	}

	public void setlTitle(String lTitle) {
		this.lTitle = lTitle;
	}

	public String getQes1() {
		return qes1;
	}

	public void setQes1(String qes1) {
		this.qes1 = qes1;
	}

	public String getRes1() {
		return res1;
	}

	public void setRes1(String res1) {
		this.res1 = res1;
	}

	public String getQes2() {
		return qes2;
	}

	public void setQes2(String qes2) {
		this.qes2 = qes2;
	}

	public String getRes2() {
		return res2;
	}

	public void setRes2(String res2) {
		this.res2 = res2;
	}

	public String getQes3() {
		return qes3;
	}

	public void setQes3(String qes3) {
		this.qes3 = qes3;
	}

	public String getRes3() {
		return res3;
	}

	public void setRes3(String res3) {
		this.res3 = res3;
	}

	public String getQes4() {
		return qes4;
	}

	public void setQes4(String qes4) {
		this.qes4 = qes4;
	}

	public String getRes4() {
		return res4;
	}

	public void setRes4(String res4) {
		this.res4 = res4;
	}

	public String getQes5() {
		return qes5;
	}

	public void setQes5(String qes5) {
		this.qes5 = qes5;
	}

	public String getRes5() {
		return res5;
	}

	public void setRes5(String res5) {
		this.res5 = res5;
	}

	public String getQes6() {
		return qes6;
	}

	public void setQes6(String qes6) {
		this.qes6 = qes6;
	}

	public String getRes6() {
		return res6;
	}

	public void setRes6(String res6) {
		this.res6 = res6;
	}

	public String getImagefile() {
		return imagefile;
	}

	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}

	@Override
	public String toString() {
		return "MyLetterVO [userId=" + userId + ", mlno=" + mlno + ", lno=" + lno + ", lTitle=" + lTitle + ", qes1="
				+ qes1 + ", res1=" + res1 + ", qes2=" + qes2 + ", res2=" + res2 + ", qes3=" + qes3 + ", res3=" + res3
				+ ", qes4=" + qes4 + ", res4=" + res4 + ", qes5=" + qes5 + ", res5=" + res5 + ", qes6=" + qes6
				+ ", res6=" + res6 + ", imagefile=" + imagefile + "]";
	};
	


}
