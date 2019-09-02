package com.insp.edu.book.oo.medium.charter1.e4_3_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 9001;
		ServerSocket svrSocket = null;
		try {
			svrSocket = new ServerSocket(port);//创建ServerSocket对象，并指定端口
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AcceptThread acceptThread = new AcceptThread(svrSocket);
		acceptThread.start();

		while(true){			
			System.out.println("你可以随时向客户端发送信息,请输入对方的姓名:");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			
			if(!acceptThread.acceptedSockets.containsKey(name)){
				System.out.println("你输入的姓名不存在，请重新输入");
				continue;
			}
			System.out.println("请输入要发送的内容：");
			String content = scan.nextLine();
			Socket socket = acceptThread.acceptedSockets.get(name);			
			PrintWriter writer = null;
	        try {	        	
				writer = new PrintWriter(socket.getOutputStream(),true); 
				writer.println(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}

}
