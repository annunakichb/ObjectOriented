package com.insp.edu.book.oo.medium.charter1.e4_3_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		
		//本例从网络中读取字节型数组，而不是字符串，读取字节等二进制型数据一般用DataInputStream
		DataInputStream stream = null;
		try {
			stream = new DataInputStream(acceptSocket.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		byte[] datas = null;
		Serialization ser = new Serialization();
		while(true){
			System.out.println("等待接收客户端发来的数据");			
			int len = 0;
			try {//因为客户端发送字节数组之前总是先发送一个整数，所以这里需要先接收这个整数
				len = stream.readInt();
			} catch (IOException e) {e.printStackTrace();}
				
			System.out.println("len="+len);		
			datas = new byte[len];   //根据收到的整数（为发送的字节数组的大小）
			try {//读取数据并放到datas里
				stream.read(datas);
			} catch (IOException e) {e.printStackTrace();}
			//datas字节数组转换为对象
			Object obj = ser.deserialize(datas);	
			//打印对象信息
			System.out.println("数据已收到，长度为"+len+"，数据对象为:");
			System.out.println("对象类型：" + obj.getClass().getSimpleName());
			System.out.println("对象数据："+obj.toString());
			
		}
		
	}

}
