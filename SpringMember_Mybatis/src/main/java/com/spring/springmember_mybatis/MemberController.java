package com.spring.springmember_mybatis;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@RequestMapping("/loginform.me")
	public String loginForm(HttpSession session) throws Exception{
		session.invalidate();
		return "loginForm";
	}
	
	@RequestMapping("/joinform.me")
	public String joinForm() throws Exception{
		return "joinForm";
	}
	
	@RequestMapping("/joinprocess.me")
	public String join(MemberVO memberVO)throws Exception{
		memberService.joinMember(memberVO);
		
		return "redirect:/loginform.me";
	}
	
	@RequestMapping("/login.me")
	public String login(@RequestParam(value="id")String id,@RequestParam(value="password")String password, HttpSession session)throws Exception{
		String res = memberService.userCheck(id,password);
		session.setAttribute("id", res);
		if(res==id) {
			System.out.println("로그인 성공.");
			return "main";
		}else {
			System.out.println("로그인 실패");
			return "redirect:/loginform.me";
		}
	}
	
	//로그아웃 
	@RequestMapping("/logout.me")
	/*public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/loginform.me";
	}*/
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "loginForm";
	}
	
	@RequestMapping("/memberlist.me")
	public ModelAndView memberList() throws Exception {
		ModelAndView result = new ModelAndView();
		ArrayList<MemberVO> member_list = memberService.getMemberlist();
		result.addObject("member_list",member_list);
		result.setViewName("member_list");
		return result;
	}
	
	@RequestMapping("/memberinfo.me")
	public ModelAndView memberinfo(@RequestParam(value="id")String id) throws Exception {
		MemberVO memberVO = memberService.getInfo(id);
		ModelAndView result = new ModelAndView();
		result.addObject("memberVO",memberVO);
		result.setViewName("member_info");
		
		return result;
	}
	
	@RequestMapping("/updateform.me")
	public ModelAndView updateform(@RequestParam(value="id")String id) throws Exception {
		MemberVO memberVO = memberService.getInfo(id);
		System.out.println("---------------------------"+id);
		ModelAndView result = new ModelAndView();
		result.addObject("memberVO",memberVO);
		result.setViewName("updateForm");
		return result;
	}
	
	@RequestMapping("/memberupdate.me")
	public String memberupdate(MemberVO memberVO) throws Exception {
		memberService.updateMember(memberVO);
		
		return "redirect:/memberlist.me";
	}
	
	@RequestMapping("memberdelete.me")
	public String memberDelete(@RequestParam(value="id") String id) throws Exception {
		memberService.deletemember(id);
		
		return "redirect:/memberlist.me";
	}
	
}