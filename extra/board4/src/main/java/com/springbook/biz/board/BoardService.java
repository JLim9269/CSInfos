package com.springbook.biz.board;

import java.util.List;

import com.springbook.biz.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO vo);
	
	void updateBoard(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	BoardVO getBoard(BoardVO vo);
	
	List<BoardVO> getBoardList(BoardVO vo);
}