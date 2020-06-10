package com.spring.springspring;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void joinMember(MemberVO memberVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.insertMember(memberVO);
		System.out.println("추가된 행의수:"+res);
	}
	
	@Override
	public String userCheck(String id,String password) {
		String dbpass="";
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		dbpass = memberMapper.checkPassword(id);
		if(dbpass.equals(password)) {
			return id;
		}else {
			return null;
		}
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist() {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		memberList = membermapper.getMemberList();
		
		return memberList;
	}
	
	@Override
	public MemberVO getInfo(String id) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO memberVO = membermapper.getInfo(id);
		
		return memberVO;
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.updateMember(memberVO);
	}

	@Override
	public void deletemember(String id) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.deletemember(id);
		
	}
	

}
