package com.job.jobPro.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.board.vo.BoardVO;

public interface BoardController {
	

	
	//게시글 작성
	public String write();
	
	//게시글 작성 처리 
	public String insert(BoardVO boardVO)throws Exception;
	
	//게시글 목록
	public ModelAndView boardList(BoardVO boardVO,HttpServletRequest request, 
			HttpServletResponse response)throws Exception;

	//게시판 상세보기
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//게시판 수정
	public String update(BoardVO boardVO) throws Exception;

	//게시판 삭제
	public String delete(int board_no) throws Exception;

	//게시판 목록 페이징처리
	public ModelAndView boardPageList(HttpServletRequest request, HttpServletResponse response) throws Exception;

//	public ModelAndView boardPageList(HttpServletRequest request, HttpServletResponse response);








}
