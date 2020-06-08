package com.spring.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.memberboard_mybatis.BoardVO;

public interface BoardMapper {

	int getListCount();

	ArrayList<BoardVO> getBoardList(@Param(value="startrow") int startrow,@Param(value="endrow") int endrow);

	int boardInsert(BoardVO bvo);

	int getNum();

	void setReadCountUpdate(BoardVO bvo);

	BoardVO getDetail(BoardVO bvo);

	int boardReply(BoardVO bvo);

	void updateRE(@Param(value="re_ref")int re_ref,@Param(value="re_seq") int re_seq);

	int boardModify(BoardVO bvo);

	int boardDelete(BoardVO bvo);

}
