package server.gui;

import common.gui.AbstractFrame;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class ServerFrame extends AbstractFrame {

	private JTextArea textArea;
	
	public ServerFrame() {
		super(700, 700);
        
		getContentPane().setBackground(new Color(0xF6F6F6));
		
		JLabel lblServerLog = new JLabel("Server Log");
		lblServerLog.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblServerLog.setBounds(37, 29, 126, 23);
		getContentPane().add(lblServerLog);
		
		textArea = new JTextArea();
		textArea.setBounds(37, 74, 613, 554);
		textArea.setEditable(false);
		getContentPane().add(textArea);
		
		setVisible(true);
	}
	
	public void startLogging() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				PipedOutputStream pOut = new PipedOutputStream();
				System.setOut(new PrintStream(pOut));
				PipedInputStream pIn = null;
				try {
					pIn = new PipedInputStream(pOut);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader reader = new BufferedReader(new InputStreamReader(pIn));

				textArea.setText("Start to log");
				textArea.repaint();
		        
				while(true) {
				    try {
				        String line = reader.readLine();
				        if(line != null) {
				        	textArea.setText(textArea.getText() + '\n' + line);
				        	textArea.repaint();
				        }
				    } catch (IOException ex) {
				        // Handle ex
				    }
				}
				
			}
		}).start();
		
	}
}
