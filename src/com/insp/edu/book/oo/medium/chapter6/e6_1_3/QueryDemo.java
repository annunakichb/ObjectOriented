package com.insp.edu.book.oo.medium.chapter6.e6_1_3;

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
	public static void main(String[] args) {
		//定义连接信息		
		String dbUserName = "study";
		String dbUserPassword = "study";
		String url = "jdbc:mysql://127.0.0.1/DB";
		//连接数据库
		QueryDemo demo = new QueryDemo();
		Connection conn = demo.getConnection(url, dbUserName, dbUserPassword);
		if(conn == null)return;
		//执行SQL
		String sql = "select * from ACCOUNT";
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();//需要创建一个事务对象
			rs = stmt.executeQuery(sql);  //使用事务对象执行查询，它返回一个ResultSet，查询总是有可能返回多条数据库记录
		}catch(Exception e){
			System.out.println("查询表失败，error="+e.getMessage()+",sql="+sql);
			e.printStackTrace();
		}
				
		List<Account> accounts = new ArrayList<Account>();
		
		Field[] fs = Account.class.getDeclaredFields();
		while(true){			
			try {				
				if(!rs.next())break; //滚动游标直到EOF
				Account acc = new Account();
				for(int i=0;i<fs.length;i++){
					String fieldName = fs[i].getName().toUpperCase();
					Object value = rs.getObject(fieldName);
					try{
						fs[i].set(acc, value);
					}catch(Exception e){
						System.out.println("解析字段出错:"+fieldName+":"+e.getMessage());
						continue;
					}
				}
						        
		        accounts.add(acc);
			} catch (SQLException e) {
				System.out.println("获取记录失败:"+e.getMessage());
				e.printStackTrace();
				continue;
			}
	        	        	       
		}
		//打印
		System.out.println("共读取"+accounts.size()+"个有效记录");
		for(Account account : accounts){
			System.out.println(account);
		}
		//最后千万不要忘记按照顺序依次关闭rs,stmt,conn。如果忘记关闭，会导致连接和事务超过数据库所能承载的上限
		try{if(rs != null)rs.close();}catch(Exception e){}
		try{if(stmt != null)stmt.close();}catch(Exception e){}
		try{if(conn != null)conn.close();}catch(Exception e){}
	}

}
