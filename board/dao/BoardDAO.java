package com.job.jobPro.board.dao;

import java.util.List;

import com.job.jobPro.board.vo.BoardVO;

public interface BoardDAO {
	
//	//게시판 작성
//	public void insertBoardWrite(BoardVO boardVO) throws Exception;
	//게시판 글작성 처리
	public void create(BoardVO boardVO) throws Exception;
	
	//게시판 목록
	public List<BoardVO> selectBoardList()throws Exception;

	//게시판 상세 보기 
	public BoardVO selectBoardRead(String board_no)throws Exception;

	//게시판 수정
	public void update(BoardVO boardVO)throws Exception;

	//게시판 삭제
	public void delete(int board_no)throws Exception;

	//게시판 조회수 증가 
	public void viewcnt(String board_no)throws Exception;

	//게시판 페이징 처리 총 게시글 수
	public int selectBoardCount()throws Exception;

	//게시판 페이징 처리 
	public List<BoardVO> selectBoardPage(int startRow,int size)throws Exception;

//	public List<BoardVO> selectboardPage(BoardPage boardPage);
	
	






	

}
