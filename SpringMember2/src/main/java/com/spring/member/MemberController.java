package com.spring.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login.me") 
	public String userCheck(MemberVO memberVO, HttpSession session, 
			HttpServletResponse response) throws Exception { 
		int res = memberService.userCheck(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res == 1)
		{
			session.setAttribute("id",memberVO.getId());
			writer.write("<script>alert('로그인 성공!!');location.href='./main.me';</script>");
			//return "redirect:/main.me"; //현재 주소를 redirect주소로 바꿔준다.
		}
		else 
		{
			writer.write("<script>alert('로그인 실패!!');location.href='./loginform.me';</script>");
			//return "redirect:/loginform.me";
		}
		return null;
	}
	
	@RequestMapping("/main.me") 
	public String mainPage() throws Exception { 
		return "main";
	}
	
	@RequestMapping("/loginform.me") 
	public String loginForm() throws Exception { 
		return "loginForm";
	}
	
	@RequestMapping("/joinform.me") 
	public String joinForm() throws Exception { 
		return "joinForm";
	}
	//회원정보 수정 폼으로 이동
	@RequestMapping("/updateform.me") 
	public String updateForm() throws Exception { 
		return "updateForm";
	}
	
	@RequestMapping("/joinprocess.me") 
	public String insertMember(MemberVO memberVO, HttpServletResponse response) 
		throws Exception { 
		int res = memberService.insertMember(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res != 0)
		{
			writer.write("<script>alert('회원 가입 성공!!');"
					+ "location.href='./loginform.me';</script>");
		}
		else
		{
			writer.write("<script>alert('회원 가입 실패!!');"
					+ "location.href='./joinform.me';</script>");
		}
		return null;
	}
	
	@RequestMapping("/memberlist.me") 
	public String getMemberlist(Model model) throws Exception { 
		ArrayList<MemberVO> member_list = memberService.getMemberlist();
		model.addAttribute("member_list", member_list);
		
		return "member_list";
	}
	
	@RequestMapping("/memberinfo.me") 
	public String selectMember(MemberVO memberVO, Model model) throws Exception { 
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member_info";
	}
	
	@RequestMapping("/memberdelete.me") 
	public String deleteMember(MemberVO memberVO, Model model) throws Exception { 
		memberService.deleteMember(memberVO);
		
		return "redirect:/memberlist.me";
	}
	
	//회원정보 수정 메소드 실행
	@RequestMapping("/memberupdate.me")
	public String updateMember(MemberVO memberVO, HttpServletResponse response)
			throws Exception{
		int res = memberService.updateMember(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if(res!=0) {
			writer.write("<script>alert('회원 가입 수정 성공!!');"
					+"location.href='./memberlist.me';</script>");
		}else {
			writer.write("<script>alert('회원 가입 수정 실패!!');"
					+ "location.href='./updateform.me';</script>");
		}
		return null;
	}
}