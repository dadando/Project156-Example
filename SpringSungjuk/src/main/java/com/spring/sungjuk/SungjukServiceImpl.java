package com.spring.sungjuk;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sungjukService")
public class SungjukServiceImpl implements SungjukService {
	
	@Autowired(required=false) 
	private SungjukDAO sungjukDAO=null;
	
	@Override
	public int insertSungjuk(SungjukVO sungjukVO) {
		int res  = sungjukDAO.insertSungjuk(sungjukVO); 
		
		return res;
	}

	@Override
	public ArrayList<SungjukVO> getSungjuklist() {
		ArrayList<SungjukVO> sungjuk_list = new ArrayList<SungjukVO>();
		sungjuk_list = sungjukDAO.getSungjuklist();
	
		return sungjuk_list;
	}

	@Override
	public SungjukVO selectSungjuk(SungjukVO sungjukVO) {
		SungjukVO vo  = sungjukDAO.selectSungjuk(sungjukVO);
		
		return vo;
	}

	@Override
	public int deleteSungjuk(SungjukVO sungjukVO) {
		int res = sungjukDAO.deleteSungjuk(sungjukVO); 
		
		return res;
	}

	@Override
	public int updateSungjuk(SungjukVO sungjukVO) {
		int res = sungjukDAO.updateSungjuk(sungjukVO);
		
		return res;
	}

}
