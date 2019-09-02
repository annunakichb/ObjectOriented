package com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry;

import java.util.HashMap;
import java.util.Map;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.Style;

/**
 * 几何图形抽象类
 * 将所有的几何图形分成三类：点、线、面
 * @author chb
 *
 */
public abstract class Geometry {	

	/** 几何图形分类：点 */
	public final static int CATAORY_POINT = 1;
	/** 几何图形分类：线 */
	public final static int CATAORY_LINE = 2;
	/** 几何图形分类：面 */
	public final static int CATAORY_FILL = 3;
	
	/** 样式，实际引用Style子类的对象 */
	protected Map<String,Style> styles = new HashMap<String,Style>();
	
	/**
	 * 构造方法
	 */
	public Geometry(){}
	/**
	 * 构造方法
	 * @param ss
	 */
	public Geometry(Style...ss){
		if(styles == null || ss.length<=0)return;
		for(int i=0;i<ss.length;i++){
			String className = ss[i].getClass().getSimpleName();
			Style new_style_obj = ss[i].clone();
			this.styles.put(className,new_style_obj);
		}
	}
	/**
	 * 取得当前样式
	 * @return
	 */
	public Style getStyle(String styleClassName) {
		if(styles.containsKey(styleClassName))
			return styles.get(styleClassName);
		else return null;
	}
	
	
	/**
	 * 维度
	 * @return
	 */
	public abstract int dimension();
	/**
	 * 分类
	 * @return
	 */
	public abstract int cataory();
	/**
	 * 长度
	 * @return
	 */
	public abstract double length();
	/**
	 * 面积
	 * @return
	 */
	public abstract double area();
	
	/**
	 * 显示几何图形
	 * @param graphics 实际为Graphics类型
	 */
	public abstract void draw(Object graphics);
	
	
	
}
