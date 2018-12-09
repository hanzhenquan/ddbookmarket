package com.ddbookmarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ddbookmarket.dao.SmalltypeDao;
import com.ddbookmarket.model.Smalltype;
import com.ddbookmarket.util.DButil;

public class SmalltypeDaojdbcImpl implements SmalltypeDao {

	@Override
	public boolean save(Smalltype smalltype) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=DButil.getconnection();
			stmt=conn.prepareStatement("insert into t_smalltypeadd values(default,?,?)");
		    stmt.setString(1, smalltype.getName());
		    stmt.setInt(2, smalltype.getBid());
		    int ret=stmt.executeUpdate();
		    if(ret>0) {
		    return true;	
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.free(stmt, conn);
		}
		return false;
	}

	
	@Override
	public List<Smalltype> findAllbid(int bid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DButil.getconnection();
			stmt=conn.createStatement();
		String sql="select * from t_smalltypeadd where bid="+bid;
		rs=stmt.executeQuery(sql);
		List<Smalltype> ls=new ArrayList<>();
		while (rs.next()) {
			Smalltype smalltype=new Smalltype();
			smalltype.setId(rs.getInt("id"));
			smalltype.setName(rs.getString("name"));
			smalltype.setBid(rs.getInt("bid"));
			ls.add(smalltype);
		}
		return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DButil.free(rs,stmt,conn);
		}
		return null;
	}


	@Override
	public int finAllByBid(int sid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DButil.getconnection();
			stmt=conn.createStatement();
		String sql="select bid from t_smalltypeadd where id="+sid;
		rs=stmt.executeQuery(sql);
		if (rs.next()) {
			return rs.getInt(1);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DButil.free(rs,stmt,conn);
		}
		return 0;
	}

}


