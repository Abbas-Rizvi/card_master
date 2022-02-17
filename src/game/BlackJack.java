package game;

public class BlackJack {

	//create deck for dealer
	Deck deck = new Deck(false);

	//create dealer and player 
	Player host = new Player();
	Player p1 = new Player();

	// --------------------
	// game over
	public void gameOver(boolean win) {

		// If Player won
		if (win) {
			System.out.println("Dealer Bust; You Win!");
			p1.win();
		} else {
			// if player loses
			System.out.println("Player Bust; Dealer Wins!");
			p1.lose();
		}



	}

	// Game Table
	// Holds actual game, rules and logic
	public void table(){

		//used as exit condition
		boolean exit = false;

		// Welcome player
		System.out.println("\n\nWelcome to Blackjack table " + p1.getName());
		System.out.println("Your Current Balance is $" +  p1.getMoney());

		// take bet
		System.out.println("Enter Amount you wish to bet: ");
		if (!p1.setBet(Menu.scan.nextDouble())) {
			exit = true;
			System.out.println("Invalid Bet; Exiting");
		}
		System.out.println(p1.getName() + " Has Wagered $" + p1.getBet() + "!");
		
		//return cards to deck from previous games
		for (int i= 0; i < p1.deck.num_cards(); i++) {
			deck.newCard(p1.deck.deal());
		}

		for (int i= 0; i < host.deck.num_cards(); i++) {
			deck.newCard(host.deck.deal());
		}

		//deal cards
		deck.shuffle();

		host.deck.newCard(deck.deal());
		host.deck.newCard(deck.deal());

		p1.deck.newCard(deck.deal());
		p1.deck.newCard(deck.deal());
		


		while (!exit) {

			System.out.println("---- Dealer Hand ----");
			System.out.println("HIDDEN");

			//prints all cards except 1 for dealer hand
			for (int i=1; i <host.deck.num_cards(); i++ )
				System.out.println(host.deck.printCard(i));

			//print player hand
			System.out.print("\n---- Player Hand ----");
			System.out.println(p1.deck.toString());


			// let player choose to hit or stay
			System.out.println("\nPlayer Turn: ");
			System.out.println("1: Hit");
			System.out.println("2: Stay");


			// fix this later ***********************
			while (!Menu.scan.hasNextInt()) {
				System.out.println("invalid input");

				Menu.scan.nextInt();
			}

			int optSel = Menu.scan.nextInt();


			// Option cases
			switch (optSel) {
			case 1: 
				// Hit
				p1.deck.newCard(deck.deal());

				//if went over 21, break loop
				if (p1.deck.handScore() > 21) {
					exit = true;
					break;
				}

			case 2: 
				// Stay
				exit = true;

				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}



			// dealer decides if they should hit
			if ( p1.deck.handScore() > host.deck.handScore() && host.deck.handScore() <= 17 ) {
				host.deck.newCard(deck.deal());

				//if went over 21, break loop
				if (host.deck.handScore() > 21) {
					exit = true;
					break;
				}
			}


		}

		if (p1.deck.handScore() >= 21) {
			//player bust
			gameOver(false);
		} else if (host.deck.handScore() >= 21 ) {
			//host bust
			gameOver(true);
		} else if (p1.deck.handScore() > host.deck.handScore()){
			//player win
			gameOver(true);
		} else if (p1.deck.handScore() < host.deck.handScore()){
			//dealer win
			gameOver(false);
		} else {
			//draw

		}




		//

	}



	// --------------------
	// start game
	public void play(){

		// Player Initialization
		System.out.println("Welcome to BlackJack!");

		//name
		System.out.print("Enter Name: ");
		p1.setName(Menu.scan.next());

		//money
		System.out.print("Enter " + p1.getName() +  " Balance: ");
		p1.setMoney(Menu.scan.nextDouble());



		// exit condition variable
		boolean exit = false;

		// game loop
		do {
			// game menu
			System.out.println("\n\n~~~~   BLACKJACK   ~~~~");
			System.out.println("---- Player Info ----");
			System.out.println(p1.getName() + " : $" + p1.getMoney());

			System.out.println("\n\nSelect an option");

			System.out.println("1: New Game");
			System.out.println("2: Deposit Additional Funds");
			System.out.println("9: Withdraw Funds and Exit ");


			// get user input
			int optSel;

			// fix this later ***********************
			while (!Menu.scan.hasNextInt()) {
				System.out.println("invalid input");

				Menu.scan.nextInt();
			}

			optSel = Menu.scan.nextInt();


			// Option cases
			switch (optSel) {
			case 1: 
				//new game
				table();
				break;
			case 2: 
				// deposit more funds
				System.out.print("Enter Amount to Deposit: ");
				p1.deposit(Menu.scan.nextDouble());
				System.out.println("New Balance: " + p1.getMoney());

				break;

			case 9:
				//quit
				exit = true;
				System.out.println("Player " + p1.getName() + " Has withdrawn $" + p1.getMoney() + "!");
				System.out.println("Exiting...");
				break;

			default:
				// invalid input
				System.out.println("invalid input, Please select valid option!\n\n");
				exit = false;
				break;
			}

		}while (!exit);




	}



}
