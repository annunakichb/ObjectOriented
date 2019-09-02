package com.insp.edu.book.oo.medium.chapter3.e3_7_4.style;

import java.awt.Color;

import com.sun.prism.BasicStroke;

/**
 * 线条样式
 * @author chb
 *
 */
public class LineStyle extends Style{
	/** 线类型：实线 */
	public final static int SOLID = 1;
	/** 线类型：虚线 */
	public final static int DASHED = 2;
	
	/** 线颜色，缺省黑色 */
	public Color color1 = new Color(0,0,0); 
	/** 线颜色2，如果和color1不一样，意味着是渐变色 */
	public Color color2 = new Color(0,0,0); 
	/** 线跨度，缺省1个像素 */
	public int width = 1; 
	/** 线型，缺省为实心线 */
	public int style = SOLID;
	
	/**
	 * 构造方法
	 */
	public LineStyle(){}
	/**
	 * 构造方法
	 * @param color1
	 * @param color2
	 * @param width
	 * @param style
	 */
	public LineStyle(Color color1,Color color2,int width,int style){
		this.color1 = color1;
		this.color2 = color2;
		this.width = width;
		this.style = style;
	}
	/**
	 * 克隆方法
	 */
	@Override
	public Style clone(){
		return new LineStyle(color1,color2,width,style);
	}
}
