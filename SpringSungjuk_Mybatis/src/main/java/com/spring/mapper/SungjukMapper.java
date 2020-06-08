package com.spring.mapper;

import java.util.ArrayList;

import com.spring.springsungjuk_mybatis.SungjukVO;

public interface SungjukMapper {
	ArrayList<SungjukVO> getSungjuklist();
	SungjukVO selectSungjuk(String hakbun);
	int insertSungjuk(SungjukVO sungjukVO);
	void deleteSungjuk(String hakbun);
	void updateSungjuk(SungjukVO sungjukVO);
	int getCount();
}
