package game;

public class Player {
	
	// player variables
	private double money;
	private double bet = 0;
	private String name;
	
	
	public Deck deck = new Deck(true);


	public boolean setBet(double amount) {
		
		// check if can be removed from account
		// if player has enough, remove and move to bet
		// otherwise inform player about invalid bet
		if (bet < money) {
			money = money - amount;
			bet = amount;
			return true;
		} else {
			return false;
		}
		
	}
	
	// deposit more money
	public void deposit(double addition) {
		money += addition;
	}
	
	// return amount placed in bet
	public double getBet() {
		return bet;
	}
	
	//returns bet to player
	public void draw() {
		money += bet;
	}
	
	// if player won, reward double amount placed in bet
	public void win() {
		money += (2*bet);
		bet = 0;
	}
	
	// if player lost, remove money held in bet
	public void lose() {
		bet = 0;
	}

	// return player money
	public double getMoney() {
		return money;
	}

	// set player money
	public void setMoney(double money) {
		this.money = money;
	}
	
	//get name
	public String getName() {
		return name;
	}

	//set name
	public void setName(String name) {
		this.name = name;
	}


}
