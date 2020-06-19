package com.spring.bid.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void getBoardList(HttpServletRequest request, Model model) {
		ArrayList<BoardVO> boardlist = new ArrayList<BoardVO>();
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		
		int page = 1;
		int limit = 10; //한 화면에 뿌려줄 글의 갯수
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		int listcount = boardmapper.getListCount(); //총 리스트 수를 받아옴
		int startrow = (page-1)*10+1; //읽기 시작할 row 번호
		int endrow = startrow+limit-1; //읽을 마지막 row 번호
		boardlist = boardmapper.getBoardList(startrow,endrow); // 리스트를 받아 옴 
		//총 페이지 수	
		int maxpage=(int)((double)listcount/limit+0.95); //0.95를 더해서 올림 처리 
		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)   
		int startpage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1;   
		//현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등...)
		int endpage = maxpage;     
		if (endpage>startpage+10-1) 
			endpage=startpage+10-1; 
		
		model.addAttribute("page", page); // 현재 페이지 수 
		model.addAttribute("maxpage", maxpage); // 최대 페이지 수 
		model.addAttribute("startpage", startpage);//  현재 페이지에 표시할 첫 페이지 수   
		model.addAttribute("endpage", endpage); //현재 페이지에 표시할 페이지 수
		
		model.addAttribute("listcount",listcount);  //글 수 
		model.addAttribute("boardlist", boardlist); //글
		
	}

	public void boardinsert(BoardVO bvo)throws Exception {
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		
		boardmapper.boardInsert(bvo);
		
	}

	public BoardVO getDetail(int num) {
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO bvo = boardmapper.getDetail(num);
		
		return bvo;
	}

}
