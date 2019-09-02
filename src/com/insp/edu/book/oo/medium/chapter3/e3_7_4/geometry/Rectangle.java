package com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry;

import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.FillStyle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.LineStyle;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.Style;

public class Rectangle extends Geometry{
	private Point[] pts = new Point[]{new Point(),new Point()};
	
	public Rectangle(){}
	public Rectangle(Point leftTop,Point rightBottom,Style...styles){
		super(styles);
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
	
	public double[] getLengthOfSide(){		
		int d = dimension();
		double[] r = new double[d];
		for(int i=0;i<d;i++){
			r[i] = Math.abs(pts[0].getCoords()[i] - pts[1].getCoords()[i]);
		}
		return r;
	}
	
	
	@Override
	public int dimension() {
		// TODO Auto-generated method stub
		return pts[0].dimension();
	}
	
	

	@Override
	public int cataory() {
		// TODO Auto-generated method stub
		return Geometry.CATAORY_FILL;
	}

	@Override
	public double length() {
		// TODO Auto-generated method stub
		double[] r = getLengthOfSide();
		return (r[0]+r[1])*2;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		double[] r = getLengthOfSide();
		return r[1]*r[2];
	}
	@Override
	public void draw(Object graphics2d) {
		// TODO Auto-generated method stub
		//graphics2d的实际类型为Graphics2D
		Graphics2D g = (Graphics2D) graphics2d;
		//先画边框		
		LineStyle lineStyle = (LineStyle) getStyle("LineStyle");
		if(lineStyle != null){
			////设置画实线还是虚线
			Stroke stroke = null;
			if(lineStyle.style == LineStyle.DASHED)
				stroke = new BasicStroke(lineStyle.width,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[]{15,10},0f);
			else
				stroke = new BasicStroke(lineStyle.width,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[]{15,0},0f);		
			g.setStroke(stroke);
										
			////设置颜色
			if(lineStyle.color1 == lineStyle.color2)
				g.setColor(lineStyle.color1);
			else{//渐变线
				GradientPaint p = new GradientPaint(0, 0, lineStyle.color1, 500, 0, lineStyle.color2);
				g.setPaint(p);
			}
			double[] ss = this.getLengthOfSide();
			g.drawRect((int)this.pts[0].getX(), (int)this.pts[0].getY(), (int)ss[0], (int)ss[1]);
		}
		//画填充区域
		FillStyle fillStyle = (FillStyle) getStyle("FillStyle");
		if(fillStyle != null){
			////设置颜色
			if(fillStyle.color1 == fillStyle.color2)
				g.setColor(fillStyle.color1);
			else{////渐变线
				GradientPaint p = new GradientPaint(0, 0, fillStyle.color1, 500, 0, fillStyle.color2);
				g.setPaint(p);
			}
			double[] ss = this.getLengthOfSide();
			g.fillRect((int)this.pts[0].getX(), (int)this.pts[0].getY(), (int)ss[0], (int)ss[1]);
		}
	}
	
	@Override
	public String toString(){
		return "("+pts[0]+";"+pts[1]+")";
	}
	
}
