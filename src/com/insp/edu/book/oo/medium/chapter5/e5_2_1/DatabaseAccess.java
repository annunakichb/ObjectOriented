package com.insp.edu.book.oo.medium.chapter5.e5_2_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess {

	public static void main(String[] args) {
		
		//连接数据库需要的基本信息
		String driverName = "com.mysql.jdbc.Driver";//驱动名，相应的jar包应该已经加到了build path中
		String dbUserName = "study";
		String dbUserPassword = "study";
		String url = "jdbc:mysql://127.0.0.1/DB";
		
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
			conn = DriverManager.getConnection(url,dbUserName,dbUserPassword);
		} catch (SQLException e) {
			System.out.println("连接数据库失败："+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("连接数据库成功:");
		
		try {
			System.out.println("product="+conn.getMetaData().getDatabaseProductName());
			System.out.println("version="+conn.getMetaData().getDatabaseProductVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
