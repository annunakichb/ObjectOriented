package com.insp.edu.book.oo.medium.chapter5.e5_3_1;

public class Account {
	public int id;
	public String account;
	public String password;
	public String username;
	public int age;
	public java.sql.Date createTime;
	public String enabled;
	
	public Account(int id,String account,String password,String username,int age,java.sql.Date createTime,String enabled){
		this.id = id;
		this.account = account;
		this.password = password;
		this.username = username;
		this.age = age;
		this.createTime = createTime;
		this.enabled = enabled;
		
	}
}
