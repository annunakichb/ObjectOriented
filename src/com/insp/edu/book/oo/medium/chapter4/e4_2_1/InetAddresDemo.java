package com.insp.edu.book.oo.medium.chapter4.e4_2_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddresDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			InetAddress address1 =InetAddress.getByName("www.sohu.com");
			InetAddress address2=InetAddress.getByName("192.168.31.135");
			System.out.println(address1.toString());         
			System.out.println(address2.toString());
		}catch(UnknownHostException e) {
			System.out.println(e.getMessage());
		} 
	}

}
