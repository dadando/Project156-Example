package com.spring.memberboard.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.memberboard.JDBCUtil;

@Repository
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//글의 갯수 구하기
	public int getListCount() {
		int x = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from smemberboard");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x=rs.getInt(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.closeResource(pstmt, conn);
		}
		return x;
	}
	
	//글 리스트 보기
	public ArrayList<BoardVO> getBoardList(int page,int limit) {
		String board_list_sql = "select * from (select rownum rnum,"
				+ "num,id,subject,content,re_ref,re_lev,re_seq,readcount,boarddate from"
				+ "(select * from smemberboard order by re_ref desc,re_seq asc)) where "
				+ "rnum>=? and rnum<=?";
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		int startrow = (page-1)*10+1; //읽기 시작할 row 번호
		int endrow = startrow+limit-1; //읽을 마지막 row 번호
		try {
			conn=JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			BoardVO bvo;
			while(rs.next()) {
				bvo = new BoardVO();
				bvo.setNum(rs.getInt("num"));
				bvo.setId(rs.getString("id"));
				bvo.setSubject(rs.getString("subject"));
				bvo.setContent(rs.getString("content"));
				bvo.setRe_ref(rs.getInt("re_ref"));
				bvo.setRe_lev(rs.getInt("re_lev"));
				bvo.setRe_seq(rs.getInt("re_seq"));
				bvo.setReadcount(rs.getInt("readcount"));
				bvo.setBoarddate(rs.getDate("boarddate"));
				list.add(bvo);
				
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return null;
	}
	
	//글 내용 보기
	public BoardVO getDetail(BoardVO bvo) throws Exception{
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select * from smemberboard where num=?");
			pstmt.setInt(1, bvo.getNum());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bvo = new BoardVO();
				bvo.setNum(rs.getInt("num"));
				bvo.setId(rs.getString("id"));
				bvo.setSubject(rs.getString("subject"));
				bvo.setContent(rs.getString("content"));
				bvo.setRe_ref(rs.getInt("re_ref"));
				bvo.setRe_lev(rs.getInt("re_lev"));
				bvo.setRe_seq(rs.getInt("re_seq"));
				bvo.setReadcount(rs.getInt("readcount"));
				bvo.setBoarddate(rs.getDate("boarddate"));
				
			}
			return bvo;
		}catch(Exception ex) {
			System.out.println("DAO getDetail오류: "+ex.getMessage());
			ex.printStackTrace();
		}finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return null;
	}
	
	//글 등록(글쓰기)
	public int boardInsert(BoardVO bvo) {
		int num=0;
		String sql="";
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select max(num) from smemberboard");
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //등록된 글이 있을때 그다음 숫자를 부여하기 위해
				num = rs.getInt(1)+1;
			}else { //등록된 글이 없을 때 최초 글의 번호는 1.
				num = 1;
			}
			sql = "insert into smemberboard(num,id,subject,content,re_ref,"
					+ "re_lev,re_seq,readcount,boarddate) values(?,?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.setString(2, bvo.getId());
			pstmt.setString(3, bvo.getSubject());
			pstmt.setString(4, bvo.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			result = pstmt.executeUpdate();
			return result;
		}catch(Exception ex) {
			System.out.println("DAO Insert오류: "+ex.getMessage());
			ex.printStackTrace();
		}finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return 0;
	}
	
	//글 답변
	public int boardReply(BoardVO bvo) {
		String board_max_sql = "select max(num) from smemberboard";
		String sql = "";
		int num = 0;
		int result = 0;
		
		int re_ref = bvo.getRe_ref();
		System.out.println("re_ref= "+re_ref);
		int re_lev = bvo.getRe_lev();
		int re_seq = bvo.getRe_seq();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1;
			}else {
				num = 1;
			}
			
			sql = "update smemberboard set re_seq = re_seq+1 where re_ref=? and re_seq>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.executeUpdate();
			
			re_seq = re_seq+1;
			re_lev = re_lev+1;
			
			sql = "insert into smemberboard(num,id,subject,content,re_ref,"
					+"re_lev,re_seq,readcount,boarddate) values(?,?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, bvo.getId());
			pstmt.setString(3, bvo.getSubject());
			pstmt.setString(4, bvo.getContent());
			pstmt.setInt(5, re_ref);
			pstmt.setInt(6, re_lev);
			pstmt.setInt(7, re_seq);
			pstmt.setInt(8, 0);
			result = pstmt.executeUpdate();
			
			return result;
		}catch(Exception ex) {
			System.out.println("DAO 답변 오류: "+ex.getMessage());
			ex.printStackTrace();
		}finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return 0;
	}
	
	//글 수정.
	public int boardModify(BoardVO bvo) throws Exception{ 
		String sql="update smemberboard set subject=?, content=? where num=?";
		int result = 0;
		
		try{ 
			System.out.println("제목: "+bvo.getSubject());
			conn = JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getSubject()); 
			pstmt.setString(2, bvo.getContent());
			pstmt.setInt(3, bvo.getNum()); 
			result = pstmt.executeUpdate(); 
			
			return result; 
		}catch(Exception ex){ 
			System.out.println( "boardModify 에러  : " + ex); 
		}finally{ 
			JDBCUtil.closeResource(pstmt, conn);
		} 
		return 0;
	}
	
	//글 삭제.
	public int boardDelete(BoardVO bvo){ 
		String board_delete_sql= "delete from smemberboard where num=?";
		int result=0;
		
		try{ 
			conn = JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(board_delete_sql); 
			pstmt.setInt(1, bvo.getNum()); 
			result=pstmt.executeUpdate(); 

			return result;
		}catch(Exception ex){ 
			System.out.println("boardDelete  에러  : "+ex.getMessage());
			ex.printStackTrace();
		}finally{ 
			try{ 
				JDBCUtil.closeResource(pstmt, conn);
			}catch(Exception ex) {}
		}
		return 0;
	}
		
	//조회수 없데이트 . 
	public void setReadCountUpdate(BoardVO bvo) throws Exception{ 
		String sql="update smemberboard set readcount = "
				+ "readcount+1 where num =? ";
		
		try{ 
			conn=JDBCUtil.getConnection(); 
			pstmt=conn.prepareStatement(sql); 
			pstmt.setInt(1, bvo.getNum());
			pstmt.executeUpdate(); 
		}catch(Exception ex){ 
			System.out.println( "setReadCountUpdate 에러 : "+ex); 
			ex.printStackTrace();
		}finally{ 
			try{
				JDBCUtil.closeResource(pstmt, conn);
			}catch(Exception ex) {} 
		}
	}
		
	//글쓴이본인인지 확인
	public boolean isBoardWriter(BoardVO bvo){ 
		String board_sql= "select * from smemberboard where num=?";
		
		try{ 
			conn=JDBCUtil.getConnection(); 
			pstmt=conn.prepareStatement(board_sql); 
			pstmt.setInt(1, bvo.getNum()); 
			rs=pstmt.executeQuery(); 
			rs.next();
			
			if(bvo.getId().equals(rs.getString("id"))){ 
				return true;
			} 
		}catch(Exception ex){ 
			System.out.println( "isBoardWriter 에러 : "+ex); 
			ex.printStackTrace();
		}finally{ 
			try{ 
				JDBCUtil.closeResource(pstmt, conn);
			}catch(Exception ex){
			} 
		} 
		return false;
	}
}
