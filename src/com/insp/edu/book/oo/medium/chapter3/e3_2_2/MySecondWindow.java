package com.insp.edu.book.oo.medium.chapter3.e3_2_2;

import javax.swing.JFrame;

public class MySecondWindow extends JFrame{
	public MySecondWindow(){super();}
	public MySecondWindow(String title){super(title);}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySecondWindow win = new MySecondWindow("第二个窗口");
		win.setSize(300, 300);//设置窗口宽高
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);//窗口关闭后程序退出
		win.setVisible(true);//显示窗口
	}
}
