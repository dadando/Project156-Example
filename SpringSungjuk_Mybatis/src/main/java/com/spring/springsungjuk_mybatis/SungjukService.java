package com.spring.springsungjuk_mybatis;

import java.util.ArrayList;

public interface SungjukService {
	public ArrayList<SungjukVO> getSungjuklist();
	public SungjukVO selectSungjuk(String hakbun);
	public void insertSungjuk(SungjukVO sungjukVO);
	public void deleteSungjuk(String hakbun);
	public void updateSungjuk(SungjukVO sungjukVO);
}
