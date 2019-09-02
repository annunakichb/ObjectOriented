package com.insp.edu.book.oo.medium.charter1.e1_4_8;
import java.util.*;
import java.io.*;
public class DictionaryDemo {
   public static void main(String args[]) {       
       File file=new File("word.txt");
       Dictionary dict = new Dictionary(file);       
       Scanner scanner = new Scanner(System.in);
       System.out.print("开始翻译，请输入要翻译的词汇:");
       while(scanner.hasNextLine()) {
           String englishWord = scanner.nextLine();
           if(englishWord.length()==0) break;
           System.out.println(dict.translate(englishWord));
       } 
   }
}
