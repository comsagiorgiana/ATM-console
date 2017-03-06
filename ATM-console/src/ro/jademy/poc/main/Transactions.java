package ro.jademy.poc.main;

public class Transactions {

	private String transactionType;
	private int value;
	private int fundsAvailable;
	

	public Transactions() {
	}

	public int getFundsAvailable() {
		return fundsAvailable;
	}

	public void setFundsAvailable(int fundsAvailable) {
		this.fundsAvailable = fundsAvailable;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Transactions(String transactionType, int value, int fundsAvailable) {
	}

	@Override
	public String toString() {
		return "Transactions [Transaction =" + transactionType + ", value =" + value + ", Funds available =" + fundsAvailable + "]";
	}
}
