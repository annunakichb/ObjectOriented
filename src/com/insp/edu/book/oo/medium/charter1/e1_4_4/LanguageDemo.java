package com.insp.edu.book.oo.medium.charter1.e1_4_4;

interface Speak<E> {
    void speak(E x);
}
class Student implements Speak<English> {
   public void speak(English p) {
      p.show();
   }
}
class Teacher implements Speak<Chinese> {
   public void speak(Chinese v) {
      v.show();
   }
}
class English {
   public void show() {
      System.out.println("hello");
   }
}
class Chinese {
    public void show() {
      System.out.println("你好");
   }
}
public class LanguageDemo {
	public static void main(String args[ ]) {
	      Student zhang=new Student();  
	      System.out.println("学生说:");
	      zhang.speak(new English());
	      Teacher teacher=new Teacher(); 
	       System.out.println("老师说:"); 
	      teacher.speak(new Chinese());
	   }
}
