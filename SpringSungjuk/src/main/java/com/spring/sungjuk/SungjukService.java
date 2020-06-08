package com.spring.sungjuk;

import java.util.ArrayList;

public interface SungjukService {
	public int insertSungjuk(SungjukVO sungjukVO);
	public ArrayList<SungjukVO> getSungjuklist();
	public SungjukVO selectSungjuk(SungjukVO sungjukVO);
	public int deleteSungjuk(SungjukVO sungjukVO);
	public int updateSungjuk(SungjukVO sungjukVO);
}
