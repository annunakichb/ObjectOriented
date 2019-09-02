package com.insp.edu.book.oo.medium.charter1.e4_3_4.server;

public abstract class CommonThread extends Thread{
	private boolean quitFlag;
	private int sleepTime = 1000;
	
	public void bagin(){
		end();
		quitFlag = false;
		this.start();
		
	}
	public void end(){
		quitFlag = true;
		this.interrupt();
	}
	public void sleep() throws Exception{
		if(sleepTime <= 0)
			sleepTime = 1000;
		Thread.sleep(sleepTime);
	}
	public abstract void execute() throws Exception;
	
	public void run(){
		while(!quitFlag){
			try {
				sleep();
			}catch(InterruptedException e){break;} 
			catch (Exception e) {continue;}
			
			try {
				execute();
			} catch(InterruptedException e){break;} 
			catch (Exception e) {
				System.out.println("线程运行异常:"+e.getMessage());
				e.printStackTrace();
				continue;
			}
				
		}
	}
	public boolean isQuitFlag() {
		return quitFlag;
	}
	public void setQuitFlag(boolean quitFlag) {
		this.quitFlag = quitFlag;
	}
	public int getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
}
