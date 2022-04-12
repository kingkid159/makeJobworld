package com.job.jobPro.board.service;

import java.util.List;


import com.job.jobPro.board.vo.BoardVO;

public interface BoardService {
	
	//게시판 작성 
//	public void insertBoardWrite(BoardVO boardVO)throws Exception;
	public void create(BoardVO boardVO)throws Exception;
	
	//게시판 목록
	public List<BoardVO> selectBoardList(BoardVO vo) throws Exception;

	//게시판 상세보기
	public BoardVO view(String board_no)throws Exception;

	//게시판 수정
	public void update(BoardVO boardVO)throws Exception;

	//게시판 삭제
	public void delete(int board_no)throws Exception;

	//게시판 조회수 증가 처리
	public void viewcnt(String board_no)throws Exception;
	
	//게시판 페이징 처리 총 게시글 수

	
	//게시판 페이징 처리
	public BoardPage getBoardPage(int pageNo)throws Exception;










}
