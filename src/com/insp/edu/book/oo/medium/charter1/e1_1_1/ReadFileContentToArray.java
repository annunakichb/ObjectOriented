/**
 * 
 */
package com.insp.edu.book.oo.medium.charter1.e1_1_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author chb
 *
 */
public class ReadFileContentToArray {

	/**
	 * 读取文件内容到数组里
	 * 因为我们不知道读取的文件有多大，导致我们构造出来的数组有可能因为过大浪费了很多存储空间，也可能因为过小使得程序出错
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
		int n = 100; //这里n的值无论给多少都可能是不合适的
		byte[] contents = new byte[n];
		byte[] temp = new byte[10];
		int i = 0, t = 0;
		while((t = stream.read(temp)) > 0){
			for(int j=0;j<t;j++)contents[i+j] = temp[j];
			i += t;
		}
		
		//输出读取到的内容
		String str = new String(contents);
		System.out.println(str);
	}

}
