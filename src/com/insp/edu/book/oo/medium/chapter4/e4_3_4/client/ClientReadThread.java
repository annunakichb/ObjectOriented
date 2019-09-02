package com.insp.edu.book.oo.medium.chapter4.e4_3_4.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * 客户端数据读取线程
 * @author chb
 *
 */
public class ClientReadThread extends Thread{
	/** 保留 */
	private String title; 
	/** 连接用的socket对象 */
	private Socket socket;
	/** 界面对象，收到信息后调用它的方法显示 */
	private ClientDemo clientUI;
	/**
	 * 构造方法
	 * @param title
	 * @param socket
	 * @param clientUI
	 */
	public ClientReadThread(String title,Socket socket,ClientDemo clientUI){this.title = title;this.socket = socket;this.clientUI = clientUI;}
	/**
	 * 线程函数
	 */
	public void run(){
		//从socket创建读对象
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		while(true){
			//读
			String s = "";
			try {
				s = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//保留
			System.out.println(title+":"+s);
			//显示到界面上
			clientUI.showMsg(s);
		}
	}
}
