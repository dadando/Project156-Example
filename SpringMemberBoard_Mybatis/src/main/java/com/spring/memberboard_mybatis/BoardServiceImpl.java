package com.spring.memberboard_mybatis;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired 
	private SqlSession sqlSession;
	
	@Override
	public void getBoardList(HttpServletRequest request,Model model) {
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
	
	@Override
	public BoardVO getDetail(BoardVO bvo){
		BoardVO vo;
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		boardmapper.setReadCountUpdate(bvo);
		vo = boardmapper.getDetail(bvo);
		
		return vo;
	}

	@Override
	public int boardInsert(BoardVO bvo)throws Exception{
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		int num=0;
		num = boardmapper.getNum();
		
		if(num!=0) { //등록된 글이 있을때 그다음 숫자를 부여하기 위해
			num = num+1;
		}else { //등록된 글이 없을 때 최초 글의 번호는 1.
			num = 1;
		}
		bvo.setNum(num);
		int res = boardmapper.boardInsert(bvo);
		
		return res;
	}

	@Override
	public int boardReply(BoardVO bvo) {
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		int num=0;
		num = boardmapper.getNum();
		num = num+1;
		bvo.setNum(num);
		
		int re_ref = bvo.getRe_ref();
		System.out.println("re_ref= "+bvo.getRe_ref());
		int re_lev = bvo.getRe_lev();
		int re_seq = bvo.getRe_seq();
		
		boardmapper.updateRE(re_ref,re_seq);
		
		re_seq = re_seq+1;
		re_lev = re_lev+1;
		bvo.setRe_seq(re_seq);
		bvo.setRe_lev(re_lev);
		
		int res = boardmapper.boardReply(bvo);
		
		return res;
	}
	

	@Override
	public int boardModify(BoardVO bvo) throws Exception {
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		int res = boardmapper.boardModify(bvo);
		
		return res;
	}
	
	@Override
	public int boardDelete(BoardVO bvo) {
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		int res = boardmapper.boardDelete(bvo);
		
		return res;
	}
/*
    @Override
	public boolean isBoardWriter(BoardVO bvo) {
		boolean b = boardDAO.isBoardWriter(bvo);
		return b;
	}
	
	
*/
}
