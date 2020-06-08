package com.spring.memberboard.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("boardService")
public class BoardServiceImpl{
	
	@Autowired(required=false) 
	private BoardDAO boardDAO=null;

	public void getBoardList(HttpServletRequest request,Model model) {
		ArrayList<BoardVO> boardlist = new ArrayList<BoardVO>();
		
		int page = 1;
		int limit = 10; //한 화면에 뿌려줄 글의 갯수
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		int listcount = boardDAO.getListCount(); //총 리스트 수를 받아옴
		boardlist = boardDAO.getBoardList(page,limit); // 리스트를 받아 옴 
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

	public BoardVO getDetail(BoardVO bvo){
		BoardVO vo;
		try {
			boardDAO.setReadCountUpdate(bvo);
			vo = boardDAO.getDetail(bvo);
			
			return vo;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public int boardInsert(BoardVO bvo)throws Exception{
		
		int res = boardDAO.boardInsert(bvo);
		
		return res;
	}

	//-------------------------------------------------------------------
	public int boardReply(BoardVO bvo) {
		int res = boardDAO.boardReply(bvo);
		
		return res;
	}
	//-------------------------------------------------------------------

	public int boardModify(BoardVO bvo) throws Exception {
		int res = boardDAO.boardModify(bvo);
		
		return res;
	}

	public int boardDelete(BoardVO bvo) {
		int res = boardDAO.boardDelete(bvo);
		
		return res;
	}

	public boolean isBoardWriter(BoardVO bvo) {
		boolean b = boardDAO.isBoardWriter(bvo);
		return b;
	}
	
	

}
