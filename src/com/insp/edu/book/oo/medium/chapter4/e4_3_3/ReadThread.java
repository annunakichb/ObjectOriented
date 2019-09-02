package com.insp.edu.book.oo.medium.chapter4.e4_3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread{
	private String title;
	private Socket socket;
	public ReadThread(String title,Socket socket){this.title = title;this.socket = socket;}
	public void run(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		while(true){
			String s = "";
			try {
				s = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(title+":"+s);
		}
	}
}
