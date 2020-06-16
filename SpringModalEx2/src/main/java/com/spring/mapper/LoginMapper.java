package com.spring.mapper;

import com.spring.modal.MemberVO;

public interface LoginMapper {
	
	String usercheck(String id);

	void insertMember(MemberVO memberVO);

}
