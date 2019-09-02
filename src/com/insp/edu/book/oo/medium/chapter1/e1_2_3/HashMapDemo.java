/**
 * 
 */
package com.insp.edu.book.oo.medium.chapter1.e1_2_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chb
 *
 */
public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap(); 
		map.put("张三",94.5);  map.put("李四",78.6);
		System.out.println(map.get("张三"));
		System.out.println(map.get("李四"));
	}

}
