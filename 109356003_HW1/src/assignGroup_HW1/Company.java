package assignGroup_HW1;

import java.util.*;

public class Company {
	
	String name;
	ArrayList<Employee> employee = new ArrayList<>();
	WageAnalyzer wageAnalyzer;
	OvertimeAnalyzer overtimeAnalyzer;
	
	public Company (String name)
    {  
    	this.name = name;
    	
    }
	
	public void addEmployee(Employee employee) {
		
		this.employee.add(employee);	
		
	}
	
	public Employee findEmployee(String name) {

		Employee employe = null;
		
		for(Employee employee:employee) {
			
			if(employee.name == name) {
				employe = employee;	
			}
		}
		return employe;
	}
	
	public void addWorkDays(String name, int day) {
		
		
		if(this.findEmployee(name) != null) {
			
			Employee employee = this.findEmployee(name);
			employee.addWorkDays(day);
			
		}
	}
	
	public void overtimeWork(String name, int hour) {
		
		if(this.findEmployee(name) != null) {
			
			Employee employee = this.findEmployee(name);
			employee.overtimeWork(hour);
			
		}
	}	
	
	public String summaryWage() {
		
		String s=String.format(
				  "%10s%10s%n"
				+ "%10s%10s%15s%21s%7s%12s%n",
				"Company:","NCCU",
				"Name","WorkDay","OverTime Count","Overtime Hour(Total)","Wage","Title");
		
		for(int i=0;i< this.employee.size();i++) {
			s += String.format(
				"%10s%10d%15d%21d%7d%12s%n",
				employee.get(i).name,employee.get(i).workDay,employee.get(i).overtimeCount,employee.get(i).overtime,employee.get(i).payment(),employee.get(i).title
				);
		}
		return s;
	}
	
	public String analyzeWage() {
		wageAnalyzer = new WageAnalyzer(employee);
		return wageAnalyzer.summary();	
	}
	
	public String analyzeOvertime() {
		overtimeAnalyzer = new OvertimeAnalyzer(employee);
		return overtimeAnalyzer.summary();
		
	}
	
	
}
