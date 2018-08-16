package com.bank.people.framework.bean;


public class PaymentGateway {
	
	public static boolean transfer(BankAccount sender, BankAccount receiver, double amount) {
		
		boolean status;
		if (sender.getAccountBalance() >= amount) {
			sender.withdraw(amount);
			receiver.deposit(amount);
			status = true;
		} else {
			status = false;
		}
		return status;
	}

}
