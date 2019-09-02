package com.insp.edu.book.oo.medium.chapter4.e4_3_5.data;



public class Point extends Geometry implements Cloneable{
	private double x;
	private double y;
	public Point(){}
	public Point(double x,double y){this.x = x;this.y = y;}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public Point clone(){
		return new Point(this.x,this.y);
	}
	
	@Override
	public String toString(){
		return "x="+x+",y="+y;
	}
	
	public static Point parse(String s){
		if(s == null || s.equals(""))return null;
		try{
			String[] ss = s.split(",");
			double x = Double.parseDouble(ss[0]);
			double y = Double.parseDouble(ss[1]);
			return new Point(x,y);
		}catch(Exception e){
			System.out.println("解析点对象失败:"+e.getMessage()+",str="+s);
			e.printStackTrace();
			return null;
		}
				
	}
}
