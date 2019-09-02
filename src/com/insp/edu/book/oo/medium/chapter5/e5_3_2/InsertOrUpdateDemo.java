/**
 * 
 */
package com.insp.edu.book.oo.medium.chapter5.e5_3_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;


/**
 * @author chb
 *
 */
public class InsertOrUpdateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertOrUpdateDemo demo = new InsertOrUpdateDemo();
		//定义连接信息		
		String dbUserName = "study";
		String dbUserPassword = "study";
		String url = "jdbc:mysql://127.0.0.1/DB";
		//连接
		ConnectManager connManger = new ConnectManager();
		Connection conn = connManger.getConnection(dbUserName,dbUserPassword,url);
		//创建事务对象
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner scan = new Scanner(System.in);
		while(true){
			//输入账号信息
			Account acc = new Account();
			System.out.println("请输入账号ID：");acc.id = scan.nextInt();
			if(acc.id <= 0)break;
			System.out.println("请输入账号：");acc.account = scan.next();
			System.out.println("请输入密码：");acc.password = scan.next();
			System.out.println("请输入姓名：");acc.username = scan.next();
			System.out.println("请输入年龄：");acc.age = scan.nextInt();
			System.out.println("请输入创建时间：");acc.createTime = new java.sql.Date(new java.util.Date().getTime());
			//查询输入的账户id是否已经在数据库中存在
			Account oldAccount = demo.queryById(stmt,acc.id);
			//创建用于插入或者用于修改的sql语句
			String sql = "";
			if(oldAccount == null){
				System.out.println("执行插入操作：");
				sql = demo.createInsertSql(acc);
			}else{
				System.out.println("执行修改操作：");
				sql = demo.createInsertSql(acc);
			}
			
			//创建PerparedStatement
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				if(oldAccount == null){
					pstmt.setInt(0, acc.id);
					pstmt.setString(1, acc.account);
					pstmt.setString(2, acc.password);
					pstmt.setString(3, acc.username);
					pstmt.setInt(4, acc.age);
					pstmt.setDate(5, acc.createTime);
					pstmt.setString(6, acc.enabled);
				}else{					
					pstmt.setString(0, acc.account);
					pstmt.setString(1, acc.password);
					pstmt.setString(2, acc.username);
					pstmt.setInt(3, acc.age);
					pstmt.setDate(4, acc.createTime);
					pstmt.setString(5, acc.enabled);
					pstmt.setInt(6, acc.id);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//执行插入或者修改
			try {
				
				pstmt.execute();
				System.out.println("执行操作完成，请输入下一个记录");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("执行操作失败："+e.getMessage()+",sql="+sql);
				e.printStackTrace();
			}			
			//回收数据库连接
			connManger.recycle(null, pstmt, null);			
		}
		//回收数据库连接
		connManger.recycle(null, stmt, null);
	}
		
	private Account queryById(Statement stmt,int id){
		String sql = "select * from ACCOUNT where ACCOUNT_ID = " + id;
			
		ResultSet rs = null;
		try{				
			rs = stmt.executeQuery(sql);  //使用事务对象执行查询，它返回一个ResultSet，查询总是有可能返回多条数据库记录
			if(rs.next()){//这里用if，而不是where，是因为根据id查询，应该顶多查询出一条记录				
				String account = rs.getString("ACCOUNT_NAME");
				String password = rs.getString("ACCOUNT_PASSWD");
				String username = rs.getString("USER_NAME");
				int age = rs.getInt("USER_AGE");
				java.sql.Date createTime = rs.getDate("CREATE_TIME");
				String enabled = rs.getString(6);//取得第7个字段，类型是整数
			        
				Account acc = new Account(id,account,password,username,age,createTime,enabled);
				return acc;
			}
		}catch(Exception e){
			System.out.println("查询表失败，error="+e.getMessage()+",sql="+sql);
			e.printStackTrace();
		}finally{
			try{if(rs != null)rs.close();}catch(Exception e){}
		}
			
		return null;
	}
	
	private String createInsertSql(Account account){
		if(account == null)return "";

		String str = account.id + ",'" + account.account + "','" + 
		             account.password + "','" + account.username+ "'," +
				     account.age + ",'" + 
				     "DATE(STR_TO_DATE('" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(account.createTime) + "','%Y-%m-%d %H:%M:%S'))" +
				     "','" + account.enabled + "'";
		return "insert into ACOCUNT(ACCOUNT_ID,ACCOUNT_NAME,ACCOUNT_PASSWORD,USER_NAME,USER_AGE,CREATE_TIME,IS_ENABLED) values(?,?,?,?,?,?,?)";
				      
	}
	private String createUpdateSql(){
		String str = "update ACCOUNT set ACCOUNT_NAME=?," +
		             "ACCOUNT_PASSWORD=?," +
				     "USER_NAME=?," +
		             "USER_AGE=?," +
				     "CREATE_TIME=?," +
		             "IS_ENABLED=?" + 
				     " where ACCOUNT_ID=?";
		return str;
	}

}
