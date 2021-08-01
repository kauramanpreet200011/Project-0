package com.revature.project0;

public interface CustInterface {
	
	boolean login1(int acc_no, String password);
	void viewBalance(int acc_no);
	void deposit(int acc_no);
	void withdrawl(int acc_no);
	void transfer(int acc_no);
	void register();
	
}
