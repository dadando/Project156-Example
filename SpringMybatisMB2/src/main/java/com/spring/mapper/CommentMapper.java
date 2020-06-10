package com.spring.mapper;

import java.util.List;

import com.spring.mybatismb2.comment.CommentVO;

public interface CommentMapper {
	public int commentCount() throws Exception; //댓글 갯수
	public List<CommentVO> commentList(int bno) throws Exception; //댓글 목록
	public int commentInsert(CommentVO comment) throws Exception; //댓글 추가
	public int commentUpdate(CommentVO comment) throws Exception; //댓글 수정
	public int commentDelete(int cno) throws Exception; //댓글 삭제
}
