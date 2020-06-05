package com.spring.springajax1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController: 스프링 4점대 버전부터 지원하는 어노테이션.
컨트롤러 클래스에 @RestController만 붙이면 메소드에 
@ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON등을 전송할 수 있다.
뷰를 리턴하는 메소드를 가지고있는 @Controller와는 다르게 
@RestController는 문자열, 객체등을 리턴하는 메소드들을 가지고 있다. 
*/

@RestController
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	
	//produces 속성을 이용해 Response의 Content-Type을 제어할 수 있다
	//@PostMapping : Method가 POST 방식일 때만 사용한다는 의미.
	//@GetMapping : Method가 GET 방식일 때만 사용한다는 의미.
	@PostMapping(value="/getPeopleJSON.do", produces="application/json;charset=UTF-8")
	public List<PeopleVO> getPeopleJSONGET() {
		List<PeopleVO> list = peopleService.getPeoplejson();
		
        return list;
	}

	@PostMapping(value="/insertPeople.do", produces="application/json;charset=UTF-8")
	public Map<String, Object> insertPerson(PeopleVO vo) {
		Map<String, Object> retVal = new HashMap<String, Object>(); //리턴값 저장
		try{
			peopleService.insertPeople(vo);
			
	        retVal.put("res", "OK");
		}
		catch (Exception e)
		{
			retVal.put("res", "FAIL");
        	retVal.put("message", "Failure");
		}
        
		return retVal;
	}

	@RequestMapping(value="/updatePeopleForm.do", produces="application/json;charset=UTF-8")
	public PeopleVO updatePeopleForm(PeopleVO vo) {

		vo = peopleService.getPeople(vo.getId());
		
        return vo;
	}
	
	@RequestMapping(value="/updatePeople.do", produces="application/json;charset=UTF-8")
	public Map<String, Object> updatePeople(PeopleVO vo) {

		Map<String, Object> retVal = new HashMap<String, Object>(); //리턴값 저장
		try{
			peopleService.updatePeople(vo);
			
	        retVal.put("res", "OK");
		}
		catch (Exception e)
		{
			retVal.put("res", "FAIL");
        	retVal.put("message", "Failure");
		}
        
		return retVal;
	}

	@RequestMapping(value="/deletePeople.do", produces="application/json;charset=UTF-8")
	public Map<String, Object> deletePeople(@RequestParam(value="id") String id) {
		Map<String, Object> retVal = new HashMap<String, Object>(); //리턴값 저장
		try{
			peopleService.deletePeople(id);
			
	        retVal.put("res", "OK");
		}
		catch (Exception e)
		{
			retVal.put("res", "FAIL");
        	retVal.put("message", "Failure");
		}
        
		return retVal;
	}

}
