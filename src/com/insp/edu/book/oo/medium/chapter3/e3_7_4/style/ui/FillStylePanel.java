package com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.ui;

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

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.FillStyle;
import com.sun.prism.BasicStroke;

/**
 * 填充样式设置界面
 * @author chb
 *
 */
public class FillStylePanel extends JPanel implements ActionListener{
	/**
	 * 当前设置的填充风格
	 */
	private FillStyle fillStyle = new FillStyle();
	
	private Box baseBox,boxV1,boxV2; 
	private JButton btnColor1;
	private JButton btnColor2;
	
	public FillStylePanel(){
		this.setBorder(BorderFactory.createTitledBorder("填充"));
		
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
				
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(boxV2);
		
		setLayout(new FlowLayout());
        add(baseBox); 
	}
	
	public FillStyle getFillStyle() {
		return fillStyle;
	}

	public void setFillStyle(FillStyle fillStyle) {
		this.fillStyle = fillStyle;
		
		btnColor1.setForeground(fillStyle.color1);
		btnColor2.setForeground(fillStyle.color2);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnColor1){
			fillStyle.color1 = JColorChooser.showDialog(this,"选色",fillStyle.color1);
			btnColor1.setForeground(fillStyle.color1);
		}else if(e.getSource() == btnColor2){
			fillStyle.color2 = JColorChooser.showDialog(this,"选色",fillStyle.color2);
			btnColor2.setForeground(fillStyle.color2);
		}
	}

	
}
