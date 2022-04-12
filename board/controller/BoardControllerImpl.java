package com.job.jobPro.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.board.service.BoardPage;
import com.job.jobPro.board.service.BoardService;

import com.job.jobPro.board.vo.BoardVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	
	@Inject
	private BoardService boardService;
	
	//게시판 수정
	@Override
	@RequestMapping(value="/board/boardUpdate.do",method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO boardVO) throws Exception{
		System.out.println("컨트롤러 업데이트 ="+boardVO);
		boardService.update(boardVO);
		return "redirect:boardPageList.do";
	}
	
	
	//게시판 삭제
	@Override
	@RequestMapping(value="/board/boardDelete.do",method=RequestMethod.POST)
	public String delete(@RequestParam(value="board_no",required = false) int board_no) throws Exception{
		boardService.delete(board_no);
		BoardVO baordVO = new BoardVO();
		return "redirect:boardPageList.do";
	}
	//게시판 상세보기 
	@Override
	@RequestMapping(value="/board/boardRead.do",method=RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//파라미터 받기 
		String board_no = request.getParameter("board_no");
		//2.비즈니스로직수행<->Service<->Dao<->(MyBatis)<->DB
		BoardVO boardVO = boardService.view(board_no);
		//조회수 증가 처리 객체 생성
		boardService.viewcnt(board_no);
		//3.Model
		//4.View
		ModelAndView mv = new ModelAndView();  //ModelAndView객체생성
	    mv.addObject("boardVO", boardVO); //Model처리-addObject(String 속성명, Object 값)
	    mv.setViewName("/board/boardRead");//View지정
	    return mv;
	}
	//게시판 목록 
	@Override
	@RequestMapping(value = "/board/boardList.do", method = RequestMethod.GET)
	public ModelAndView boardList(BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		System.out.println("boardList = "+boardList);
		//3.model   4. View
		ModelAndView mv = new ModelAndView();  //ModelAndView객체생성
		mv.addObject("boardList", boardList); //Model처리-addObject(Object 속성명, Object 값)
		mv.setViewName("/board/boardList");   //View지정
		return mv;
	}
	
	
	
	//게시글 작성 처리
	//@Override
	@RequestMapping(value ="/board/insert.do",method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO boardVO) throws Exception{
		System.out.println("boardVO = "+boardVO);
		boardService.create(boardVO);
		return "redirect:boardPageList.do";
	}
	

	//게시글 작성 화면 
//	@Override
	@RequestMapping(value = "/board/boardWrite.do", method = RequestMethod.GET)
	public String write(){
		//로그인 시 작성 페이지 가능 로그인 폼 연결 시 주석 제거
//		BoardVO boardvo = new BoardVO();
//		if(boardvo.getWriter_id() != null) {
//			return"board/boardWrite";
//		}else {
//			return "redirect:boardPageList.do";
//		}
		return "/board/boardWrite";
	}
	
	//게시판 목록 페이징 처리
	BoardPage boardPage = new BoardPage();
	@Override
	@RequestMapping(value="/board/boardPageList.do")
	public ModelAndView boardPageList(HttpServletRequest request
			, HttpServletResponse response)throws Exception {
		System.out.println("boardPageList 컨트롤러 진입");
		//2.비즈니스로직수행<->Service<->Dao<->(MyBatis)<->DB
		String pageNoVal = request.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal!=null) {
			pageNo = Integer.parseInt(pageNoVal);
			System.out.println("pageNo = "+pageNo);
		}
		BoardPage boardPage = boardService.getBoardPage(pageNo);
		System.out.println("boardPage = "+boardPage);
		//3.Model
		//4.View
		ModelAndView mav = new ModelAndView();
		System.out.println("컨트롤러"+boardPage.toString());
		System.out.println("컨트롤러"+boardPage.hasResult());
		System.out.println("컨트롤러"+boardPage.hasNoResult());
		mav.addObject("boardPage",boardPage);  // model처리
		System.out.println("모델 처리 후 boardPage ="+boardPage);
		mav.setViewName("/board/boardList"); //view지정 
		
		return mav;
		
	}
	
//	@Override
//	@RequestMapping(value = "/board/boardList.do", method = RequestMethod.GET)
//	public ModelAndView boardList(BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
//		System.out.println("boardList = "+boardList);
//		//3.model   4. View
//		ModelAndView mv = new ModelAndView();  //ModelAndView객체생성
//		mv.addObject("boardList", boardList); //Model처리-addObject(Object 속성명, Object 값)
//		mv.setViewName("/board/boardList");   //View지정
//		return mv;
	}

	

