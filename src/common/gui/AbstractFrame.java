package common.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * 
 * @author Wooyong Choi
 * �����ӵ��� ���� ���� ����
 * 
 */
public abstract class AbstractFrame extends JFrame {

	protected Container contentPane;
	
	
	public AbstractFrame(int width, int height) {

		// �⺻ ���� (����, ������, �����ư)
		setTitle("GUI Framework");
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		// �ʱ� ��ġ ���� (�ػ� ���� ����� ��ġ�ϰ�)
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (int)(screen.getWidth() / 2 - width / 2);
        int yPos = (int)(screen.getHeight() / 2 - height / 2);
        this.setLocation(xPos, yPos);
		
		// Frame�� �⺻ ContnetPanel�� ������
		contentPane = getContentPane();
		
		// Panel�� ���� ������� ����
		contentPane.setBackground(Color.WHITE);
		
		// Panel�� Absolute layout���� ���� (��ǥ�� ��ü ��ġ ����)
		contentPane.setLayout(null);
	}
	
	// ��Ʈ ����
	protected static void setUIFont(FontUIResource f) {
		Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				FontUIResource orig = (FontUIResource) value;
				Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
				UIManager.put(key, new FontUIResource(font));
			}
		}
	}
}
