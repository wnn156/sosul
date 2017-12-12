package ProblemDomain;

public class Assessment {
	private float grade; //乞痢
	private String review; //府轰
	
	public Assessment(){ //积己磊
		this.grade = 0;
		this.review = null;
	}
	
	public Assessment(float grade, String review){ //积己磊
		this.grade = grade;
		this.review = review;
	}
	
	public void setGrade(float grade){
		this.grade = grade;
	}
	public float getGrade(){
		return this.grade;
	}
	public void setReview(String review){
		this.review = review;
	}
	
}
