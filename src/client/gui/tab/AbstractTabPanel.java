package client.gui.tab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import info.User;

/**
 * 
 * @author Wooyong Choi
 * 탭 패널들의 공통 사항 제공
 * 
 */
public abstract class AbstractTabPanel extends JPanel {
	
	protected static int panelWidth = 887;
	protected static int panelHeight = 608;

	protected User user;
	
	
	public AbstractTabPanel(User user) {

		this.user = user;
		
		// 사이즈 설정
		setSize(new Dimension(panelWidth, panelHeight));
		
		// Panel의 색상 흰색으로 설정
		setBackground(new Color(0xEBF7FF));
		
		// Panel을 Absolute layout으로 설정 (좌표로 객체 위치 설정)
		setLayout(null);		
	}
	
}
