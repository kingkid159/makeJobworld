package com.job.jobPro.letter.vo;

import java.util.List;


public class LetterPage {
	private int total;			 //전체게시물수
	private int currentPage;	 //현재 페이지
	private List<LetterVO> content;//게시글목록정보(글번호,제목,작성자,조회수,최초작성일,마지막수정일)
	private int totalPages;		//총페이지수
	private int startPage;		//시작페이지번호
	private int endPage;		//끝페이지번호
	
	public LetterPage() {};

	public LetterPage(int total, int currentPage,
			int size, List<LetterVO> content) {
		super();
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if (total == 0) { //게시물이 존재하지 않는 경우
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else { //게시물이 존재하는 경우
			totalPages = total/size; //총페이지수=전체게시물수/1page당 보여줄 게시물수
			
			if (total%size>0) {      //나머지가 0보다 크면
				totalPages++;        //전체페이수를 1씩증가
			}
			int modVal=currentPage%5;  //user가보고싶어요청페이지를 5로 나눈 나머지를 저장
			// 요청페이지가 1-> modVal은 1
			// 요청페이지가 2-> modVal은 2
			// 요청페이지가 3-> modVal은 3
			// 요청페이지가 4-> modVal은 4
			// 요청페이지가 5-> modVal은 0
			
			startPage =currentPage/5*5 + 1;
			// 요청페이지가 1-> startPage는 1
			// 요청페이지가 2-> startPage는 1
			// 요청페이지가 3-> startPage는 1
			// 요청페이지가 4-> startPage는 1
			// 요청페이지가 5-> startPage는 6
			
			//modVal==0은 요청페이지가 5의배수인 5 10 15....
			if (modVal==0) startPage-=5;//startPage=startPage-5;
			
			//한번에 출력한 page블럭을 5개라고 한다면 endPage는 startPage+4가 된다.
			/*1 2 3 4 5 
			 *6 7 8 9 10
			 *11.  13.15   */
			endPage = startPage + 4;
			//endPage가 전체페이수보다크면  endPage값을 전체페이수로 적용해라
			//예(  5>3  )  endPage를 5가 아닌 3으로 적용해라
			if(endPage>totalPages) endPage=totalPages;
		}
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<LetterVO> getContent() {
		return content;
	}
	public void setContent(List<LetterVO> content) {
		this.content = content;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	//게시글없니? 게시글없으면 true리턴
	public boolean hasNoLetters() {
		return total == 0;
	}

	//게시글이 존재하니? 게시글 있으면 true
	public boolean hasLetters() {
		return total > 0;
	}
	
	
}
