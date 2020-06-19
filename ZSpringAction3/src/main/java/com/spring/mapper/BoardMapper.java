package com.spring.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.bid.board.BoardVO;

public interface BoardMapper {

	int getListCount();

	ArrayList<BoardVO> getBoardList(@Param(value="startrow")int startrow,@Param(value="endrow")int endrow);

	void boardInsert(BoardVO bvo);

	BoardVO getDetail(int num);

	void updateBoard(@Param("price")int price,@Param(value="bno") int bno);

	int selectNowPrice(@Param("bno")int bno);

	
}
