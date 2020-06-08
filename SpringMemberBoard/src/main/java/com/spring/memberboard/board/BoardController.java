package com.spring.memberboard.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping("/boardlist.bo")
	public String boardlist(HttpServletRequest request,Model model) throws Exception{
		boardService.getBoardList(request,model);
		
		return "board/board_list";
	}
	
	@RequestMapping("/boardwrite.bo")
	public String boardwrite(BoardVO bvo,Model model) throws Exception{
		model.addAttribute("id",bvo.getId());
		
		return "board/board_write";
	}
	
	@RequestMapping("/boardinsert.bo")
	public String boardinsert(BoardVO bvo,HttpServletResponse response) throws Exception{
		int res = boardService.boardInsert(bvo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(res!=0) {
			writer.write("<script>alert('글 작성 성공!!');"
					+"location.href='./boardlist.bo';</script>");
		}else {
			writer.write("<script>alert('글 입력 실패!!');"
					+"location.href='./boardwrite.bo';</script>");
		}
		return null;
	}
	
	@RequestMapping("/boarddetail.bo")
	public String boarddetail(BoardVO bvo, Model model)throws Exception {
		BoardVO vo = boardService.getDetail(bvo);
		model.addAttribute("bvo",vo);
		
		return "board/board_view";
	}
	
	@RequestMapping("/boraddelete.bo")
	public String boarddelete(BoardVO bvo)throws Exception{
		boardService.boardDelete(bvo);
		
		return "redirect:/boardlist.bo";
	}
	@RequestMapping("/boardreplyform.bo")
	public String replyform(BoardVO bvo,Model model)throws Exception{
		BoardVO vo = boardService.getDetail(bvo);
		model.addAttribute("bvo",vo);
		
		return "board/board_reply";
	}
	
	
	@RequestMapping("/boardreply.bo")
	public void boardreply(BoardVO bvo,HttpServletResponse response)throws Exception{
		int res = boardService.boardReply(bvo);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(res!=0) {
			writer.write("<script>alert('답변 성공!!');"
					+"location.href='./boardlist.bo';</script>");
		}else {
			writer.write("<script>alert('답변 실패!!');"
					+"location.href='./boardreplyform.bo';</script>");
		}
	}
	
	@RequestMapping("/boardmodifyform.bo")
	public String modifyform(BoardVO bvo,Model model) throws Exception {
		BoardVO vo = boardService.getDetail(bvo);
		model.addAttribute("vo",vo);
		
		return "board/board_modify";
	}
	
	@RequestMapping("/boardmodify.bo")
	public void boardmodify(BoardVO bvo,HttpServletResponse response)throws Exception{
		int res = boardService.boardModify(bvo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if(res!=0) {
			writer.write("<script>alert('수정 성공!!');"
					+"location.href='./boardlist.bo';</script>");
		}else {
			writer.write("<script>alert('수정 실패!!');"
					+"location.href='./boardmodifyform.bo';</script>");
		}
	}
	
}
