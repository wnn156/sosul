package client.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import client.gui.tab.InfoTabPanel;
import client.gui.tab.SearchTabPanel;
import common.gui.AbstractFrame;
import info.User;

/**
 * 
 * @author Wooyong Choi
 * 메인 기능을 제공할 프레임 
 * 
 */
public class MainFrame extends AbstractFrame {

	private User user;
	
	private InfoTabPanel infoTab;
	private SearchTabPanel searchTab;
	
	public MainFrame(User user) {
		// Size 넘겨 줌 (Width, Height)
		super(900, 800);
		
		// 넘어온 유저 정보 받아둠
		this.user = user;
		
		
		JLabel lblTitle = new JLabel("My Program");
		lblTitle.setBounds(20, 20, 340, 70);
		contentPane.add(lblTitle);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		
		
		// 유저 정보 표시
		JLabel lblUserInfo = new JLabel("User : " + user.getID());
		lblUserInfo.setBounds(738, 50, 176, 18);
		contentPane.add(lblUserInfo);
		
		
		// TabPanel 생성해서 Tab 추가
		infoTab = new InfoTabPanel(user);
		searchTab = new SearchTabPanel(user);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(7, 125, 880, 640);
		tabbedPane.add("My Infomation", infoTab);  // 내 정보 탭 추가
		tabbedPane.add("Search", searchTab);  // 검색 탭 추가
		contentPane.add(tabbedPane);
		
		
		// SearchTab의 Contract 버튼 클릭 시 InfoTab의 List에 추가 
		searchTab.getBtnContract().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = searchTab.getList().getSelectedIndex();
				
				String selected = (String) searchTab.getListModel().getElementAt(index);
				infoTab.getListModel().addElement(selected);
		    	
	            JOptionPane.showMessageDialog(searchTab, "Success to contract", "Infomation", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		// 보이게 만듬
		setVisible(true);
	}
}

