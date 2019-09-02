package com.insp.edu.book.oo.medium.chapter4.e4_3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

public class AcceptThread extends Thread{
	private ServerSocket serverSocket;
	public Map<String,Socket> acceptedSockets = new HashMap<String,Socket>();

	public AcceptThread(ServerSocket serverSocket){this.serverSocket = serverSocket;}
	
	public void run(){
		while(true){
			try {
				Socket clientSocket = serverSocket.accept();
				BufferedReader reader = null;
				PrintWriter writer = null;
		        try {
		        	reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//通过socket获得BufferedReader类型的对象用于读取来自服务器端发送的数据
					writer = new PrintWriter(clientSocket.getOutputStream(),true); //通过Socket获得用于向服务器发送数据的对象PrintWriter，这块与服务器端不同，两者实现的功能一样
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		        writer.println("收到你的连接请求，请输入你的名称:");
		        String name = reader.readLine();
		        acceptedSockets.put(name, clientSocket);	
		        
		        ReadThread readThread = new ReadThread("服务端收到来自"+name+"的消息：",clientSocket);
				readThread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
