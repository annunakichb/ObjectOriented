package com.insp.edu.book.oo.medium.chapter3.e3_4_5;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowBox extends JFrame{

	private Box baseBox,boxV1,boxV2; 
    public WindowBox()
    { 
	      Box boxV1= Box.createVerticalBox();
	      boxV1.add(new JLabel("输入您的姓名"));
	      
	      Component t = Box.createVerticalStrut(8);
	      boxV1.add(t);
	      boxV1.add(new JLabel("输入email"));
	      boxV1.add(Box.createVerticalStrut(8));
	      boxV1.add(new JLabel("输入您的职业"));
	      
	      boxV2=Box.createVerticalBox();
	      boxV2.add(new JTextField(16));
	      boxV2.add(Box.createVerticalStrut(8));
	      boxV2.add(new JTextField(16));
	      boxV2.add(Box.createVerticalStrut(8));
	      boxV2.add(new JTextField(16));
	      
	      baseBox=Box.createHorizontalBox();
	      baseBox.add(boxV1);
	      baseBox.add(Box.createHorizontalStrut(10));
	      baseBox.add(boxV2);
	      
	      Container con = getContentPane();
	      con.setLayout(new FlowLayout());
	      con.add(baseBox); 
	      con.validate();
	      setBounds(120,125,200,200);
	      setVisible(true);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowBox();
	}

}
