package com.insp.edu.book.oo.medium.charter1.e3_4_1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


public class WindowFlow extends JFrame{  
    WindowFlow(String s){
      super(s);
      Container  contenetPane=this.getContentPane();
      FlowLayout flow=new FlowLayout();
      flow.setAlignment(FlowLayout.LEFT);
      flow.setHgap(2);
      flow.setVgap(8);
      contenetPane.setLayout(flow);
      
      
      for(int i=1;i<=10;i++) 
        { 
    	   JButton btn = new JButton("i am "+i);
    	   btn.addActionListener(
    			   new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton ele = (JButton) e.getSource();
						JOptionPane.showMessageDialog(null, "你点击了"+ele.getText());
					}
    				   
    			   }
    	   );
           contenetPane.add(btn);
       }

      contenetPane.validate();

      setBounds(100,100,150,120);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){ 
       new WindowFlow("FlowLayout布局窗口");
    }
}
