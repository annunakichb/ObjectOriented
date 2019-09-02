package com.insp.edu.book.oo.medium.chapter6.e6_2_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射
@Target(ElementType.FIELD)//规定注解只能加在字段上
public @interface TableField {
	/** 对应表中字段的名称 */
	String name();
}
