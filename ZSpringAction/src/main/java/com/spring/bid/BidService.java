package com.spring.bid;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.BidMapper;

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
		
		return bidmapper.bidInsert(bidvo);
	}

}
