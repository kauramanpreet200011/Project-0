package com.revature.project0;

import java.sql.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.lang.NullPointerException;

public class CustImpl implements CustInterface{
	private static final Logger logger = LogManager.getLogger(CustImpl.class);
	EmpImpl e1 = new EmpImpl();
	static String url="jdbc:postges://database-1.cpemxk3wvwow.us-east-2.rds.amazonaws.com/customer";
	Scanner sc = new Scanner(System.in);
	boolean b1;
	int count=0,c=0;
	Connection con = ConnectionUtils.getConnection();
	@Override
	public boolean login1(int acc_no,String password) {
		try {
			logger.entry();
			logger.info("Login main function is called!");
		int acc_no1 = acc_no;
		String pwd1 = password;
		String query="select * from cust_details where accountno=? and pwd=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1,acc_no1);
		stmt.setString(2,pwd1);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println("Welcome "+rs.getString(1));count++;
		}	if(count == 1) {b1=true;}else {b1=false;}
	}catch(SQLException | NullPointerException e) {
		e.printStackTrace();
	}
	return  b1;
	}
	@Override
	public void viewBalance(int acc_no) {
		try {
		int acc_no1= acc_no;
		String query="select balance from cust_details where accountno=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, acc_no1);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("balance"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deposit(int acc_no) {
		try {
			int acc_no1= acc_no;
			System.out.println("Enter the amount to deposit = ");
			double amt=sc.nextDouble();
			if(amt>0) {
			String query="update cust_details set balance= balance+? where accountno=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, amt);
			stmt.setInt(2, acc_no1);
			int update = stmt.executeUpdate();
			System.out.println("Amount Deposited Successfully");
			ResultSet rs = stmt.getGeneratedKeys();
			while(rs.next()) {
				System.out.println(rs.getString(1)+ "  "+rs.getInt("balance"));
			}}
			else {
				System.out.println("Enter positive value!!");
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void withdrawl(int acc_no) {
		try {
			int acc_no1= acc_no;
			System.out.println("Enter the amount to be withdrawn = ");
			double amt=sc.nextDouble();
			String q="select balance from cust_details where accountno ="+acc_no1;
			PreparedStatement stmt = con.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
		    	if(rs.getInt("balance")-amt>0) {update(acc_no1,amt);}
		    	else {
		    		System.out.println("Insufficient Balance !");
		    	}
			}
			}catch(SQLException e) { 
				e.printStackTrace();
			}
}
	public void update(int acc_no1,Double amt) {
		try {
		String query="update cust_details set balance = balance-? where accountno=?";
		PreparedStatement stmt1 = con.prepareStatement(query);
		stmt1.setDouble(1, amt);
		stmt1.setInt(2, acc_no1);
		ResultSet rs1 = stmt1.executeQuery();
	    while(rs1.next()) {
			System.out.println(rs1.getString(1)+ "  "+rs1.getInt("balance"));}
		}catch(SQLException e) { 
			e.printStackTrace();
		}
	}
	
	@Override
	public void transfer(int acc_no) {
		try {
		int acc_no1=acc_no;
		System.out.println("Enter another account no to transfer money = ");
		int acc_no2=sc.nextInt();
		String query1="select * from cust_details where accountno=?";
		PreparedStatement stmt = con.prepareStatement(query1);
		stmt.setInt(1, acc_no2);
		ResultSet rs= stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+ "  "+rs.getInt("balance"));c++;
		}if(c == 1) {System.out.println("Account Exists .");
		System.out.println("Enter amount to be transferred = ");
		Double amt=sc.nextDouble();
		update1(amt,acc_no2);
		update2(amt,acc_no1);}
		else {System.out.println("Wrong Account number!!!");}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void update1(Double amt,int acc_no2) {
		try {
		String query2="update cust_details set balance = balance+? where accountno = ?";
		PreparedStatement stmt1 = con.prepareStatement(query2);
		stmt1.setDouble(1, amt);
		stmt1.setInt(2, acc_no2);
		ResultSet rs1 = stmt1.executeQuery();
		while(rs1.next()) {
			System.out.println(rs1.getString(1)+ "  "+rs1.getInt("balance"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
	
	public void update2(Double amt,int acc_no1) {
		try {
		String query3="update cust_details set balance = balance-? where accountno = ?";
		PreparedStatement stmt2 = con.prepareStatement(query3);
		stmt2.setDouble(1, amt);
		stmt2.setInt(2, acc_no1);
		ResultSet rs2 = stmt2.executeQuery();
		while(rs2.next()) {
			System.out.println(rs2.getString(1)+ "  "+rs2.getInt("balance"));
		}}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void register() {
			System.out.println("Enter your name = ");
			String name = sc.nextLine();
			System.out.println("Enter amount to open account = ");
			Double amt=sc.nextDouble();
			System.out.println("Create a password for login purpose = ");
			String pwd=sc.next();
			int acc_no=10003;
			e1.approval(name,acc_no,pwd,amt);
		}
	}

