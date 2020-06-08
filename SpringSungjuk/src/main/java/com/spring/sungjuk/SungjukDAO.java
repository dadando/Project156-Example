package com.spring.sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class SungjukDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertSungjuk(SungjukVO sungjukVO) {
		int result = 0;
		
		try {
			conn = JDBCUtill.getConnection();
			
			pstmt = conn.prepareStatement("insert into sungjuk values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, sungjukVO.getHakbun());
			System.out.println(sungjukVO.getHakbun());
			pstmt.setString(2, sungjukVO.getName());
			pstmt.setInt(3, sungjukVO.getKor());
			pstmt.setInt(4, sungjukVO.getEng());
			pstmt.setInt(5, sungjukVO.getMath());
			sungjukVO.process();
			pstmt.setInt(6, sungjukVO.getTot());
			pstmt.setDouble(7,sungjukVO.getAvg());
			pstmt.setString(8, sungjukVO.getGrade());
			result = pstmt.executeUpdate();
			System.out.println(result);
			
		}
		catch(Exception ex) {
			System.out.println("성적입력오류"+ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			JDBCUtill.closeResource(pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<SungjukVO> getSungjuklist()
	{
		SungjukVO vo = null;
		ArrayList<SungjukVO> sungjuk_list = null;

		try
		{
			sungjuk_list = new ArrayList<SungjukVO>();
			//처음 실행때 입력된 성적정보가 없을때 를 대비해서 객체를 미리 생성한다.(if문안에서 만들려고하면 NullPointer예외가 발생)
			conn = JDBCUtill.getConnection();

			pstmt = conn.prepareStatement("select * from sungjuk order by hakbun");
			rs = pstmt.executeQuery();

			if (rs.next())
			{
				
				do
				{
					vo = new SungjukVO();
					vo.setHakbun(rs.getString("hakbun"));
					vo.setName(rs.getString("name"));
					vo.setKor(rs.getInt("kor"));
					vo.setEng(rs.getInt("eng"));
					vo.setMath(rs.getInt("math"));
					vo.setTot(rs.getInt("tot"));
					vo.setAvg(rs.getDouble("avg"));
					vo.setGrade(rs.getString("grade"));
					
					sungjuk_list.add(vo);
				}while(rs.next());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtill.closeResource(rs, pstmt, conn);
		}
		System.out.println("리스트 행수:"+sungjuk_list.size());
		return sungjuk_list;
	}
	
	public SungjukVO selectSungjuk(SungjukVO sungjukVO)
	{ 
		SungjukVO vo = null;

		try
		{
			conn = JDBCUtill.getConnection();

			pstmt = conn.prepareStatement("select * from sungjuk where hakbun = ?");
			pstmt.setString(1, sungjukVO.getHakbun());
			System.out.println("학번:"+sungjukVO.getHakbun());
			rs = pstmt.executeQuery();
			rs.next();
			vo = new SungjukVO();
			vo.setHakbun(rs.getString("hakbun"));
			vo.setName(rs.getString("name"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
			vo.setTot(rs.getInt("tot"));
			vo.setAvg(rs.getDouble("avg"));
			vo.setGrade(rs.getString("grade"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtill.closeResource(rs, pstmt, conn);
		}
		
		return vo;
	}

	public int deleteSungjuk(SungjukVO sungjukVO)
	{ 
		int result = 0;

		try
		{
			conn = JDBCUtill.getConnection();

			pstmt = conn.prepareStatement("delete from sungjuk where hakbun = ?");
			pstmt.setString(1, sungjukVO.getHakbun());
			result = pstmt.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtill.closeResource(pstmt, conn);
		}
		
		return result;
	}
	
	public int updateSungjuk(SungjukVO sungjukVO) {
		
		int result = 0;
		
		try {
			conn = JDBCUtill.getConnection();
			
			pstmt = conn.prepareStatement("update sungjuk set kor=?,eng=?,math=?,"
					+ "tot=?,avg=?,grade=? where hakbun=?");
			System.out.println("학번: "+sungjukVO.getHakbun());
			pstmt.setInt(1, sungjukVO.getKor());
			pstmt.setInt(2, sungjukVO.getEng());
			pstmt.setInt(3, sungjukVO.getMath());
			sungjukVO.process();
			pstmt.setInt(4, sungjukVO.getTot());
			pstmt.setDouble(5, sungjukVO.getAvg());
			pstmt.setString(6, sungjukVO.getGrade());
			pstmt.setString(7,sungjukVO.getHakbun());
			result = pstmt.executeUpdate();
			System.out.println("행:"+result);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtill.closeResource(pstmt, conn);
		}
		
		return result;
	}
	
}
