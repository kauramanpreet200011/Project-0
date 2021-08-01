package com.revature.project0;

public class Customer {
	
	private String name;
	private int acc_no;
	private double balance;
	public Customer() {
	}
	public Customer(String name, int acc_no, double balance) {
		super();
		this.name = name;
		this.acc_no = acc_no;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "Customer [name=" + name + ", acc_no=" + acc_no + ", balance=" + balance + "]";
	}
}
