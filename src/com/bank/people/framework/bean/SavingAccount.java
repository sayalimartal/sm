package com.bank.people.framework.bean;



public abstract class SavingAccount extends BankAccount {
	
	private boolean salary;
	private double MIN_BAL;
	
	public SavingAccount(Customer accountHolder, double accountBalance, boolean salary) {
		super(accountHolder, accountBalance);
		this.salary = salary;
		MIN_BAL = 5000;
	}
	
	public boolean isSalary() {
		return salary;
	}

	public void setSalary(boolean salary) {
		this.salary = salary;
		if(salary)
			this.MIN_BAL =0;
		else
			this.MIN_BAL = 5000;
	}

	public double getMIN_BAL() {
		return MIN_BAL;
	}

	public void setMIN_BAL(double mIN_BAL) {
		MIN_BAL = mIN_BAL;
	}

	public abstract String withdraw(double amount);

	@Override
	public String toString() {
		return "SavingAccount [salary=" + salary + ", MIN_BAL=" + MIN_BAL + ", toString()=" + super.toString() + "]";
	}

}
