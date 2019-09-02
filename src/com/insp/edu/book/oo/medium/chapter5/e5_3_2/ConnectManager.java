package com.insp.edu.book.oo.medium.chapter5.e5_3_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectManager {
	public Connection getConnection(String url,String dbUserName,String dbuserPassword){		
		//注册JDBC驱动程序，这样才可以打开与数据库的通信信道
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动失败："+e.getMessage());
			e.printStackTrace();
		}
				
		//打开一个连接：
		System.out.println("连接数据库...");
		Connection conn  = null;
		try {
			conn = DriverManager.getConnection(url,dbUserName,dbuserPassword);
		} catch (SQLException e) {
			System.out.println("连接数据库失败："+e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}
	
	public void recycle(Connection conn,Statement stmt,ResultSet rs){		
		try{if(rs != null)rs.close();}catch(Exception e){}
		try{if(stmt != null)stmt.close();}catch(Exception e){}
		try{if(conn != null)conn.close();}catch(Exception e){}
		
	}
}
