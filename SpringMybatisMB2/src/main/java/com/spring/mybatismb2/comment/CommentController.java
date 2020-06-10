package com.spring.mybatismb2.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

	@Autowired
	CommentService mCommentService;
	
	@RequestMapping(value="/comment_list.bo",produces="application/json;charset=UTF-8") //댓글리스트
	private List<CommentVO> mCommentServiceList(@RequestParam int bno)throws Exception{
		List<CommentVO> comment_list = mCommentService.commentListService(bno);
		System.out.println(comment_list.size());
		return comment_list;
	}
	
	@RequestMapping(value="/comment_insert.bo",produces="application/json;charset=UTF-8") //댓글리스트
	private int mCommentServiceInsert(CommentVO comment,HttpSession session)throws Exception{
		comment.setWriter((String)session.getAttribute("id"));
		
		return mCommentService.commentInsertService(comment);
	}
	
	@RequestMapping(value="/comment_update.bo",produces="application/json;charset=UTF-8") //댓글리스트
	private int mCommentServiceUpdateProc(@RequestParam int cno,@RequestParam String content)throws Exception{
		CommentVO comment = new CommentVO();
		comment.setCno(cno);
		comment.setContent(content);
		
		return mCommentService.commentUpdateService(comment);
	}
	
	@RequestMapping(value="/comment_delete.bo",produces="application/json;charset=UTF-8") //댓글리스트
	private int mCommentServiceDelete(@RequestParam(value="cnt") int cno)throws Exception{
		
		return mCommentService.commentDeleteService(cno);
	}
}
