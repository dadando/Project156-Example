package com.spring.modal;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.LoginMapper;

@Service
public class LoginServiceImpl {
	
	@Autowired
	private SqlSession sqlSession;
	
	public String logincheck(String id, String pw) {
		String pw1 = ""; //아이디가 테이블에 존재하지않을때 null반환시 오류를 방지해준다.
		LoginMapper loginmapper = sqlSession.getMapper(LoginMapper.class);
		pw1 = loginmapper.usercheck(id);
		if(pw1.equals(pw)) {
			return id;
		}else {
			return null;
		}
	}

	public void insertMember(MemberVO memberVO) {
		LoginMapper loginmapper = sqlSession.getMapper(LoginMapper.class);
		loginmapper.insertMember(memberVO);
	}

}
