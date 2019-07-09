package com.visa.prj.entity;
/**
 * This is an entity class to represent
 * account business data
 * 
 * @author root
 * @version 1.0
 * 
 */
public class Account {
	private double balance; //state of object [instance variable]
	private String accNo;	//state of object
	static private int count; //state of class
	
	public Account(String no) {
		this.accNo = no;
		count++;
	}
	
	/**
	 * 
	 * method to credit amount into account
	 * 
	 * @param amt amount to be credited
	 */
	public void deposit(double amt) { //deposit(Account this,double amt)
		this.balance += amt;					//this.balance += amt;
	}
	
	/**
	 * gives the status of current balance
	 * @return current balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	public String getAccno() {
		return accNo;
	}
	@Override
	public boolean equals(Object obj) {
		Account other = (Account) obj;
		return this.accNo.equals(other.accNo);
	}
	
	public static int getCount() {
		return count;
	}

}
