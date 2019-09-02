package com.insp.edu.book.oo.medium.charter1.e1_5_1;

import java.util.ArrayList;
import java.util.List;

class P{}
class C extends P{}


public class CovariantAndContravariantDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<P> list1 = new ArrayList<P>(); 
		List<? extends P> list2 = new ArrayList<P>();
		List<? super P> list3 = new ArrayList<P>();
		list1.add(new P()); //正确
		list1.add(new C()); //正确
		//list2.add(new P()); //错误
		//list2.add(new C()); //错误
		list3.add(new P()); //错误
		list3.add(new C()); //错误
	}

}
