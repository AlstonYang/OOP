import java.util.*;


public class Register {

	ArrayList<Student> studentList;
	ArrayList<Course> courseList ;
	
	public Register() {
		
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		
	}
	
	public ArrayList<Student> getstudentList(){
		
		return(this.studentList);
		
	}
	
	public ArrayList<Course> getcourseList(){
		
		return(this.courseList);
		
	}
	
	
	public void addStudent(String id, String name) {
		
		Student student = new Student(id,name);
		studentList.add(student);
		
	}
	
	public void addCourse(String id, String name, int credits) {
		
		Course course = new Course(id,name,credits);
		courseList.add(course);
	}
	
	public Student findStudent(String studentID) {
		Student re_student=null;
		
		for(Student student:studentList) {
			if(student.getStudentID().equals(studentID)) {
				re_student=student;
			}
		}
		return re_student;
	}
	
	public Course findCourse(String courseID) {
		Course re_course=null;
		
		for(Course course:courseList) {
			if(course.getcourseID().equals(courseID)) {
				re_course = course;
			}
		}
		return re_course;	
	}
	
	public boolean enrollCourse(String studentID, String courseID) {
		
		boolean result=false;
		Student student = this.findStudent(studentID);
		Course course = this.findCourse(courseID);
		
		if(student!=null &&course!=null) {
			if(student.getcurrentCredits()+course.getcredits()<student.getmaxCredits()){
				if(!student.getenrolledCourses().contains(course.courseID)) {	
					student.setcurrentCredits(student.getcurrentCredits()+course.credits);
					student.enrolledCourses.add(course.courseID);
					result=true;
				}
			}
		}
		return(result);
	}
	
	public boolean dropCourse(String studentID, String courseID) {
		
		boolean result=false;
		Student student = this.findStudent(studentID);
		Course course = this.findCourse(courseID);
		
		if(student!=null &&course!=null) {
			if(student.enrolledCourses.contains(course.courseID)){
					student.setcurrentCredits(student.getcurrentCredits()-course.credits);
					student.enrolledCourses.remove(course.courseID);
					result=true;
			}
		}
		return(result);
		
		
	}
	
	public void removeStudent(String studentID) {
		
		this.studentList.remove(this.findStudent(studentID));
	
	}
	
	public void removeCourse(String courseID) {
		
		this.courseList.remove(this.findCourse(courseID));
	
	}
	
	
	
	
}
