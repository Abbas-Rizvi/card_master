package game;

public class Card {

	//Enumerated variables
	//-----------------------------------------------------------------------------------------
	public enum Suit {
		CLUBS, HEARTS, DIAMONDS, SPADES
	}

	public enum Value{
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	//variables
	//-----------------------------------------------------------------------------------------
	private Suit card_suit;
	private Value card_value;


	//constructors
	//-----------------------------------------------------------------------------------------
	public Card(Suit card_suit, Value card_value) {
		this.card_suit = card_suit;
		this.card_value = card_value;
	}

	// functions
	//-----------------------------------------------------------------------------------------

	public int calculateRank(){

		//if card is from ACE TO TEN
		if (card_value.ordinal() < 10)

			//return ordinal + 1
			return (card_value.ordinal() + 1);

		//cards JACK, QUEEN, KING
		else

			//return 10
			return 10;
	}


	//getters
	//-----------------------------------------------------------------------------------------

	public Suit getCard_suit() {
		return card_suit;
	}

	public Value getCard_value() {
		return card_value;
	}


	//setters
	//-----------------------------------------------------------------------------------------
	public void setAll(Suit card_suit, Value card_value){
		this.card_suit = card_suit;
		this.card_value =card_value;
	}

	public void setCard_suit(Suit card_suit) {
		this.card_suit = card_suit;
	}

	public void setCard_value(Value card_value) {
		this.card_value = card_value;
	}


	//toString
	//-----------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return card_value + " OF " + card_suit;

	}
}
