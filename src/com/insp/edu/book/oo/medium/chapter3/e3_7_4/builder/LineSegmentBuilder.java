package com.insp.edu.book.oo.medium.chapter3.e3_7_4.builder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.PaintContext;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.LineSegment;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.Point;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.LineStyle;

/**
 * 线段构建类
 * @author chb
 *
 */
public class LineSegmentBuilder extends GeometryBuilder{
	
	
	
	/** 记录鼠标是否按下的状态 */
	private boolean mousePressed;
	/** 记录线段的第一个点 */
	private Point beginPoint;
	/** 记录线段的第二个点 */
	private Point endPoint;
	
	@Override
	public int doMousePressed(Component canvas,MouseEvent e){
		mousePressed = true;
		beginPoint = new Point(e.getX(),e.getY());		
		
		geometry = null;
		endPoint =  null;
		return BUILDING;
	}
	@Override
	public int doMouseReleased(Component canvas,MouseEvent e){
		mousePressed = false;
		Point p = new Point(e.getX(),e.getY());
		if(p.equals(beginPoint))return CANCEL;
		endPoint = p;
		
		LineStyle style = PaintContext.mainFrame.getPnlStyle().getStyle(LineStyle.class);
		geometry = new LineSegment(beginPoint,endPoint,style);
		return DONE;
	}
	@Override
	public int doMouseMoved(Component canvas,MouseEvent e){
		if(!mousePressed)return BUILDING;
		
		Graphics g = canvas.getGraphics();
		Point p = new Point(e.getX(),e.getY());
		
		
		endPoint = p;
		LineStyle style = PaintContext.mainFrame.getPnlStyle().getStyle(LineStyle.class);
		geometry = new LineSegment(beginPoint,endPoint,style);
		
		canvas.repaint();
		return BUILDING;
	}
	@Override
	public int doMouseClicked(Component canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		return 0;
	}
}
