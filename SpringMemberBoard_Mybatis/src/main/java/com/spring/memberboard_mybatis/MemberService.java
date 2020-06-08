package com.spring.memberboard_mybatis;

import java.util.ArrayList;

public interface MemberService {

	void joinMember(MemberVO memberVO);

	String userCheck(String id, String password);

	ArrayList<MemberVO> getMemberlist();

	MemberVO getInfo(String id);

	void updateMember(MemberVO memberVO);

	void deletemember(String id);

}
