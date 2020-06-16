package com.spring.modal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@RequestMapping(value = "home.me")
	public String home() {
		return "home";
	}
	
	//로그인 클릭후 실제 유저인지 체크하는 과정.
	@RequestMapping(value="login.me")
	public String main(@RequestParam(value="userId")String id,@RequestParam(value="userPW")String pw,HttpSession session)throws Exception {
		String id1 = loginService.logincheck(id,pw);
		session.setAttribute("id", id1);
		if(id1 == id){
			return "main";
		}else {
			return "redirect:/home.me";
		}
		
	}
	
	@RequestMapping(value="join.me")
	public String main(MemberVO memberVO)throws Exception {
		loginService.insertMember(memberVO);
		
		return "redirect:/home.me";
	}
}
