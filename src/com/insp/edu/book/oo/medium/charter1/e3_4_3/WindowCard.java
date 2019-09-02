package com.insp.edu.book.oo.medium.charter1.e3_4_3;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class WindowCard extends JFrame{
	private JTabbedPane p;
    public WindowCard(){
    	setBounds(100,100,500,300);
    	setVisible(true);
    	
    	p = new JTabbedPane(JTabbedPane.TOP);    	
    	for(int i=1;i<=5;i++){
    		p.add("第"+ i + "个卡片",new JButton("按钮"+ i));
    	}
    	p.validate();
    	
    	Container con = this.getContentPane();
    	con.add(p,BorderLayout.CENTER);
    	
    	con.validate();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
       new WindowCard();
    }
}
