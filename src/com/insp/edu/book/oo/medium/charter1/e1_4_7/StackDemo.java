package com.insp.edu.book.oo.medium.charter1.e1_4_7;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack=new Stack<Integer>();
	    stack.push(1); 
	    stack.push(2);
	    System.out.print("1 2"); 
	    int k=1;
	    while(k<=10) {
	        for(int i=1;i<=2;i++) {
	          int k1 = stack.pop();	         
	          int k2 = stack.pop();
	          int k3 = k1+k2;	          
	          System.out.print(" "+k3); 
	          stack.push(k1); //想想看这里应该是k1还是k2
	          stack.push(k3); //想想看能否与上一句颠倒顺序
	          
	          k++;
	        }
	    } 
	}

}
