package com.insp.edu.book.oo.medium.chapter3.e3_7_4.builder;

import java.awt.Component;
import java.awt.event.MouseEvent;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.Geometry;

/**
 * 用鼠标操作构建几何对象的构建类
 * 每个实现子类需要实现鼠标按下，鼠标移动，鼠标抬起，鼠标点击（按下后立即抬起）
 * @author chb
 *
 */
public abstract class GeometryBuilder {
	/** 构造状态：构建中 */
	public final static int BUILDING = 0;
	/** 构造状态：构建完成  */
	public final static int DONE = 1;
	/** 构造状态：构建被取消  */
	public final static int CANCEL = 2;
	
	/** 构建的最终结果对象，初始为null */
	protected Geometry geometry;
	
	/**
	 * 取得构建的几何对象
	 * @return
	 */
	public Geometry getGeometry() {
		return geometry;
	}
	
	/**
	 * 鼠标按下
	 * @param canvas 鼠标操作的组件
	 * @param e      事件对象
	 * @return       构造状态
	 */
	public abstract int doMousePressed(Component canvas,MouseEvent e);
	/**
	 * 鼠标抬起
	 * @param canvas 鼠标操作的组件
	 * @param e      事件对象
	 * @return       构造状态
	 */
	public abstract int doMouseReleased(Component canvas,MouseEvent e);
	/**
	 * 鼠标移动
	 * @param canvas 鼠标操作的组件
	 * @param e      事件对象
	 * @return       构造状态
	 */
	public abstract int doMouseMoved(Component canvas,MouseEvent e);
	
	/**
	 * 鼠标点击
	 * @param canvas 鼠标操作的组件
	 * @param e      事件对象
	 * @return       构造状态
	 */
	public abstract int doMouseClicked(Component canvas,MouseEvent e);
	
}
