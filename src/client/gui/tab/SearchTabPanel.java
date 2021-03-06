package client.gui.tab;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import info.Product;
import info.User;

public class SearchTabPanel extends AbstractTabPanel {

	private DefaultListModel listModel;
	private JList list;

	private JButton btnContract;
	final JRadioButton rd1;
	final JRadioButton rd2;

	final List<Product> testProduct1 = new ArrayList<>();
	final List<Product> testProduct2 = new ArrayList<>();
	
	public SearchTabPanel(User user) {
		super(user);
		
		// 테스트용 제품 생성
		testProduct1.add(new Product("item1", "./figures/picture1.png", 1100000));
		testProduct1.add(new Product("item2", "./figures/picture2.png", 1400000));
		testProduct1.add(new Product("item3", "./figures/picture3.png",  900000));
		testProduct2.add(new Product("item4", "./figures/picture4.png", 2200000));
		testProduct2.add(new Product("item5", "./figures/picture5.png", 3400000));
		testProduct2.add(new Product("item6", "./figures/picture6.png", 5600000));
		
		// GUI part
		JLabel lblTitle = new JLabel("Search");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblTitle.setBounds(40, 33, 240, 30);
		add(lblTitle);
		
		
		JLabel lblForSale = new JLabel("Item List");
		lblForSale.setBounds(40, 116, 122, 24);
		add(lblForSale);
		
		
		// 이름과 가격 출력
		final JTextArea lblProductName = new JTextArea();
		lblProductName.setBounds(600, 222, 80, 30);
		lblProductName.setText("Name :");
		add(lblProductName);
		
		final JTextArea lblProductPrice = new JTextArea();
		lblProductPrice.setBounds(600, 262, 80, 30);
		lblProductPrice.setText("Price : ");
		add(lblProductPrice);
		
		final JTextField txtProductName = new JTextField();
		txtProductName.setBounds(700, 222, 150, 30);
		add(txtProductName);
		
		final JTextField txtProductPrice = new JTextField();
		txtProductPrice.setBounds(700, 262, 150, 30);
		add(txtProductPrice);
		
		
		// 제품 이미지를 Label의 Icon으로 설정
		final JLabel lblProductImage = new JLabel();
		lblProductImage.setBounds(607, 275, 180, 280);
		add(lblProductImage);
		

		// Scroll 가능한 List 보여주는 객체 생성 (ScrollPane 안에 JList 넣음
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 150, 530, 425);
		add(scrollPane);

		
		// Listmodel 생성 (List의 element에 대한 정보를 지님)
		listModel = new DefaultListModel();
		for (Product element : testProduct1) {
			listModel.addElement(element.getName());
		}
		
		// Listmodel을 연결한 JList 생성하고 Scroll 가능한 Panel에 추가 
		list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		
		// 리스트에서 클릭 시 제품 정보와 사진 출력
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
		        // 클릭된 경우 정보 표시
	            int index = list.getSelectedIndex();
	            if ( index < 0 ) return ;
	            if ( rd1.isSelected() ) {
	            	if ( index >= testProduct1.size() ) return ;
	            	Product selected = testProduct1.get(index);
	            	txtProductName.setText(selected.getName());
	            	txtProductPrice.setText(selected.getPrice()+"");
		    		lblProductImage.setIcon(new ImageIcon(selected.getFigurePath()));
				} else if ( rd2.isSelected() ) {
					if ( index >= testProduct2.size() ) return ;
					Product selected = testProduct2.get(index);
	            	txtProductName.setText(selected.getName());
	            	txtProductPrice.setText(selected.getPrice()+"");
		    		lblProductImage.setIcon(new ImageIcon(selected.getFigurePath()));
				}
			}
		});
		
		
		// 리스트에서 더블 클릭 시 정보 보여주도록 함
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList) evt.getSource();
		        
		        if (evt.getClickCount() != 0) {
		        }
		        // Double-click일 경우
		        if (evt.getClickCount() == 2) {
		        	// 클릭된 Index 가져옴
		            int index = list.locationToIndex(evt.getPoint());
		            if ( index < 0 ) return ;
		            
		            if ( rd1.isSelected() ) {
		            	if ( index >= testProduct1.size() ) return ;
		            	Product selected = testProduct1.get(index);
			            String msg = String.format("%s : %,d원", selected.getName(), selected.getPrice());
			            JOptionPane.showMessageDialog(SearchTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
					} else if ( rd2.isSelected() ) {
						if ( index >= testProduct2.size() ) return ;
						Product selected = testProduct2.get(index);
			            String msg = String.format("%s : %,d원", selected.getName(), selected.getPrice());
			            JOptionPane.showMessageDialog(SearchTabPanel.this, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
					}
		        }
		    }
		});
		
		// 옵션 선택에 따라 리스트 정보 변경
		ButtonGroup optionGroup = new ButtonGroup();
		rd1 = new JRadioButton("option1");
		rd2 = new JRadioButton("option2");
		rd1.setBounds(40, 70, 100, 30);
		rd2.setBounds(140, 70, 100, 30);
		optionGroup.add(rd1);
		optionGroup.add(rd2);
		add(rd1);
		add(rd2);
		rd1.addItemListener(new RadioButtonSelectedEvent());
		rd2.addItemListener(new RadioButtonSelectedEvent());
		// 기본으로 선택된 옵션1
		rd1.setSelected(true);
		

		// 계약 버튼 추가
		// 계약 버튼에 대한 Listener는 MainFrame에 있음
		// 왜냐하면 SearchTab의 객체가 InfoTab의 객체에 접근할 필요가 있기 때문
		btnContract = new JButton("Contract");
		btnContract.setBounds(607, 150, 181, 51);
		add(btnContract);
		
		// 새로 데이터를 추가하는 버튼
		JButton btnNewData = new JButton("Add new Data");
		btnNewData.setBounds(607, 500, 181, 45);
		add(btnNewData);
		btnNewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 옵션 1 일 때 보여줄 리스트
				if ( rd1.isSelected() ) {
					testProduct1.add(new Product(txtProductName.getText(), "", Integer.parseInt(txtProductPrice.getText())));
				} else if ( rd2.isSelected() ) {
					// 옵션 2 일 때 보여줄 리스트
					testProduct2.add(new Product(txtProductName.getText(), "", Integer.parseInt(txtProductPrice.getText())));
				}
				updateList();
			}
		});
		
		// 기존 데이터를 삭제하는 버튼
		JButton btnDelData = new JButton("Del existing Data");
		btnDelData.setBounds(607, 550, 181, 45);
		add(btnDelData);
		btnDelData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				// 옵션 1 일 때 
				if ( rd1.isSelected() ) {
					testProduct1.remove(index);
				} else if ( rd2.isSelected() ) {
					// 옵션 2 일 때 
					testProduct2.remove(index);
				}
				updateList();
			}
		});
	}
	
	// class 형식으로 이벤트를 표현하는 방법
	class RadioButtonSelectedEvent implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			updateList();
		}
	}
	
	private void updateList() {
		// 옵션 1 일 때 보여줄 리스트
		listModel.clear();
		if ( rd1.isSelected() ) {
			for (Product element : testProduct1) {
				listModel.addElement(element.getName());
			}
		} else if ( rd2.isSelected() ) {
			// 옵션 2 일 때 보여줄 리스트
			for (Product element : testProduct2) {
				listModel.addElement(element.getName());
			}
		}
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

	public JButton getBtnContract() {
		return btnContract;
	}


	public void setBtnContract(JButton btnContract) {
		this.btnContract = btnContract;
	}
}