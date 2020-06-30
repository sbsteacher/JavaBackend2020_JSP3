package com.koreait.board3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board3.vo.BoardListModel;
import com.koreait.board3.vo.BoardVO;

public class BoardDAO {
	public static int regBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i_board = 0;
		
		String sql = " INSERT INTO t_board3 "
				+ " (i_board, title, ctnt, i_user) "
				+ " VALUES "
				+ " (seq_board3.nextval, ?, ?, ?) ";
		
		String cols[] = {"i_board"}; 
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql, cols);
			ps.setNString(1, param.getTitle());
			ps.setNString(2, param.getCtnt());
			ps.setInt(3,  param.getI_user());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				i_board = rs.getInt(1);				
				System.out.println("i_board : " + i_board);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		return i_board;
	}
	
	public static List<BoardListModel> selectBoardList() {
		List<BoardListModel> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT " + 
				"    A.i_board, A.title, A.r_dt " + 
				"    , B.i_user, B.nm as userNm " + 
				" FROM t_board3 A " + 
				" INNER JOIN t_user3 B " + 
				" ON A.i_user = B.i_user " + 
				" ORDER BY i_board DESC ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getNString("title");
				String r_dt = rs.getNString("r_dt");
				int i_user = rs.getInt("i_user");
				String userNm = rs.getNString("userNm");
				
				BoardListModel bm = new BoardListModel();
				bm.setI_board(i_board);
				bm.setTitle(title);
				bm.setR_dt(r_dt);
				bm.setI_user(i_user);
				bm.setUserNm(userNm);
				
				list.add(bm);
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}
		
		return list;
	}
}















