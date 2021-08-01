package com.revature.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpImpl implements EmpInterface {
	
	static String url="jdbc:postges://database-1.cpemxk3wvwow.us-east-2.rds.amazonaws.com/customer";
	Scanner sc = new Scanner(System.in);
	
	boolean b1;
	Connection con =ConnectionUtils.getConnection();
	
	@Override
	public boolean login1(String id,String password) {
		String id1 = id;
		String pwd1 = password;
		int count=0;
		try {
		String query="select * from emp_details where emp_id=? and pwd=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1,id1);
		stmt.setString(2,pwd1);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));count++;
		}if(count==1) { b1=true;} else {b1=false;}
	}catch(SQLException | NullPointerException e) {
		e.printStackTrace();
	}
	return  b1;
}

	
	@Override
	public void viewbalance() {
		try {
			String query="select * from cust_details ";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"  "+rs.getInt("balance"));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	public void approval(String name, int acc_no,String pwd, Double amt) {
		
		System.out.println("Need Approval->");
		System.out.println("press 1 if you are sure or 2 to reject");
		int x=sc.nextInt();
		if(x == 1) {
			String query="insert into cust_details values(?,?,?,?)";
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(query);
				stmt.setString(1,name);
				stmt.setInt(2,acc_no);
				stmt.setString(3, pwd);
				stmt.setDouble(4,amt);
				ResultSet rs= stmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1)+" "+ rs.getInt(2)+ " " +rs.getInt(3));
					System.out.println("Registration Successful");
					System.out.println("Account opened successfully!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}else
	{
		System.out.println("Registration Unsuccessful !");
		System.out.println("Account opening failed!");
	}
	}
}

