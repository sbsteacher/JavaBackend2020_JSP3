package com.koreait.board3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
			while(rs.next()) {				
				i_board = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		
		return i_board;
	}
}
