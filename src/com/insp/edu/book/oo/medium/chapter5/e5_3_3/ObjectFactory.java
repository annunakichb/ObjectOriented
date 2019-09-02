package com.insp.edu.book.oo.medium.chapter5.e5_3_3;

import java.util.Scanner;


public class ObjectFactory {
	public Account createAccount(){
		Scanner scan = new Scanner(System.in);
		Account acc = new Account();
		System.out.println("请输入账号ID：");acc.id = scan.nextInt();
		System.out.println("请输入账号：");acc.account = scan.next();
		System.out.println("请输入密码：");acc.password = scan.next();
		System.out.println("请输入姓名：");acc.username = scan.next();
		System.out.println("请输入年龄：");acc.age = scan.nextInt();
		System.out.println("请输入创建时间：");acc.createTime = new java.sql.Date(new java.util.Date().getTime());
		return acc;
	}
	public AccountRole createRole(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入账号ID：");
		int id = scan.nextInt();
		System.out.println("请输入角色名称：");
		String name = scan.next();
		return new AccountRole(id,name);
	}
}
