import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterFrame extends JFrame{

	int FRAME_WIDTH = 380;
	int FRAME_HEIGHT = 600;
	int FIELD_WIDTH =10;
	int AREA_WIDTH=30;
	int AREA_HEIGHT=10;
	
	
	final Register register;
	JPanel panel;
	JLabel studentIDLabel;
	JLabel courseIDLabel;
	JTextField studentIDField;
	JTextField courseIDField;
	JButton studentInfoButton;
	JButton courseInfoButton;
	JButton enrollButton;
	JButton dropButton;
	JScrollPane scrollPane;
	JTextArea outputTextArea;
	JMenuBar menuBar;
	JMenu file;
	JMenu manage;
	JMenuItem Show_students;
	JMenuItem Show_courses;
	JMenuItem exit;
	JMenuItem student;
	JMenuItem course;
	
	
	public RegisterFrame() {
		
		register = new Register();
		register.addCourse("306049001", "OOPI", 2);
		register.addCourse("306005001", "ICS", 2); //Introduction to Computer Science 
		register.addCourse("001303999", "Intern", 23); 
		register.addStudent("107306001", "A");
		register.addStudent("107306010", "B");
		
		
		creatPanel();
		setTitle("Course Register");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	}
	
	public void createStudentIDComp() {
		
		studentIDLabel = new JLabel("Student ID: ");
		studentIDField = new JTextField(FIELD_WIDTH);
		studentInfoButton = new JButton("Student INFO");
		
		class studentInfoButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
				
				String studentID = studentIDField.getText();
				Student student = register.findStudent(studentID);
				
				
				if(student != null) {
					outputTextArea.append(student.toString());
				}else {
					outputTextArea.append("False");
					}
			
			}
		
		}
		
		ActionListener studentInfoButtonActionListener = new studentInfoButtonActionListener();
		studentInfoButton.addActionListener(studentInfoButtonActionListener);
	}
	
	public void createCourseIDComp() {
		
		courseIDLabel = new JLabel("Course ID: ");
		courseIDField = new JTextField(FIELD_WIDTH);
		courseInfoButton = new JButton("Course INFO");
		
		class courseInfoButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
				
				String courseID = courseIDField.getText();
				Course course = register.findCourse(courseID);
				
				if(course != null) {
					outputTextArea.append(course.toString());
				}else {
					outputTextArea.append("False");
					}
			
			}
		
		}
		
		ActionListener courseInfoButtonActionListener = new courseInfoButtonActionListener();
		courseInfoButton.addActionListener(courseInfoButtonActionListener);
	}
	
	public void createEnrollBtn() {
		
		enrollButton = new JButton("Enroll");

		class enrollButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
				
				String studentID = studentIDField.getText();
				String courseID = courseIDField.getText();
				boolean result = register.enrollCourse(studentID, courseID);
				
				if(result == true) {
					outputTextArea.append("studentID enrolled in courseID");
				}else {
					outputTextArea.append("False");
					}
			
			}
		
		}
		
		ActionListener enrollButtonActionListener = new enrollButtonActionListener();
		enrollButton.addActionListener(enrollButtonActionListener);
		
	}
	
	public void createDropBtn() {
		
		dropButton = new JButton("Drop");

		class dropButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
				
				String studentID = studentIDField.getText();
				String courseID = courseIDField.getText();
				boolean result = register.dropCourse(studentID, courseID);
				
				if(result == true) {
					outputTextArea.append("studentID dropped out of courseID");
				}else {
					outputTextArea.append("False");
					}
			
			}
		
		}
		
		ActionListener dropButtonActionListener = new dropButtonActionListener();
		dropButton.addActionListener(dropButtonActionListener);
		
	}
	
	public void outputTextArea(){
		
		outputTextArea = new JTextArea(AREA_HEIGHT,AREA_WIDTH);
		scrollPane = new JScrollPane(outputTextArea);
		
		outputTextArea.setLineWrap(true);
				
	}
	
	public void createMenuBar() {
		
		
		
		file = new JMenu("File");
		manage = new JMenu("Manage");
		
		Show_students = new JMenuItem("Show students");
		Show_courses = new JMenuItem("Show courses");
		exit = new JMenuItem("Exit");
		
		student = new JMenuItem("Student");
		course = new JMenuItem("Course");
		
		
		
		file.add(Show_students);
		file.add(Show_courses);
		file.add(exit);
		
		manage.add(student);
		manage.add(course);
		
		
		
		
		class show_students_Listener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
		    {
				
				for(Student student:register.getstudentList()) {
					
					outputTextArea.append(student.toString());
				
				}
		        
		    }
		 	
		}      
		
		
		class show_courses_Listener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
		    {
				
				for(Course course:register.getcourseList()) {
					
					outputTextArea.append(course.toString());
					System.out.println(course.toString());
				}
		        
		    }
		 	
		} 
		
		class student_Listener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
		    {
				
				 JFrame studentFrame = new StudentFrame();
				 studentFrame.setTitle("Manage Students");
				 studentFrame.setLocation(380, 0);
		        
		    }
		 	
		} 
		
		class course_Listener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
		    {
				
				 JFrame courseFrame = new CourseFrame();
				 courseFrame.setTitle("Manage Courses");
				 courseFrame.setLocation(380, 0);
		        
		    }
		 	
		} 
		
		class exit_Listener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
		    {
				
				System.exit(0);
		        
		    }
		 	
		} 
		
		
		Show_students.addActionListener(new show_students_Listener());
		Show_courses.addActionListener(new show_courses_Listener());
		student.addActionListener(new student_Listener());
		course.addActionListener(new course_Listener());
		exit.addActionListener(new exit_Listener());
	}
	
	
	public void creatPanel() {
		
		panel = new JPanel();
		
		createStudentIDComp();
		createCourseIDComp();
		createEnrollBtn(); 
		createDropBtn ();
		createMenuBar();
		
		panel.add(this.studentIDLabel);
		panel.add(this.studentIDField);
		panel.add(this.studentInfoButton);
		panel.add(this.courseIDLabel);
		panel.add(this.courseIDField);
		panel.add(this.courseInfoButton);
		
		panel.add(this.enrollButton);
		panel.add(this.dropButton);
		
		outputTextArea();
		panel.add(this.scrollPane);
		
		this.add(panel);
		
		JMenuBar menuBar = new JMenuBar();     
		setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(manage);
	}
	
	
	public Register getRegister() {
		
		return(this.register);
	}
	
	
}
