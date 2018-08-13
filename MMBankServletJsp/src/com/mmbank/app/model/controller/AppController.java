package com.mmbank.app.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moneymoney.app.model.account.pojo.MMCurrentAccount;
import com.moneymoney.app.model.account.pojo.MMCustomer;
import com.moneymoney.app.model.account.pojo.MMSavingsAccount;
import com.moneymoney.app.model.service.ServiceImpl;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;

@WebServlet("*.app")
public class AppController extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	ServiceImpl service = new ServiceImpl();
	BankAccount account = null;
	MMCustomer activecustomer = null;
	RequestDispatcher dispatcher = null;
	Map<String,String> loginDetails = new HashMap<>();
	ServletRequest session;
	
	public AppController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {	
		case "/addNewAccount.app":
			response.sendRedirect("AddNewAccount.jsp");
			break;
		case "/add.app":
			String name = request.getParameter("customerName");
			String email = request.getParameter("customerEmail");
			String dob = request.getParameter("dob");
			String contact = request.getParameter("contact");
			activecustomer = new MMCustomer(name,Long.parseLong(contact),dob,email);
			String choice = request.getParameter("accountType");
			String balance,odLimit = null;		
			if(choice.equals("savingaccount")) {
				String type = request.getParameter("salary");
				System.out.println(type);
				if(type.equals("Blue")) {
					balance = request.getParameter("salbal");
				}
				else {
					balance = request.getParameter("bal");
				}
				account = new MMSavingsAccount(activecustomer,Double.parseDouble(balance));
			}else {
				balance = request.getParameter("cbal");
				odLimit = request.getParameter("odLimit");
				account = new MMCurrentAccount(activecustomer,Double.parseDouble(balance),Double.parseDouble(odLimit));
			}
			System.out.println(name+""+email+""+dob+""+contact+""+choice+""+balance+""+odLimit+""+account.getAccountNumber());
			
			activecustomer.setAccountNumber(account.getAccountNumber());
			
			service.addBankAccount(account);
			service.addCustomer(activecustomer);
			request.setAttribute("accNo", account.getAccountNumber());
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;
		case "/searchAcc.app":
			int num = Integer.parseInt(request.getParameter("accNo"));
			request.setAttribute("accNo", num);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;
		case "/displayAccount.app":
			if(service.searchAccountById(((int)request.getAttribute("accNo"))) == null) {
				response.sendRedirect("AccountNotFound.jsp");
			}else {
			account = service.searchAccountById((int) request.getAttribute("accNo"));
			String classType = account.getClass().getName();
			System.out.println(classType);
			request.setAttribute("bankAccount", account);
			request.setAttribute("classType", classType);
			dispatcher = request.getRequestDispatcher("ViewAccount.jsp");
			dispatcher.forward(request, response);
			}
			break;
		case "/withdrawAmount.app":
			response.sendRedirect("withdraw.jsp");
			break;
		case "/depositAmount.app":
			response.sendRedirect("deposit.jsp");
			break;
		case "/withdraw.app":
			int accNo = Integer.parseInt(request.getParameter("accNo"));
			double amount = Double.parseDouble(request.getParameter("withdrawamount"));
			String msg = service.withdraw(accNo, amount);
			System.out.println(msg);
			request.setAttribute("accNo", accNo);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;
		case "/deposit.app":
			accNo = Integer.parseInt(request.getParameter("accNo"));
			amount = Double.parseDouble(request.getParameter("depositamount"));
			service.deposit(accNo, amount);
			request.setAttribute("accNo", accNo);
			System.out.println(accNo+"  jkbdabk  " +amount);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;
		case "/searchAccount.app":
			response.sendRedirect("SearchAccount.jsp");
			
			break;
		
		case "/viewAllCustomers.app":
			ArrayList<Customer> cust = service.viewAllCustomers();
			request.setAttribute("customers", cust);
			dispatcher = request.getRequestDispatcher("ViewAllCustomers.jsp");
			dispatcher.forward(request, response);
			break;
		case "/fundTransfer.app":
			int senderId = Integer.parseInt(request.getParameter("sender"));
			int receiverId = Integer.parseInt(request.getParameter("receiver"));
			amount = Double.parseDouble(request.getParameter("amount"));
			BankAccount senderAcc=service.searchAccountById(senderId);
			BankAccount receiverAcc=service.searchAccountById(receiverId);
			service.FundTransfer(senderAcc, receiverAcc, amount);
		default:
			response.sendRedirect("home.jsp");
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
