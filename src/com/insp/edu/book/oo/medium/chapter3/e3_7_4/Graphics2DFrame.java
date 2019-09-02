package com.insp.edu.book.oo.medium.chapter3.e3_7_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.canvas.CanvasPanel;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.command.CommandPanel;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.Geometry;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.ui.StylePanel;

/**
 * 本例子实现了：
 * 1.用鼠标画图形
 * 2.可以在画图形前设定图形的颜色等风格信息
 * @author chb
 */
public class Graphics2DFrame extends JFrame{
	/** 命令Panel，显示画哪种几何图形的按钮 */
	private CommandPanel pnlBtns = new CommandPanel();
	/** 画布Panel，用于显示几何图形 */
	private CanvasPanel pnlCanvas = new CanvasPanel();
	/** 样式Panel，用于设定几何图形的颜色、字体等风格 */
	private StylePanel pnlStyle = new StylePanel();
	/** 窗口底部状态栏 */
	private JToolBar statusBar = new JToolBar(); 
	/** 用于在底部状态栏显示当前正在画的几何图形类型*/
	private JLabel lblCommand = new JLabel("图形类型：无");
	/** 用于在底部状态栏显示当前鼠标位置坐标 */
	private JLabel lblCoords = new JLabel("X=,Y=");

	/**
	 * 构造方法
	 */
	public Graphics2DFrame(){
		//设定窗口大小
		this.setSize(1024,600);
		//让窗口显示在屏幕中央
		setLocationRelativeTo(null);

		//取得内容面板，并设置为Boder布局
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());	
		
		//上部显示命令按钮，左边显示图形样式，中间为空白几何画图区
		contentPane.add(pnlBtns,BorderLayout.NORTH);
		contentPane.add(pnlCanvas,BorderLayout.CENTER);
		contentPane.add(pnlStyle,BorderLayout.WEST);
		contentPane.add(statusBar,BorderLayout.SOUTH);
				
		statusBar.add(lblCommand);//把标签加到工具栏上
		statusBar.add(lblCoords);//把标签加到工具栏上
		
		//显示并设置关闭方式
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * 主函数
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintContext.mainFrame = new Graphics2DFrame();
	}

	/**
	 * 取得命令Panel对象
	 * @return
	 */
	public CommandPanel getPnlBtns() {
		return pnlBtns;
	}

	/**
	 * 取得画布Panel对象
	 * @return
	 */
	public CanvasPanel getPnlCanvas() {
		return pnlCanvas;
	}

	/**
	 * 取得样式Panel对象
	 * @return
	 */
	public StylePanel getPnlStyle() {
		return pnlStyle;
	}
	
	public void showCommandInfo(String cmdText){
		lblCommand.setText("图形类型："+cmdText);
	}
	public void showCoordInfo(int x,int y){
		lblCoords.setText(" ; X="+x+",Y="+y);
	}
	
}
