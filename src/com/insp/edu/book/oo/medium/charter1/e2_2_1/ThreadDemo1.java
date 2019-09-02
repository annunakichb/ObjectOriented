package com.insp.edu.book.oo.medium.charter1.e2_2_1;

class Hello1 extends Thread{
	public void run(){
		while(true) {
			System.out.println("hello");
			try {
				Thread.sleep(1000);
	        } catch (InterruptedException e) {}		
	    }
	}
}
class Hello2 extends Thread{
	public void run(){
		while(true) {	    
			System.out.println("你好");
	        try {
				Thread.sleep(1000);
	        } catch (InterruptedException e) {}			
	    }
	}
}
public class ThreadDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello1 h1 = new Hello1();
		Hello2 h2 = new Hello2(); //与上一行的位置交换试试看
		h1.start(); 
		h2.start(); //与上一行的位置交换试试看        

	}

}
