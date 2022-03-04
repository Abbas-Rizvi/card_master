package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.*;

public class DeckTest {

	@Before
	public void setUp() throws Exception {
	}

	// test empty deck
	@Test
	public void testEmptyDeck() {
		Deck deck = new Deck(true);
		
		// check if has no cards
		assertEquals(deck.num_cards(),0);
	}
	
	// test full deck
	@Test
	public void testFullDeck() {
		Deck deck = new Deck(false);
		
		// check if has no cards
		assertEquals(deck.num_cards(),52);
	}
	

	// test getting the value of all cards in deck
	@Test
	public void testHandScore() {
		
		//create empty deck
		Deck deck = new Deck(true);
		
		//create two cards
		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		Card c2 = new Card(Card.Suit.SPADES, Card.Value.NINE);
		
		//add cards to deck
		deck.newCard(c1);
		deck.newCard(c2);
		
		// assert deck value is 17
		assertEquals(deck.handScore(),17);
		
	}

	// test dealing a card from deck
	@Test
	public void testDeal() {
		Deck deck = new Deck(true);

		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		
		deck.newCard(c1);
		
		//test toString function because equating object error
		assertTrue(deck.deal().toString().equals(c1.toString()));
		
	}
	
	// test printing card (by index)
	@Test
	public void testPrintCard() {
		Deck deck = new Deck(true);

		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		
		deck.newCard(c1);
		
		assertEquals("EIGHT OF CLUBS",deck.printCard(0));
	}

	// test adding a new card
	@Test
	public void testNewCard() {

		// create empty deck
		Deck deck = new Deck(true);

		//create arbitrary card
		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		
		// add card to deck
		deck.newCard(c1);
		
		//test toString function because equating object error
		assertTrue(deck.deal().toString().equals(c1.toString()));
		
	}

	@Test
	public void testNum_cards() {
		
		// empty deck
		Deck deck = new Deck(true);

		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		
		//add 5 cards
		deck.newCard(c1);
		deck.newCard(c1);
		deck.newCard(c1);
		deck.newCard(c1);
		deck.newCard(c1);

		assertEquals(deck.num_cards(), 5);
	}

	@Test
	public void testToString() {

		// empty deck
		Deck deck = new Deck(true);

		Card c1 = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
		Card c2 = new Card(Card.Suit.HEARTS, Card.Value.ACE);
		
		deck.newCard(c1);
		deck.newCard(c2);
		
		assertEquals("\nEIGHT OF CLUBS\nACE OF HEARTS",deck.toString());
	}

}
