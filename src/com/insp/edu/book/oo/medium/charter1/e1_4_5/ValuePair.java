/**
 * 
 */
package com.insp.edu.book.oo.medium.charter1.e1_4_5;

import java.util.Date;

/**
 * @author chb
 *
 */
public class ValuePair<K,V> {
	private K key;
	private V value;
	public ValuePair(){}
	public ValuePair(K k,V v){key = k;value=v;}
	public String toString(){return "key="+key+",value="+value;}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValuePair<String,Date> pair1 = new ValuePair<String,Date>("国庆",new Date(2017,10,1));
		ValuePair<String,Double> pair2 = new ValuePair<String,Double>("信科2015",67.2);
		System.out.println(pair1);
		System.out.println(pair2);
	}

}
