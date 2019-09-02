package com.insp.edu.book.oo.medium.chapter1.e1_1_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileContentToArray {

	/**
	 * 读取文件内容到数组里
	 * 因为我们不知道读取的文件有多大，导致我们构造出来的数组有可能因为过大浪费了很多存储空间，也可能因为过小使得程序出错
	 * 这里给出的解决办法是当发现数组大小不够的时候，创建一个全新的且足够大的数组，然后将原数组的内容拷贝到新数组，原数组就丢弃不用了
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//初始化文件
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入文件名:");
		String filename = scan.nextLine();
		FileInputStream stream = new FileInputStream(new File(filename));		
		//读取文件内容		
		//byte[] contents = new byte[100]; 
		DynamicArray array = new DynamicArray();
		byte[] temp = new byte[10];
		while((stream.read(temp)) > 0){
			array.add(temp);
		}
		
		//输出读取到的内容
		String str = new String(array.getAll());
		System.out.println(str);
	}

}
