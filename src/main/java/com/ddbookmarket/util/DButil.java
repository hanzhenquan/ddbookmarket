package com.ddbookmarket.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DButil {
	static Properties properties;
	//只加载一次，所以写在静态代码块中
	static {
		properties=new Properties();
		try {
			//获得属性文件中的值
			properties.load(DButil.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//只加载一次，所以写在静态代码块中
	static {
		try {
			Class.forName(properties.getProperty("driverClass"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public static  Connection getconnection(){
		try {
			return DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("pwd"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static  void free(Statement stmt, Connection conn) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static  void free(ResultSet rs, Statement stmt, Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	}

