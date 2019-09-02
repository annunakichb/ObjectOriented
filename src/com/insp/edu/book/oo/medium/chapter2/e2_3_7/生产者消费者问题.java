package com.insp.edu.book.oo.medium.chapter2.e2_3_7;

class 生产者 extends Thread{
	public 数据池 池子;
	public Object 同步锁;
	public void run() {
		int 序号 = 0;
		int d = 0;
		while(true) {
			synchronized(同步锁) {
				池子.datas[序号] = d;
				System.out.println("我是生产者，我放入了"+d);
				d += 1;
				序号++;
				if(序号 >= 池子.datas.length)
					序号 = 0;
				
				try {
					同步锁.notify();
					同步锁.wait();
				}catch(Exception e) {
					
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class 消费者 extends Thread{
	public 数据池 池子;
	public Object 同步锁;
	public void run() {
		int 序号 = 0;
		while(true) {
			synchronized(同步锁){
				
				
				int d = 池子.datas[序号];
				System.out.println("我是消费者，我取得了"+d);
				序号++;
				if(序号 >= 池子.datas.length)
					序号 = 0;
				
				try {
					同步锁.notify();
					同步锁.wait();
				}catch(Exception e) {}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class 数据池 {
	public final int[] datas = new int[5];
}

public class 生产者消费者问题 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		数据池 chi = new 数据池();
		Object suo1 = new Object();

		
		生产者 p = new 生产者();
		p.池子 = chi;
		p.同步锁 = suo1;

		消费者 c = new 消费者();
		c.池子 = chi;
		c.同步锁 = suo1;

		
		
		p.start();
		c.start();
		
	}

}
