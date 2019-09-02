package com.insp.edu.book.oo.medium.chapter6.e6_1_2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
	private String name;
	private double[] scores;
	
	public double getAvgScores(){
		double sum = 0;
		for(int i=0;i<scores.length;i++){
			sum += scores[i];
		}
		return sum / scores.length;
	}
}
public class RelectionDemo {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("输入学生姓名和分数，如:张三,91.8,21.4");
		while(true){
			String line = scan.nextLine();
			if(line == null || line.equals(""))break;
			String[] ss = line.split(",");
			
			Student obj = new Student();
			Class clazz = obj.getClass();
			Field f1 = clazz.getDeclaredField("name");
			Field f2 = clazz.getDeclaredField("scores");
			
			f1.setAccessible(true);
			f1.set(obj, ss[0]);
			
			double[] values = new double[ss.length-1];			
			for(int i=1;i<ss.length;i++){
				double d = Double.parseDouble(ss[i]);
				Array.set(values, i-1, d);
			}
			
			f2.setAccessible(true);
			f2.set(obj, values);
			
			Method m = clazz.getDeclaredMethod("getAvgScores");
			double v = (double) m.invoke(obj);
			
			System.out.println(ss[0]+"平均分="+v);
		}
		
		
		
	}

}
