package com.insp.edu.book.oo.medium.chapter4.e4_3_2;

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
		
		Socket acceptSocket = null;
		try {
			acceptSocket = svrSocket.accept(); //等待接收客户端的连接请求，如果客户端没有发出客户端请求，当前运行线程会处于中断wait状态
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReadThread readThread = new ReadThread("服务端收到",acceptSocket);
		readThread.start();//这里不再直接读，而是创建线程,在线程里读
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(acceptSocket.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){			
			System.out.println("你可以随时向客户端发送信息,请输入:");
			Scanner scan = new Scanner(System.in);
			String resp = scan.nextLine();
			writer.println(resp);			
		}
	}

}
