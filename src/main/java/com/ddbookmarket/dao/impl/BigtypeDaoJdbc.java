package com.ddbookmarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ddbookmarket.dao.BigtypeDao;
import com.ddbookmarket.model.Bigtype;
import com.ddbookmarket.util.DButil;

public class BigtypeDaoJdbc implements BigtypeDao {
	public boolean save(String name) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DButil.getconnection();
			String sql="insert into t_bigtypeadd values(default,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			int ret=ps.executeUpdate();
			if(ret>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.free(ps, conn);
		}
		return false;
	}

	@Override
	public List<Bigtype> fandAll() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DButil.getconnection();
			stmt=conn.createStatement();
		String sql="select * from t_bigtypeadd";
		rs=stmt.executeQuery(sql);
		List<Bigtype> ls=new ArrayList<>();
		while (rs.next()) {
			Bigtype bigtype=new Bigtype();
			bigtype.setId(rs.getInt("id"));
			bigtype.setName(rs.getString("name"));
			ls.add(bigtype);
		}return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DButil.free(rs,stmt,conn);
		}
		return null;
	}

}
