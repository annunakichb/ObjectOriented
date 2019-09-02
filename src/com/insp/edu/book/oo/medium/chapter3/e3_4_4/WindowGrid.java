package com.insp.edu.book.oo.medium.chapter3.e3_4_4;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowGrid extends JFrame{
	public WindowGrid(){
    	GridLayout grid=new GridLayout(3,4);
    	
    	this.setLayout(grid);
    	setBounds(100,100,500,300);
    	setVisible(true);
    	
    	Container con = this.getContentPane();
    	for(int i=1;i<=10;i++){
    		con.add("第"+ i + "个按钮",new JButton("按钮"+ i));
    	}
    	
    	JPanel pen = new JPanel();
    	GridLayout grid2=new GridLayout(2,2);
    	pen.setLayout(grid2);
    	
    	for(int i=11;i<=14;i++){
    		pen.add("第"+ i + "个按钮",new JButton("按钮"+ i));
    	}    	
    	con.add(pen);

    	con.validate();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowGrid();
	}

}
