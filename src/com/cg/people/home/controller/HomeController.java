package com.cg.people.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";	
	}
	
	@RequestMapping("/deposit")
	public String deposit() {
		return "DepositForm";	
	}
	
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "WithdrawForm";	
	}
	
	@RequestMapping("/fundtransfer")
	public String fundtransfer() {
		return "FundTransfer";	
	}

}
