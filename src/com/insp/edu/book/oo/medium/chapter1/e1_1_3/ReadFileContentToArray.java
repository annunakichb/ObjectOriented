package com.insp.edu.book.oo.medium.chapter1.e1_1_3;

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
		byte[] contents = new byte[100];
		byte[] temp = new byte[10];
		int i = 0, t = 0;
		while((t = stream.read(temp)) > 0){
			if(i+t>contents.length){
				byte[] newarray = new byte[i+t];  //创建一个足够大的数组
				for(int j=0;j<contents.length;j++)newarray[j] = contents[j];//将原来已经读取的内容拷贝到新数组中去
				contents = newarray;//丢弃原来的contents数组，让contents引用新数组
			}
			for(int j=0;j<t;j++)contents[i+j] = temp[j];
			i += t;
		}
		
		//输出读取到的内容
		String str = new String(contents);
		System.out.println(str);
	}

}
