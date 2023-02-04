package entities;

public class PersonalAccounting extends TaxPayer{
	
	private Double healthExpenses;
	
	public PersonalAccounting() {
		super();
	}
	
	public PersonalAccounting(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}
	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public double taxPayment() {
		
		double tax = 0;
		
		if(getAnnualIncome() < 20000.00 && getHealthExpenses() == 0.0) 
		{
			tax = (getAnnualIncome() * 0.15); 	
		}
		else if(getAnnualIncome() < 20000.00 && getHealthExpenses() >= 0.1) 
		{
			tax = (getAnnualIncome() * 0.15) - (getHealthExpenses() * 0.50);
		}
		else if(getAnnualIncome() > 20000.00 && getHealthExpenses() == 0.0)
		{
			tax = (getAnnualIncome() * 0.25);			
		}
		else
		{
			tax = (getAnnualIncome() * 0.25) - (getHealthExpenses() * 0.50);
		}
		
		return tax;
	}
	
}
