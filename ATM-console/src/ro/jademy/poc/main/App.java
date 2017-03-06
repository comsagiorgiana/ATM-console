package ro.jademy.poc.main;


import java.util.ArrayList;
import java.util.Scanner;

import ro.jademy.poc.model.User;
import ro.jademy.poc.service.Login;
import ro.jademy.poc.service.Register;
import ro.jademy.poc.ui.Menu;

public class App {

	// Database
	public static ArrayList<User> registeredUsers;
	public static Menu menu;
	public static Scanner s;
	public static User currentUser;
	public static Boolean runningApp = true;
	public static final Integer EXIT = 0;
	public static int amount = 0;
	public static int amountToRemove = 0;

	public static void main(String[] args) {

		init();

		while (runningApp) {
			// show menu principal
			menu.showPrincipal();
			Integer opt = menu.readOption(s);

			switch (opt) {
			case 1:
				System.out.println("Execute Login");
				Login login = new Login();

				if (login.execute(s)) {
					handlerSecondary();
				}
				break;

			case 2:
				System.out.println("Please create a new account:");
				Register register = new Register();
				register.readCredentials(s);
				handlerSecondary();	
				break;

			default:
				System.out.println("Invalid option");
				break;
			}
		}
	}

	private static void handlerSecondary(){
		Integer optS;
		do {
			menu.showSecondary();
			optS = menu.readOption(s);
			switch (optS) {
			case 1:
			    handleShowSold();
				break;
			case 2:
				handleAdd();
				break;
			case 3:
				handleRemoveSold();
				break;
			case 4:
				System.out.println("Execute transactions:");
				App.currentUser.statement();
				break;
			case 0:
				return;
				
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (optS != EXIT);
	}
	


	private static void handleAdd() {
		System.out.println("Input amount of money you want to deposit: ");
		Integer amount;
		while(!s.hasNextInt()){
			System.out.println("Invalid value. Please enter a digit number.");
			s.next();
		}
		 amount= s.nextInt();
		if ((amount == 0)||(amount<0)) {
			System.out.println("You cannot add 0 or a value  smaller than 0.");
			return;
			}

		System.out.println("Your account will be deposited with:" + amount);
		System.out.println("If it's ok, type Y, else press any key...");

		String option = s.next();

		if ("Y".equalsIgnoreCase(option)) {
			App.currentUser.addMoneyToAccount(amount);
		} else {
			
		}
	}

	private static void handleRemoveSold() {
		System.out.println("Input amount of money you want to withdraw: ");
		Integer amountToRemove ;
		while(!s.hasNextInt()){
			System.out.println("Invalid value. Please enter a digit number.");
			s.next();
		}
		amountToRemove = s.nextInt();
		if ((amountToRemove == 0)||(amountToRemove<0)) {
			System.out.println("Please enter an amount bigger than 0.");
			return;
		}
		if (amountToRemove > App.currentUser.getSold()) {
			System.out.println("You don't have enough money in your account.");
			return;
		} else {
			System.out.println("Your account will be deducted with:" + amountToRemove);
			System.out.println("If it's ok, type Y, else press any key...");

			String option = s.next();

			if ("Y".equalsIgnoreCase(option)) {
				App.currentUser.removeMoneyFromAccount(amountToRemove);
			} else {
			}
		}

	}

	private static void handleShowSold() {
		System.out.print("Your current balance is: ");
		System.out.println(App.currentUser.getSold());
	}

	private static void init() {
		System.out.println("ATM ....");
		menu = new Menu();
		s = new Scanner(System.in);
		registeredUsers = new ArrayList<User>();
		addAdmin();
		System.out.println("Welcome! Let's start\n");
	}

	private static void addAdmin() {
		User u = new User();
		u.setFullname("Admin IT");
		u.setUsername("admin");
		u.setPassword("admin");
		u.setSold(1000000);
		u.getTransactions().add(new Transactions("Initial sold", 0, u.getSold()));
		registeredUsers.add(u);
	
	}
}
