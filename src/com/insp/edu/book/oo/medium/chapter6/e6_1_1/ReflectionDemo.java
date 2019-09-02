package com.insp.edu.book.oo.medium.chapter6.e6_1_1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;


public class ReflectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class clazz = String.class;
		
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("String类共有"+fields.length+"个字段");
		for(int i=0;i<fields.length;i++){
			System.out.print("第"+(i+1)+"个字段:");
			System.out.print(Modifier.toString(fields[i].getModifiers())+" ");
			System.out.print(fields[i].getType().getSimpleName()+" ");
			System.out.println(fields[i].getName()+";");
		}
		
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("String类共有"+methods.length+"个方法");
		for(int i=0;i<methods.length;i++){
			System.out.print("第"+(i+1)+"个方法:");
			System.out.print(Modifier.toString(methods[i].getModifiers())+" ");
			System.out.print(methods[i].getReturnType().getSimpleName()+" ");
			System.out.print(methods[i].getName()+"(");
			
			Parameter[] params = methods[i].getParameters();
			for(int j=0;j<params.length;j++){
				System.out.print(params[j].getType().getSimpleName() + " " + params[j].getName());
				if(j!=params.length-1)
					System.out.print(",");
			}
			
			System.out.println(");");
		}
	}

}
