package com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.FillStyle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.FontStyle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.LineStyle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.Style;

/**
 * 线条样式、填充样式、字体样式三个设置界面的组合界面
 * @author chb
 *
 */
public class StylePanel extends JPanel{
	private LineStylePanel lineStylePanel = new LineStylePanel();
	private FillStylePanel fillStylePanel = new FillStylePanel();
	private FontStylePanel fontStylePanel = new FontStylePanel();
	
	public StylePanel(){
		this.setPreferredSize(new Dimension(300, 600));
		this.setBorder(BorderFactory.createTitledBorder("样式"));
		
		
		this.setLayout(new FlowLayout());
		this.add(lineStylePanel);
		this.add(new FillStylePanel());
		this.add(new FontStylePanel());
	}
	
	public LineStyle getLineStyle(){
		return lineStylePanel.getLineStyle();
	}
	public FillStyle getFillStyle(){
		return fillStylePanel.getFillStyle();
	}
	public FontStyle getFontStyle(){
		return fontStylePanel.getFontStyle();
	}
	
	public <T extends Style> T getStyle(Class<? extends Style> clazz){
		if(LineStyle.class.isAssignableFrom(clazz))
			return (T) lineStylePanel.getLineStyle();
		else if(FillStyle.class.isAssignableFrom(clazz))
			return (T) fillStylePanel.getFillStyle();
		else if(FontStyle.class.isAssignableFrom(clazz))
			return (T) fontStylePanel.getFontStyle();
		else
			return null;
	}
}
