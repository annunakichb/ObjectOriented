package com.insp.edu.book.oo.medium.chapter6.e6_2_2;

@Table(name="ACCOUNT")
public class Account {
	@TableField(name="ACCOUNT_ID")
	public int id;
	@TableField(name="ACCOUNT_NAME")
	public String account;
	@TableField(name="ACCOUNT_PASSWD")
	public String password;
	@TableField(name="USER_NAME")
	public String username;
	@TableField(name="USER_AGE")
	public int age;
	@TableField(name="CREATE_TIME")
	public java.sql.Date createTime;
	@TableField(name="ENABLED")
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
