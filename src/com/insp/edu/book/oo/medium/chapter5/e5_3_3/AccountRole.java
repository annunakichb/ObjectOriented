package com.insp.edu.book.oo.medium.chapter5.e5_3_3;

import java.text.SimpleDateFormat;

public class AccountRole {
	public int accountId;
	public String roleName;
	public AccountRole(){}
	public AccountRole(int accountId,String roleName){
		this.accountId = accountId;
		this.roleName = roleName;
	}
	public String createInsertSql(){
		String str = accountId + ",'" + roleName + "'";
		return "insert into ACOCUNT_ROLE(ACCOUNT_ID,ROLE_NAME) values(" + str + ")";
				      
	}
	public String createUpdateSql(){
		String str = "update ACOCUNT_ROLE set " +
		             "ROLE_NAME='" + roleName + "' where " +
				     "ACCOUNT_ID=" + accountId;
		return str;
	}
	
	
}
