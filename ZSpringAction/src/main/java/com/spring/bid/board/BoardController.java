package com.spring.bid.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping("/boardlist.me")
	public String boardlist(HttpServletRequest request,Model model)throws Exception {
		boardService.getBoardList(request,model);
		
		return "board/board_list";
	}
	
	@RequestMapping("/boardwrite.bo")
	public String boardlist()throws Exception{
		return "board/board_write";
	}
	
	@RequestMapping("/boardinsert.bo")
	public String boardinsert(BoardVO bvo)throws Exception{
		boardService.boardinsert(bvo);
		
		return "redirect:/boardlist.me";
	}
	
	@RequestMapping("/boarddetail.bo")
	public String boardDetail(@RequestParam(value="num")int num,Model model) {
		BoardVO bvo = boardService.getDetail(num);
		model.addAttribute("bvo",bvo);
		
		return "board/board_detail";
	}
}
