package com.insp.edu.book.oo.medium.chapter4.e4_3_4.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class ClientDemo extends JFrame{
	private JPanel pnlNorth = new JPanel();//放连接信息的面板
	private JLabel lblIp = new JLabel("IP:");
	private JTextArea txtIp = new JTextArea("127.0.0.1");
	private JLabel lblPort = new JLabel("端口:");
	private JTextArea txtPort = new JTextArea("9001");
	private JButton btnConnect = new JButton("连接");
	private JButton btnDisconnect = new JButton("断开");
	
	//放在内容区域的面板
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
	//接收区	
	private JTextArea txtRecv = new JTextArea();
	private JScrollPane txtRecvPanel = new JScrollPane(txtRecv,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	//发送区
	private JTextArea txtSend = new JTextArea();
	private JScrollPane txSendPanel = new JScrollPane(txtSend,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	private Socket socket = null;
	private boolean connected = false;
	
	private void init(){
		setTitle("客户端");		
		this.setSize(600,400);
		
		getContentPane().setLayout(new BorderLayout());
		//面板北部（上部）放置连接面板，里面包含IP信息，端口信息，连接和断开按钮
		getContentPane().add(pnlNorth,BorderLayout.NORTH);
		pnlNorth.setLayout(new FlowLayout());
		pnlNorth.add(lblIp);
		pnlNorth.add(txtIp);
		pnlNorth.add(lblPort);
		pnlNorth.add(txtPort);
		pnlNorth.add(btnConnect);
		pnlNorth.add(btnDisconnect);
		
		//将tab面板加入到中间区，然后将接收和发送面板加入到tab面板
		getContentPane().add(tabbedPane, BorderLayout.CENTER);	
		tabbedPane.add("接收",txtRecvPanel);
		tabbedPane.add("发送",txSendPanel);
		
		//为连接按钮点击添加事件处理
		ClientDemo demo = this;
		btnConnect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					socket = new Socket("127.0.0.1",9001);//定义socket并向服务端发起连接请求，这里的IP地址是服务端的IP地址，端口是服务端的端口，不是自己的
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				
				ClientReadThread readThread = new ClientReadThread("客户端收到:",socket,demo);	
				readThread.start();	
				
				connected = true;
			}
			
			
			
		});
		
		//为断开连接按钮添加事件处理
		btnDisconnect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		//为信息发送文本框加入事件处理：当用户输入完成回车后，将信息发送文本框中内容发送出去
		txtSend.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyChar() != '\n')
					return;
				PrintWriter writer = null;
		        try {        	
					writer = new PrintWriter(socket.getOutputStream(),true); //通过Socket获得用于向服务器发送数据的对象PrintWriter，这块与服务器端不同，两者实现的功能一样
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		        writer.println(txtSend.getText());
		        
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			
		});
		
		//显示
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//当ClientReadThread线程接收到信息的时候，调用该方法显示
	public void showMsg(String msg){
		this.txtRecv.setText(this.txtRecv.getText()+"\r\n"+msg);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientDemo demo = new ClientDemo();
		demo.init();
	}

}
