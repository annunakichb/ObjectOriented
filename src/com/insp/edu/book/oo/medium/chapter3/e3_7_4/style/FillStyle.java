package com.insp.edu.book.oo.medium.chapter3.e3_7_4.style;

import java.awt.Color;

import com.sun.prism.BasicStroke;

/**
 * 填充样式
 * @author chb
 *
 */
public class FillStyle extends Style{
	
	/** 填充颜色,缺省黑色 */
	public Color color1 = new Color(0,0,0); 
	/** 填充颜色2，如果和color1不一样，意味着是渐变色 */
	public Color color2 = new Color(0,0,0);

	/**
	 * 构造方法
	 */
	public FillStyle(){}
	/**
	 * 构造方法
	 * @param color1
	 * @param color2
	 */
	public FillStyle(Color color1,Color color2){
		this.color1 = color1;
		this.color2 = color2;

	}
	/**
	 * 克隆
	 */
	@Override
	public Style clone(){
		return new FillStyle(color1,color2);
	}
}
