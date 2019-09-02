package com.insp.edu.book.oo.medium.charter1.e4_2_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class URLDemo implements Runnable{
	private URL url = null;
	
	public static void main(String args[]) {
		URLDemo urlDemo = new URLDemo();
	    Scanner scanner = new Scanner(System.in);;
	    Thread thread = new Thread(urlDemo);
	    System.out.println("请输入URL,例如:http://www.sohu.com");
	    try {  
	    	urlDemo.url = new URL(scanner.nextLine());
	        thread.start();
	       }
	       catch(Exception exp){
	          System.out.println(exp);
	       } 	      
	   }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try { 
	        InputStream in = url.openStream();
	        byte [] b = new byte[1024];
	        int n=-1;
	        while((n=in.read(b))!=-1) {
	           System.out.print(new String(b,0,n));
	        }
	      }
	      catch(IOException exp){}
	}
}
