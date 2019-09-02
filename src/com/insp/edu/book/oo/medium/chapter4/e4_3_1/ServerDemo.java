package com.insp.edu.book.oo.medium.chapter4.e4_3_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
		
		//从acceptSocket中构造出一个reader对象，用于接收客户端发来的数据
		InputStream stream = null;
		try {
			stream = acceptSocket.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		InputStreamReader sr = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(sr);	//这个才是真正用来接收对方数据的对象，这个对象有readLine方法，可以一次从网络中读取一整行，InputStream和InputStreamReader则没有这个功能
		//从acceptSocket中构造出一个write对象，用于向客户端发送数据
        BufferedWriter writer = null;
		try {
			OutputStream s = acceptSocket.getOutputStream();
			OutputStreamWriter w = new OutputStreamWriter(s);
			writer = new BufferedWriter(w);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
			String s = "";
			try {
				s = reader.readLine();//接收客户端发送来的字符串,如果执行该方法的时候客户端并没有发送任何数据，该方法同accept方法一样会使得当前线程中断，直到收到客户端的有效数据
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println("接收到客户端发来的信息:"+s);
			System.out.println("请对客户端做出答复：");
			Scanner scan = new Scanner(System.in);
			String resp = scan.nextLine();
			try {
				writer.write(resp); //向客户端发送数据
				writer.newLine();   //由于客户端也是调用reader.readLine()来读取数据的，因此这里发送的时候必须发送换行信息
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
