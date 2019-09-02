package com.insp.edu.book.oo.medium.chapter5.e5_3_2;

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
	
}
