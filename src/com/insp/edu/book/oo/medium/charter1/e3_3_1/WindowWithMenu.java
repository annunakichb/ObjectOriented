package com.insp.edu.book.oo.medium.charter1.e3_3_1;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.MenuElement;

class MenuActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JMenuItem ele = (JMenuItem) arg0.getSource();
		JOptionPane.showMessageDialog(null, "你点击了"+ele.getText());
	}
	
}
public class WindowWithMenu extends JFrame{

	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem  item1,item2,item3,item31,item32; 
	public WindowWithMenu(String s) 
    {
		super(s);        
		setSize(500,500);
		setLocation(120,120);
		
		
		MenuActionListener menuListener = new MenuActionListener();
                
		menubar=new JMenuBar(); 
		menu=new JMenu("文件"); 
		String pngPath = this.getClass().getResource("/com/insp/edu/book/oo/medium/charter1/e3_3_1").getPath();
		item1=new JMenuItem("打开",new ImageIcon(pngPath+"/open.png"));
		item1.setAccelerator(KeyStroke.getKeyStroke('O')); 
		item1.addActionListener(menuListener);
		item2=new JMenuItem("保存",new ImageIcon(pngPath+"/save.png"));		
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));         
		item2.addActionListener(menuListener);
		
		item3=new JMenu("另存...");
		item31=new JMenuItem("图像",new ImageIcon(pngPath+"/image.png"));
		item31.addActionListener(menuListener);
		item32=new JMenuItem("几何",new ImageIcon(pngPath+"/geometry.png"));
		item32.addActionListener(menuListener);
		item3.add(item31);
		item3.add(item32);
		
		menu.add(item1); //必须将菜单项加入到菜单里，否则不会显示出来
		menu.addSeparator();//会显示一条横线
		menu.add(item2);
		menu.add(item3);
		menubar.add(menu);
		
		setJMenuBar(menubar);//必须设置菜单条对象
      
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

		setVisible(true);     
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowWithMenu("菜单演示");
	}

}
