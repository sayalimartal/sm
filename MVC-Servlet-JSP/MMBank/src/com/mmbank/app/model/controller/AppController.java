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
	ServiceImpl serviceImpl = new ServiceImpl();
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
//		case "/login.app":
//			response.sendRedirect("login.jsp");
//			break;
//		
//		case "/validate.app":
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			String savedPassword = loginDetails.get(username);
//			if(savedPassword.equals(password)) {
//				session.setAttribute("user",username);
//				response.sendRedirect("home.jsp");
//			}
//			else {
//				response.sendRedirect("error.jsp");
//			}
//			break;
//		case "/signnup.app":
//			username = request.getParameter("username");
//			password = request.getParameter("password");
//			loginDetails.put(username, password);
//			response.sendRedirect("login.jsp");
//			break;	
		case "/addNewAccount.app":
			response.sendRedirect("addNewAccount.jsp");
			break;
		case "/add.app":
			String name = request.getParameter("customerName");
			String email = request.getParameter("customerEmail");
			String dob = request.getParameter("dob");
			String contact = request.getParameter("contact");
			activecustomer = new MMCustomer(name,Long.parseLong(contact),dob,email);
			String choice = request.getParameter("accountType");
			String balance,odLimit = null;
			boolean sal;
			if(choice.equals("savingaccount")) {
				String type = request.getParameter("salary");
				System.out.println(type);
				if(type.equals("Blue")) {
					sal=true;
					balance = request.getParameter("salbal");
				}
				else {
					balance = request.getParameter("bal");
					sal = false;
				}
				account = new MMSavingsAccount(activecustomer,Double.parseDouble(balance),sal);
			}else {
				balance = request.getParameter("cbal");
				odLimit = request.getParameter("odLimit");
				account = new MMCurrentAccount(activecustomer,Double.parseDouble(balance),Double.parseDouble(odLimit));
			}
			System.out.println(name+""+email+""+dob+""+contact+""+choice+""+balance+""+odLimit+""+account.getAccountNumber());
			
			activecustomer.setAccountNumber(account.getAccountNumber());
			
			serviceImpl.addBankAccount(account);
			serviceImpl.addCustomer(activecustomer);
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
			if(serviceImpl.searchAccountById(((int)request.getAttribute("accNo"))) == null) {
				response.sendRedirect("AccountNotFound.jsp");
			}else {
			account = serviceImpl.searchAccountById((int) request.getAttribute("accNo"));
			String classType = account.getClass().getSimpleName();
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
			String msg = serviceImpl.withdraw(accNo, amount);
			System.out.println(msg);
			request.setAttribute("accNo", accNo);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;
		case "/deposit.app":
			accNo = Integer.parseInt(request.getParameter("accNo"));
			amount = Double.parseDouble(request.getParameter("depositamount"));
			serviceImpl.deposit(accNo, amount);
			request.setAttribute("accNo", accNo);
			System.out.println(accNo+"  jkbdabk  " +amount);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;
		case "/searchAccount.app":
			response.sendRedirect("searchAcc.jsp");
			
			break;
		case "/fundTransfer.app":
			response.sendRedirect("payment.jsp");
			break;
		case "/transfer.app":
			int sender = Integer.parseInt(request.getParameter("sender"));
			int reciever = Integer.parseInt(request.getParameter("reciever"));
			amount = Double.parseDouble(request.getParameter("amount"));
			System.out.println(sender+" "+amount+" "+ reciever);
			msg = serviceImpl.withdraw(sender, amount);
			System.out.println(msg);
			serviceImpl.deposit(reciever, amount);
			request.setAttribute("sender", sender);
			request.setAttribute("reciever", reciever);
			request.setAttribute("amount", amount);
			dispatcher = request.getRequestDispatcher("fundTransfer.jsp");
			dispatcher.forward(request, response);
			break;
		case "/viewAllCustomers.app":
			ArrayList<Customer> cust = serviceImpl.viewAllCustomers();
			request.setAttribute("customers", cust);
			dispatcher = request.getRequestDispatcher("viewAllCustomers.jsp");
			dispatcher.forward(request, response);
			break;
		default:
			response.sendRedirect("home.jsp");
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
