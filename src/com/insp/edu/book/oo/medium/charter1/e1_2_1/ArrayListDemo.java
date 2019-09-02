package com.insp.edu.book.oo.medium.charter1.e1_2_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List al = new ArrayList();
		System.out.println("List的初始大小: " + al.size());
		// 向List中增加元素
		al.add("A");  al.add("B");  al.add("C");
		al.add(1); al.add(new Object()); al.add(new Date());
		System.out.println("增加元数后的大小: " + al.size());
		//显示其内容
		System.out.println("List中的内容: " + al);
		//删除List中的元素
		al.remove("D");al.remove(2);
		System.out.println("删除元素后的大小：" + al.size());
		System.out.println("内容: " + al);
	}

}
