package com.insp.edu.book.oo.medium.chapter3.e3_7_4.style;

import java.awt.Color;
import java.awt.Font;


/**
 * 字体样式
 * @author chb
 *
 */
public class FontStyle extends Style{
	/** 字体，缺省为宋体 */
	public Font font = new Font("宋体",0,12);
	/** 颜色，缺省为黑色 */
	public Color color = Color.BLACK;
	/**
	 * 构造方法
	 */
	public FontStyle(){}
	/**
	 * 构造方法
	 * @param font
	 * @param color
	 */
	public FontStyle(Font font,Color color){
		this.font = font;
		this.color = color;
	}
	/**
	 * 克隆
	 */
	@Override
	public Style clone(){
		return new FontStyle(font,color);
	}
	
}
