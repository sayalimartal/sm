package com.bank.people.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.people.framework.bean.BankAccount;
import com.bank.people.framework.bean.Customer;
import com.bank.people.model.bean.PeopleCurrentAccount;
import com.bank.people.model.bean.PeopleCustomer;
import com.bank.people.model.bean.PeopleSavingAccount;
import com.bank.people.model.service.BankServiceImpl;


/**
 * Servlet implementation class BankController
 */
@WebServlet("*.app")
public class BankController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	BankServiceImpl service = new BankServiceImpl();
	BankAccount account = null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		String action = request.getServletPath();
		System.out.println("123");
		System.out.println(action+"123");
		switch(action) 
		{
		case "/addNewAccount.app":
			
			response.sendRedirect("AddNewAccount.jsp");
			break;
			
		case "/addAccount.app":
			
			String name = request.getParameter("customerName");
			String email = request.getParameter("customerEmail");
			String dob = request.getParameter("dob");
			String contact = request.getParameter("contact");
			
			PeopleCustomer customer = new PeopleCustomer(name,Long.parseLong(contact),dob,email);
			
			String type = request.getParameter("accountType");
			String balance;
			boolean isSalary;
			
			if(type.equals("savingaccount")) {
				String salaryType = request.getParameter("salary");
				if(salaryType.equals("salaried")) {
					isSalary=true;
					balance = request.getParameter("salaryBal");
				}
				else {
					balance = request.getParameter("bal");
					isSalary = false;
				}
				account = new PeopleSavingAccount(customer,Double.parseDouble(balance),isSalary);
			}
			else {
				String odLimit = request.getParameter("odLimit");
				balance = request.getParameter("currentBal");
				account = new PeopleCurrentAccount(customer,Double.parseDouble(balance),Double.parseDouble(odLimit));
			}
			
			customer.setAccountNumbers(account.getAccountNumber());
			
			service.addAccount(account);
			service.addCustomer(customer);
			request.setAttribute("accountNumber", account.getAccountNumber());
			RequestDispatcher dispatcher = request.getRequestDispatcher("accountDetail.app");
			dispatcher.forward(request, response);
			break;
			
		case "/accountDetail.app":
			
			if(service.getAccountById((int)request.getAttribute("accountNumber")) == null) 
				response.sendRedirect("AccountNotFound.jsp");
			else {
			account = service.getAccountById((int) request.getAttribute("accountNumber"));
			String accountType = account.getClass().getSimpleName();

			request.setAttribute("accountType", accountType);
			request.setAttribute("account", account);
			
			dispatcher = request.getRequestDispatcher("ViewAccount.jsp");
			dispatcher.forward(request, response);
			}
			break;
			
		case "/search.app":
			
			response.sendRedirect("SearchAccount.jsp");
			break;
			
		case "/searchAccount.app":
			
			int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			request.setAttribute("accountNumber", accountNumber);
			
			dispatcher = request.getRequestDispatcher("accountDetail.app");
			dispatcher.forward(request, response);
			break;
			
		case "/viewAllCustomers.app":
			
			ArrayList<Customer> customers = service.viewAllCustomers();
			request.setAttribute("customers", customers);
			
			dispatcher = request.getRequestDispatcher("ViewAllCustomers.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/withdraw.app":
			
			response.sendRedirect("WithdrawForm.jsp");
			break;
			
		case "/withdrawAmount.app":
			
			accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			
			String result = service.withdraw(accountNumber, amount);
			request.setAttribute("result", result);
			request.setAttribute("accountNumber", accountNumber);
			
			dispatcher = request.getRequestDispatcher("DisplayMessage.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/deposit.app":
			
			response.sendRedirect("DepositForm.jsp");
			break;
			
		case "/depositAmount.app":
			
			accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			amount = Double.parseDouble(request.getParameter("amount"));
			
			service.deposit(accountNumber, amount);
			request.setAttribute("accountNumber", accountNumber);

			dispatcher = request.getRequestDispatcher("accountDetail.app");
			dispatcher.forward(request, response);
			break;
			
		case "/fundTransfer.app":
			
			response.sendRedirect("FundTransfer.jsp");
			break;
			
		case "/transfer.app":
			
			int senderId = Integer.parseInt(request.getParameter("sender"));
			int receiverId = Integer.parseInt(request.getParameter("receiver"));
			amount = Double.parseDouble(request.getParameter("amount"));
			
			BankAccount senderAcc=service.getAccountById(senderId);
			BankAccount receiverAcc=service.getAccountById(receiverId);
			boolean success = service.fundTransfer(senderAcc,receiverAcc,amount);
			
			if(success == true)
				result=receiverId+" received Rs. "+amount+" from "+senderId;
			else
				result="Fund transfer failed";	
			
			request.setAttribute("result", result);
			dispatcher = request.getRequestDispatcher("DisplayMessage.jsp");
			dispatcher.forward(request, response);
			break;
			
		default:
			response.sendRedirect("home.jsp");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
