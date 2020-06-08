package com.spring.sungjuk;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SungjukController {
	
	@Autowired
	private SungjukService sungjukService;

	@RequestMapping("/listform.me")
	public String getSungjuklist(Model model) throws Exception { 
		ArrayList<SungjukVO> sungjuk_list = sungjukService.getSungjuklist();
		model.addAttribute("sungjuk_list", sungjuk_list);
		return "listForm";
	}
	
	@RequestMapping("/inputform.me")
	public String inputForm() throws Exception{
		return "inputForm";
	}
	
	@RequestMapping("/sungjukupdate.me") 
	public String updateForm(SungjukVO sungjukVO, Model model) throws Exception { 
		SungjukVO vo = sungjukService.selectSungjuk(sungjukVO);
		model.addAttribute("vo",vo);
		/*model.addAttribute("hakbun",sungjukVO.getHakbun());
		model.addAttribute("name",sungjukVO.getName());*/
		return "updateForm";
	}
	
	@RequestMapping("/inputprocess.me")
	public String insertSungjuk(SungjukVO sungjukVO, HttpServletResponse response) 
			throws Exception { 
			int res = sungjukService.insertSungjuk(sungjukVO);
			
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res != 0)
		{
			writer.write("<script>alert('성적 입력 성공!!');"
					+ "location.href='./listform.me';</script>");
		}
		else
		{
			writer.write("<script>alert('성적 입력 실패!!');"
					+ "location.href='./inputform.me';</script>");
		}
		return null;
	}
	
	@RequestMapping("/sungjukinfo.me") 
	public String selectSungjuk(SungjukVO sungjukVO, Model model) throws Exception { 
		SungjukVO vo = sungjukService.selectSungjuk(sungjukVO);
		model.addAttribute("sungjukVO", vo);
		
		return "infoForm";
	}
	
	@RequestMapping("/sungjukdelete.me") 
	public String deleteSungjuk(SungjukVO sungjukVO, Model model) throws Exception { 
		sungjukService.deleteSungjuk(sungjukVO);
		
		return "redirect:/listform.me";
	}
	//회원정보 수정 메소드 실행
	@RequestMapping("/updateform.me")
	public String updateSungjuk(SungjukVO sungjukVO, HttpServletResponse response)
			throws Exception{
		int res = sungjukService.updateSungjuk(sungjukVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if(res!=0) {
			writer.write("<script>alert('성적 정보 수정 성공!!');"
					+"location.href='./listform.me';</script>");
		}else {
			writer.write("<script>alert('성적 정보 수정 실패!!');"
					+ "location.href='./sungjukupdate.me';</script>");
		}
		return null;
	}
	
}
