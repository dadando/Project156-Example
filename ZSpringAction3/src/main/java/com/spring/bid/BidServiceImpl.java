package com.spring.bid;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.BidMapper;
import com.spring.mapper.BoardMapper;

@Service
public class BidServiceImpl {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BidVO> bidListService(int bno) {
		BidMapper bidmapper = sqlSession.getMapper(BidMapper.class);
		return bidmapper.bidList(bno);
	}

	public int bidInsertService(BidVO bidvo) {
		BidMapper bidmapper = sqlSession.getMapper(BidMapper.class);
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);  //상세보기쪽 mapper
		int bno = bidvo.getBno();
		
		int price = 0;
		//응찰리스트의 수를 구함 =>응찰번호
		int res = bidmapper.countBidList(bno);
		bidvo.setBidno(res);
		
		if(res==1) {
			//첫 응찰시 현재가로 바로 응찰.
			price = boardmapper.selectNowPrice(bidvo.getBno());
			bidvo.setNow_price(price);
		}else {
			//응찰하기 클릭시 +1000원된 가격으로 응찰이 된다.
			//두번째 응찰부터
			price = bidmapper.selectNowPrice(bno);
			price +=1000;
			bidvo.setNow_price(price); 
		}
		//상세보기의 현재가 갱신
		
		boardmapper.updateBoard(price,bidvo.getBno());
		
		return bidmapper.bidInsert(bidvo);
	}

}
