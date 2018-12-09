package com.ddbookmarket.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ddbookmarket.dao.BookaddDao;
import com.ddbookmarket.model.Bookaddtype;
import com.ddbookmarket.util.DButil;
import com.ddbookmarket.util.PageZongshu;

public class BookaddDaoimpl implements BookaddDao {

	@Override
	public boolean save(Bookaddtype bookaddtype) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=DButil.getconnection();
			stmt=conn.prepareStatement("insert into t_bookadd values(default,?,?,?,?,?,?,?,?,?)");
		    stmt.setString(1,bookaddtype.getName());
		    stmt.setInt(2,bookaddtype.getZishu());
		    stmt.setDouble(3,bookaddtype.getMoney());
		    stmt.setString(4,bookaddtype.getAuthor());
		    stmt.setString(5,bookaddtype.getAuthorhome());
		    stmt.setDate(6,new Date(bookaddtype.getPublishdate().getTime()));
		    stmt.setString(7,bookaddtype.getJianjie());
		    stmt.setString(8,bookaddtype.getPhoto());
		    stmt.setInt(9,bookaddtype.getSid());
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
	public List<Bookaddtype> findBook(int dangqianpage,String name, int sid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DButil.getconnection();
			stmt=conn.createStatement();
		//String sql="select * from t_bookadd order by id desc limit ";
//		//四种条件
//		//4.1都不限定
//		if((name==null||name.equals(""))&&sid==-1) {
//			
//		}
//		//4.2限定name,不限定sid
//		if((name!=null&&!name.equals(""))&&(sid==-1)){
//			sql+= "where name like '%"+name+"%' ";
//		}
//	     //4.3不限定name，限定sid
//		if((name==null||name.equals(""))&&sid!=-1) {
//             sql+= " where sid="+sid;			
//		}
//		
//		//4.4两个都限定
//		if((name!=null&&!name.equals(""))&&(sid!=-1)) {
//			sql+= "where name like '%"+name+"%' and sid="+sid;
//		}
			String sql="select * from t_bookadd where 1=1 ";
			if(name!=null&&!name.equals("")) {
				sql+= " and name like '%"+name+"%' ";
			}
			if(sid!=-1) {
				sql+=" and sid="+sid;
			}
		
		sql+=" order by id desc limit "+((dangqianpage-1)*PageZongshu.PAGE_SIZE+1-1)+","+PageZongshu.PAGE_SIZE;
		System.out.println(sql+"+++++++++sql");
		rs=stmt.executeQuery(sql);
		List<Bookaddtype> ls=new ArrayList<>();
		while (rs.next()) {
			Bookaddtype bookaddtype=new Bookaddtype();
			bookaddtype.setId(rs.getInt("id"));
			bookaddtype.setSid(rs.getInt("sid"));
			bookaddtype.setName(rs.getString("name"));
			bookaddtype.setAuthor(rs.getString("author"));
			bookaddtype.setAuthorhome(rs.getString("authorhome"));
			bookaddtype.setPublishdate(rs.getDate("publishdate"));
			bookaddtype.setJianjie(rs.getString("jianjie"));
			bookaddtype.setMoney(rs.getDouble("money"));
			bookaddtype.setPhoto(rs.getString("photo"));
			bookaddtype.setZishu(rs.getInt("zishu"));
			
			ls.add(bookaddtype);
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

	@Override
	public int total(String name, int sid) {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	try {
		conn=DButil.getconnection();
		stmt=conn.createStatement();
	String sql="select count(*) from t_bookadd where 1=1 ";
	if(name!=null&&!name.equals("")) {
		sql+= " and name like '%"+name+"%' ";
	}
	if(sid!=-1) {
		sql+=" and sid="+sid;
	}
	
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

	@Override
	public int delid(int id) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DButil.getconnection();
			stmt=conn.prepareStatement("delete from t_bookadd where id="+id);
		
		int rs=stmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DButil.free(stmt,conn);
		}
		return 0;
	}

	@Override
	public Bookaddtype find(int id) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DButil.getconnection();
			stmt=conn.createStatement();
			String sql="select * from t_bookadd where id="+id;
		
		
		System.out.println(sql+"+++++++++sql");
		rs=stmt.executeQuery(sql);
		if(rs.next()) {
			Bookaddtype bookaddtype=new Bookaddtype();
			bookaddtype.setId(rs.getInt("id"));
			bookaddtype.setSid(rs.getInt("sid"));
			bookaddtype.setName(rs.getString("name"));
			bookaddtype.setAuthor(rs.getString("author"));
			bookaddtype.setAuthorhome(rs.getString("authorhome"));
			bookaddtype.setPublishdate(rs.getDate("publishdate"));
			bookaddtype.setJianjie(rs.getString("jianjie"));
			bookaddtype.setMoney(rs.getDouble("money"));
			bookaddtype.setPhoto(rs.getString("photo"));
			bookaddtype.setZishu(rs.getInt("zishu"));
			
			return bookaddtype;
		}
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
	public boolean update(Bookaddtype bookaddtype) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=DButil.getconnection();
			
			
			if(bookaddtype.getPhoto()==null) {
				stmt=conn.prepareStatement("update t_bookadd set name=?,zishu=?,money=?,author=?,authorhome=?,publishdate=?,jianjie=?,photo=?,sid=? where id=?");
			    stmt.setString(1,bookaddtype.getName());
			    stmt.setInt(2,bookaddtype.getZishu());
			    stmt.setDouble(3,bookaddtype.getMoney());
			    stmt.setString(4,bookaddtype.getAuthor());
			    stmt.setString(5,bookaddtype.getAuthorhome());
			    stmt.setDate(6,new Date(bookaddtype.getPublishdate().getTime()));
			    stmt.setString(7,bookaddtype.getJianjie());
			    stmt.setInt(8,bookaddtype.getId());
			    stmt.setInt(9,bookaddtype.getSid());
			    
			}else {
				
				stmt=conn.prepareStatement("update t_bookadd set name=?,zishu=?,money=?,author=?,authorhome=?,publishdate=?,jianjie=?,photo=?,sid=? where id=?");
			    stmt.setString(1,bookaddtype.getName());
			    stmt.setInt(2,bookaddtype.getZishu());
			    stmt.setDouble(3,bookaddtype.getMoney());
			    stmt.setString(4,bookaddtype.getAuthor());
			    stmt.setString(5,bookaddtype.getAuthorhome());
			    stmt.setDate(6,new Date(bookaddtype.getPublishdate().getTime()));
			    stmt.setString(7,bookaddtype.getJianjie());
			    stmt.setString(8,bookaddtype.getPhoto());
			    stmt.setInt(9,bookaddtype.getSid());
			    stmt.setInt(10,bookaddtype.getId());
			}
			
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
	
	

}
