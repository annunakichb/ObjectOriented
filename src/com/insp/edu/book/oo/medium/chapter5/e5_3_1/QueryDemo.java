package com.insp.edu.book.oo.medium.chapter5.e5_3_1;

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
		
		//对ResultSet进行遍历，取出所有的记录；对每一个记录，创建Account对象记录每个字段的值
		//假如执行SQL取得了3条记录，逻辑上我们认为有5条，在实际的三个立即前有一条“虚拟记录”，记为BOF，三个记录之后也认为有一个记录，记为EOF
		//在尚未对ResultSet进行遍历时，总是假设有个游标指向BOF记录，调用next方法将使得游标指向实际的第一条记录，以后调用getXXX方法总是对游标指向的记录操作的
		//当执行next方法时，游标指向EOF的时候，方法返回false，遍历结束
		List<Account> accounts = new ArrayList<Account>();
		while(true){			
			try {				
				if(!rs.next())break; //滚动游标直到EOF
				int id  = rs.getInt("ACCOUNT_ID"); //字段名为ACCOUNT_ID的字段值，写这段程序你必须直到每个字段的字段名和类型
				String account = rs.getString("ACCOUNT_NAME");
				String password = rs.getString("ACCOUNT_PASSWD");
				String username = rs.getString("USER_NAME");
				int age = rs.getInt("USER_AGE");
				java.sql.Date createTime = rs.getDate("CREATE_TIME");
		        String enabled = rs.getString(6);//取得第7个字段，类型是整数
		        
		        Account acc = new Account(id,account,password,username,age,createTime,enabled);
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
