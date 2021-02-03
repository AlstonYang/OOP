package assignGroup_HW1;

public class Manager extends Employee{

	double bonusRate;
	
	public Manager(String name, String title, int dailyWage, double bonusRate)
    {  
		super(name,title,dailyWage);
		this.bonusRate = bonusRate;
    }
	
	public int payment()
	   {
			int wage =(int) Math.round(super.payment()*this.bonusRate);
			return wage;	
	   } 
}
