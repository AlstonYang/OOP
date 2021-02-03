package assignGroup_HW1;

import java.util.ArrayList;

public class OvertimeAnalyzer implements Analyzer {

	ArrayList<Employee> employee = new ArrayList<>();
	
	public OvertimeAnalyzer (ArrayList<Employee> employees){
		
		
		this.employee = employees;
		
	}
	@Override
	public String summary() {
		// TODO Auto-generated method stub
		return String.format(
				"%18s%7d%n"
				+ "%18s%7d%n"
				+ "%18s%7d%n"
				+ "%18s%7d%n"
				+ "%18s%7d%n",
				"Total employees:",this.count(),
				"Total wage:",this.sum(),
				"Average wage:",this.avg(),
				"Min wage:",this.min(),
				"Max wage:",this.max());
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count = 0;
		
		for(Employee employee:employee) {
			if(employee.overtimeCount !=0) {			
				count +=1;
			}	
		}
		return count;
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		int overtime = 0;
		
		for(Employee employee:employee) {
			if(employee.overtimeCount !=0) {			
				overtime +=employee.overtime;
			}	
		}
		return overtime;
	}

	@Override
	public int avg() {
		// TODO Auto-generated method stub
		return (this.sum()/this.count());
	}

	@Override
	public int max() {
		// TODO Auto-generated method stub
		int max = 0;
		
		for(Employee employee:employee) {
			if(employee.overtimeCount !=0) {			
				if(employee.overtime > max) {					
					max = employee.overtime;					
				}
			}	
		}
		return max;
	}

	@Override
	public int min() {
		// TODO Auto-generated method stub
		int min = 0;
		
		for(Employee employee:employee) {
			if(employee.overtimeCount !=0) {			
				if(-1*employee.overtime < min) {					
					min = employee.overtime;					
				}
			}	
		}
		
		return min;
	}

}
