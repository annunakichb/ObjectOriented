package com.insp.edu.book.oo.medium.charter1.e4_3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",9001);//定义socket并向服务端发起连接请求，这里的IP地址是服务端的IP地址，端口是服务端的端口，不是自己的
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReadThread readThread = new ReadThread("客户端收到:",socket);	
		readThread.start();
		PrintWriter writer = null;
        try {        	
			writer = new PrintWriter(socket.getOutputStream(),true); //通过Socket获得用于向服务器发送数据的对象PrintWriter，这块与服务器端不同，两者实现的功能一样
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
		while(true){
			System.out.println("连接成功，随时可以向服务器发送信息，请输入：");
			Scanner scan = new Scanner(System.in);
			String info = scan.nextLine();
			writer.println(info);

		}
	}

}
