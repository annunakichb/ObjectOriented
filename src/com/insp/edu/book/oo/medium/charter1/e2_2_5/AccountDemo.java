package com.insp.edu.book.oo.medium.charter1.e2_2_5;

class Account{
	private String name;
	private double money;
	public Account(String client,double initMoney){name=client;money = initMoney;}
	public void withdraw(double moneyTaken){
		money -= moneyTaken;
		System.out.println(name+"账户中被取走"+moneyTaken+",还剩下"+money);
	}
	public void deposit(double moneySaved){
		money += moneySaved;
		System.out.println(name+"账户存入"+moneySaved+",目前有"+money);
	}	 
}
class Wife implements Runnable{
	public void run(){
		while(true){
			int time = (int) (Math.random()*3);			
			try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {}
			
			int moneyTaken = (int) (Math.random()*1000);
			AccountDemo.familyAccount.withdraw(moneyTaken);
		}
	}
}
class Husband implements Runnable{
	public void run(){
		while(true){
			int time = (int) (Math.random()*3);			
			try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {}
			
			int moneySaved = (int) (Math.random()*1000);
			AccountDemo.familyAccount.deposit(moneySaved);
		}
	}
}
public class AccountDemo {
	public static Account familyAccount = new Account("你的",10000);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Husband h = new Husband();  //不再是线程
		Wife w = new Wife();
		
		Thread t1 = new Thread(h);//直接创建Thread对象，构造方法中参数传递为Runnable的实现类对象
		Thread t2 = new Thread(w);
		
		t1.start();
		t2.start();
	}
}
