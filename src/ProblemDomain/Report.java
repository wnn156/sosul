package ProblemDomain;

public class Report {
	private User reporter; //신고자
	private User suspect; //피신고자
	private String content; //내용
	
	public Report(){ //생성자
		reporter = null;
		suspect = null;
		content = null;
	}
	
	public Report(User reporter, User suspect, String content){ //생성자
		this.reporter = reporter;
		this.suspect = suspect;
		this.content = content;
	}
	
	public void report(){ //신고하기
		
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
