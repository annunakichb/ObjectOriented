/**
 * 
 */
package com.insp.edu.book.oo.medium.chapter2.e2_2_6;

import java.util.Scanner;

class A extends Thread{
	public boolean stopflag = false;
	public int sleepTime = 1000;
	public boolean waitFlag = false;
	public Object waitObject = new Object();

	public void run(){
		int n = 1;
		while(!stopflag){
			try {
				Thread.sleep(sleepTime);
			} 
			catch (InterruptedException e) {break;} //InterruptedException由interrupt方法调用引发
			catch(Exception e){//其它异常不终止线程
				System.out.println("sleep状态发生了异常:"+e.getMessage());
				continue;
			}
			
			System.out.println("目前是第"+ n++ + "次循环");	
			
			if(waitFlag){
				synchronized(waitObject){ //调用wait和notify方法的地方必须放在synchronized块中
					try {
						waitObject.wait();
					} 
					catch (InterruptedException e) {break;}
					catch(Exception e){
						System.out.println("wait状态发生了异常:"+e.getMessage());
						e.printStackTrace();
						continue;
					}
				}
			}
				
		}
	}
}
public class ThreadStateDemo {

	static A thread = new A();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("请输入命令(输入help可以查询所有命令):");
			String line = scan.nextLine();
			if(line == null || line.length()<=0){
				System.out.println("命令无效");
				continue;
			}
			if(line.equalsIgnoreCase("help")){
				help();
			}else if(line.equalsIgnoreCase("start")){
				start();
			}else if(line.equalsIgnoreCase("interrupt")){
				interrupt();
			}else if(line.equalsIgnoreCase("stop")){
				stop();
			}else if(line.toLowerCase().contains("sleep")){
				String[] s = line.split(" ");
				int n = 1000;//缺省值
				if(s.length >= 2){
					n = Integer.parseInt(s[1]);
				}
				sleep(n);
			}else if(line.equalsIgnoreCase("wait")){
				wait1();
			}else if(line.equalsIgnoreCase("notify")){
				notify1();
			}else if(line.equalsIgnoreCase("end")){
				System.exit(0);
			}
			
		}
	}
	
	private static void help(){
		System.out.println("start  启动线程");
		System.out.println("interrupt   强力终止线程,该命令不管线程运行在那里，即使正在执行sleep也强行终止");
		System.out.println("stop 终止线程，让线程的run方法执行结束，从而让线程结束");
		System.out.println("sleep n 让线程休眠，n为休眠毫秒数");
		System.out.println("wait 让线程进入等待状态");
		System.out.println("notify 让线程从wait状态恢复执行");
		System.out.println("end 结束整个程序");
	}
	private static void start(){
		stop();
		thread = new A();
		thread.stopflag = false; //这句一定要有
		thread.start();		
	}
	private static void interrupt(){
		if(thread == null)thread = new A();
		thread.interrupt();
		thread = null;
	}
	private static void stop(){
		if(thread == null)thread = new A();
		thread.stopflag = true;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}	
		thread = null;
	}
	private static void sleep(int n){
		if(thread == null)thread = new A();
		if(!thread.isAlive()) return;
		thread.sleepTime = n;
		
	}
	private static void wait1(){
		if(thread == null)thread = new A();
		if(!thread.isAlive()) return;
		thread.waitFlag = true;
	}
	private static void notify1(){
		if(thread == null)thread = new A();
		thread.waitFlag = false;
		synchronized(thread.waitObject){
			thread.waitObject.notify();
		}
	}

}
