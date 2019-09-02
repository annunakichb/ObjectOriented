package com.insp.edu.book.oo.medium.chapter3.e3_7_4.command;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.PaintContext;

/**
 * 用于显示命令按钮的Panel
 * CommandPanel类提供构造方法和getCommand方法给其它类调用
 * @author chb
 *
 */
public class CommandPanel extends JPanel implements ActionListener{
	/**
	 * 用于记录用户最后点击的按钮
	 */
	private int command = Command.NOTHING;
	/**
	 * 构造方法
	 */
	public CommandPanel(){
		init1(); 
		//init2();
	}
	/**
	 * 取得用户最后点击的按钮类型
	 * @return
	 */
	public int getCommand() {		
		return this.command;
	}
	
	/**
	 * 初始化：在Panel中加入按钮。
	 * 与init2方法不同，这里每个按钮分别处理
	 */
	private void init1(){
		setLayout(new GridLayout(1,8));
		
		JButton btn = new JButton("线段");
		btn.addActionListener(this);
		add(btn);
		btn = new JButton("矩形1");
		btn.addActionListener(this);
		add(btn);
		btn = new JButton("矩形2");
		btn.addActionListener(this);
		add(btn);
		btn = new JButton("椭圆1");
		btn.addActionListener(this);
		add(btn);
		btn = new JButton("椭圆2");
		btn.addActionListener(this);
		add(btn);
		btn = new JButton("多边形1");
		btn.addActionListener(this);
		add(btn);
		btn = new JButton("多边形2");
		btn.addActionListener(this);
		add(btn);
		btn = new JButton("文字");
		btn.addActionListener(this);
		add(btn);
	}
	/**
	 * 该数组用于表示有多少个按钮，每个按钮上显示什么文字
	 */
	private String[] btnTexts = {"线段","矩形1","矩形2","椭圆1","椭圆2","多边形1","多边形2"};
	
	/**
	 * 初始化：在Panel中加入按钮。
	 * 该方法使用一个循环实现初始化功能，比init1方法代码更简洁，扩展性也更强（只要修改btnTexts就行）
	 */
	private void init2(){
		setLayout(new GridLayout(1,btnTexts.length));
		for(int i=0;i<btnTexts.length;i++){
			JButton btn = new JButton(btnTexts[i]);
			btn.addActionListener(this);
			add(btn);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//取得点击的按钮，以及按钮上的文字
		JButton btn = (JButton) e.getSource();
		String btnText = btn.getText();
		
		//判断按钮上的文字是btnTexts数组里面的第几个
		int index = -1;
		for(int i=0;i<btnTexts.length;i++){
			if(btnText.equals(btnTexts[i])){
				index = i;
				break;
			}
		}
		//先判断错误的情况（尽管它不大可能发生）
		if(index == -1)return;
		
		//index是按钮文本在btnTexts数组中的位置，index+1是Command类中对应整数值		
		command = index+1;
		
		//在主窗口下部状态栏上显示当前几何图形类型
		PaintContext.mainFrame.showCommandInfo(btnTexts[index]);		
	}
	
}
