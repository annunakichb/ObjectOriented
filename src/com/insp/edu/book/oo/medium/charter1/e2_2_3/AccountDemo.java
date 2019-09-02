package com.insp.edu.book.oo.medium.charter1.e2_2_3;

class Account{
	private String name;
	private ThreadLocal<Double> money = new ThreadLocal<Double>();
	//private double money;
	public Account(String client,double initMoney){name=client;money.set(initMoney);}
	public void initMoney(double m){money.set(m);}
	public void withdraw(double moneyTaken){
		double temp = money.get();
		temp -= moneyTaken;
		money.set(temp); 
		System.out.println(name+"账户中被取走"+moneyTaken+",还剩下"+temp);
	}
	public void deposit(double moneySaved){
		double temp = money.get();
		temp += moneySaved;
		money.set(temp);
		System.out.println(name+"账户存入"+moneySaved+",目前有"+temp);
	}	 
}
class Wife extends Thread{
	public void run(){
		AccountDemo.familyAccount.initMoney(1000);
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
class Husband extends Thread{
	public void run(){
		AccountDemo.familyAccount.initMoney(1000);
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
		Husband h = new Husband();		
		Wife w = new Wife();
		h.start();
		w.start();
	}
}
