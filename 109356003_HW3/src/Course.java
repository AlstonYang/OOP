
public class Course {

	String courseID;
	String courseName;
	int credits;
	
	public Course(String id, String name, int credits) {
		
		this.courseID=id;
		this.courseName=name;
		this.credits=credits;
		
	}
	
	public String getcourseID() {
		
		return(this.courseID);	
		
	}
	
	public String getcourseName() {
		
		return(this.courseName);
		
	}
	
	public int getcredits() {
		
		return(this.credits);
		
	}
	
	public String toString() {
		
		return(String.format("CourseID: %s, CourseName: %s, Credits: %d", 
			this.courseID,this.courseName,this.credits));
		
	}
	
	
}
