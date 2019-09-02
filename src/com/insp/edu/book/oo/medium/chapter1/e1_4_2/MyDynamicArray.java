package com.insp.edu.book.oo.medium.chapter1.e1_4_2;

import java.lang.reflect.Array;

public class MyDynamicArray<T> {//T称为类型模板，它并不是一个实际的类型	
	private T[] elements = (T[]) new Object[0]; //不能写new T[0],原因自己百度下，但是C++可以，C#可以，所以百度完了以后你要清楚，其实是JDK设计的人昏了头
	private int dataLength = 0;
	
	public void add(T t){
		if(t == null)return;		
		if(dataLength + 1 > elements.length){
			T[] newArray = (T[]) new Object[dataLength +1];//同样不能写new T[dataLength + ts.length]
			System.arraycopy(elements, 0, newArray, 0, dataLength);//自己百度下这个函数
			elements = newArray;
		}
		elements[dataLength++] = t;
	}
	

	public T get(int index){
		if(index < 0 || index >= elements.length)return null;
		return elements[index];
	}
	public int size(){
		return dataLength;
	}
}
