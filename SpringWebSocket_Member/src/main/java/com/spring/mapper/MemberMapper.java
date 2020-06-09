package com.spring.mapper;

import java.util.ArrayList;

import com.spring.springwebsocket.MemberVO;

public interface MemberMapper {

	int insertMember(MemberVO memberVO);
	String checkPassword(String id);
	ArrayList<MemberVO> getMemberList();
	MemberVO getInfo(String id);
	void updateMember(MemberVO memberVO);
	void deletemember(String id);

}
