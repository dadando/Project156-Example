package com.spring.memberboard_mybatis;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardService {

	void getBoardList(HttpServletRequest request, Model model);

	BoardVO getDetail(BoardVO bvo);

	int boardInsert(BoardVO bvo) throws Exception;

	int boardReply(BoardVO bvo);

	int boardModify(BoardVO bvo) throws Exception;

	int boardDelete(BoardVO bvo);

}
