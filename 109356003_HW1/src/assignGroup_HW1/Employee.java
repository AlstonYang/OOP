package assignGroup_HW1;

public class Employee {
	
	String name;
	String title;
	int dailyWage;
	int workDay = 0;
	int overtimeCount = 0;
	int overtime = 0;
	
	public Employee (String name, String title, int dailyWage)
    {  
    	this.name = name;
    	this.title = title;
    	this.dailyWage = dailyWage;
    }
	
	public int payment()
	   {
			int wage = 0;
			
			wage = dailyWage * workDay + overtime * 150;
			
	      	return wage;
	   } 
	
	public void addWorkDays(int dayCount)
	   {
			this.workDay += dayCount;
	   } 
	
	public void overtimeWork(int hour)
	   {
			this.overtime += hour;
			this.overtimeCount += 1;
	   } 
	
}
