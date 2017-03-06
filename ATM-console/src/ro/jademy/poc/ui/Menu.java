package ro.jademy.poc.ui;

import java.util.Scanner;

import ro.jademy.poc.main.App;

public class Menu {

	public void showPrincipal() {
		System.out.println("Choose the number for your option: ");
		System.out.println("(1) Login");
		System.out.println("(2) Register");
	}

   public Integer readOption(Scanner s) {

		String readOption = null;
		readOption = s.next();
		if (readOption.matches("\\d+")) {// checks if input only contains
											// digits
			return Integer.parseInt(readOption);
		} else {
			return 0;
		}
	}
   

	public void showSecondary() {
		System.out.println("Choose the number for your option: ");
		System.out.println("(1) Check sold");
		System.out.println("(2) Add");
		System.out.println("(3) Remove");
		System.out.println("(4) Transactions");
		System.out.println("(" + App.EXIT+") Exit");
	}
}
