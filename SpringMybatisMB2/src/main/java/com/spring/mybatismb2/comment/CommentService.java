package com.spring.mybatismb2.comment;

import java.util.List;

public interface CommentService {
	public int commentCount() throws Exception; //댓글 갯수
	public List<CommentVO> commentListService(int bno) throws Exception; //댓글 목록
	public int commentInsertService(CommentVO comment) throws Exception; //댓글 추가
	public int commentUpdateService(CommentVO comment) throws Exception; //댓글 수정
	public int commentDeleteService(int cno) throws Exception; //댓글 삭제
}
