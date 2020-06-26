package com.koreait.board3.dao;

import java.sql.*;
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
}
