package com.insp.edu.book.oo.medium.chapter1.e1_1_4;

public class DynamicArray {
	private int initCapacity = 100;
	private byte[] contents;
	private int vaildLength = 0;
	public DynamicArray(){contents = new byte[initCapacity];}
	public DynamicArray(int capacity){
		initCapacity = capacity;
		contents = new byte[initCapacity];
	}
	public void add(byte[] temp){
		if(temp == null)return;
		if(vaildLength+temp.length>contents.length){
			byte[] newarray = new byte[vaildLength+temp.length];  //创建一个足够大的数组
			for(int j=0;j<contents.length;j++)newarray[j] = contents[j];//将原来已经读取的内容拷贝到新数组中去
			contents = newarray;//丢弃原来的contents数组，让contents引用新数组
		}
	}
	public byte[] getAll(){return contents;}
	
}
