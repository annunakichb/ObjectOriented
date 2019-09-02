package com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry;

import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.LineStyle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.Style;

public class LineSegment extends Geometry{
	private Point[] pts = new Point[]{new Point(),new Point()};
	
	public LineSegment(){}
	public LineSegment(Point p1,Point p2){
		this.pts[0] = p1;
		this.pts[1] = p2;
	}
	public LineSegment(Point p1,Point p2,Style...styles){
		super(styles);
		this.pts[0] = p1;
		this.pts[1] = p2;
	}
	
	public Point[] getPoints(){return pts;}
	public void setPoints(Point p1,Point p2){
		this.pts[0] = p1;
		this.pts[1] = p2;
	}
	
	public Point getBeginPoint(){return this.pts[0];}
	public Point getEndPoint(){return this.pts[1];}
	
	public void setBeginPoint(Point p1){this.pts[0] = p1;}
	public void setEndPoint(Point p2){this.pts[1] = p2;}
	
	public void swap(){
		Point pt = this.pts[0];
		this.pts[0] = this.pts[1];
		this.pts[1] = pt;
	}
	
	
	
	
	@Override
	public int dimension() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cataory() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double length() {
		// TODO Auto-generated method stub
		double sum = 0;
		for(int i=0;i<dimension();i++){
			double diff = Math.abs(pts[1].getCoords()[i]-pts[0].getCoords()[i]);
			double pow = Math.pow(diff,2);
			sum += pow;
		}
		return Math.sqrt(sum);										
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void draw(Object graphics2d) {
		// TODO Auto-generated method stub
		//graphics2d的实际类型为Graphics2D
		Graphics2D g = (Graphics2D) graphics2d;
		//style的实际类型是LineStyle
		LineStyle lineStyle = (LineStyle) getStyle("LineStyle");
		//设置画实线还是虚线
		Stroke stroke = null;
		if(lineStyle.style == LineStyle.DASHED)
			stroke = new BasicStroke(lineStyle.width,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[]{15,10},0f);
		else
			stroke = new BasicStroke(lineStyle.width,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[]{15,0},0f);		
		g.setStroke(stroke);
		
		//设置颜色
		if(lineStyle.color1 == lineStyle.color2)
			g.setColor(lineStyle.color1);
		else{//渐变线
			GradientPaint p = new GradientPaint(0, 0, lineStyle.color1, 500, 0, lineStyle.color2);
			g.setPaint(p);
		}
		
		g.drawLine((int)pts[0].getX(), (int)pts[0].getY(), (int)pts[1].getX(), (int)pts[1].getY());
	}
	
	@Override
	public String toString(){
		return "("+pts[0]+";"+pts[1]+")";
	}
}
