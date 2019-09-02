package com.insp.edu.book.oo.medium.chapter3.e3_7_4.canvas;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.PaintContext;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.builder.GeometryBuilder;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.builder.LineSegmentBuilder;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.builder.RectangleBuilder;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.Geometry;
import com.insp.edu.book.oo.medium.chapter3.e3_7_4.geometry.Point;

public class CanvasPanel extends Panel implements MouseListener,MouseMotionListener{
	/**
	 * 所有已经画好的几何图形的集合
	 * 1.每画好一个几何图形，就将几何图形对象放到该集合里面
	 * 2.当窗口被遮挡后，需要将被遮挡部分的几何图形在paint方法中重画，因此将需要将所有的几何图形放在这个集合里面
	 * 3.geometries是泛型List，且类型规定为Geometry,因此所有Geometry子类的对象都可以放在该集合里
	 * 4.也可以分别定义具体类型的集合，如
	 *   List<LineSegment> lines;
	 *   List<Rectangle> rectangle;
	 *   ...
	 *   但是这样与只定义一个：List<Geometry> geometries，哪个更方便呢？请读者自己考虑
	 */
	private List<Geometry> geometries = new ArrayList<Geometry>();
	
	private List<GeometryBuilder> builder = Arrays.asList(new LineSegmentBuilder(),new RectangleBuilder(false),new RectangleBuilder(true));
	
	private GeometryBuilder getBuilderByCommand(){
		int cmd = PaintContext.mainFrame.getPnlBtns().getCommand();
		if(cmd<=0)return null;
		return builder.get(cmd-1);
	}
	/**
	 * 取得几何图形几何，用于CanvasPanel往集合里面加几何图形，或者取出所有图形重画
	 * @return
	 */
	public List<Geometry> getGeometries() {
		return geometries;
	}
	
	public CanvasPanel(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		for(int i=0;i<this.geometries.size();i++)
			this.geometries.get(i).draw(g);
		
		GeometryBuilder builder = getBuilderByCommand();
		if(builder == null)return;
		Geometry buildingGeometry = builder.getGeometry();
		if(buildingGeometry == null)return;
		buildingGeometry.draw(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		getBuilderByCommand().doMousePressed(this, e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int result = getBuilderByCommand().doMouseReleased(this, e);
		if(result == GeometryBuilder.DONE){
			Geometry g = getBuilderByCommand().getGeometry();
			this.geometries.add(g);
			this.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		getBuilderByCommand().doMouseMoved(this, e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		PaintContext.mainFrame.showCoordInfo(e.getX(), e.getY());
	}
}
