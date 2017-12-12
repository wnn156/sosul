package ProblemDomain;

public class Report {
	private User reporter; //�Ű���
	private User suspect; //�ǽŰ���
	private String content; //����
	
	public Report(){ //������
		reporter = null;
		suspect = null;
		content = null;
	}
	
	public Report(User reporter, User suspect, String content){ //������
		this.reporter = reporter;
		this.suspect = suspect;
		this.content = content;
	}
	
	public void report(){ //�Ű��ϱ�
		
	}
	
	public void setReporter(User reporter){
		this.reporter = reporter;
	}
	public User getReporter(){
		return this.reporter;
	}
	
	public void setSuspect(User suspect){
		this.suspect = suspect;
	}
	public User getSuspect(){
		return this.suspect;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return this.content;
	}
}
