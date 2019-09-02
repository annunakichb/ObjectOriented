package com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.LineStyle;
import com.sun.prism.BasicStroke;

/**
 * 线条样式设置界面
 * @author chb
 *
 */
public class LineStylePanel extends JPanel implements ActionListener,ItemListener{
	/**
	 * 当前设置的线条样式
	 */
	protected LineStyle lineStyle = new LineStyle();
	
	private Box baseBox,boxV1,boxV2; 
	private JButton btnColor1;
	private JButton btnColor2;
	private JComboBox cmbWidth;
	private JComboBox cmbLineType;
	
	public LineStylePanel(){
		this.setBorder(BorderFactory.createTitledBorder("线"));
		
		boxV1 = Box.createVerticalBox();
		boxV2 = Box.createVerticalBox();
		
		boxV1.add(new JLabel("颜色1:"));
		btnColor1 = new JButton("选择");
		btnColor1.addActionListener(this);
		boxV2.add(btnColor1);
		
		boxV1.add(new JLabel("颜色2:"));
		btnColor2 = new JButton("选择");
		btnColor2.addActionListener(this);
		boxV2.add(btnColor2);
		
		boxV1.add(new JLabel("线宽:"));
		cmbWidth = new JComboBox(new String[]{ "1px", "2px", "3px", "4px", "5px" });
		cmbWidth.addItemListener(this);
		boxV2.add(cmbWidth);
		
		boxV1.add(new JLabel("线型:"));
		cmbLineType = new JComboBox(new String[]{ "实线", "虚线"});
		cmbLineType.addItemListener(this);
		boxV2.add(cmbLineType);
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(boxV2);
		
		setLayout(new FlowLayout());
        add(baseBox); 
		
	}
		
	public LineStyle getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
		
		btnColor1.setForeground(lineStyle.color1);
		btnColor2.setForeground(lineStyle.color2);
		cmbWidth.setSelectedIndex(lineStyle.width-1);
		
		if(lineStyle.style == LineStyle.SOLID){
			cmbLineType.setSelectedIndex(0);
		}else{
			cmbLineType.setSelectedIndex(1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnColor1){
			lineStyle.color1 = JColorChooser.showDialog(this,"选色",lineStyle.color1);
			btnColor1.setForeground(lineStyle.color1);
		}else if(e.getSource() == btnColor2){
			lineStyle.color2 = JColorChooser.showDialog(this,"选色",lineStyle.color2);
			btnColor2.setForeground(lineStyle.color2);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cmbWidth){
			lineStyle.width = cmbWidth.getSelectedIndex() + 1;
		}else if(e.getSource() == cmbLineType){
			if(cmbLineType.getSelectedIndex() == 0){
				lineStyle.style = LineStyle.SOLID;
			}else{
				lineStyle.style = LineStyle.DASHED;
			}
		}
	}
	
}
