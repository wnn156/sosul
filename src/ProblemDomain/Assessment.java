package ProblemDomain;

public class Assessment {
	private float grade; //����
	private String review; //����
	
	public Assessment(){ //������
		this.grade = 0;
		this.review = null;
	}
	
	public Assessment(float grade, String review){ //������
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
