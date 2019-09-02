package com.insp.edu.book.oo.medium.chapter3.e3_7_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 画几何图形的Stream API版本
 * 
 * @author chb
 *
 */
/**
 * 控件组件
 * 记录每个按钮对象，按钮是否点击过，以及按钮点击后的画几何图形方法Lamda表达式
 * @author chb
 *
 */
class ControlComponent{
	/** 按钮 */
	public JButton btn;
	public boolean showed;
	public Consumer<Graphics> consume;//Consumer<Graphics>是函数型变量，即变量的值是函数，且函数的形参类型为Graphics，返回类型为void
	public ControlComponent(JButton btn,Consumer<Graphics> consume){
		this.btn = btn;
		this.consume = consume;
	}
	
}
public class GraphicsDemo2 extends JFrame implements ActionListener{
	private Panel pnlCanvas = new Panel();
	private Panel pnlBtns = new Panel();

	Consumer<Graphics> drawLine = g->{g.setColor(Color.RED);g.drawLine(10, 10, 100, 100);};
	Consumer<Graphics> drawRect1 = g->{Color color = new Color(125,125,125);g.setColor(color);g.drawRect(100, 100, 80, 80);};
	Consumer<Graphics> drawRect2 = g->{g.setColor(new Color(255,125,125));g.fillRect(100, 100, 80, 80);};
	Consumer<Graphics> drawEllipse1 = g->{g.setColor(Color.BLUE);g.drawOval(200,200,150,150);};
	Consumer<Graphics> drawEllipse2 = g->{g.setColor(Color.CYAN);g.fillOval(200,200,150,150);};
	Consumer<Graphics> drawPolygon1 = g->{	g.setColor(Color.RED);
											int[] x = {300,310,400,420,250,200,300};//第一个点和最后一个点必须重合
											int[] y = {400,410,420,430,250,200,400};//Y坐标的个数必须与X坐标一致
											g.drawPolygon(x, y, x.length);};
	Consumer<Graphics> drawPolygon2 = g->{	g.setColor(Color.GREEN);
											int[] x = {300,310,400,420,250,200,300};//第一个点和最后一个点必须重合
											int[] y = {400,410,420,430,250,200,400};//Y坐标的个数必须与X坐标一致
											g.fillPolygon(x, y, x.length);};
	Consumer<Graphics> drawText = g->{	g.setColor(new Color(0,125,125));
										g.setFont(new Font("宋体",Font.BOLD | Font.ITALIC,12));
										g.drawString("你好，Graphics!", 500, 500);};
	
	
	
	private List<ControlComponent> components = Arrays.asList(
			new ControlComponent(new JButton("线段"),drawLine),
			new ControlComponent(new JButton("矩形1"),drawRect1),
			new ControlComponent(new JButton("矩形2"),drawRect2),
			new ControlComponent(new JButton("椭圆1"),drawEllipse1),
			new ControlComponent(new JButton("椭圆2"),drawEllipse2),
			new ControlComponent(new JButton("多边形1"),drawPolygon1),
			new ControlComponent(new JButton("多边形2"),drawPolygon2),			
			new ControlComponent(new JButton("文字"),drawText)
			);
	
	
	public GraphicsDemo2(){
		this.setSize(800,600);
		this.getContentPane().setLayout(new BorderLayout());		
		this.getContentPane().add(pnlBtns,BorderLayout.NORTH);
		this.getContentPane().add(pnlCanvas,BorderLayout.CENTER);
		
		pnlBtns.setLayout(new GridLayout(1,8));
		//对每一个按钮组合对象，将其中的按钮加入界面，并加入监听器
		components.forEach(comp -> {pnlBtns.add(comp.btn);comp.btn.addActionListener(this);});
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDemo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		//对所有按钮组合对象，找到刚点击的按钮
		ControlComponent comp = components.stream().filter(c -> c.btn == btn).findAny().get();
		comp.showed = !comp.showed;
		pnlCanvas.repaint();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		final Graphics g1 = pnlCanvas.getGraphics();
		//对所有按钮组合对象，过滤掉没有点击过的，剩下的每个分别调用其几何图形显示方法
		components.stream().filter(comp->comp.showed).forEach(c->c.consume.accept(g1));
	}
}
