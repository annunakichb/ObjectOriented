package com.insp.edu.book.oo.medium.charter1.e2_3_7;

class Producer extends Thread
{
	public DataPool dp = null;
	public Consumer sum = null;

	public void run(){
		int i = 1;
		while(true){
			synchronized(dp)
			{
				dp.data++;
				System.out.println("生产者产生数据：" + dp.data);
				try{
					dp.notify();					
					dp.wait();
				}catch(Exception e)
				{
					System.out.println("生产者异常:");
					e.printStackTrace();
				}
			}
			try{
				sleep(2000);
			}catch(Exception e)
			{
			
			}
		}
	}
}

class Consumer extends Thread
{
	public DataPool dp = null;
	public Producer pro = null;
	
	
	public void run(){
		while(true){
			synchronized(dp){
				System.out.println("消费者得到数据：" + dp.data);
				try{
				 	dp.notify();
					dp.wait();
				}catch(Exception e)
				{
					System.out.println("消费者者异常:");
					e.printStackTrace();
				}
			}
			try{
				sleep(2000);
			}catch(Exception e)
			{
			
			}
				
		}
	}
	
}

class DataPool{
	public int data = 0;
}
public class ProducerAndConsumerDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producer p = new Producer();
		Consumer c = new Consumer();
		
		DataPool dp = new DataPool();
		
		p.dp = dp;
		c.dp = dp;
		
		p.start();
		c.start();
		
		
	}

}
