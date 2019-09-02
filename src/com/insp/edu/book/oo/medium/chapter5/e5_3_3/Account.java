package com.insp.edu.book.oo.medium.chapter5.e5_3_3;

import java.text.SimpleDateFormat;

public class Account {
	public int id;
	public String account;
	public String password;
	public String username;
	public int age;
	public java.sql.Date createTime;
	public String enabled;
	
	public Account(){}
	public Account(int id,String account,String password,String username,int age,java.sql.Date createTime,String enabled){
		this.id = id;
		this.account = account;
		this.password = password;
		this.username = username;
		this.age = age;
		this.createTime = createTime;
		this.enabled = enabled;
		
	}
	public String createInsertSql(){
		String str = id + ",'" + account + "','" + 
		             password + "','" + username+ "'," +
				     age + ",'" + 
				     "DATE(STR_TO_DATE('" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(createTime) + "','%Y-%m-%d %H:%M:%S'))" +
				     "','" + enabled + "'";
		return "insert into ACOCUNT(ACCOUNT_ID,ACCOUNT_NAME,ACCOUNT_PASSWORD,USER_NAME,USER_AGE,CREATE_TIME,IS_ENABLED) values(" + str + ")";
				      
	}
	public String createUpdateSql(){
		String str = "update ACCOUNT set ACCOUNT_NAME='" + account + "'," +
		             "ACCOUNT_PASSWORD='" + password + "'," +
				     "USER_NAME='" + username + "'," +
		             "USER_AGE=" + age + "," +
				     "CREATE_TIME=DATE(STR_TO_DATE('" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(createTime) + "','%Y-%m-%d %H:%M:%S'))," +
		             "IS_ENABLED='" + enabled + "' where " +
		             "ACCOUNT_ID=" + id;
		return str;
	}

}
