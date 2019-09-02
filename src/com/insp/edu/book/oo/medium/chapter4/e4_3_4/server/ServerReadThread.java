package com.insp.edu.book.oo.medium.chapter4.e4_3_4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReadThread extends CommonThread{
	private String name;
	private Socket socket;
	private ServerDemo serverUI;
	public ServerReadThread(ServerDemo serverUI,String name,Socket socket){
		this.serverUI = serverUI;
		this.name = name;
		this.socket = socket;
	}
	public void execute(){
		//准备读
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//读取到s中
		String s = "";
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("接收到来自"+name+"的消息:"+s);
		//分析
		if(s == null || s.equals(""))return;			
		String[] items = s.split(","); //收到的信息应该被逗号分隔成两部分，前半部分是要转发过去的客户姓名，后半部分是转发内容
		if(items == null || items.length<2)return;		
		ClientInfo sendClient =  serverUI.clients.get(name); //找到发送客户
		if(sendClient == null)return;
		String recvClientName = items[0];
		ClientInfo recvClient = serverUI.clients.get(recvClientName);//找到接收客户
		if(recvClient == null)return;
		//显示
		serverUI.showClientMessage(sendClient, recvClient, items[1]);//界面上显示转发信息
		//转发
		String msg = sendClient.getName() + "," + items[1];
		recvClient.write(msg);//完成转发
	}
}
