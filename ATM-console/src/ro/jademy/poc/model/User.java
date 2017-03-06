package ro.jademy.poc.model;

import java.util.ArrayList;

import ro.jademy.poc.main.Transactions;

public class User {

	private String fullname;
	private String password;
	private String username;

	private Integer sold;

	private ArrayList<Transactions> transactions = new ArrayList<Transactions>();

	public User() {
		transactions = new ArrayList<Transactions>();
	}

	public ArrayList<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transactions> transactions) {
		this.transactions = transactions;
	}

	public User(String password, String username) {
		this.password = password;
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [fullname=" + fullname + ", username=" + username + "]";
	}

	public Integer getSold() {
		return sold;

	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public void addMoneyToAccount(Integer amount) {
		sold += amount;
		Transactions showMoneyAdded = new Transactions();
		showMoneyAdded.setTransactionType("Money added");
		showMoneyAdded.setValue(amount);
		showMoneyAdded.setFundsAvailable(sold);
		transactions.add(showMoneyAdded);
	}

	public void removeMoneyFromAccount(Integer amountToRemove) {
		sold -= amountToRemove;
		Transactions showMoneyRemoved = new Transactions();
		showMoneyRemoved.setTransactionType("Money removed");
		showMoneyRemoved.setValue(amountToRemove);
		showMoneyRemoved.setFundsAvailable(sold);
		transactions.add(showMoneyRemoved);
	}

	public void statement() {

		for (Transactions transaction : transactions) {

			System.out.println(transaction);
		}
	}
}
