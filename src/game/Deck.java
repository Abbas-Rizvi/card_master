package game;

import java.util.ArrayList;
import java.util.Random;
import game.Card.*;

public class Deck {

	//variables
	//------------------------------------------------------------------------------

	//array lists for deck
	private ArrayList<Card> deck = new ArrayList<Card>();


	//arrays for both Enum types, used to assign value using for loop
	private Suit[] suit_arr = Suit.values();
	private Value[] value_arr = Value.values();



	//constructors
	//------------------------------------------------------------------------------

	//default with no args, creates 52 card deck
	//-----------------------------------------------------------------------------------------
	public Deck(boolean empty){

		// creates full deck unless empty is specified as true
		if (!empty) {
			for(int i = 0; i < value_arr.length ; i++){
				for(int j = 0;j < 4;j++) {
					deck.add(new Card(suit_arr[j], value_arr[i]));
				}
			}
		}

	}

	//handScore
	//calculates score of cards in hand
	// -----------------------------------------------------------------------------------------
	public int handScore(){

		//initialize score to 0
		int score = 0;

		for (Card card: deck) {
			//increase the score by the value passed from the calculateRank function in the card
			score += card.calculateRank();
		}

		//return the score
		return score;
	}


	//deal a card
	//prints a random card for user
	//-----------------------------------------------------------------------------------------
	public Card deal(){

		//create object of type random
		Random rand = new Random();

		//set an integer to a random number, max number is size of deck -1
		int temp = rand.nextInt(deck.size());

		Card tempCard = new Card(deck.get(temp).getCard_suit(), deck.get(temp).getCard_value());

		//remove card at position temp
		deck.remove(temp);

		return tempCard;

	}
	
	//prints individual card
	public String printCard(int index) {
		
		return deck.get(index).toString();
		
	}

		
	// adds specific card to deck
	public String newCard(Card newCard) {
		
		deck.add(newCard);
		
		return newCard.toString();
	}


	//shuffle deck
	//shuffles cards in deck
	//-----------------------------------------------------------------------------------------
	public void shuffle(){

		//create object of type random
		Random rand = new Random();

		//for each card in deck arraylist
		for (Card card: deck) {

			//set an integer to a random number, max number is size of deck -1
			int temp = rand.nextInt(deck.size());

			//placeholder with all the values from current card object
			Card pholder = new Card(card.getCard_suit(), card.getCard_value());

			//set all values from card at p
			card.setAll(deck.get(temp).getCard_suit(), deck.get(temp).getCard_value());


			deck.get(temp).setAll(pholder.getCard_suit(), pholder.getCard_value());
		}

	}

	//Number of Cards
	//-----------------------------------------------------------------------------------------
	public int num_cards(){

		//return size of deck arraylist
		return deck.size();
	}


	//toString
	//-----------------------------------------------------------------------------------------
	@Override
	public String toString() {

		//create empty string for output
		String output = "";

		//for each card in deck
		for (Card myCard : deck){

			//concatenate toString of each card to output, each on a new line
			output += ("\n" + myCard);
		}

		//return output string
		return output;
	}
}
