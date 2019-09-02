package com.insp.edu.book.oo.medium.chapter6.e6_2_1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

class Course{
	@XmlAttribute
	public String name;
	@XmlElement
	public double score;
	public Course(){}
	public Course(String name,double score){
		this.name = name;
		this.score = score;
	}
}

class Student{
	@XmlAttribute
	public String name;
	@XmlElementWrapper(name="courses")
	@XmlElement(name="course")
	public List<Course> courses = new ArrayList<Course>();
	public Student(){}
	public Student(String name){this.name = name;}
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer();
		for(Course c : courses){
			if(!s.toString().equals(""))
				s.append(",");
			s.append(c.name+"="+c.score);
		}
		return this.name+";"+s.toString();
	}
}

/**
 * 班级
 * @author chb
 *
 */
@XmlRootElement
class Classes{	
	@XmlElementWrapper(name="members")
	@XmlElement(name="member")
	public  List<Student> students = new ArrayList<Student>();
}
public class XmlAnnonationDemo {
	private static Classes classes = new Classes();
	
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		while(true){
			System.out.println("请选择操作：1 创建学生信息；2 保存文件 3 读取文件 4打印 5 退出");
			String op = scan.nextLine();
			if(op.equals("5"))break;
			if(op.equals("1")) 
				doCreate();
			else if(op.equals("2"))
				doSave();
			else if(op.equals("3"))
				doLoad();
			else if(op.equals("4"))
				doPrint();
		}
	}
	
	private static void doCreate(){
		while(true){
			System.out.println("输入学生信息，如张三;数学分析=80.8,英语=93");
			
			String line = scan.nextLine();
			if(line == null || line.trim().equals(""))break;
			
			String[] s1 = line.split(";");
			String[] s2 = s1[1].split(",");
			
			Student s = new Student(s1[0]);
			for(int i=0;i<s2.length;i++){
				String[] s3 = s2[i].split("=");
				double score = Double.parseDouble(s3[1]);
				Course c = new Course(s3[0],score);
				s.courses.add(c);
			}
			classes.students.add(s);
			
		}
		System.out.println("目前共有"+classes.students.size()+"个学生信息");
	}
	private static void doSave(){

		System.out.println("请输入文件名(如：c:\\c.xml):");
		String fileName = scan.nextLine();
		 try {  
			 File file = new File(fileName);  
			 JAXBContext jaxbContext = JAXBContext.newInstance(Classes.class);  
			 Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
	         jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	         jaxbMarshaller.marshal(classes, file);  //输出xml格式到文件 
	         
	         System.out.println("保存到文件完成，保存内容如下：");
	         jaxbMarshaller.marshal(classes, System.out); //同时也输出到屏幕一份
	         
	         
		 } catch (JAXBException e) {  
			 System.out.println("保存到文件出错："+ e.getMessage());
			 e.printStackTrace();  
		 }  		 
	}
	private static void doLoad(){
		System.out.println("请输入文件名(如：c:\\c.xml):");
		String fileName = scan.nextLine();
		 try {  
			 File file = new File(fileName);  
			 JAXBContext jaxbContext = JAXBContext.newInstance(Classes.class);  
			 Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();  	          
	         Classes c = (Classes) jaxbMarshaller.unmarshal(file); 
	         
	         XmlAnnonationDemo.classes = c;
	         System.out.println("读取文件完成，共有"+c.students.size()+"个学生信息");	        
		 } catch (JAXBException e) {  
			 System.out.println("读取文件出错："+ e.getMessage());
			 e.printStackTrace();  
		 }
	}
	
	private static void doPrint(){
		for(int i=0;i<classes.students.size();i++){
			System.out.println(classes.students.get(i));
		}
	}

}
