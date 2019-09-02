package com.insp.edu.book.oo.medium.chapter1.e1_4_8;
import java.util.*;
import java.io.*;
public class Dictionary {
	private HashMap<String,String> hashtable = new HashMap<String,String>();
	
	public Dictionary(File file){
		load(file);
	}
	public void load(File file){
		try{ Scanner sc = new Scanner(file); 
	        while(sc.hasNext()){
	           String englishWord=sc.next();
	           String chineseWord=sc.next(); 
	           hashtable.put(englishWord,chineseWord); 
	         }
		}
		catch(Exception e){
			System.out.println("读取文件失败:"+e.getMessage());
			e.printStackTrace();
		}  
	}
	public String translate(String word){
		if(hashtable.containsKey(word))
			return hashtable.get(word);
		return word;
	}
}
