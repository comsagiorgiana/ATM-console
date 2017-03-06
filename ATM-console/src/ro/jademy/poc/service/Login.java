package ro.jademy.poc.service;

import java.util.Scanner;

import ro.jademy.poc.main.App;
import ro.jademy.poc.model.User;

public class Login {
	public static final String CORRECT_INFO = "SUCCESS";
	public static final String INCORRECT_PASS = "INVALID_PASS";
	public static final String INCORRECT_USER = "INVALID_USER";
	public static String ERROR = "ERROR";
	
	public boolean execute(Scanner s) {
		readCredentials(s);
		String result = validate();
		feedback(result);
		return CORRECT_INFO.equals(result);
	}

	public void readCredentials(Scanner s) {
		System.out.println("Input username: ");
		String user = s.next();
		System.out.println("Input password: ");
		String pass = s.next();

		App.currentUser = new User(pass, user);
	}

	public String validate() {

		// Search user in registered users list
		for (User u : App.registeredUsers) {

			if (u.getUsername().equals(App.currentUser.getUsername())) {
				if (u.getPassword().equals(App.currentUser.getPassword())) {

					App.currentUser = u;
					return CORRECT_INFO;
				} else {
					return INCORRECT_PASS;
				}
			} else {
				return INCORRECT_USER;
			}
		}
		return ERROR;

	}

	public void feedback(String code) {
		switch (code) {
		case CORRECT_INFO:
			System.out.println("Welcome " + App.currentUser.getFullname());
			break;
		case INCORRECT_USER:
			System.out.println("User not found, please register!");
			break;
		case INCORRECT_PASS:
			System.out.println("Wrong password! Please try again!");
			break;
		default:
			break;
		}
	}
}
