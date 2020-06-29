package com.koreait.board3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board3.vo.UserVO;

public class UserDAO {
	//회원가입 성공 1, 실패 0 
	public static int join(UserVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_user3 "
				+ " (i_user, cid, cpw, nm) "
				+ " VALUES "
				+ " (seq_user.nextval, ?, ?, ?) ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, param.getCid());
			ps.setNString(2, param.getCpw());
			ps.setNString(3, param.getNm());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		
		return result;
	}
	
	//1:로그인성공, 2:아이디없음, 3:비밀번호 틀림, 0:에러발생
	public static int login(UserVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String sql = " SELECT cpw FROM t_user3 WHERE cid = ? ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, param.getCid());
			rs = ps.executeQuery();			
			if(rs.next()) {
				String dbCpw = rs.getNString("cpw");				
				result = dbCpw.equals(param.getCpw()) ? 1 : 3;
			} else {
				result = 2;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}		
		return result;
	}
	
}














