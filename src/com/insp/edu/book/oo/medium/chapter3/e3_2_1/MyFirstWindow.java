/**
 * 
 */
package com.insp.edu.book.oo.medium.chapter3.e3_2_1;

import javax.swing.JFrame;

/**
 * @author chb
 *
 */
public class MyFirstWindow extends JFrame{
	public MyFirstWindow(){super();}
	public MyFirstWindow(String title){super(title);}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFirstWindow("我创建的第一个窗口").setVisible(true);
		//new JFrame("我创建的第一个窗口").setVisible(true);
	}
}
