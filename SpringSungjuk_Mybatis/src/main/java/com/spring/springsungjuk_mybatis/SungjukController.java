package com.spring.springsungjuk_mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SungjukController {
	
	@Autowired
	private SungjukServiceImpl sungjukService;

	@RequestMapping("/listform.me")
	public ModelAndView getSungjuklist() throws Exception { 
		ModelAndView result = new ModelAndView();
		ArrayList<SungjukVO> sungjuk_list = sungjukService.getSungjuklist();
		result.addObject("sungjuk_list", sungjuk_list);
		result.setViewName("listForm");
		
		return result;
	}
	
	@RequestMapping("/inputform.me")
	public String inputForm() throws Exception{
		return "inputForm";
	}
	
	@RequestMapping("/sungjukupdate.me") 
	public ModelAndView updateForm(@RequestParam(value="hakbun")String hakbun) { 
		SungjukVO vo = sungjukService.selectSungjuk(hakbun);
		
		ModelAndView result = new ModelAndView();
		result.addObject("vo",vo);
		result.setViewName("updateForm");
		
		return result;
	}
	
	@RequestMapping("/inputprocess.me")
	public String insertSungjuk(SungjukVO sungjukVO) { 
		sungjukVO.process();
		sungjukService.insertSungjuk(sungjukVO);
		
		return "redirect:/listform.me";
	}
	
	@RequestMapping("/sungjukinfo.me") 
	public ModelAndView selectSungjuk(@RequestParam(value="hakbun")String hakbun) throws Exception { 
		SungjukVO vo = sungjukService.selectSungjuk(hakbun);
		
		ModelAndView result = new ModelAndView();
		result.addObject("vo",vo);
		result.setViewName("infoForm");
		
		return result;
	}
	
	@RequestMapping("/sungjukdelete.me") 
	public String deleteSungjuk(@RequestParam(value="hakbun") String hakbun){ 
		sungjukService.deleteSungjuk(hakbun);
		
		return "redirect:/listform.me";
	}
	//회원정보 수정 메소드 실행
	@RequestMapping("/updateform.me")
	public String updateSungjuk(SungjukVO sungjukVO){
		sungjukVO.process();
		sungjukService.updateSungjuk(sungjukVO);
		
		return "redirect:/listform.me";
	}
}
