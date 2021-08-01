package com.revature.project0;

public class Employee {
	private String name;
	private int id;
	private int acc_no;
	private double balance;
	Employee(){}
	public Employee(String name, int id, int acc_no, double balance) {
		super();
		this.name = name;
		this.id = id;
		this.acc_no = acc_no;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", acc_no=" + acc_no + ", balance=" + balance + "]";
	}
	

}
