package com.bank.people.model.bean;

import com.bank.people.framework.bean.CurrentAccount;
import com.bank.people.framework.bean.Customer;

public class PeopleCurrentAccount extends CurrentAccount {

	public PeopleCurrentAccount(Customer accountHolder, double accountBalance, double odLimit) {
		super(accountHolder, accountBalance, odLimit);
	}

	@Override
	public String withdraw(double amount) {
		String result;
		if(amount <= (this.getAccountBalance() + getOdLimit())) {
			this.setAccountBalance(this.getAccountBalance()+ getOdLimit() - amount);
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
			result = "Withdrawal exceeds OD Limit!";
		}
		return result;
	}
	
	public void deposit(double amount) {
		super.deposit(amount);
	}

}
