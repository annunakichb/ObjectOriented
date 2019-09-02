package com.insp.edu.book.oo.medium.charter1.e1_3_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List al = new ArrayList();
		Iterator itr = al.iterator();
		while (itr.hasNext()){
			Object element = itr.next();
			System.out.print(element + " ");
		}
	}

}
