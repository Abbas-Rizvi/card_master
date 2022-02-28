package game;

public class BlackJack {

	//create deck for dealer
	public Deck mainDeck = new Deck(false);

	//create dealer and player 
	public Player host = new Player();
	public Player p1 = new Player();

	// --------------------
	// game over
	public void gameOver(boolean win) {

		// If Player won
		if (win) {
			System.out.println("You Win!");
			p1.win();
		} else {
			// if player loses
			System.out.println("Dealer Wins!");
			p1.lose();
		}

	}


	//return cards to deck from previous games
	public void returnCards(Player p1, Player p2, Deck deck) {

		for (int i= 0; i < p1.deck.num_cards(); i++) {
			deck.newCard(p1.deck.deal());
		}

		for (int i= 0; i < host.deck.num_cards(); i++) {
			deck.newCard(host.deck.deal());
		}
	}

	// place wager
	// returns false on failure
	public boolean wager() {
		
		System.out.println("\n\nEnter Amount you wish to Wager: ");

		if (!p1.setBet(Menu.scan.nextDouble())) {
			System.out.println("Invalid Bet; Exiting");
			return false;
		}
		
		return true;

	}
	
	
	// Deal Cards
	public void dealCard(Player player, Deck deck ,int numCards) {
		
		//shuffle
		deck.shuffle();

		// deal
		for (int i =0 ; i < numCards ; i++ ) {
			player.deck.newCard(deck.deal());
		}

	}
	
	
	// player decision for hit or stay
	// returns true if game end
	public boolean playerOption(int optSel) {
		// Option cases
		switch (optSel) {
		case 1: 
			return hit(p1);

		case 2: 
			// Stay
			return true;
		default:
			System.out.println("Invalid Selection");
			break;
		}
		
		return false;
	}
		
	
	// player draws card, returns true if hand over 21
	public boolean hit(Player player) {
		// TODO Auto-generated method stub
		// dealer decides if they should hit
		dealCard(player,mainDeck,1);

		System.out.println(player.getName() + " Drew: " + player.deck.printCard(player.deck.num_cards() - 1));

		//if went over 21, break loop
		if (player.deck.handScore() > 21) 
			return true;

		return false;
	}
	
	public boolean dealerOption(Player player, Player dealer) {
	
		if ( player.deck.handScore() > dealer.deck.handScore() && dealer.deck.handScore() <= 17 )
			return true;
		
		return false;
	}

	// Game Table
	// Holds actual game, rules and logic
	public void table(){

		//used as exit condition
		boolean exit = false;

		// Welcome player
		System.out.println("\n\nWelcome to the Blackjack table " + p1.getName());
		System.out.println("Your Current Balance is $" +  p1.getMoney());

		// Placing Wager
		System.out.println("Enter Amount You Wish to Wager: ");

		if (!p1.setBet(Menu.scan.nextDouble())) {
			exit = true;
			System.out.println("Invalid Wager!; Returning to menu");
		} else {
			System.out.println(p1.getName() + " Has Wagered $" + p1.getBet() + "!");
			returnCards(p1,host,mainDeck);
		}

		dealCard(host,mainDeck,2);
		dealCard(p1,mainDeck,2);

		while (!exit) {

			System.out.println("\n---- Dealer Hand ----");
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

			// player option selection
			exit = playerOption(Menu.scan.nextInt());

			// dealer draw card
			if (dealerOption(p1,host))
				exit = hit(host);
		}

		if (p1.deck.handScore() > 21) {
			//player bust
			gameOver(false);
		} else if (host.deck.handScore() > 21 ) {
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
			System.out.println("Draw! Returned Bet");
			p1.draw();
			
		}


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
