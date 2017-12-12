package common;

import java.io.Serializable;

/**
 * 
 * @author WooYong
 * ��� �� �ְ� ���� ��Ŷ
 *
 */
public class Message implements Serializable {

	
	private Object data;
	
	/**
	 * Client�� Request <br>
	 *   a : Append <br>  
	 *   c : Check <br>
	 *   <br>
	 * Server�� Ack <br>
	 *   s : Sucess <br>  
	 *   f : Fail
	 */
	private char mode;
	

	public Message(char mode) {
		this.data = null;
		this.mode = mode;
	}
	
	public Message(Object data, char mode) {
		this.data = data;
		this.mode = mode;
	}

	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public char getMode() {
		return mode;
	}

	public void setMode(char mode) {
		this.mode = mode;
	}
}
