package com.insp.edu.book.oo.medium.chapter6.e6_3_1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"fortran","java","c++","lisp","haskell","delphi"};
		toUpper1(strs);
	}
	
	private static void toUpper1(String[] strs){
		List<String> list = Stream.of(strs)
								.map(str -> str.toUpperCase())
								.collect(Collectors.toList());
		
		list.stream().forEach(element -> System.out.print(element + " "));
		
	}
	private static void toUpper2(String[] strs){
		String[] s = new String[strs.length];
		for(int i=0;i<strs.length;i++){
			s[i] = strs[i].toUpperCase();
		}
		for(int i=0;i<s.length;i++){
			System.out.print(s[i] + " ");
		}
	}

}
