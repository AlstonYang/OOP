import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentFrame extends RegisterFrame{

	int FRAME_WIDTH =360;
	int FRAME_HEIGHT = 160;
	int FIELD_WIDTH =10;
	
	JRadioButton addButton;
	JRadioButton deleteButton;
	JLabel studentIDLabel;
	JLabel studentNameLabel;
	JTextField studentIDField;
	JTextField studentNameField;
	JButton submitButton;
	JButton resetButton;
	Register register=this.getRegisterFromRegisterFrame();
	JPanel info;
	
	public StudentFrame() {
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.creatPanel();
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
		
		studentIDLabel = new JLabel("Student ID:");
		studentNameLabel = new JLabel("Student Name:");
		
		studentIDField = new JTextField(FIELD_WIDTH);
		studentNameField = new JTextField(FIELD_WIDTH);
		
		info = new JPanel();
		info.setLayout(new GridLayout(2,2));
		info.add(this.studentIDLabel);
		info.add(this.studentIDField);
		info.add(this.studentNameLabel);
		info.add(this.studentNameField);
		
		class deleteButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
			
				studentNameField.setEditable(false);
			}
		}
		
		class submitButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
				
				if(addButton.isSelected()) {
					
					register.addStudent(studentIDField.getText(), studentNameField.getText());
					System.out.println(register.getstudentList());
					
				}else if(deleteButton.isSelected()) {
				
					register.removeStudent(studentIDField.getText());
				
				}
			
			}
		
		}
		
		
		class resetButtonActionListener implements ActionListener{	
			public void actionPerformed(ActionEvent event) {
			
				studentIDField.setText(null);
				studentNameField.setText(null);
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
