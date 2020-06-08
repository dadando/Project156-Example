package com.spring.springsungjuk_mybatis;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.SungjukMapper;

@Service
public class SungjukServiceImpl implements SungjukService {

	@Autowired
	private SqlSession sqlSession; //마이바티스 라이브러리가 제공하는 클래스
	
	@Override
	public ArrayList<SungjukVO> getSungjuklist() {

		ArrayList<SungjukVO> sungjukList = new ArrayList<SungjukVO>();
		SungjukMapper sungjukmapper = sqlSession.getMapper(SungjukMapper.class);
		sungjukList = sungjukmapper.getSungjuklist();
		System.out.println("총 학생수: "+sungjukmapper.getCount());
		
		return sungjukList;
	}

	@Override
	public SungjukVO selectSungjuk(String hakbun) {
		SungjukMapper sungjukmapper = sqlSession.getMapper(SungjukMapper.class);
		SungjukVO sungjukVO = sungjukmapper.selectSungjuk(hakbun);
		
		return sungjukVO;
	}
	
	@Override
	public void insertSungjuk(SungjukVO sungjukVO) {
		SungjukMapper sungjukMapper = sqlSession.getMapper(SungjukMapper.class);
		int res = sungjukMapper.insertSungjuk(sungjukVO);
		System.out.println("res = "+ res);
		
	}

	@Override
	public void deleteSungjuk(String hakbun) {
		SungjukMapper sungjukMapper = sqlSession.getMapper(SungjukMapper.class);
		sungjukMapper.deleteSungjuk(hakbun);
	}

	@Override
	public void updateSungjuk(SungjukVO sungjukVO) {
		SungjukMapper sungjukMapper = sqlSession.getMapper(SungjukMapper.class);
		sungjukMapper.updateSungjuk(sungjukVO);
	}

}
