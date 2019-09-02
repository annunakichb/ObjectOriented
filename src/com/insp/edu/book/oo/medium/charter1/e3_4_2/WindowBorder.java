package com.insp.edu.book.oo.medium.charter1.e3_4_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WindowBorder  implements ActionListener{
	public static JFrame curWin;

    public static void main(String args[])
    {
       JFrame win=new JFrame("窗体");//没有定义JFrame的子类，直接创建JFrame的对象
       curWin = win; //win是main的局部引用变量，将其记在curWin中，它是全局的
    		   
       win.setBounds(100,100,300,300);
       win.setVisible(true);
       
       JButton bSouth=new JButton("南"); //创建四个按钮，并为它们添加了同一个事件监听器
       JButton bNorth=new JButton("北");
       JButton bEast =new JButton("东");
       JButton bWest =new JButton("西");
       WindowBorder e3 = new WindowBorder(); 
       bSouth.addActionListener(e3);
       bNorth.addActionListener(e3);
       bEast.addActionListener(e3);
       bWest.addActionListener(e3);
       
       JTextArea  bCenter=new JTextArea("中心"); //一个文本框
       
       Container contenetPane=win.getContentPane();//取得JFrame的内容面板
       contenetPane.add(bNorth,BorderLayout.NORTH);//将bNorth按钮加到win布局的北边
       contenetPane.add(bSouth,BorderLayout.SOUTH);
       contenetPane.add(bEast,BorderLayout.EAST);
       contenetPane.add(bWest,BorderLayout.WEST); 
       contenetPane.add(bCenter,BorderLayout.CENTER);
       
       contenetPane.validate();//令布局生效
       win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e){
    	//点击按钮后，创建一个新文本框，将新文本框加入到Boder布局中间位置（中间位置原文本框会被替换）
    	JTextArea  bNewCenter=new JTextArea("新中心");
    	curWin.getContentPane().add(bNewCenter,BorderLayout.CENTER);
    	curWin.getContentPane().validate();
    }
}
