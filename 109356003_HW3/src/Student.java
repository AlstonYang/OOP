import java.util.*;

public class Student {

	String studentID;
	String studentName;
	ArrayList<String> enrolledCourses;
	int currentCredits;
	int maxCredits;
	
	public Student(String studentID, String name) {
		
		this.studentID = studentID;
		this.studentName = name;
		this.maxCredits = 25;
		this.currentCredits=0;
		enrolledCourses = new ArrayList<>();
	}
	
	public String getStudentID() {
		
		return(this.studentID);	
		
	}
	
	public String getStudentName() {
		
		return(this.studentName);
		
	}
	public ArrayList<String> getenrolledCourses() {
		
		return(this.enrolledCourses);
		
	}
	public int getcurrentCredits() {
		
		return(this.currentCredits);
		
	}
	public int getmaxCredits() {
		
		return(this.maxCredits);
		
	}
	public void setcurrentCredits(int currentCredits) {
		
		this.currentCredits=currentCredits;
		
	}
	public void setmaxCredits(int maxCredits) {
		
		this.maxCredits=maxCredits;
		
	}
	public String toString() {
		
		return(String.format("StudentID: %s, StudentName: %s, EnrolledCourses: %s, CurrentCredits: %d, MaxCredits: %d", 
			this.studentID,this.studentName,this.enrolledCourses,this.currentCredits,this.maxCredits));
		
	}
}
