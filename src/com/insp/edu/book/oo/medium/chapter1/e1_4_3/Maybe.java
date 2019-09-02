package com.insp.edu.book.oo.medium.chapter1.e1_4_3;

import java.util.Scanner;

class Point2D{
	private double x;
	private double y;
	public Point2D(){}
	public Point2D(double x,double y){this.x = x;this.y = y;}	
	public String toString(){return "二维坐标点：(" + x + "," + y + ")";}
}
public class Maybe<T> {
	private T var; 
	public Maybe(){}
	public Maybe(T v){var = v;}
	public boolean isVaild(){return var != null;}	
	public T get(){
		return var;	
	}
	public static void main(String[] args){
		Point2D pt = null;
		Maybe<Point2D> maybePoint = new Maybe<Point2D>(new Point2D());
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		if(!line.equals("")){
			String[] arr = line.split(",");
			if(arr!=null&&arr.length>0){
				double[] value = new double[arr.length];
				for(int i=0;i<arr.length;i++){
					try{
						value[i] = Double.parseDouble(arr[i]);
					}catch(Exception e){continue;}
				}
				if(value!=null && value.length==2){
					pt = new Point2D(value[0],value[1]);
					maybePoint = new Maybe<Point2D>(pt);
				}
			}
			
		}
		
		String str1 = pt.toString();
		System.out.println("如果你看到我，说明pt的类型确实是Point2D,否则...,"+str1);
		
		String str2 = maybePoint.get().toString();
		System.out.println("你无论如何都能看到我，因为如果pt无效，maybePoint的get方法会返回一个缺省的Point2D："+str2);
	}
}
