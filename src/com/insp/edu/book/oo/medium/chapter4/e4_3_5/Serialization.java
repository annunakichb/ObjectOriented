package com.insp.edu.book.oo.medium.chapter4.e4_3_5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化器，负责将一个对象（必须实现Serializable接口）转换为字节数组，
 * 或者反过来将字节数组转换为对象
 * @author chb
 *
 */
public class Serialization {
	
	public byte[] serialize(Object obj){
		
		ByteArrayOutputStream bo = new ByteArrayOutputStream(); 
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(bo);
			out.writeObject(obj); //ObjectOutputStream的该方法将对象转换为流
		} catch (IOException e) {e.printStackTrace(); 
		}finally{
			try{out.close();}catch(Exception e){}  
			try{bo.close();}catch(Exception e){} 	
		}
		
		return bo.toByteArray();//ByteArrayOutputStream的该方法将流转换为字节数组
	}
	/**
	 * 反序列化，即将字节数组转换为对象
	 * @param bytes
	 * @return
	 */
	public Object deserialize(byte[] bytes){
		Object obj = null;  
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {    
		    bi = new ByteArrayInputStream(bytes);  
		    oi = new ObjectInputStream(bi);  		  
		    obj = oi.readObject();  
		    
		}catch (Exception e) {  		      
		    e.printStackTrace();  
		}finally{
			try{bi.close();}catch(Exception e){}  
			try{oi.close();}catch(Exception e){}  
		}
		return obj;  		  
	}
	
}
