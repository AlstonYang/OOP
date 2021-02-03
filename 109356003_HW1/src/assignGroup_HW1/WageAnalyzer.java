package assignGroup_HW1;

import java.util.ArrayList;
import java.util.Collections;

public class WageAnalyzer implements Analyzer {

	ArrayList<Employee> employee = new ArrayList<>();
	
	public WageAnalyzer (ArrayList<Employee> employees){
		
		
		this.employee = employees;
		
	}
	
	
	
	@Override
	public String summary() {
		// TODO Auto-generated method stub
		String s = String.format(
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
		
		return s;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return employee.size();
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(Employee employee : employee) {
			
			sum += employee.payment();		
		}
		
		return sum;
	}

	@Override
	public int avg() {
		// TODO Auto-generated method stub	
		return (this.sum() / this.count());
	}

	@Override
	public int max() {
		// TODO Auto-generated method stub
		int max = 0;
	    for(int i=0; i<employee.size(); i++){
	        
	    	if(employee.get(i).payment() > max){
	            max = employee.get(i).payment();
	        }
	    }    
		return max;
	}

	@Override
	public int min() {
		// TODO Auto-generated method stub
		int min = 0;
	    for(int i=0; i<employee.size(); i++){
	        
	    	if(employee.get(i).payment() * -1 > min){
	            min = employee.get(i).payment();
	        }
	    	
	    	min *= -1;
	    }    
		return min;
	}

}
