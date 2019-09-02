package com.insp.edu.book.oo.medium.chapter2.e2_3_2;

import java.util.ArrayList;
import java.util.List;

class Ticket{
	public String seatNumber;
	public int sellState; //0未出售；1已出售
	public String buyer;
	public Ticket(String n){seatNumber = n;}
}

class Buyer extends Thread{
	public String name;
	public Buyer(String name){this.name = name;}
	public void run(){
		while(true){
			if(TrainTicketDemo.unsell.size()<=0){
				System.out.println(name+"说：没有票了,过会再来买");
				continue;
			}
			break;
		}		
		Ticket ticket = TrainTicketDemo.unsell.remove(0);
		ticket.sellState = 1;
		ticket.buyer = this.name;
		TrainTicketDemo.selled.add(ticket);
		System.out.println(name+"买到了"+ticket.seatNumber);

	}
}

class Refund extends Thread{
	public void run(){
		int ticketno = 1;
		while(true){
			if(TrainTicketDemo.unsell.size() > 0){				
				continue;
			}
			int time = (int) (Math.random()*10+10);
			try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {}
				
			TrainTicketDemo.unsell.add(new Ticket("退票"+ticketno));
			System.out.println("系统产生了一个退票:"+"退票"+ticketno);
			ticketno++;
		}
		
	}
}
public class TrainTicketDemo {
	
	public static List<Ticket> unsell = new ArrayList<Ticket>();
	public static List<Ticket> selled = new ArrayList<Ticket>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initunsell();
		
		int n = 1000;//你可以修改n的值，运行的时候打开任务管理器监控CPU占用率
		Buyer[] buyers = new Buyer[n];
		for(int i=0;i<buyers.length;i++){
			buyers[i] = new Buyer("购票者"+(i+1));			
		}
		
		for(Buyer buyer : buyers)
			buyer.start();
		
		
		new Refund().start();
		
	}
	private static void initunsell(){
		unsell.clear();
		unsell.add(new Ticket("1A"));
		unsell.add(new Ticket("1B"));
		unsell.add(new Ticket("1C"));
		unsell.add(new Ticket("1D"));
		unsell.add(new Ticket("1F"));
		unsell.add(new Ticket("2A"));
		unsell.add(new Ticket("2B"));
		unsell.add(new Ticket("2C"));
		unsell.add(new Ticket("2D"));
		unsell.add(new Ticket("2F"));
		
	}

}
