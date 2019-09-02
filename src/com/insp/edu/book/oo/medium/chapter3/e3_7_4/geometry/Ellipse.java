package com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry;

import java.awt.Graphics;

public class Ellipse extends Geometry{

private Point[] pts = new Point[]{new Point(),new Point()};
	
	public Ellipse(){}
	public Ellipse(Point leftTop,Point rightBottom){
		this.pts[0] = leftTop;
		this.pts[1] = rightBottom;
	}
	
	public Point[] getPoints(){return pts;}
	public void setPoints(Point leftTop,Point rightBottom){
		this.pts[0] = leftTop;
		this.pts[1] = rightBottom;
	}
	
	public Point getLeftTop(){return this.pts[0];}
	public Point getRightBottom(){return this.pts[1];}
	
	public void setLeftTop(Point p){this.pts[0] = p;}
	public void setRightBottom(Point p){this.pts[1] = p;}
	
	
	
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
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void draw(Object graphics) {
		// TODO Auto-generated method stub
		Graphics g = (Graphics) graphics;
		//未实现
	}

}
