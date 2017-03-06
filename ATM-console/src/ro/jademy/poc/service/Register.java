package ro.jademy.poc.service;

import java.util.Scanner;

import ro.jademy.poc.main.App;
import ro.jademy.poc.model.User;

public class Register {

	public void readCredentials(Scanner s) {
		System.out.println("Input username: ");
		String user = s.next();
		System.out.println("Input password: ");
		String pass = s.next();
		System.out.println("Please insert your full name");
		String full = s.next();

		User newUser = new User(user, pass);
		newUser.setFullname(full);
		newUser.setSold(100);
		App.registeredUsers.add(newUser);
		App.currentUser = newUser;
		System.out.println("Welcome, " + full + ", you have succefully register.");

		

	}

}
