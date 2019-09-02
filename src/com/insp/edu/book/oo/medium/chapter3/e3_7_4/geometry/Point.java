package com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry;

/**
 * 点对象
 * @author chb
 *
 */
public class Point extends Geometry{
	/**
	 * 如果规定只是二维点，则应改为 double x,y;
	 * 但是如果是高维点，则应为double数组，数组的长度就是维度
	 */
	private double[] coords = new double[2];
	
	public Point(){}
	public Point(double...coords){
		this.coords = coords; 
	}
	public void setCoords(double...coords){
		for(int i=0;i<coords.length;i++)
			this.coords[i] = coords[i];
	}
	public double[] getCoords(){
		return this.coords;
	}
	public double getX(){return coords[0];}
	public double getY(){return coords[1];}
	public double getZ(){return (dimension()>=3?coords[2]:0);}
	public void setX(double x){coords[0]=x;}
	public void setY(double y){coords[1]=y;}
	public void setZ(double z){if(dimension()>=3)coords[2]=z;}
	
	@Override
	public boolean equals(Object pt){
		if(pt == null)return false;
		Point p = (Point) pt;
		for(int i=0;i<this.coords.length;i++){
			if(this.coords[i] != p.coords[i])
				return false;
		}
		return true;
	}
	
	@Override
	public Point clone(){
		Point pt = new Point();
		pt.coords = new double[this.coords.length];
		for(int i=0;i<this.coords.length;i++)
			pt.coords[i] = this.coords[i];
		return pt;
	}
	@Override
	public int dimension() {
		// TODO Auto-generated method stub
		return coords.length;
	}

	@Override
	public int cataory() {
		// TODO Auto-generated method stub
		return Geometry.CATAORY_POINT;
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
		
	}
	@Override
	public String toString(){
		return "X="+getX()+",Y="+getY();
	}
}
