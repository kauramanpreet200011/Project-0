package com.revature.project0;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginMain1 {
	 private static final Logger logger = LogManager.getLogger(LoginMain1.class);
	public static void main(String[] args) {

	    
		loginMain();
	}
	
		public static void loginMain() {
		logger.entry();
		logger.info("Login main function is called!");
		CustImpl c1 = new CustImpl();	
		EmpImpl e1 = new EmpImpl();
	//	Customer c = new Customer();
	//	Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
	  //  final String url="jdbc:postges://database-1.cpemxk3wvwow.us-east-2.rds.amazonaws.com/customer";
		System.out.println("==================================================================");
		logger.info("Enter logging information !");
		System.out.println("Enter your choice  ");
		System.out.println("1.  Login  ");
		System.out.println("2.  Register ");
		System.out.println("==================================================================");
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("==============================================================");
			logger.info("Login as user");
			System.out.println("Select one ");
			System.out.println("1.  Login as Customer");
			System.out.println("2.  Login as Employee");
			System.out.println("==============================================================");
			int a = sc.nextInt(); 
			if(a == 1) {
				logger.info("Entering account number");
				System.out.println("Enter your account number = ");
				int acc_no = sc.nextInt();
				logger.info("Entering password");
				System.out.println("Enter your password = ");
				String pwd = sc.next();
				logger.info("Checking for login details");
			    boolean b1 = c1.login1(acc_no,pwd);
			    if(b1 == true) {
			    	int b;
			    	System.out.println("Login Successful ! ");
					do {
						logger.info("Entering your next operation");
					System.out.println("======================================================");
					System.out.println("Choose next step -> ");
					System.out.println("1.  View Balance");
					System.out.println("2.  Deposit");
					System.out.println("3.  Withdrawl");
					System.out.println("4.  Transfer");
					System.out.println("5.  Exit");
					System.out.println("======================================================");
				    b = sc.nextInt();
					if(b==1) {
						c1.viewBalance(acc_no);
					}
					else if(b==2) {
						c1.deposit(acc_no);
					}
					else if(b==3) {
						c1.withdrawl(acc_no);
					}
					else if(b==4) {
						c1.transfer(acc_no);
					}
					else if(b==5) {System.exit(0);}
					else {
						System.out.println("Wrong input !");
						System.out.println("Please try again");
						loginMain();
					}
			    	}while(b!=5);
				}
				else if(b1 == false) {
					System.out.println("Recheck your account number and password !!!");
					loginMain();
				}
				}
			else if(a == 2) {
				logger.info("Entering employee id");
				System.out.println("Enter your employee id = ");
				String id = sc.next();
				logger.info("Entering your password");
				System.out.println("Enter your password = ");
				String pwd = sc.next();
				logger.info("Checking for login credentials");
			    boolean b2 = e1.login1(id,pwd);
			   do {
			    	System.out.println("=======================================================");
			    	System.out.println("press 1 to view balance of customers");
			    	System.out.println("press 2 to exit");
			    	System.out.println("=======================================================");
			    	int x = sc.nextInt();
			    	if(x == 1) {
			    		e1.viewbalance();
			    	}
			    	
			    	else if(x == 2) {
			    		System.exit(0);
			    	}
			    	else if(b2 == false){
			    		System.out.println("Invalid input ");
			    		System.out.println("Please try again .");
			    		sc.close();
			    		
			    	}
			    }while(b2!=false);
			}
			else {
				System.out.println("Wrong input !");
				System.out.println("Please try again");
				loginMain();
			}
		}
		else if(choice==2) {
			c1.register();
			
		}
		else {
			System.out.println("Wrong input !");
			System.out.println("Please try again");
			
			loginMain();
		}logger.exit();
	}

}
