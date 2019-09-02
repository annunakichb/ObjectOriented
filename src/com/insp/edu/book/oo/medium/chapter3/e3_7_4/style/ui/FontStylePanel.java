package com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.insp.edu.book.oo.medium.chapter3.e3_7_4.style.FontStyle;

/**
 * 字体样式设置界面
 * @author chb
 *
 */
public class FontStylePanel extends JPanel implements ActionListener,ItemListener,ChangeListener{
	/**
	 * 当前设置的字体样式
	 */
	private FontStyle fontStyle = new FontStyle();
	
	private Box baseBox,boxV1,boxV2; 
	private JButton btnColor;
	private JComboBox cmbFontFamily;
	private JComboBox cmbFontSize;
	private JCheckBox cbBold;
	private JCheckBox cbItalic;
	
	public FontStylePanel(){
		this.setBorder(BorderFactory.createTitledBorder("字体"));
		
		boxV1 = Box.createVerticalBox();
		boxV2 = Box.createVerticalBox();
		
		boxV1.add(new JLabel("颜色:"));
		btnColor = new JButton("选择");
		btnColor.addActionListener(this);
		boxV2.add(btnColor);
		
		// 初始化字体名称  
        GraphicsEnvironment ge = GraphicsEnvironment  
                .getLocalGraphicsEnvironment();  
        String[] fontNames = ge.getAvailableFontFamilyNames();  
        cmbFontFamily = new JComboBox(fontNames);
        cmbFontFamily.addItemListener(this);
        boxV1.add(new JLabel("字体:"));
        boxV2.add(cmbFontFamily);
        // 初始化字体大小  
        String[] fontSizes = { "8", "9", "10", "11", "12", "14", "16", "18",  
                "20", "22", "24", "26", "28", "36", "48", "72" };  
        cmbFontSize = new JComboBox(fontSizes);
        boxV1.add(new JLabel("大小:"));
        boxV2.add(cmbFontSize);
        
        
        cbBold = new JCheckBox("粗体");
        cbBold.addChangeListener(this);
        boxV1.add(cbBold);
        
        cbItalic = new JCheckBox("斜体");
        cbItalic.addChangeListener(this);
        boxV2.add(cbItalic);
     
        baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(boxV2);
		
		setLayout(new FlowLayout());
        add(baseBox); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fontStyle.color = JColorChooser.showDialog(this,"选色",fontStyle.color);
		btnColor.setForeground(fontStyle.color);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cmbFontFamily){
			String fontName = cmbFontFamily.getSelectedItem().toString();
			fontStyle.font = new Font(fontName,fontStyle.font.getStyle(),fontStyle.font.getSize());
		}else if(e.getSource() == cmbFontSize){
			String fontSize = cmbFontFamily.getSelectedItem().toString();
			int size = Integer.parseInt(fontSize);
			fontStyle.font = new Font(fontStyle.font.getFamily(),fontStyle.font.getStyle(),size);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		boolean bold = cbBold.isSelected();
		boolean italic = cbItalic.isSelected();
		
		int style = 0;
		if(bold)style = style | Font.BOLD;
		if(italic)style = style | Font.ITALIC;
		
		fontStyle.font = new Font(fontStyle.font.getFamily(),style,fontStyle.font.getSize());
	}

	public FontStyle getFontStyle() {
		return fontStyle;
	}
	
}
