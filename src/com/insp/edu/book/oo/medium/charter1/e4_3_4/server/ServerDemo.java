package com.insp.edu.book.oo.medium.charter1.e4_3_4.server;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServerDemo extends JFrame{	
	private JPanel pnlTop = new JPanel();
	private FlowLayout pnlFlowLayer = new FlowLayout();
	private JLabel lblPort = new JLabel("服务端口:");
	private JTextArea txtPort = new JTextArea("9001");
	private JButton btnStart = new JButton("启动");	
	private JButton btnStop = new JButton("停止");
	
	private JList listClientNames = new JList();
	private JScrollPane westPanel = new JScrollPane(listClientNames);
			
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel pnlSend = new JPanel();
	private JLabel lblcurSender = new JLabel("当前选择的待发送用户:");
	private JTextArea txtSend = new JTextArea();
	private JButton btnSend = new JButton("发送");
	
	private JTable recvTable = new JTable();
	private JScrollPane pnlRecv = new JScrollPane(recvTable);
	
	
	private ServerSocket svrSocket = null;	
	private AcceptThread acceptThread;
	
	public ClientInfo curSelectionClient;
	public Map<String,ClientInfo> clients = new HashMap<String,ClientInfo>();
	
	
	public ServerDemo() {
		setTitle("服务器");		
		this.setSize(600,400);
		
		getContentPane().add(pnlTop, BorderLayout.NORTH);
		pnlFlowLayer.setAlignment(FlowLayout.LEFT);
		pnlTop.setLayout(pnlFlowLayer);
		pnlTop.add(lblPort);
		pnlTop.add(txtPort);	
		pnlTop.add(btnStart);
		
		ServerDemo temp = this;
		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String port = txtPort.getText();
				int nPort = Integer.parseInt(port);
				//先关闭
				try {
					if(svrSocket != null)
						svrSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//再开启	
				try {					
					svrSocket = new ServerSocket(nPort);
					acceptThread = new AcceptThread(temp,svrSocket);
					acceptThread.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		pnlTop.add(btnStop);
		btnStop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(svrSocket == null)
					return;
				try {
					svrSocket.close();					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});				
		
		//初始化JList，用于显示连接好的客户端名称
		listClientNames.setModel(new DefaultListModel());
		listClientNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//将westPanel加入到界面上（listClientNames已经在westPanel里面了）
		getContentPane().add(westPanel, BorderLayout.WEST);
		westPanel.setPreferredSize(new Dimension(200,400));
		//将Tab加入到界面，两个页面一个显示接收到的信息，一个显示发送的信息
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		listClientNames.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				int index = listClientNames.getMinSelectionIndex();
				if(index < 0)return;
				ClientInfo selectionclient = (ClientInfo) ((DefaultListModel)listClientNames.getModel()).elementAt(index);
				if(selectionclient == null)return;
				curSelectionClient = selectionclient;
				lblcurSender.setText("当前选择的客户端名称："+curSelectionClient.getName());
			}
			
		});

		
		tabbedPane.add("接收",pnlRecv);
		tabbedPane.add("发送",pnlSend);
				
		String[] columnNames = {"时间","发送者","接受者","内容"};
		DefaultTableModel tableModel = new DefaultTableModel(null,columnNames);
		recvTable.setModel(tableModel);
		recvTable.validate();
		pnlRecv.validate();

		pnlSend.setLayout(new FlowLayout());
		pnlSend.add(lblcurSender);
		lblcurSender.setPreferredSize(new Dimension(400,50));
		JScrollPane txtSendPanel = new JScrollPane(txtSend,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnlSend.add(txtSendPanel);
		txtSendPanel.setPreferredSize(new Dimension(400,150));
		pnlSend.add(btnSend);
		pnlSend.validate();
		btnSend.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String line = txtSend.getText();
				if(curSelectionClient == null)return;
				curSelectionClient.write(line);
			}
			
		});
		
		this.setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void putClient(ClientInfo client){
		if(client == null)return;		
		DefaultListModel model = (DefaultListModel) listClientNames.getModel();		
		model.addElement(client);		
	}
	public void showClientMessage(ClientInfo src,ClientInfo dest,String msg){
		SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");
		Object[] row = new Object[]{
				fmt.format(new Date()),
				src.getName(),
				dest.getName(),
				msg
		};
		
		DefaultTableModel model = (DefaultTableModel) recvTable.getModel();
		model.addRow(row);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerDemo();
	}

}
