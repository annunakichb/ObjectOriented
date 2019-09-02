package com.insp.edu.book.oo.medium.charter1.e4_3_5;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.insp.edu.book.oo.medium.charter1.e4_3_5.data.Point;
import com.insp.edu.book.oo.medium.charter1.e4_3_5.data.Triangle;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",9001);//定义socket并向服务端发起连接请求，这里的IP地址是服务端的IP地址，端口是服务端的端口，不是自己的
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//客户端不读只写，且不会写字符串，这里直接用OutputStream对象完成写任务		
		DataOutputStream stream = null;
		try {
			stream = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Serialization ser = new Serialization();
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("请输入要创建的对象类型(1为Point,2为Triangle)：");
			int type = scan.nextInt();
			if(type == 1){
				System.out.println("请输入点(格式为\"x,y\"):");
				String s = scan.next();
				Point pt = Point.parse(s);
				if(pt == null)continue;
				
				
				byte[] datas = ser.serialize(pt);
				try {
					System.out.println("datas.length="+datas.length);
					stream.writeInt(datas.length);
					stream.write(datas);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(type == 2){
				System.out.println("请输入点(格式为\"x1,y1;x2,y2;x3,y3\"):");
				String s = scan.next();
				Triangle tri = Triangle.parse(s);
				if(tri == null)continue;
				
				byte[] datas = ser.serialize(tri);
				
				try {
					System.out.println("datas.length="+datas.length);
					stream.writeInt(datas.length);
					stream.write(datas);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(type == 0){
				System.exit(0);
			}else{			
				System.out.println("输入类型不认识");
			}
		}
	}

}
