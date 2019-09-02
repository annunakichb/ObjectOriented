package com.insp.edu.book.oo.medium.chapter4.e4_3_4.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * 客户信息是对一个客户连接的相关全部信息和行为的封装。
 * 客户连接相关的信息对象包括：客户姓名、socket对象、读线程（每个客户连接都会有一个独立的读线程对象）、写流对象（基于socket对象构造，用于向客户端写）
 * 客户连接相关的行为包括：写方法（传入一个字符串，方法将字符串发送到客户端）；关闭方法（端口与该客户端的连接）
 * @author chb
 *
 */
public class ClientInfo {
	private String name;
	private Socket socket;
	private ServerReadThread readThread;
	private PrintWriter writer;
	
	public ClientInfo(ServerDemo serverUI,String name,Socket socket){
		this.name = name;
		this.socket = socket;
		System.out.println("接收到客户连接："+name);
		
        try {        	
			writer = new PrintWriter(socket.getOutputStream(),true); //通过Socket获得用于向服务器发送数据的对象PrintWriter，这块与服务器端不同，两者实现的功能一样
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
        readThread = new ServerReadThread(serverUI,name,socket);
        readThread.start();
	}
	public void write(String s){
		writer.println(s);
	}
	public void close(){
		readThread.end();
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("用户"+name+"连接被关闭");
		}
	}
	public String getName() {
		return name;
	}
	public Socket getSocket() {
		return socket;
	}
	public ServerReadThread getReadThread() {
		return readThread;
	}
	public PrintWriter getWriter() {
		return writer;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
