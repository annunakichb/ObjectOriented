package com.insp.edu.book.oo.medium.chapter5.e5_3_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class TransactionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义连接信息		
		String dbUserName = "study";
		String dbUserPassword = "study";
		String url = "jdbc:mysql://127.0.0.1/DB";
		//连接
		ConnectManager connManger = new ConnectManager();
		Connection conn = connManger.getConnection(dbUserName,dbUserPassword,url);
		//输入账号和角色
		ObjectFactory factory = new ObjectFactory();
		Account acc = factory.createAccount();
		AccountRole role = factory.createRole();
		//数据库操作不自动commit，这样做的目的是事务过程中出现错误的时候，手工回滚事务
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stmt = connManger.createStatement(conn);
		try {
			stmt.addBatch(acc.createInsertSql());
			stmt.addBatch(role.createInsertSql());
			stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			connManger.recycle(conn, stmt, null);
		}
		
	}
	

}
