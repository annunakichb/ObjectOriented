package com.insp.edu.book.oo.medium.chapter3.e3_7_1;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class GraphicsDemo extends JFrame implements MouseListener{
	private Panel pnl;
	
	public GraphicsDemo(){
		this.setSize(800,600);
		pnl = new Panel();
		this.getContentPane().add(pnl);
		pnl.setSize(800,600);
		pnl.addMouseListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDemo();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Graphics g = pnl.getGraphics();
		g.drawLine(100, 100, 500, 500);	
		
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	

}
