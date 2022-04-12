package com.job.jobPro.board.vo;


public class BoardVO {
	//필드
	private int board_no = 0;
	private String writer_id;
	private String writer_name;
	private String title;

	private String content;
	private int read_cnt;
	
	
	
	public int getBoard_no() {
		return board_no;
	}



	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}



	public String getWriter_id() {
		return writer_id;
	}



	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}



	public String getWriter_name() {
		return writer_name;
	}



	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getRead_cnt() {
		return read_cnt;
	}



	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}



	public BoardVO() {}



	public BoardVO(int board_no, String writer_id, String writer_name, String title, String content, int read_cnt) {
		super();
		this.board_no = board_no;
		this.writer_id = writer_id;
		this.writer_name = writer_name;
		this.title = title;
		this.content = content;
		this.read_cnt = read_cnt;
	}



	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", writer_id=" + writer_id + ", writer_name=" + writer_name
				+ ", title=" + title + ", content=" + content + ", read_cnt=" + read_cnt + "]";
	}
	
	
}