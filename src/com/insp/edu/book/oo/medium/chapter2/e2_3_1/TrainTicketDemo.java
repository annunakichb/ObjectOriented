package com.insp.edu.book.oo.medium.chapter2.e2_3_1;

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
		if(TrainTicketDemo.unsell.size()<=0){
			System.out.println("没有票了");
		}		
		Ticket ticket = TrainTicketDemo.unsell.remove(0);
		ticket.sellState = 1;
		ticket.buyer = this.name;
		TrainTicketDemo.selled.add(ticket);
		System.out.println(name+"买到了"+ticket.seatNumber);
	}
}
public class TrainTicketDemo {
	
	public static List<Ticket> unsell = new ArrayList<Ticket>();
	public static List<Ticket> selled = new ArrayList<Ticket>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initunsell();
		
		Buyer[] buyers = new Buyer[]{
				new Buyer("张三"),
				new Buyer("李四"),
				new Buyer("王五"),
				new Buyer("赵六"),
				new Buyer("钱七"),
				new Buyer("万八"),
		};
		
		for(Buyer buyer : buyers)
			buyer.start();
		
		
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
