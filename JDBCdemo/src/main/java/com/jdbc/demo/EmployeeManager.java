package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

	public static void main(String[] args) {
		final String URL = "jdbc:postgresql://revaturedatabase.cetjsxujxxdq.us-east-2.rds.amazonaws.com/employee";
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		String first_name;
		String last_name;
		double salary;
		int choice;
		int id;

		String insertCmd;
		String readCmd;
		String updateCmd;
		String deleteCmd;
		System.out.println("Select from the Given Options: ");
		System.out.println("1: Create  2:Read  3:Update  4:Delete");
		System.out.println("Enter your choice");
		choice = sc.nextInt();

		try {
			con = DriverManager.getConnection(URL, "postgres", "postgres123");
			switch (choice) {
			case 1:
				System.out.println("Enter first name: ");
				first_name = sc.next();
				System.out.println("Enter last name: ");
				last_name = sc.next();
				System.out.println("Enter salary: ");
				salary = sc.nextDouble();
				insertCmd = "insert into employees(first_name,last_name,salary) values(?,?,?)";
				PreparedStatement stmt = con.prepareStatement(insertCmd);
				stmt.setString(1, first_name);
				stmt.setString(2, last_name);
				stmt.setDouble(3, salary);
				if (stmt.execute()) {
					System.out.println("Error!");
				} else {
					System.out.println("Executed");
				}
				stmt.close();
				con.close();
				break;
			case 2:
				System.out.println("Running, Please Wait!");
				readCmd = "select * from employees";
				stmt = con.prepareStatement(readCmd);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1) + "  " + rs.getString("first_name") + "  " + rs.getString(3) + " "
							+ rs.getDouble(4));
				}
				stmt.close();
				con.close();
				break;

			case 3:
				System.out.println("Enter the id number: ");
				id = sc.nextInt();
				System.out.println("Enter first name: ");
				first_name = sc.next();
				System.out.println("Enter last name: ");
				last_name = sc.next();
				System.out.println("Enter salary: ");
				salary = sc.nextInt();

				updateCmd = "update employees set first_name = ?, last_name = ?, salary = ? where id =?";
				stmt = con.prepareStatement(updateCmd);
				stmt.setString(1, first_name);
				stmt.setString(2, last_name);
				stmt.setDouble(3, salary);
				stmt.setInt(4, id);
				if (stmt.execute()) {
					System.out.println("Error");
				} else {
					System.out.println("Executed");
				}
				stmt.close();
				con.close();
				break;

			case 4:
				System.out.println("Enter the id number: ");
				id = sc.nextInt();
				deleteCmd = "delete from employees where id =?";
				stmt = con.prepareStatement(deleteCmd);
				stmt.setInt(1, id);
				if (stmt.execute()) {
					System.out.println("Error!");
				} else {
					System.out.println("Executed");
				}
				stmt.close();
				con.close();
				break;

			default:
				System.out.println("Wrong Choice");
			break;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
