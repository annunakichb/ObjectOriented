package com.insp.edu.book.oo.medium.chapter3.e3_2_3;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class WindowWithEvent extends JFrame implements WindowListener{
	public WindowWithEvent(){super();}
	public WindowWithEvent(String title){super(title);}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowWithEvent win = new WindowWithEvent("演示窗口");
		win.setSize(300, 300);//设置窗口宽高
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);//窗口关闭后程序退出
		win.addWindowListener(win);//为win设置窗口事件监听器
		win.setVisible(true);//显示窗口
	}
	
	
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}


	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		int option = JOptionPane.showConfirmDialog(null, "关闭窗口将使得程序退出，确定关闭吗？","重要提醒",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(option == JOptionPane.YES_OPTION)this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		else this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}

}
