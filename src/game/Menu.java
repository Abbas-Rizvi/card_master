package game;

import java.util.Scanner;

public class Menu {

	// -------------------------------
	// global variables
	// -------------------------------

	//Create scanner for input
	public static Scanner scan = new Scanner(System.in);
	public static boolean exit = false;


	// -------------------------------
	// printMenu
	// prints game menu and returns number of available games
	public static void printMenu() {
		System.out.println("What game would you like to play today?");

		System.out.println("1: Blackjack");
		System.out.println("9: Quit");

	}
	

	// -------------------------------
	// select game
	public static void selGame() {

		// get user input
		int gameSel;

		// fix this later ***********************
		while (!scan.hasNextInt()) {
			System.out.println("invalid input");

			scan.hasNextInt();
		}

		gameSel = scan.nextInt();

		switch (gameSel) {
		case 1: 
			//blackjack
			BlackJack blackjack = new BlackJack();
			blackjack.play();			
			break;

		case 9:
			//quit
			exit = true;
			System.out.println("Goodbye!");
			break;

		default:
			// invalid input
			System.out.println("invalid input, returning to menu\n\n");
			exit = false;
			break;
		}

		if (!exit) {
			//prompt exit
			System.out.println("Do you want to exit? [y/N]");
			if (scan.hasNext("y"))
				exit = true;
		}

	}

	// -------------------------------
	// main
	// outputs menu and handles user input
	public static void main(String[] args) {


		// welcome message
		System.out.println("Welcome to Card Master\n");

		while (!exit) {
			printMenu();
			selGame();
		}


		// close scanner object
		scan.close();
	}

}
