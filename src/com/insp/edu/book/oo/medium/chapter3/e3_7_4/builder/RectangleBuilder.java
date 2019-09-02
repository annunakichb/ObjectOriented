package com.insp.edu.book.oo.medium.chapter3.e3_7_4.builder;

import java.awt.Component;
import java.awt.event.MouseEvent;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.PaintContext;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.Point;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.Rectangle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.FillStyle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.LineStyle;

public class RectangleBuilder extends GeometryBuilder{
	
	private Point first;
	private Point second;
	private boolean mousePressed;
	
	private boolean filled;
	public RectangleBuilder(boolean filled){
		this.filled = filled;
	}
	@Override
	public int doMousePressed(Component canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = true;
		first = new Point(e.getX(),e.getY());
		return GeometryBuilder.BUILDING;
	}

	@Override
	public int doMouseReleased(Component canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = false;
		second = new Point(e.getX(),e.getY());
		LineStyle styleline = PaintContext.mainFrame.getPnlStyle().getStyle(LineStyle.class);
		FillStyle stylefill = PaintContext.mainFrame.getPnlStyle().getStyle(FillStyle.class);
		if(filled)
			geometry = new Rectangle(first,second,styleline,stylefill);
		else
			geometry = new Rectangle(first,second,styleline);
		return GeometryBuilder.DONE;
	}

	@Override
	public int doMouseMoved(Component canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		if(!mousePressed)return GeometryBuilder.BUILDING;
		second = new Point(e.getX(),e.getY());
		LineStyle styleline = PaintContext.mainFrame.getPnlStyle().getStyle(LineStyle.class);
		FillStyle stylefill = PaintContext.mainFrame.getPnlStyle().getStyle(FillStyle.class);
		if(filled)
			geometry = new Rectangle(first,second,styleline,stylefill);
		else
			geometry = new Rectangle(first,second,styleline);
		System.out.println(geometry);
		canvas.repaint();
		return GeometryBuilder.BUILDING;
		
	}
	@Override
	public int doMouseClicked(Component canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
