package com.bank.people.model.bean;

import com.bank.people.framework.bean.Customer;
import com.bank.people.framework.bean.SavingAccount;

public class PeopleSavingAccount extends SavingAccount {

	public PeopleSavingAccount(Customer accountHolder, double accountBalance, boolean salary) {
		super(accountHolder, accountBalance, salary);
	}

	@Override
	public String withdraw(double amount) {
		String result;
		if(amount <= (this.getAccountBalance() - super.getMIN_BAL())) {
			this.setAccountBalance(this.getAccountBalance() - amount);
				int twoThousand = (int)amount/2000;
				amount = amount%2000;
				int fiveHundred = (int)amount/500;
				amount = amount%500;
				int hundred = (int)amount/100;
				amount = amount%100;
				String denominations =  twoThousand+" two thousand notes"+"\n"+fiveHundred+" five hundred notes "+"\n"+hundred+" hundred notes";
				result=denominations;
		}
		else
		{
			result = "Suffcient balance not available for withdrawal";
		}
		return result;
	}
	
	public void deposit(double amount) {
		super.deposit(amount);
	}

	@Override
	public String toString() {
		return "PeopleSavingAccount [toString()=" + super.toString() + "]";
	}

}
