package com.spring.mapper;

import java.util.List;

import com.spring.bid.BidVO;

public interface BidMapper {

	List<BidVO> bidList(int bno);

	int bidInsert(BidVO bidvo);

	int selectNowPrice(int bno);

	int countBidList(int bno);

}
