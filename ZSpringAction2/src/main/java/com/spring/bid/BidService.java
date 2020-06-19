package com.spring.bid;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.BidMapper;
import com.spring.mapper.BoardMapper;

@Service
public class BidService {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BidVO> bidListService(int bno) {
		BidMapper bidmapper = sqlSession.getMapper(BidMapper.class);
		return bidmapper.bidList(bno);
	}

	public int bidInsertService(BidVO bidvo) {
		BidMapper bidmapper = sqlSession.getMapper(BidMapper.class);
		int price = bidmapper.selectNowPrice();
		price +=1000;
		bidvo.setNow_price(price); //응찰하기 클릭시 +1000원된 가격으로 응찰이 된다.
		
		//상세보기의 현재가 갱신
		BoardMapper boardmapper = sqlSession.getMapper(BoardMapper.class);
		boardmapper.updateBoard(price,bidvo.getBno());
		
		return bidmapper.bidInsert(bidvo);
	}

}
