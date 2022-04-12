package com.job.jobPro.board.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.job.jobPro.board.dao.BoardDAO;

import com.job.jobPro.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	//페이지에 보여줄 게시물의 개수 
	public int size = 10;
	
	@Inject
	private BoardDAO boardDAO;
	
	//게시판 작성 화면
//	@Override
//	public void insertBoardWrite(BoardVO boardVO) throws Exception{
//			boardDAO.insertBoardWrite(boardVO);
//	}

	//게시글 작성 처리
	@Override
	public void create(BoardVO boardVO) throws Exception {
		String writer_id = boardVO.getWriter_id();
		String writer_name = boardVO.getWriter_name();
		String title = boardVO.getTitle();
		String content = boardVO.getContent();
//		String writer = boardVO.getWriter_id();
		boardDAO.create(boardVO);
	}
	
	//게시판 목록
	@Override
	public List<BoardVO> selectBoardList(BoardVO vo)throws Exception {
		List<BoardVO> boardList = boardDAO.selectBoardList();
		System.out.println("service = "+boardList);
		return boardList;
	}

	//게시판 상세보기
	@Override
	public BoardVO view(String board_no) throws Exception {
		BoardVO boardvo = boardDAO.selectBoardRead(board_no);
		System.out.println("서비스의 board_no="+board_no);
		return boardvo;
	}

	//게시판 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
		System.out.println("서비스 업데이트 ="+boardVO);
	}

	//게시판 삭제
	@Override
	public void delete(int board_no) throws Exception {
		System.out.println("서비스 삭제 업데이트 전  ="+board_no);
		boardDAO.delete(board_no);
		System.out.println("서비스 삭제 업데이트 후 ="+board_no);
	}

	//게시판 조회수 증가 처리 
	@Override
	public void viewcnt(String board_no) throws Exception {
		boardDAO.viewcnt(board_no);
	}

	//게시판 페이징 처리 
	@Override
    public BoardPage getBoardPage(int pageNo)throws Exception{
      int total = boardDAO.selectBoardCount();
      System.out.println("total ="+total);
      List<BoardVO> content = boardDAO.selectBoardPage((pageNo-1)*size,(pageNo)*size);
      System.out.println("서비스 content = "+content);
      return new BoardPage(total,pageNo,size,content);
   }

//	@Override
//	public BoardPage boardPage(String boardList, int pageNo) {
//		System.out.println("boardPage서비스 진입"+"pageNo="+pageNo);
//		
//		//select를 실행하여 총개수를 total에 저장
//		int total= boardDAO.selectBoardCount(boardList);
//		
//		System.out.println("total="+total);
//		//페이지번호를 객체에 저장, DAO의 함수를 호출
//		BoardPage boardPage = new BoardPage(boardList,pageNo,size);
//		System.out.println(boardPage.toString());
//		
//		List<BoardVO> content = boardDAO.selectboardPage(boardPage);
//		return new BoardPage(boardList,total,currentPage,size,content);
//	}









}
