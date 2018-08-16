package com.cg.people.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.people.framework.bean.BankAccount;
import com.bank.people.model.service.BankServiceImpl;

@Controller
public class BankController {
	
	BankServiceImpl service = new BankServiceImpl();
	
	@RequestMapping("/withdrawAmount")
	public String withdrawAmount(@RequestParam("accountNumber") int accountNumber,@RequestParam("amount") double amount, Model model) {
		
		String result= service.withdraw(accountNumber, amount);
		model.addAttribute("result", result);
		model.addAttribute("bankAccount", service.getAccountById(accountNumber));
		model.addAttribute("classType",service.getAccountById(accountNumber).getClass().getSimpleName());
		return "DisplayMessage";	
	}
	
	@RequestMapping("/depositAmount")
	public String depositAmount(@RequestParam("accountNumber") int accountNumber,@RequestParam("amount") double amount, Model model) {
		service.deposit(accountNumber, amount);
		model.addAttribute("bankAccount", service.getAccountById(accountNumber));
		model.addAttribute("classType",service.getAccountById(accountNumber).getClass().getSimpleName());
		System.out.println(service.getAccountById(accountNumber).toString());
		return "ViewAccount";	
	}
	
	@RequestMapping("/transfer")
	public String transfer(@RequestParam("sender") int senderId,@RequestParam("receiver") int receiverId,@RequestParam("amount") double amount, Model model) {
		BankAccount senderAcc=service.getAccountById(senderId);
		BankAccount receiverAcc=service.getAccountById(receiverId);
		boolean success = service.fundTransfer(senderAcc,receiverAcc,amount);
		String result;
		if(success == true)
			result=receiverId+" received Rs. "+amount+" from "+senderId;
		else
			result="Fund transfer failed";	
		
		model.addAttribute("result", result);
		return "DisplayMessage";	
	}
	
	@RequestMapping("/accountDetail")
	public String accountDetail() {
		return "ViewAccount";	
	}

}
