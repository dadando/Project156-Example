package com.spring.bid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	BidServiceImpl bidService;
	
	@RequestMapping(value="/bid_list.bo", produces="application/json;charset=UTF-8")
	private List<BidVO> bidList(@RequestParam int bno)throws Exception{
		List<BidVO> bid_list = bidService.bidListService(bno);
		
		return bid_list;
	}
	
	@RequestMapping(value="/bid_insert.bo",produces="application/json;charset=UTF-8")
	private int mbidInsert(BidVO bidvo)throws Exception{
		int res = bidService.bidInsertService(bidvo);
		
		
		return res;
	}
}
