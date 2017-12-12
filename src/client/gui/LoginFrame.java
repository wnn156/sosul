package client.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import client.ChatClient;
import common.Message;
import common.gui.AbstractFrame;
import info.User;

/**
 * 
 * @author Wooyong Choi
 * 로그인을 하기 위한 프레임 
 * 
 */
public class LoginFrame extends AbstractFrame {

	
	private ChatClient client;
	
	private JTextField tfID;
	private JPasswordField tfPW;
	
	public LoginFrame(ChatClient chatClient) {
		// Size 넘겨 줌 (Width, Height)
		super(450, 270);

		this.client = chatClient;	
		
		// 전체 Client UI의 폰트를 Times 일반, 크기는 20으로 설정
        setUIFont(new FontUIResource(new Font("Times", Font.PLAIN, 20)));
		
		// 단순 Text 표시하는 객체(JLabel) 생성
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(116, 55, 62, 18);
		contentPane.add(lblID);
		
		JLabel lblPW = new JLabel("PW");
		lblPW.setBounds(116, 95, 62, 18);
		contentPane.add(lblPW);

		
		// Text 입력받을 수 있는 객체(JTextField) 생성
		tfID = new JTextField();
		tfID.setBounds(165, 49, 136, 30);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfPW = new JPasswordField();
		tfPW.setBounds(165, 89, 136, 30);
		contentPane.add(tfPW);
		tfPW.setColumns(10);
		
		
		// 로그인 및 회원가입 버튼(JButton) 표시
		JButton btnSignin = new JButton("Sign in");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 로그인 버튼이 눌렸을 때 수행
				// TextField에서 입력된 ID와 PW를 가져와서 유저 객체 생성
				String inputID = tfID.getText();
				String inputPW = tfPW.getText();
				User user = new User(inputID, inputPW);
				
				// 서버로 보내서 Check
				Message msg = null;
				try {
					client.sendToServer(new Message(user, 'c'));
					msg = client.receiveFromServer();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				switch(msg.getMode()) {
				case 's': // Success
			        // 유저를 담아서 MainFrame 켜기
					new MainFrame(user);
					
					// LoginFrame 종료
					dispose();
					break;
					
				case 'f': // Fail
					JOptionPane.showMessageDialog(LoginFrame.this, "Invalid ID or PW", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
			}
		});
		btnSignin.setBounds(82, 157, 105, 35);
		contentPane.add(btnSignin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 회원가입 버튼이 눌렸을 때 수행
				// ID와 PW를 입력받을 Dialog를 띄움
				String newID = JOptionPane.showInputDialog("Please input your ID.");
				String newPW = JOptionPane.showInputDialog("Please input your Password");
				User user = new User(newID, newPW);

				// 서버로 회원가입한 정보 Append
				try {
					client.sendToServer(new Message(user, 'a'));
					client.receiveFromServer();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(212, 157, 130, 35);
		contentPane.add(btnRegister);

		
		// 보이게 만듬
		setVisible(true);
	}
	
}
