package com.insp.edu.book.oo.medium.chapter1.e1_4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Point2D{
	private double x;
	private double y;
	public Point2D(){}
	public Point2D(double x,double y){this.x = x;this.y = y;}	
	public String toString(){return "二维坐标点：(" + x + "," + y + ")";}
}
class Point{
	private double[] coords;
	public Point(){}
	public Point(double x,double y){coords = new double[]{x,y};}
	public Point(double...coords){this.coords = coords;}
	public String toString(){
		StringBuffer s = new StringBuffer();
		for(double v : coords){
			if(!s.toString().equals(""))s.append(",");
			s.append(v);
		}
		return this.coords.length+"维坐标点：(" +  s.toString() + ")";	
	}
}
public class ListElementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		List list = new ArrayList();
		while(true){
			//输入坐标字符串
			System.out.println("请输入几何点坐标序列（坐标值用\",\"分隔,例如12.8,24.1,32.3）");
			String line = scan.nextLine();
			if(line.equals(""))break;
			String[] arr = line.split(",");
			if(arr==null||arr.length<=0)break;
			//解析字符串，得到double数组
			double[] value = new double[arr.length];
			for(int i=0;i<arr.length;i++){
				try{
					value[i] = Double.parseDouble(arr[i]);
				}catch(Exception e){continue;}
			}
			//将double数组转换为坐标点Point或者Point2D对象之一，并加入到List中去
			if(value.length<2){
				list.add(value[0]);
			}
			else if(value.length==2){
				Point2D pt2d = new Point2D(value[0],value[1]);
				list.add(pt2d);
			}else{
				Point pt = new Point(value);
				list.add(pt);
			}
		}
		System.out.println("现在不清楚List中的每个元素是什么类型的对象，只知道其长度为："+list.size());
		for(int i=0;i<list.size();i++){
			Object element = list.get(i);
			if(element instanceof Double){
				System.out.println("第"+i+"个元素类型是double,值是:"+(double)element);
			}else if(element instanceof Point2D){
				System.out.println("第"+i+"个元素类型是Point2D,值是:"+(Point2D)element);
			}else if(element instanceof Point){
				System.out.println("第"+i+"个元素类型是Point,值是:"+(Point)element);
			}
		}
		
		
	}

}
