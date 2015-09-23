package PS3;

import java.util.Date;

public class Account {
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	
	public Account () 
	{
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	
	public Account (int id, double balance, double annualInterestRate, Date dateCreated)
	{
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		return getAnnualInterestRate() / 12;
	}
	
	public void withdraw(double amt) throws InsufficientFundsException {
		if (amt <= balance) {
			balance -= amt;
		}
		else {
			double needs = amt - balance;
			throw new InsufficientFundsException(needs);
		}	
	}
	
	public void deposit(double amt) {
		balance += amt;
	}
}
