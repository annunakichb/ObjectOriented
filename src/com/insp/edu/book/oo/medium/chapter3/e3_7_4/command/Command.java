package com.insp.edu.book.oo.medium.chapter3.e3_7_4.command;

/**
 * 用于表示CommandPanel中所有按钮代表的意义
 * 每个按钮被按下代表向CanvasPanel发起一个画某种图形的命令
 * @author chb
 *
 */
public interface Command {
	/** 空 */
	public final static int NOTHING = 0;
	/** 线段 */
	public final static int LineSegment = 1;
	/** 空心矩形 */
	public final static int Rectangle = 2;
	/** 填充矩形 */
	public final static int Fill_Rectangle = 3;
	/** 空心椭圆 */
	public final static int Ellipse = 4;
	/** 填充椭圆 */
	public final static int Fill_Ellipse = 5;
	/** 折线 */
	public final static int Polyline = 6;
	/** 填充多边形 */
	public final static int Polygon = 7;
	/** 文字 */
	public final static int Text = 8;
	
}
