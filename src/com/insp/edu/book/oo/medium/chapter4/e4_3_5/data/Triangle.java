package com.insp.edu.book.oo.medium.chapter4.e4_3_5.data;



public class Triangle extends Geometry{
	private Point[] pts = new Point[]{new Point(),new Point(),new Point()};
	public Triangle(){}
	public Triangle(Point... ps){
		if(ps == null || ps.length<=0)return;
		if(ps.length>=1 && ps[0] != null)pts[0] = ps[0].clone();
		if(ps.length>=2 && ps[1] != null)pts[1] = ps[1].clone();
		if(ps.length>=3 && ps[2] != null)pts[2] = ps[2].clone();
	}
	@Override
	public String toString(){
		return "("+ pts[0] + "),(" + pts[1] + "),(" + pts[2] + ")";
	}
	public static Triangle parse(String s){
		if(s == null || s.equals(""))return null;
		try{
			String[] ss = s.split(";");
			Point a = Point.parse(ss[0]);
			Point b = Point.parse(ss[1]);
			Point c = Point.parse(ss[2]);
			return new Triangle(a,b,c);
		}catch(Exception e){
			System.out.println("解析三角形对象失败:"+e.getMessage()+",str="+s);
			e.printStackTrace();
			return null;
		}
				
	}
}
