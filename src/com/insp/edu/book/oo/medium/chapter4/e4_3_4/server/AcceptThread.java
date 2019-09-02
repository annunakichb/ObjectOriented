package com.insp.edu.book.oo.medium.chapter4.e4_3_4.server;

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

public class AcceptThread extends CommonThread{
	private ServerDemo serverUI;
	private ServerSocket serverSocket;
	
	public AcceptThread(ServerDemo serverUI,ServerSocket serverSocket){
		this.serverUI = serverUI;
		this.serverSocket = serverSocket;
	}
	
	
	@Override
	public void execute() throws Exception {
		//接收到客户请求
		Socket clientSocket = serverSocket.accept();

		//准备读写
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
        	reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//通过socket获得BufferedReader类型的对象用于读取来自服务器端发送的数据
			writer = new PrintWriter(clientSocket.getOutputStream(),true); //通过Socket获得用于向服务器发送数据的对象PrintWriter，这块与服务器端不同，两者实现的功能一样
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//向客户端发送欢迎信息,并读取客户端发送的名称
		try {			 
	        writer.println("收到你的连接请求，请输入你的名称:");
	        String name = reader.readLine();
	        ClientInfo client = new ClientInfo(serverUI,name,clientSocket);
	        serverUI.clients.put(name, client);		        
	        serverUI.putClient(client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
