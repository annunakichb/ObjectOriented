package com.insp.edu.book.oo.medium.chapter6.e6_3_2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入一系列整数，逗号分隔，如:11,12,13,21,22,23");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		int sum = transform1(line);
		System.out.println("平方和为:"+sum);
		
		
	}
	private static int transform1(String line){
		Optional<Integer> option = Stream.of(line.split(","))
				.map(e1 -> Integer.parseInt(e1))
				.map(e2->e2*e2)
				.reduce((a,b)->a+b);
		if(option.isPresent())return option.get();
		else return 0;
	}
	
	private static int transform2(String line){
		String[] s1 = line.split(",");
		int[] v1 = new int[s1.length];
		int sum = 0;
		for(int i=0;i<v1.length;i++){
			v1[i] = Integer.parseInt(s1[i]);
			v1[i] = v1[i]*v1[i];
			sum += v1[i];
		}
		return sum;
	}
	
	

}
