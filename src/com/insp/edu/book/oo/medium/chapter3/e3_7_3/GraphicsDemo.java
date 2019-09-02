package com.insp.edu.book.oo.medium.chapter3.e3_7_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicsDemo extends JFrame implements ActionListener{
	private Panel pnlCanvas = new Panel();
	private Panel pnlBtns = new Panel();
	
	private boolean[] clicked = new boolean[8];//该变量用于记录哪个按钮点击过
	public GraphicsDemo(){
		this.setSize(800,600);
		this.getContentPane().setLayout(new BorderLayout());		
		this.getContentPane().add(pnlBtns,BorderLayout.NORTH);
		//this.getContentPane().add(pnlCanvas,BorderLayout.CENTER);
		
		pnlBtns.setLayout(new GridLayout(1,8));
		JButton btn = new JButton("线段");
		btn.addActionListener(this);pnlBtns.add(btn);
		btn = new JButton("矩形1");
		btn.addActionListener(this);pnlBtns.add(btn);
		btn = new JButton("矩形2");
		btn.addActionListener(this);pnlBtns.add(btn);
		btn = new JButton("椭圆1");
		btn.addActionListener(this);pnlBtns.add(btn);
		btn = new JButton("椭圆2");
		btn.addActionListener(this);pnlBtns.add(btn);
		btn = new JButton("多边形1");
		btn.addActionListener(this);pnlBtns.add(btn);
		btn = new JButton("多边形2");
		btn.addActionListener(this);pnlBtns.add(btn);
		btn = new JButton("文字");
		btn.addActionListener(this);pnlBtns.add(btn);		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDemo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		Graphics g = pnlCanvas.getGraphics();
		if(btn.getText().equals("线段")){
			clicked[0] = true;
		}else if(btn.getText().equals("矩形1")){
			clicked[1] = true;
		}else if(btn.getText().equals("矩形2")){
			clicked[2] = true;
		}else if(btn.getText().equals("椭圆1")){
			clicked[3] = true;
		}else if(btn.getText().equals("椭圆2")){
			clicked[4] = true;
		}else if(btn.getText().equals("多边形1")){
			clicked[5] = true;
		}else if(btn.getText().equals("多边形2")){
			clicked[6] = true;
		}else if(btn.getText().equals("文字")){
			clicked[7] = true;
		}
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		//g = pnlCanvas.getGraphics();
		if(clicked[0]){
			g.setColor(Color.RED);
			g.drawLine(10, 10, 100, 100);
		}
		if(clicked[1]){
			Color color = new Color(125,125,125);
			g.setColor(color);
			g.drawRect(100, 100, 80, 80);
		}
		if(clicked[2]){
			g.setColor(new Color(255,125,125));
			g.fillRect(100, 100, 80, 80);
		}
		if(clicked[3]){
			g.setColor(Color.BLUE);
			g.drawOval(200,200,150,150);
		}
		if(clicked[4]){
			g.setColor(Color.CYAN);
			g.fillOval(200,200,150,150);
		}
		if(clicked[5]){
			g.setColor(Color.RED);
			int[] x = {300,310,400,420,250,200,300};//第一个点和最后一个点必须重合
			int[] y = {400,410,420,430,250,200,400};//Y坐标的个数必须与X坐标一致
			g.drawPolygon(x, y, x.length);
		}
		if(clicked[6]){
			g.setColor(Color.GREEN);
			int[] x = {300,310,400,420,250,200,300};//第一个点和最后一个点必须重合
			int[] y = {400,410,420,430,250,200,400};//Y坐标的个数必须与X坐标一致
			g.fillPolygon(x, y, x.length);
		}
		if(clicked[7]){
			g.setColor(new Color(0,125,125));
			g.setFont(new Font("宋体",Font.BOLD | Font.ITALIC,12));
			g.drawString("你好，Graphics!", 500, 500);
		}
	}

}
