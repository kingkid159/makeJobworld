package com.job.jobPro.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;


import com.job.jobPro.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private  SqlSession sqlSession;
	
	
	
	//게시글 작성 처리
	@Override
	public void create(BoardVO boardVO) throws Exception {
		sqlSession.insert("mapper.board.insertBoardWrite", boardVO);
		
	}
	
	
	//게시판목록
	@Override
	public List<BoardVO> selectBoardList()throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList");
	}

	//게시판 상세 보기
	@Override
	public BoardVO selectBoardRead(String board_no) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoardRead",board_no);
	}

	//게시판 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		System.out.println("서비스 업데이트 ="+boardVO);
		sqlSession.update("mapper.board.updateBoard",boardVO);
	}


	//게시판 삭제 
	@Override
	public void delete(int board_no) throws Exception {
		System.out.println("DAO 삭제 업데이트전 ="+board_no);
		sqlSession.delete("mapper.board.deleteBoard", board_no);
		System.out.println("DAO 삭제 업데이트후 ="+board_no);
	}


	//게시판 조회수 증가 
	@Override
	public void viewcnt(String board_no) throws Exception {
		sqlSession.update("mapper.board.updateViewcnt",board_no);
	}


	//게시판 페이징 처리 총 게시글 수 
	@Override
	public int selectBoardCount()throws Exception{
		System.out.println("DAO count 접근");
		int select = sqlSession.selectOne("mapper.board.selectBoardCount");
		return select;
	}


	//게시판 페이징 처리 
	@Override
    public List<BoardVO> selectBoardPage(int startRow,int size){
    Map map = new HashMap();
    map.put("startRow", startRow);
    map.put("size", size);
    System.out.println("selectLetter");
    System.out.println(startRow);
    System.out.println(size);
    List<BoardVO> result = (ArrayList)sqlSession.selectList("mapper.board.selectBoardPage",map);
    System.out.println("result"+result);
    return result;
   }


//	@Override
//	public List<BoardVO> selectboardPage(BoardPage boardPage) {
//		List<BoardVO> selectboardPage = (ArrayList)sqlSession.selectList("mapper.board.selectBoardPage",boardPage);
//		return selectboardPage;
//	}












}
