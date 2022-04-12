package com.job.jobPro.search.service;

import java.util.List;

import com.job.jobPro.search.model.Search;

// 페이징 처리와 게시글 정보를 저장하는 클래스
public class SearchPage {
	
	private String search; //유저가 검색한 검색어를 저장
	private int pageNo; // 파라미터로 넘어온 페이지번호-1*size 로 select의 시작값
	private int size; //한페이지에 보여줄 게시물 수
	private int total;			 //전체게시물수
	private int currentPage;	 //현재 페이지
	private List<Search> content;//게시글목록정보(글번호,제목,작성자,조회수,최초작성일,마지막수정일)
	private int totalPages;		//총페이지수
	private int startPage;		//시작페이지번호
	private int endPage;		//끝페이지번호
	
	public SearchPage() {
		
	}
	
	public SearchPage(String search,int pageNo,int size) {
		System.out.println(pageNo);
		this.search = search;
		this.pageNo = (pageNo-1)*size;
		this.size = size+this.pageNo;
	}

	public SearchPage(String search,int total, int currentPage, List<Search> content, int size ) {
		this.search = search;
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total==0) { // 게시글 수가 0 == 게시글이 없을때
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else { // 게시글이 있을 때 
			totalPages = total/size; // 총페이지수 = 총 게시글 수 / 한페이지당 보여줄 게시글 수
			
			if (total%size>0) {      //나머지가 0보다 크면
				totalPages++;        //전체페이수를 1씩증가
			}
			
			int modVal=currentPage%5;  //user가보고싶어요청페이지를 5로 나눈 나머지를 저장
			// 요청페이지가 1-> modVal은 1
			// 요청페이지가 2-> modVal은 2
			// 요청페이지가 3-> modVal은 3
			// 요청페이지가 4-> modVal은 4
			// 요청페이지가 5-> modVal은 0
			
			startPage = currentPage/5*5 + 1;
			// 요청페이지가 1-> startPage는 1
			// 요청페이지가 2-> startPage는 1
			// 요청페이지가 3-> startPage는 1
			// 요청페이지가 4-> startPage는 1
			// 요청페이지가 5-> startPage는 6
			
			//modVal==0은 요청페이지가 5의배수인 5 10 15....
			if (modVal==0) {startPage-=5;}//startPage=startPage-5;
			
			//한번에 출력한 page블럭을 5개라고 한다면 endPage는 startPage+4가 된다.
			/*1 2 3 4 5 
			 *6 7 8 9 10
			 *11.  13.15   */
			endPage = startPage + 4;
			//endPage가 전체페이수보다크면  endPage값을 전체페이수로 적용해라
			//예(  5>3  )  endPage를 5가 아닌 3으로 적용해라
			if(endPage>totalPages) {endPage=totalPages;}

		}
	}
	//게시글 없으면 true
	public boolean hasNoResult() {
		return total == 0;
	}

	//게시글 있으면 true
	public boolean hasResult() {
		return total > 0;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public List<Search> getContent() {
		return content;
	}

	public void setContent(List<Search> content) {
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

	@Override
	public String toString() {
		return "SearchPage [search=" + search + ", pageNo=" + pageNo + ", size=" + size + ", total=" + total
				+ ", currentPage=" + currentPage + ", content=" + content + ", totalPages=" + totalPages
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

	
	
}
