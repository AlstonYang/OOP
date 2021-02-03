import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CourseFrame extends RegisterFrame{

	int FRAME_WIDTH =360;
	int FRAME_HEIGHT = 180;
	int FIELD_WIDTH =10;
	
	JRadioButton addButton;
	JRadioButton deleteButton;
	
	JLabel courseIDLabel;
	JLabel courseNameLabel;
	JLabel courseCreditsLabel;
	
	JTextField courseIDField;
	JTextField courseNameField;
	JTextField courseCreditsField;
	
	JButton submitButton;
	JButton resetButton;
	
	Register register = this.getRegisterFromRegisterFrame();
	JPanel info;
	
	public CourseFrame() {
	
		this.creatPanel();
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void creatPanel() {
	
		addButton = new JRadioButton("Add");
		deleteButton = new JRadioButton("Delete");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(addButton);
		buttonGroup.add(deleteButton);
		addButton.setSelected(true);
		
		submitButton = new JButton("Submit");
		resetButton = new JButton("Reset");
		
		courseIDLabel = new JLabel("Student ID:");
		courseNameLabel = new JLabel("Student Name:");
		courseCreditsLabel = new JLabel("Course Credits");
		
		
		courseIDField = new JTextField(FIELD_WIDTH);
		courseNameField = new JTextField(FIELD_WIDTH);
		courseCreditsField = new JTextField(FIELD_WIDTH);
		
		info = new JPanel();
		info.setLayout(new GridLayout(3,3));
		info.add(this.courseIDLabel);
		info.add(this.courseIDField);
		info.add(this.courseNameLabel);
		info.add(this.courseNameField);
		info.add(this.courseCreditsLabel);
		info.add(this.courseCreditsField);
		
		class deleteButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
			
				courseNameField.setEditable(false);
				courseCreditsField.setEditable(false);
			}
		}
		
		class submitButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
				
				if(addButton.isSelected()) {
					
					register.addCourse(courseIDField.getText(), courseNameField.getText(), Integer.parseInt(courseCreditsField.getText()));
				
					
				}else if(deleteButton.isSelected()) {
				
					register.removeCourse(courseIDField.getText());
				
				}
			
			}
		
		}
		
		
		class resetButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
			
				courseIDField.setText(null);
				courseNameField.setText(null);
				courseCreditsField.setText(null);
			}
	
		}
	
			
		submitButton.addActionListener(new submitButtonActionListener());
		resetButton.addActionListener(new resetButtonActionListener());;
		deleteButton.addActionListener(new deleteButtonActionListener());
	
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		JPanel botton = new JPanel();
		
		top.add(addButton);
		top.add(this.deleteButton);
		
		center.add(this.info);
		
		botton.add(this.submitButton);
		botton.add(this.resetButton);
		
		add(top, BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		add(botton,BorderLayout.SOUTH);
	}
	
	private Register getRegisterFromRegisterFrame() {
		for(Frame frame: JFrame.getFrames()) { 
			if(frame.getTitle().equals("Course Register")) {
				RegisterFrame registerFrame = (RegisterFrame) frame; 
				return registerFrame.getRegister();
			
			}
		} 
	
		return null;
	}	
	
}
