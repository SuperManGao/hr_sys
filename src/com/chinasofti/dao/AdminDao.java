package com.chinasofti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.entity.Admin;

public class AdminDao extends BaseDao{
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean login(Admin admin){
		String sql="select * from hr_admin where username=? and password=?";
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setString(1, admin.getUserName());
			pstmt.setString(2, admin.getPassword());
			pstmt.setString(3, admin.getAdminLevel());
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
