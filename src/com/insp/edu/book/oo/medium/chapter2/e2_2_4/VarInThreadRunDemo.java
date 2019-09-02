/**
 * 
 */
package com.insp.edu.book.oo.medium.chapter2.e2_2_4;

class A extends Thread{
	public void run(){
		int money = 0;
		while(true){
			int time = (int) (Math.random()*3);
			try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {}
			
			money += 10;
			System.out.println("线程名称="+getName()+",n="+money);
			
		}
	}
}
/**
 * @author chb
 *
 */
public class VarInThreadRunDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();
		a1.setName("张三");
		A a2 = new A();
		a2.setName("李四");
		
		a1.start();
		a2.start();
	}
}
