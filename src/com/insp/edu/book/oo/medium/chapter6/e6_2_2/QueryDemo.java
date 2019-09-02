package com.insp.edu.book.oo.medium.chapter6.e6_2_2;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class QueryDemo {

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
	
	public static <T> List<T> readTable(Class<T> clazz,Connection conn) throws Exception{
		Table tableAnnoation = clazz.getAnnotation(Table.class);
		if(tableAnnoation == null)
			throw new Exception("必须在类上加Table注解");
		String tableName = tableAnnoation.name();
		String sql = "select * from " + tableName;
		
		Statement stmt = conn.createStatement();//需要创建一个事务对象
		ResultSet rs = stmt.executeQuery(sql);
		
		List<T> results = new ArrayList<T>();
		while(rs.next()){
			T element = clazz.newInstance();
			Field[] fs = clazz.getDeclaredFields();
			for(int i=0;i<fs.length;i++){
				TableField fieldAnnotation = fs[i].getAnnotation(TableField.class);
				if(fieldAnnotation == null)continue;
				String fieldName = fieldAnnotation.name();
				
				Object value = rs.getObject(fieldName);
				fs[i].set(element, value);
			}
			
			results.add(element);
		}
		rs.close();
		stmt.close();
		return results;
	}
	public static void main(String[] args) {
		//定义连接信息		
		String dbUserName = "study";
		String dbUserPassword = "study";
		String url = "jdbc:mysql://127.0.0.1/DB";
		//连接数据库
		QueryDemo demo = new QueryDemo();
		Connection conn = demo.getConnection(url, dbUserName, dbUserPassword);
		if(conn == null)return;
		
				
		List<Account> accounts = null;
		try {
			accounts = readTable(Account.class,conn);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//打印
		System.out.println("共读取"+accounts.size()+"个有效记录");
		for(Account account : accounts){
			System.out.println(account);
		}		
		try{if(conn != null)conn.close();}catch(Exception e){}
	}

}
