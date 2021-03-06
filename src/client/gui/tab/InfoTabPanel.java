package client.gui.tab;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import info.User;

public class InfoTabPanel extends AbstractTabPanel {

	private DefaultListModel listModel;
	private JList list;
	
	
	public InfoTabPanel(User user) {
		super(user);
		
		// 사이즈 설정
		setSize(new Dimension(panelWidth, panelHeight));
		

		JLabel lblTitle = new JLabel("User Info");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblTitle.setBounds(40, 33, 240, 30);
		add(lblTitle);
		
		
		JLabel lblId = new JLabel("ID : " + user.getID());
		lblId.setBounds(40, 102, 180, 23);
		add(lblId);
		
		
		// Scroll 가능한 List 보여주는 객체 생성 (ScrollPane 안에 JList 넣음
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 150, 276, 194);
		add(scrollPane);

		
		// 테스트용 생성
		listModel = new DefaultListModel();
		listModel.addElement("가가가");
		
		JList list = new JList(listModel);
		scrollPane.setViewportView(list);

		
		// 더블 클릭 시 정보 보여주도록 함
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList) evt.getSource();
		        
		        // Double-click일 경우
		        if (evt.getClickCount() == 2) {
		        	// 클릭된 Index 가져옴
		            int index = list.locationToIndex(evt.getPoint());
		            
		            String selected = (String) listModel.getElementAt(index);
		            String msg = String.format("%s : %d만원", selected, index * 100);
		            
		            JOptionPane.showMessageDialog(InfoTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});
	}
	
	
	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}
}
