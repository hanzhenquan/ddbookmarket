package com.ddbookmarket.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ddbookmarket.dao.AdminDao;
import com.ddbookmarket.model.Admin;
import com.ddbookmarket.util.DButil;
import com.ddbookmarket.util.MD5Util;
import com.ddbookmarket.util.Md5Utill;

public class AdminDaoimpl implements AdminDao {

	@Override
	public boolean findAdmin(Admin admin) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
//		try {
//			conn=DButil.getconnection();
//			String sql="select * from t_admin where name=? and pwd=?";
//			stmt=conn.prepareStatement(sql);
//			stmt.setString(1,admin.getName());
//
//			//加密
//			stmt.setString(2, MD5Util.MD5Encode(admin.getPwd(),"utf-8"));
//			rs=stmt.executeQuery();
//		if (rs.next()) {
//			return true;
//		}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DButil.free(rs,stmt,conn);
//		}
		try {
			conn=DButil.getconnection();
			String sql="select pwd from t_admin where name=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,admin.getName());
			rs=stmt.executeQuery();
			if (rs.next()) {
				String dbpwd=rs.getString(1);
				try {
					return Md5Utill.validPasswd(admin.getPwd(),dbpwd);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DButil.free(rs,stmt,conn);
		}
		return false;
	}
}
